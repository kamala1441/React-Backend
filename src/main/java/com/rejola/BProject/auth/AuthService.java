package com.rejola.BProject.auth;


import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.exception.BadRequestException;
import com.rejola.BProject.exception.CustomException;
import com.rejola.BProject.exception.UserNotFoundException;
import com.rejola.BProject.mapper.ModelMapper;
import com.rejola.BProject.security.JwtTokenProvider;
import com.rejola.BProject.master.user.Users;
import com.rejola.BProject.shared.ResultBuilder;
import com.rejola.BProject.utils.Json;
import com.rejola.BProject.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

@Service
public class AuthService {

    private  final AuthRepository authRepository;
    @Autowired
    ModelMapper modelMapper;
    private  final JwtTokenProvider jwtTokenProvider;

    public AuthService(AuthRepository authRepository, JwtTokenProvider jwtTokenProvider) {
        this.authRepository = authRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public ResponseEntity<JsonNode> signIn(String empId, String password) {
        if (empId == null || password == null) {
            throw new CustomException("Invalid User", HttpStatus.BAD_REQUEST);
        }
        Optional<Users> user = authRepository.findByEmpId(empId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("Invalid User");
        }
        if (user.get().getPassword().equals(password)) {
            System.out.println(Json.toJson(user.get()));
            LoginDTO dto = modelMapper.map(user.get());
            dto.setToken(jwtTokenProvider.createToken(Json.toJson(user.get()).toString()));
            return ResponseEntity.ok(ResultBuilder.successJson("Login success", dto));
        } else {
            throw new UserNotFoundException("Invalid username/password supplied");
        }
    }


    public String refresh(String username) {
        return jwtTokenProvider.createToken(username);
    }




    public ResponseEntity<JsonNode> forgotPassword(HttpServletRequest request, String email) {
        String baseUrl = Utils.getBaseUrl(request);
        StringBuilder stringBuilder = new StringBuilder();
        if (email == null) {
            throw new UserNotFoundException("Invalid user");
        }
        Optional<Users> usersOptional = authRepository.findByEmail(email);
        if (usersOptional.isEmpty()) {
            throw new UserNotFoundException("Invalid Email");
        }
        Users user = usersOptional.get();
        stringBuilder.append(baseUrl).append("/auth/password/reset?t=").append(jwtTokenProvider.createToken(user.getEmail()));
        try {
            sendmail(stringBuilder.toString());
            return ResponseEntity.ok(ResultBuilder.successJson("Email Sent"));
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void sendmail(String data) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mail@rejola.com", "gk)4duXc!Hp");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("mail@rejola.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("gnanamoorthy@rejola.com"));
        msg.setSubject("EMS Password Reset");
        msg.setContent(data, "text/html");
        msg.setSentDate(new Date());

        //  MimeBodyPart messageBodyPart = new MimeBodyPart();
        //  messageBodyPart.setContent("Tutorials point email", "text/html");

        //  Multipart multipart = new MimeMultipart();
        //  multipart.addBodyPart(messageBodyPart);
        //  MimeBodyPart attachPart = new MimeBodyPart();

        //   attachPart.attachFile("/var/tmp/image19.png");
        //  multipart.addBodyPart(attachPart);
        //   msg.setContent(multipart);
        Transport.send(msg);
    }


    public ResponseEntity<JsonNode> resetPassword(ResetPasswordRequest request) {
        String email = jwtTokenProvider.getTokenData(request.getT()).get("email").asText();
        Optional<Users> usersOptional = authRepository.findByEmail(email);
        if (usersOptional.isPresent()) {
            Users user = usersOptional.get();
            user.setPassword(request.getPassword());
            authRepository.save(user);
            return ResponseEntity.ok(ResultBuilder.successJson("Password Updated"));
        } else {
            throw new BadRequestException("UnAuthorized");
        }
    }
}
