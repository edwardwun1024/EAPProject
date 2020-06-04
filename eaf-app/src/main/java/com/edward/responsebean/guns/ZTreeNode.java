package com.edward.responsebean.guns;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/5/27 14:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZTreeNode {
    private Integer id;	//节点id
    private String code;
    private Integer pId;//父节点id
    private String pcode;
    private String cnName;//节点中文名称
    private String enName;//节点英文名称
    private String name;
    private Boolean open;//是否打开节点
    private Boolean checked;//是否被选中
    private Boolean created;


}
