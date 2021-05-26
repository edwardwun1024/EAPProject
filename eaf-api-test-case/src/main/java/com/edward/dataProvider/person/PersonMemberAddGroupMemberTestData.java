package com.edward.dataProvider.person;

import com.edward.common.EnumCode;
import com.edward.requestbean.person.bean.PersonMemberAddGroupMemberRequestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcheng
 * @date 2020/6/4 18:12
 */
public class PersonMemberAddGroupMemberTestData {
    public Object[][] genPersonMemberAddGroupMemberTestData() {
        String groupId = "31";
        List<String> userIds = new ArrayList<>();
        userIds.add("4124");
        String operatePerson = "wangcheng";

        PersonMemberAddGroupMemberRequestBean personMemberAddGroupMemberRequestBean = new PersonMemberAddGroupMemberRequestBean();
        personMemberAddGroupMemberRequestBean.setGroupId(groupId);
        personMemberAddGroupMemberRequestBean.setUidList(userIds);
        personMemberAddGroupMemberRequestBean.setOperatePerson(operatePerson);

        return new Object[][]{
                {"将人加到组中", personMemberAddGroupMemberRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
