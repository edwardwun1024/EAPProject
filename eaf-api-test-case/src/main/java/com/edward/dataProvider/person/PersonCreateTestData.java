package com.edward.dataProvider.person;

import com.edward.common.EnumCode;
import com.edward.requestbean.person.bean.PersonCreateRequestBean;

/**
 * @author wangcheng
 * @date 2020/6/3 18:38
 */
public class PersonCreateTestData {

    public Object[][] genPersonCreateTestData() {
        String cnName = "wc-person-02";
        String idNumber = "id-wc-person-02";
        String imageUrl = "/images/person/20200603/67/df6b92bbcdbc3bdd5b8c107562be984a.jpeg";
        String operatePerson = "60";
        PersonCreateRequestBean personCreateRequestBean = new PersonCreateRequestBean();
        personCreateRequestBean.setCnName(cnName);
        personCreateRequestBean.setIdNumber(idNumber);
        personCreateRequestBean.setImageURI(imageUrl);
        personCreateRequestBean.setOperatePerson(operatePerson);

        return new Object[][]{
                {"创建人员", personCreateRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
