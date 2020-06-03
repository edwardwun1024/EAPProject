package com.edward.appcaller;

import com.edward.app.AbstractServiceCaller;
import com.edward.http.HttpApi;
import com.edward.requestbean.person.bean.PersonGroupListRequestBean;

import static com.edward.app.PersonApp.*;

public class PersonAppCaller extends AbstractServiceCaller {


    public String getPostPersonGroupList(PersonGroupListRequestBean personGroupListRequestBean){
        return this.getPostPersonGroupList(POST_PERSON_GROUP_LIST,personGroupListRequestBean);
    }
    private String getPostPersonGroupList(HttpApi POST_PERSON_GROUP_LIST, PersonGroupListRequestBean personGroupListRequestBean){
       return doPost(POST_PERSON_GROUP_LIST,personGroupListRequestBean);
    }


}
