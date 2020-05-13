package com.edward.http;

public class HttpApi {

    public String path;
    public HttpMethod httpMethod;

    public HttpApi() {
    }

    public HttpApi(String path, HttpMethod httpMethod) {
        this.path = path;
        this.httpMethod = httpMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpType) {
        this.httpMethod = httpMethod;
    }

    @Override
    public String toString() {
        return "HttpApi{" +
                "path='" + path + '\'' +
                ", httpMethod=" + httpMethod +
                '}';
    }
}
