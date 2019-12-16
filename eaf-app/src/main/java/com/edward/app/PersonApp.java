package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

public class PersonApp {
    public static final String POST_PERSON_GROUP_LIST_PATH = "/PERSON/personGroup/list";
    public static final HttpApi POST_PERSON_GROUP_LIST = new HttpApi(POST_PERSON_GROUP_LIST_PATH, HttpMethod.POST.getName());

}
