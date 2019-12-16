package com.edward.responsebean.person;

import java.io.Serializable;

public class PageRes<T> implements Serializable {
    private T data;
    private Integer size;
    private Integer total;
    private String code;
    private String msg;
}