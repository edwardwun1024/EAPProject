package com.edward.requestbean.guns.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/5/11 18:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GunsAccountSetRoleRequestBean {
    private Integer userId;
    private String roleIds;
}
