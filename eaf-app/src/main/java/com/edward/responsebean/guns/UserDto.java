package com.edward.responsebean.guns;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/3 15:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String depName;
    private String createTime;
    private String accountType;
    private Integer depId;
    private String phone;
    private String sexName;
    private String name;
    private String roleName;
    private String statusName;
    private Integer id;
    private String account;
    private String email;
    private Integer status;

}
