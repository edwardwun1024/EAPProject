package com.edward.http;

public class HttpApi {

    public String path;
    public String httpType;

    public HttpApi() {
    }

    public HttpApi(String path, String httpType) {
        this.path = path;
        this.httpType = httpType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHttpType() {
        return httpType;
    }

    public void setHttpType(String httpType) {
        this.httpType = httpType;
    }

    @Override
    public String toString() {
        return "HttpApi{" +
                "path='" + path + '\'' +
                ", httpType='" + httpType + '\'' +
                '}';
    }
}
