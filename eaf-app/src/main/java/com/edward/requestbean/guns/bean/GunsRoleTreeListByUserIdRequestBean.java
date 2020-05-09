package com.edward.requestbean.guns.bean;

/**
 * @author wangcheng
 * @date 2020/5/9 15:20
 */
public class GunsRoleTreeListByUserIdRequestBean {
    private Integer userId;

    public GunsRoleTreeListByUserIdRequestBean() {
    }

    public GunsRoleTreeListByUserIdRequestBean(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GunsRoleTreeListByUserIdRequestBean{" +
                "userId=" + userId +
                '}';
    }
}
