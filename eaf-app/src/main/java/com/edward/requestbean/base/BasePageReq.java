package com.edward.requestbean.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/3 15:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasePageReq {
    public Integer current;
    public Integer size;
}
