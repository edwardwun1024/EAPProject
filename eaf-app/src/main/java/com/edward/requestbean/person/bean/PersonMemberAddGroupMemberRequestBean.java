package com.edward.requestbean.person.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020/6/4 10:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonMemberAddGroupMemberRequestBean {
    private String groupId;
    private String desc;
    private List<String> uidList;
    private String operatePerson;


    public PersonMemberAddGroupMemberRequestBean(String groupId, String desc, List<String> uidList) {
        this.groupId = groupId;
        this.desc = desc;
        this.uidList = uidList;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getUidList() {
        return uidList;
    }

    public void setUidList(List<String> uidList) {
        this.uidList = uidList;
    }

    @Override
    public String toString() {
        return "PersonMemberAddGroupMemberRequestBean{" +
                "groupId='" + groupId + '\'' +
                ", desc='" + desc + '\'' +
                ", uidList=" + uidList +
                '}';
    }
}
