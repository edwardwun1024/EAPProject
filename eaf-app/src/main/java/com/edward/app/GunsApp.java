package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

public class GunsApp {
    public static final String GUNS_MGR_LOGIN_PATH = "/GUNS/mgr/login";
    public static final HttpApi POST_GUNS_MGR_LOGIN = new HttpApi(GUNS_MGR_LOGIN_PATH, HttpMethod.POST.getName());

    public static final String
            GUNS_ACCOUNT_ADD_PATH = "/GUNS/account/add";

}
