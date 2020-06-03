package com.edward.requestbean.person.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangcheng
 * @date 2020/6/3 17:32
 */
public class PersonCreateRequestBean {
    private String birthday;
    private String cnName; //not null
    private String desc;
    private String documentId;
    private String enName;
    private String expireDate;
    private String idCountry;
    private String idExpiryDate;
    private String idNumber;
    private String idType;
    private String imageURI; //not null
    private String operatePerson; //not null
    private String personTag;
    private String personType;
    private String privilege;
    private String sex;

    public PersonCreateRequestBean() {
    }

    public PersonCreateRequestBean(String birthday, String cnName, String desc, String documentId, String enName, String expireDate, String idCountry, String idExpiryDate, String idNumber, String idType, String imageURI, String operatePerson, String personTag, String personType, String privilege, String sex) {
        this.birthday = birthday;
        this.cnName = cnName;
        this.desc = desc;
        this.documentId = documentId;
        this.enName = enName;
        this.expireDate = expireDate;
        this.idCountry = idCountry;
        this.idExpiryDate = idExpiryDate;
        this.idNumber = idNumber;
        this.idType = idType;
        this.imageURI = imageURI;
        this.operatePerson = operatePerson;
        this.personTag = personTag;
        this.personType = personType;
        this.privilege = privilege;
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    public void setIdExpiryDate(String idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getOperatePerson() {
        return operatePerson;
    }

    public void setOperatePerson(String operatePerson) {
        this.operatePerson = operatePerson;
    }

    public String getPersonTag() {
        return personTag;
    }

    public void setPersonTag(String personTag) {
        this.personTag = personTag;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonCreateRequestBean{" +
                "birthday='" + birthday + '\'' +
                ", cnName='" + cnName + '\'' +
                ", desc='" + desc + '\'' +
                ", documentId='" + documentId + '\'' +
                ", enName='" + enName + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", idCountry='" + idCountry + '\'' +
                ", idExpiryDate='" + idExpiryDate + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", idType='" + idType + '\'' +
                ", imageURI='" + imageURI + '\'' +
                ", operatePerson='" + operatePerson + '\'' +
                ", personTag='" + personTag + '\'' +
                ", personType='" + personType + '\'' +
                ", privilege='" + privilege + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
