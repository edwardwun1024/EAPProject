package com.edward.requestbean.person.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/4 10:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonGroupCreateRequestBean {
    private String cnName; //英文名字
    private String enName; //中文名
    private String type;  //0:目标人组  1：Nebula特定白名单
    private String desc;
    private String inGroupValidHour; //有效时间
    private String operatePerson;
}
