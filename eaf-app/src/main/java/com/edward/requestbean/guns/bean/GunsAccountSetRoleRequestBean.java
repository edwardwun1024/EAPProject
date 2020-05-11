package com.edward.requestbean.guns.bean;

/**
 * @author wangcheng
 * @date 2020/5/11 18:08
 */
public class GunsAccountSetRoleRequestBean {
    private Integer userId;
    private String roleIds;

    public GunsAccountSetRoleRequestBean() {
    }

    public GunsAccountSetRoleRequestBean(Integer userId, String roleIds) {
        this.userId = userId;
        this.roleIds = roleIds;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "GunsAccountSetRoleRequestBean{" +
                "userId=" + userId +
                ", roleIds='" + roleIds + '\'' +
                '}';
    }
}
