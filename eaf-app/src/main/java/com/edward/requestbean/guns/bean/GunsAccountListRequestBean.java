package com.edward.requestbean.guns.bean;

import com.edward.requestbean.base.BasePageReq;
import com.sun.istack.internal.NotNull;
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
    @NotNull
    public Integer current;
    @NotNull
    public Integer size;
}
