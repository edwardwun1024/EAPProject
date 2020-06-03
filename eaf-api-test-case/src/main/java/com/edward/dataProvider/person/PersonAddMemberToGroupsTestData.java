package com.edward.dataProvider.person;

import com.edward.common.EnumCode;
import com.edward.requestbean.person.bean.PersonAddMemberToGroupsRequestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcheng
 * @date 2020/6/3 18:39
 */
public class PersonAddMemberToGroupsTestData {
    public Object[][] genPersonAddMemberToGroupsTestData() {

        String personId = "2397";
        String operatePerson = "60";
        List<String> groupIdList = new ArrayList<>();
        groupIdList.add("31");

        PersonAddMemberToGroupsRequestBean personAddMemberToGroupsRequestBean = new PersonAddMemberToGroupsRequestBean();
        personAddMemberToGroupsRequestBean.setUid(personId);
        personAddMemberToGroupsRequestBean.setOperatePerson(operatePerson);
        personAddMemberToGroupsRequestBean.setGroupIdList(groupIdList);

        return new Object[][]{
                {"加人到多个组中",personAddMemberToGroupsRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
