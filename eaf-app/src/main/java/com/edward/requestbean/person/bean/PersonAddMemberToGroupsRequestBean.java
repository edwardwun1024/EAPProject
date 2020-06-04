package com.edward.requestbean.person.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020/6/3 18:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonAddMemberToGroupsRequestBean {
    private String uid; //not null
    private List<String> groupIdList;
    private String operatePerson;
}
