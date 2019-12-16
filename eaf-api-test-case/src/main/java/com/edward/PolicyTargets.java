package com.edward;

public class PolicyTargets {
    private String targetId;
    private String targetValue;
    private String operator;
    private String classId;

    public PolicyTargets() {
    }

    public PolicyTargets(String targetId, String targetValue, String operator, String classId) {
        this.targetId = targetId;
        this.targetValue = targetValue;
        this.operator = operator;
        this.classId = classId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "PolicyTargets{" +
                "targetId='" + targetId + '\'' +
                ", targetValue='" + targetValue + '\'' +
                ", operator='" + operator + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}
