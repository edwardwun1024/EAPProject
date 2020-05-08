package com.edward.requestbean.guns.bean;

import java.util.Date;

/**
 * @author wangcheng
 * @date 2019/12/16 14:04
 */
public class GunsAccountAddRequestBean {
    /**
     * id:
     * account: wcTest1
     * sex:
     * password: y8Gw/EqQfhEPnnvCgWLONA==
     * email: wcTest1@qq.com
     * name: wcTest1
     * birthday:
     * rePassword: y8Gw/EqQfhEPnnvCgWLONA==
     * deptid: 0
     * phone: 16602103425
     * createUser: 9
     * accountType: 0
     */
//    private Integer id;
    private String account;
    private String name;
    private String password;
    private String rePassword;
    private String email;
    private String phone;
    private Integer deptid;
    private String accountType;
    private Integer createUser;

    public GunsAccountAddRequestBean() {
    }

    public GunsAccountAddRequestBean( String account, String name, String password, String rePassword, String email, String phone, Integer deptid, String accountType, Integer createUser) {
//        this.id = id;
        this.account = account;
        this.name = name;
        this.password = password;
        this.rePassword = rePassword;
        this.email = email;
        this.phone = phone;
        this.deptid = deptid;
        this.accountType = accountType;
        this.createUser = createUser;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "GunsAccountAddRequestBean{" +
//                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", rePassword='" + rePassword + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptid=" + deptid +
                ", accountType='" + accountType + '\'' +
                ", createUser=" + createUser +
                '}';
    }
}
