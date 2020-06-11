package com.edward.requestbean.utility.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/9 10:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilityOtaListAppByProductRequestBean {
    private String product;
}
