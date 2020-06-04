package com.edward.requestbean.guns.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/5/9 15:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GunsRoleTreeListByUserIdRequestBean {
    private Integer userId;
}
