package com.rejola.BProject.auth;

import com.rejola.BProject.security.UserRoleMap;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDataDTO {

  private String username;
  private String email;
  private String password;
  List<UserRoleMap> appUserRoleMaps;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<UserRoleMap> getAppUserRoleMaps() {
	return appUserRoleMaps;
}
public void setAppUserRoleMaps(List<UserRoleMap> appUserRoleMaps) {
	this.appUserRoleMaps = appUserRoleMaps;
}
  

}
