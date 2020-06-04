package com.edward.dataProvider.person;

import com.edward.common.EnumCode;
import com.edward.requestbean.person.bean.PersonGroupCreateRequestBean;

/**
 * @author wangcheng
 * @date 2020/6/4 10:56
 */
public class PersonGroupCreateTestData {
    public Object[][] genPersonGroupCreateTestData() {
        PersonGroupCreateRequestBean personGroupCreateRequestBean = new PersonGroupCreateRequestBean();
        personGroupCreateRequestBean.setCnName("wc-testgroup64");
        personGroupCreateRequestBean.setType("1");
        personGroupCreateRequestBean.setOperatePerson("60");
        return new Object[][]{
                {"创建组",personGroupCreateRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
