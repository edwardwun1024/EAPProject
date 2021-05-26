package com.edward.dataProvider.person;


import com.edward.common.EnumCode;
import com.edward.requestbean.person.bean.PersonGroupListRequestBean;

public class PersonGroupListTestData {

    public Object[][] genPersonGroupListTestData() {
        PersonGroupListRequestBean personGroupListRequestBean = new PersonGroupListRequestBean();
        personGroupListRequestBean.setCurrent("1");
        personGroupListRequestBean.setSize("10");
        personGroupListRequestBean.setCnName("wc-TestGroup");
        personGroupListRequestBean.setGroupId("");

        return new Object[][]{
                {"获取组的list", personGroupListRequestBean, EnumCode.BASE_SUCCESS}
        };
    }

}
