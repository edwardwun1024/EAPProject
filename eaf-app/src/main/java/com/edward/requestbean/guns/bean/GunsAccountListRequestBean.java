package com.edward.requestbean.guns.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/3 15:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GunsAccountListRequestBean{

    private String name;
    private String beginTime;
    private String endTime;
    public Integer current;
    public Integer size;
}