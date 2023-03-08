package com.rejola.BProject.master.user;

import com.rejola.BProject.models.BaseModel;
import com.rejola.BProject.security.UserRoleMap;
import com.rejola.BProject.shared.Status;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Users extends BaseModel {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(unique = true, nullable = false)
	private String empId;

	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String phoneNo;

	// @Size(min = 8, message = "Minimum password length: 8 characters")
	private String password;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany
	@JoinColumn(name = "userId")
	private List<UserRoleMap> roles;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<UserRoleMap> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRoleMap> roles) {
		this.roles = roles;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
