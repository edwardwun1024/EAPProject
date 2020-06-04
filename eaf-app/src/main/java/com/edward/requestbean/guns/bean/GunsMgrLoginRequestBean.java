package com.edward.requestbean.guns.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GunsMgrLoginRequestBean {
    private String username;
    private String password;
    private String accountType;
    private Integer userId;

}
