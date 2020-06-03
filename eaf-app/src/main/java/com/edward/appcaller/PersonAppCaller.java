package com.edward.appcaller;

import com.edward.app.AbstractServiceCaller;
import com.edward.http.HttpApi;
import com.edward.requestbean.person.bean.*;
import static com.edward.app.PersonApp.*;

public class PersonAppCaller extends AbstractServiceCaller {


    public String getPostPersonGroupList(PersonGroupListRequestBean personGroupListRequestBean){
        return this.getPostPersonGroupList(POST_PERSON_GROUP_LIST,personGroupListRequestBean);
    }
    private String getPostPersonGroupList(HttpApi POST_PERSON_GROUP_LIST, PersonGroupListRequestBean personGroupListRequestBean){
       return doPost(POST_PERSON_GROUP_LIST,personGroupListRequestBean);
    }

    public String getPostPersonCreate(PersonCreateRequestBean personCreateRequestBean){
        return this.getPostPersonCreate(POST_PERSON_PERSON_CREATE,personCreateRequestBean);
    }
    private String getPostPersonCreate(HttpApi POST_PERSON_PERSON_CREATE, PersonCreateRequestBean personCreateRequestBean){
        return doPost(POST_PERSON_PERSON_CREATE,personCreateRequestBean);
    }

    public String getPostPersonAddMemberToGroups(PersonAddMemberToGroupsRequestBean personAddMemberToGroupsRequestBean){
        return this.getPostPersonAddMemberToGroups(POST_PERSON_MEMBER_ADDMEMBERTOGROUP,personAddMemberToGroupsRequestBean);
    }
    private String getPostPersonAddMemberToGroups(HttpApi POST_PERSON_MEMBER_ADDMEMBERTOGROUP, PersonAddMemberToGroupsRequestBean personAddMemberToGroupsRequestBean){
        return doPost(POST_PERSON_MEMBER_ADDMEMBERTOGROUP,personAddMemberToGroupsRequestBean);
    }


}
