package com.edward.responsebean.guns;

/**
 * @author wangcheng
 * @date 2020/5/27 14:35
 */
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

    public ZTreeNode() {
    }

    public ZTreeNode(Integer id, String code, Integer pId, String pcode, String cnName, String enName, String name, Boolean open, Boolean checked, Boolean created) {
        this.id = id;
        this.code = code;
        this.pId = pId;
        this.pcode = pcode;
        this.cnName = cnName;
        this.enName = enName;
        this.name = name;
        this.open = open;
        this.checked = checked;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ZTreeNode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", pId=" + pId +
                ", pcode='" + pcode + '\'' +
                ", cnName='" + cnName + '\'' +
                ", enName='" + enName + '\'' +
                ", name='" + name + '\'' +
                ", open=" + open +
                ", checked=" + checked +
                ", created=" + created +
                '}';
    }
}
