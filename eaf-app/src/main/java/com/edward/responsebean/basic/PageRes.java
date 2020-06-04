package com.edward.responsebean.basic;

import com.edward.requestbean.sensebi.bean.SensePassV2RecordRequestBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangcheng
 * @date 2020/6/3 15:49
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRes<T> implements Serializable {
    private T data;
    private Integer size;
    private Integer total;
    private String code;
    private String msg;

}
