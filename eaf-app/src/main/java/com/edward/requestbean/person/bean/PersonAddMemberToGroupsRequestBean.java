package com.edward.requestbean.person.bean;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020/6/3 18:27
 */
public class PersonAddMemberToGroupsRequestBean {
    private String uid; //not null
    private List<String> groupIdList;
    private String operatePerson;

    public PersonAddMemberToGroupsRequestBean() {
    }

    public PersonAddMemberToGroupsRequestBean(String uid, List<String> groupIdList, String operatePerson) {
        this.uid = uid;
        this.groupIdList = groupIdList;
        this.operatePerson = operatePerson;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<String> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<String> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public String getOperatePerson() {
        return operatePerson;
    }

    public void setOperatePerson(String operatePerson) {
        this.operatePerson = operatePerson;
    }

    @Override
    public String toString() {
        return "PersonAddMemberToGroupsRequestBean{" +
                "uid='" + uid + '\'' +
                ", groupIdList=" + groupIdList +
                ", operatePerson='" + operatePerson + '\'' +
                '}';
    }
}
