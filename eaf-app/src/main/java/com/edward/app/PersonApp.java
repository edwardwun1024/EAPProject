package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

public class PersonApp {
    private static final String POST_PERSON_GROUP_LIST_PATH = "/PERSON/personGroup/list";
    public static final HttpApi POST_PERSON_GROUP_LIST = new HttpApi(POST_PERSON_GROUP_LIST_PATH, HttpMethod.POST_JSON);

    private static final String POST_PERSON_PERSON_CREATE_PATH = "/PERSON/person/create";
    public static final HttpApi POST_PERSON_PERSON_CREATE = new HttpApi(POST_PERSON_PERSON_CREATE_PATH, HttpMethod.POST_JSON);

    private static final String POST_PERSON_MEMBER_ADDMEMBERTOGROUP_PATH = "/PERSON/member/addMemberToGroups";
    public static final HttpApi POST_PERSON_MEMBER_ADDMEMBERTOGROUP = new HttpApi(POST_PERSON_MEMBER_ADDMEMBERTOGROUP_PATH, HttpMethod.POST_JSON);

}
