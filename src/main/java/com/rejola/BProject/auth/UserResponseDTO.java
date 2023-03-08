package com.rejola.BProject.auth;

import com.rejola.BProject.security.UserRoleMap;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserResponseDTO {

  private UUID id;
  private String username;
  private String email;
  List<UserRoleMap> appUserRoleMaps;
public UUID getId() {
	return id;
}
public void setId(UUID id) {
	this.id = id;
}
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
public List<UserRoleMap> getAppUserRoleMaps() {
	return appUserRoleMaps;
}
public void setAppUserRoleMaps(List<UserRoleMap> appUserRoleMaps) {
	this.appUserRoleMaps = appUserRoleMaps;
}
  

}
