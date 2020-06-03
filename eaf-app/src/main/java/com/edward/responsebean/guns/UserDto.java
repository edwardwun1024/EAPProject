package com.edward.responsebean.guns;

/**
 * @author wangcheng
 * @date 2020/6/3 15:56
 */
public class UserDto {
    private String depName;
    private String createTime;
    private String accountType;
    private Integer depId;
    private String phone;
    private String sexName;
    private String name;
    private String roleName;
    private String statusName;
    private Integer id;
    private String account;
    private String email;
    private Integer status;

    public UserDto() {
    }

    public UserDto(String depName, String createTime, String accountType, Integer depId, String phone, String sexName, String name, String roleName, String statusName, Integer id, String account, String email, Integer status) {
        this.depName = depName;
        this.createTime = createTime;
        this.accountType = accountType;
        this.depId = depId;
        this.phone = phone;
        this.sexName = sexName;
        this.name = name;
        this.roleName = roleName;
        this.statusName = statusName;
        this.id = id;
        this.account = account;
        this.email = email;
        this.status = status;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "depName='" + depName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", accountType='" + accountType + '\'' +
                ", depId=" + depId +
                ", phone='" + phone + '\'' +
                ", sexName='" + sexName + '\'' +
                ", name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                ", statusName='" + statusName + '\'' +
                ", id=" + id +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
