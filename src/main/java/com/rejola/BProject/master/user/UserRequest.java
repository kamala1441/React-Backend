package com.rejola.BProject.master.user;

import java.util.UUID;

public class UserRequest {
    private String id;
    private String empId;
    private String name;
    private String email;
    private String phoneNo;
    private String password;
    private Long designationId;
    private Long departmentId;
    private String projectManagerId;
    private String teamLeadId;
    private Long branchId;
    private String timeSheetApproverId;
    private Long budgetGroupId;
    private String ctc;
    private String status;
  //  private List<String> rolesIds;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public UUID getProjectManagerId() {
        if(projectManagerId == null) {
            return null;
        }
        return UUID.fromString(projectManagerId);
    }

    public void setProjectManagerId(String projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public UUID getTimeSheetApproverId() {
        if(timeSheetApproverId == null) {
            return null;
        }
        return UUID.fromString(timeSheetApproverId);
    }

    public void setTimeSheetApproverId(String timeSheetApproverId) {
        this.timeSheetApproverId = timeSheetApproverId;
    }

    public Long getBudgetGroupId() {
        return budgetGroupId;
    }

    public void setBudgetGroupId(Long budgetGroupId) {
        this.budgetGroupId = budgetGroupId;
    }

    public String getCtc() {
        return ctc;
    }

    public void setCtc(String ctc) {
        this.ctc = ctc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

 /*   public List<String> getRoles() {
        return rolesIds;
    }

    public void setRoles(List<String> rolesIds) {
        this.rolesIds = rolesIds;
    }
*/
    public UUID getTeamLeadId() {
        if(teamLeadId == null) {
            return null;
        }
        return UUID.fromString(teamLeadId);
    }

    public void setTeamLeadId(String teamLeadId) {
        this.teamLeadId = teamLeadId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
