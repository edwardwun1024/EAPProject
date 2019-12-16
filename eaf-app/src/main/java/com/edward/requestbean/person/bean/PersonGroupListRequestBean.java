package com.edward.requestbean.person.bean;

public class PersonGroupListRequestBean {
    private String current;
    private String size;
    private String cnName;
    private String groupId;

    public PersonGroupListRequestBean() {
    }

    public PersonGroupListRequestBean(String current, String size, String cnName, String groupId) {
        this.current = current;
        this.size = size;
        this.cnName = cnName;
        this.groupId = groupId;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "PersonGroupListRequestBean{" +
                "current='" + current + '\'' +
                ", size='" + size + '\'' +
                ", cnName='" + cnName + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
