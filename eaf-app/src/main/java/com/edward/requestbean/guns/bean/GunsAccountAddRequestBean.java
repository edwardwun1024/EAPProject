package com.edward.requestbean.guns.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wangcheng
 * @date 2019/12/16 14:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GunsAccountAddRequestBean {

    private String account;
    private String name;
    private String password;
    private String rePassword;
    private String email;
    private String phone;
    private Integer deptid;
    private String accountType;
    private Integer createUser;
}
