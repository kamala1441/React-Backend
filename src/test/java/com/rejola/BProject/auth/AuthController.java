package com.rejola.BProject.auth;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@CrossOrigin
@RestController
@RequestMapping("/v1/auth")
@Api(tags="Authentication", description="User Authentication")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping(value = "/login", produces = "application/json")
  @ApiOperation(
          value = "Login user",
          notes = "User authentication")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Login success"),
          @ApiResponse(code = 404, message = "User not found"),
  })
  public ResponseEntity<JsonNode> login(@RequestBody LoginRequest loginRequest) {
    return authService.signIn(loginRequest.getEmpId(), loginRequest.getPassword());
  }
  @GetMapping(value = "/forgot", produces = "application/json")
  public ResponseEntity<JsonNode> forgotPassword(
          @ApiParam(name = "email", value = "Employee email id", required = true)
          @RequestParam String email, HttpServletRequest request) {
    return authService.forgotPassword(request, email);
  }

  @PostMapping(value = "/password/reset", produces = "application/json")
  @ApiOperation(
          value = "Reset password",
          notes = "Reset password",
          response = ResetPasswordRequest.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Password Updated"),
          @ApiResponse(code = 401, message = "UnAuthorized"),
  })
  public ResponseEntity<JsonNode> resetPassword(@RequestBody ResetPasswordRequest request) {
    return authService.resetPassword(request);
  }

  @GetMapping("/refresh")
  public String refresh(HttpServletRequest req) {
    return authService.refresh(req.getRemoteUser());
  }
}
