package com.edward.requestbean.person.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/3 17:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonCreateRequestBean {
    private String birthday;
    private String cnName; //not null
    private String desc;
    private String documentId;
    private String enName;
    private String expireDate;
    private String idCountry;
    private String idExpiryDate;
    private String idNumber;
    private String idType;
    private String imageURI; //not null
    private String operatePerson; //not null
    private String personTag;
    private String personType;
    private String privilege;
    private String sex;

}
