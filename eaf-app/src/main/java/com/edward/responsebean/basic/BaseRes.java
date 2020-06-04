package com.edward.responsebean.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//基类返回体
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseRes<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

}
