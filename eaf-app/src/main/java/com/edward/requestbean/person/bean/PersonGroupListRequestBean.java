package com.edward.requestbean.person.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonGroupListRequestBean {
    private String current;
    private String size;
    private String cnName;
    private String groupId;

}
