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
        return this.getPostPersonAddMemberToGroups(POST_PERSON_MEMBER_ADDMEMBERTOGROUPS,personAddMemberToGroupsRequestBean);
    }
    private String getPostPersonAddMemberToGroups(HttpApi POST_PERSON_MEMBER_ADDMEMBERTOGROUPS, PersonAddMemberToGroupsRequestBean personAddMemberToGroupsRequestBean){
        return doPost(POST_PERSON_MEMBER_ADDMEMBERTOGROUPS,personAddMemberToGroupsRequestBean);
    }

    public String getPostPersonPersonGroupCreate(){
        return this.getPostPersonPersonGroupCreate(POST_PERSON_PERSONGROUP_CREATE,"");
    }

    public String getPostPersonPersonGroupCreate(HttpApi POST_PERSON_PERSONGROUP_CREATE,String s){
        return doPost(POST_PERSON_PERSONGROUP_CREATE,"");
    }

    public String getPostPersonMemberAddGroupMember(){
        return this.getPostPersonAddGroupMember(POST_PERSON_MEMBER_ADDGROUPMEMBER,"");
    }

    public String getPostPersonAddGroupMember(HttpApi POST_PERSON_MEMBER_ADDGROUPMEMBER,String s){
        return doPost(POST_PERSON_MEMBER_ADDGROUPMEMBER,"");
    }


}
