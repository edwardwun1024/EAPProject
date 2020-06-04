package com.edward.responsebean.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonGroupListRes {
    private String groupId;
    private String cnName;
    private String enName;
    private String type;
    private String sts;
    private String memberCount;
    private String createTs;
    private String lastModTs;
    private String privilege;

}
