package com.edward.service;

import com.edward.appcaller.PersonAppCaller;
import com.edward.requestbean.person.bean.PersonAddMemberToGroupsRequestBean;
import com.edward.requestbean.person.bean.PersonCreateRequestBean;
import com.edward.responsebean.basic.BaseRes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcheng
 * @date 2020/6/3 19:44
 */
public class PersonService extends BaseService{

    //创建person并加到组中
    public void genPersonAndAddPersonToGoups(){

        //1、创建person
        String cnName = "wc-person-02";
        String idNumber = "id-wc-person-02";
        String imageUrl = "/images/person/20200603/67/df6b92bbcdbc3bdd5b8c107562be984a.jpeg";
        String operatePerson = "60";
        PersonCreateRequestBean personCreateRequestBean = new PersonCreateRequestBean();
        personCreateRequestBean.setCnName(cnName);
        personCreateRequestBean.setIdNumber(idNumber);
        personCreateRequestBean.setImageURI(imageUrl);
        personCreateRequestBean.setOperatePerson(operatePerson);
        String responseString = personAppCaller.getPostPersonCreate(personCreateRequestBean);
        BaseRes baseRes = gson.fromJson(responseString,BaseRes.class);
        String personId = baseRes.getData().toString();

        //2、将person加到组中
        String personId1 = personId;
        String operatePerson1 = operatePerson;
        List<String> groupIdList = new ArrayList<>();
        groupIdList.add("31");

        PersonAddMemberToGroupsRequestBean personAddMemberToGroupsRequestBean = new PersonAddMemberToGroupsRequestBean();
        personAddMemberToGroupsRequestBean.setUid(personId1);
        personAddMemberToGroupsRequestBean.setOperatePerson(operatePerson1);
        personAddMemberToGroupsRequestBean.setGroupIdList(groupIdList);
        String personAddMemberToGroupsResponseString = new PersonAppCaller().getPostPersonAddMemberToGroups(personAddMemberToGroupsRequestBean);
        BaseRes personAddMemberToGroupsResponseBaseRes = gson.fromJson(responseString,BaseRes.class);

    }
}
