package com.edward.swaggertool.services;

import com.edward.http.HttpApi;
import com.edward.http.HttpClientUtil;
import com.edward.http.HttpMethod;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.common.util.StringUtil;
import com.edward.http.exception.HttpProcessException;
import com.edward.swaggertool.models.*;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangcheng
 * @date 2020/6/5 11:43
 */
public class SwaggerService {
    private String address;
    public static final String GET_SWAGGER_RESOURCES_PATH = "/swaggerresources";
    public static final HttpApi GET_SWAGGER_RESOURCES = new HttpApi(GET_SWAGGER_RESOURCES_PATH, HttpMethod.GET);

    //获取当前项目的根目录
    public static final String currentProjectRootPath = Paths.get(".").toAbsolutePath().normalize().toString();


    public SwaggerService(String address) {
        this.address = address;
    }

    /**
     * 获取所有服务
     * @return
     */
    public List<SwaggerProjectModel> getAllProjects() {
        List<SwaggerProjectModel> projects = new ArrayList<SwaggerProjectModel>();
        String httpResponse = doGetBySwaggerResources(GET_SWAGGER_RESOURCES);
        List<SwaggerProjectModel> swaggerProjectModels = new Gson().fromJson(httpResponse, new TypeToken<List<SwaggerProjectModel>>() {
        }.getType());
        return swaggerProjectModels;
    }

    /**
     * 通过每个服务获取每个服务对应的apiList和对应的请求体list
     * @param swaggerProjectModelList
     * @return
     */
    public List<SwaggerApiModleForApp> getAllSwaggerProjectBean(List<SwaggerProjectModel> swaggerProjectModelList) {
        List<SwaggerApiModleForApp> swaggerApiModleForApps = new ArrayList<SwaggerApiModleForApp>();
        //遍历每个project
        for (SwaggerProjectModel swaggerProjectModel : swaggerProjectModelList) {
            String response = doGetBySwaggerResources(new HttpApi(swaggerProjectModel.url, HttpMethod.GET));
            SwaggerProjectBean swaggerProjectBean = new Gson().fromJson(response, SwaggerProjectBean.class);

            //获取definitions 方便后面查parameter
            //todo

            //遍历每一个path
            ArrayList<PathModel> pathModels = new ArrayList<PathModel>();
            Map pathMap = swaggerProjectBean.getPaths();
            for (Object key : pathMap.keySet()) {
                PathModel pathModel = new PathModel();
                pathModel.setUrl(key.toString());
                pathModel.setRequestTypeModel((LinkedTreeMap<String, LinkedTreeMap>) pathMap.get(key));
                pathModels.add(pathModel);
            }

            List<RequestTypeModel> requestTypeModelList = new ArrayList<RequestTypeModel>();
            //遍历每一个path的requestType值
            for (PathModel pathModel : pathModels) {
                String url = pathModel.getUrl();
                Map requestTypeMap = pathModel.getRequestTypeModel();
                //封装成RequestTypeModel类，并加到List集合中
                for (Object key : requestTypeMap.keySet()) {
                    RequestTypeModel requestTypeModel = new RequestTypeModel();
                    requestTypeModel.setUrl(url);
                    requestTypeModel.setRequeType(key.toString());
                    requestTypeModel.setRequestTypeValue((LinkedTreeMap<String, Object>) requestTypeMap.get(key));
                    requestTypeModelList.add(requestTypeModel);
                }
            }

            List<ApiModle> apiModles = new ArrayList<ApiModle>();
            //封装成SwaggerProjectModelPathBean
            for (RequestTypeModel requestTypeModel : requestTypeModelList) {
                //判断


                //todo:判断patameter是否走definition
                //1:

                SwaggerProjectModelPathBean swaggerProjectModelPathBean = new SwaggerProjectModelPathBean();
                swaggerProjectModelPathBean.setTags((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("tags"));
                swaggerProjectModelPathBean.setSummary((String) requestTypeModel.getRequestTypeValue().get("summary"));
                swaggerProjectModelPathBean.setOperationId((String) requestTypeModel.getRequestTypeValue().get("operationId"));
                swaggerProjectModelPathBean.setSchemes((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("schemes"));
                swaggerProjectModelPathBean.setConsumes((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("consumes"));
                swaggerProjectModelPathBean.setProduces((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("produces"));
                swaggerProjectModelPathBean.setParameters((ArrayList<LinkedTreeMap>) requestTypeModel.getRequestTypeValue().get("parameters"));
                swaggerProjectModelPathBean.setResponses((LinkedTreeMap<String, LinkedTreeMap<String, LinkedTreeMap>>) requestTypeModel.getRequestTypeValue().get("responses"));
                swaggerProjectModelPathBean.setSecurity((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("security"));
                swaggerProjectModelPathBean.setType((String) requestTypeModel.getRequestTypeValue().get("type"));

                ApiModle apiModle = new ApiModle();
                apiModle.setUrl(requestTypeModel.getUrl());
                apiModle.setRequestType(requestTypeModel.getRequeType());
                apiModle.setSwaggerProjectModelPathBean(swaggerProjectModelPathBean);
                apiModles.add(apiModle);

            }

            //生成每个app对应的apimodel
            SwaggerApiModleForApp swaggerApiModleForApp = new SwaggerApiModleForApp();
            swaggerApiModleForApp.setAppName(swaggerProjectModel.name);
            swaggerApiModleForApp.setDefinitions(swaggerProjectBean.getDefinitions());
            swaggerApiModleForApp.setApiModles(apiModles);

            //将所有的SwaggerApiModleForApp装到list中，并返回
            swaggerApiModleForApps.add(swaggerApiModleForApp);
        }

        return swaggerApiModleForApps;
    }

    //

    /**
     * 遍历通过swaggerApiModleForApps，SwaggerApiModleForApp向指定目录中写入文件
     * @param swaggerApiModleForApps
     */
    public void writeFileBySwaggerApiModleForApps(List<SwaggerApiModleForApp> swaggerApiModleForApps) {
//        for(int i=0;i<swaggerApiModleForApps.size();i++){
//            System.out.println("=====================开始生成文件：" + swaggerApiModleForApps.get(i) + "=========== i =" + i);
//            genFile(swaggerApiModleForApps.get(i));
//        }
//        genFile(swaggerApiModleForApps.get(1));

    }


    //

    /**
     *  向指定目录写入文件
     *  1、向指定文件目录写入 xxxRequestBean.java
     *  2、根据apiModel 生成追加app内容并返回httpApiName
     *  3、根据apiModel 和生成的requestBean 生成or追加appcaller内容
     * @param swaggerApiModleForApp
     */
    public void genFile(SwaggerApiModleForApp swaggerApiModleForApp) {

        //1、生成requesBean
        String requestBeanFileLocalPath = "\\eaf-app\\src\\main\\java\\com\\edward\\requestbean";
        String packageName = swaggerApiModleForApp.getAppName();
        Object definitionsObj = swaggerApiModleForApp.getDefinitions();
        String requestBeanPath = currentProjectRootPath + requestBeanFileLocalPath + "\\" + packageName + "\\bean\\";


        List<ApiModle> apiModleList = swaggerApiModleForApp.getApiModles();
        for (ApiModle apiModle : apiModleList) {
            String url = apiModle.getUrl();
            String requestType = apiModle.getRequestType();
            String requestBeanName = StringUtil.changeaToAFromString(url) + "RequestBean";
            String requestBeanFileName = requestBeanName + ".java";
            String summary = apiModle.getSwaggerProjectModelPathBean().getSummary(); //接口功能
            String consumes = apiModle.getSwaggerProjectModelPathBean().getConsumes().toString(); //请求方式：application/json 。。。
            String parametersContent = "";


            //如果没有参数就直接返回
            if (apiModle.getSwaggerProjectModelPathBean().getParameters().size() == 0)
                break;

            //单个接口中所有参数
            ArrayList<LinkedTreeMap> parameters = apiModle.getSwaggerProjectModelPathBean().getParameters();
            //遍历参数，获取参数名称并写入parametersContent
            for (LinkedTreeMap parameterDetail : parameters) {
                String parameterIn = parameterDetail.get("in").toString(); //body、header
                String parameterName = (String) parameterDetail.get("name");
                String parameterType = (String) parameterDetail.get("type"); //string 参数数据类型(header参数)
                Map<String, String> parameterSchema = (Map<String, String>) parameterDetail.get("schema");
                String reqParaBodyKey = null;

                //Header参数
                if (parameterIn.equals("header")) {
                    parametersContent += "\tprivate String " + parameterName + "; //Header参数\n";
                } else {
                    //参数不需要通过路径映射来获取（直接再parameter中）
                    if (parameterSchema.containsKey("type")) {
                        //如果不是header参数就放到bean中
                        if (!parameterIn.equals("header")) {
                            switch (parameterSchema.get("type")) {
                                case "string":
                                    parametersContent += "\tprivate String " + parameterName + ";\n";
                                    break;
                                case "int":
                                    parametersContent += "\tprivate Integer " + parameterName + ";\n";
                                    break;
                            }
                        }
                    } else if (parameterSchema.containsKey("$ref")) { //参数需要通过路径映射来获取（通过key从definitions中获取）
                        String reqParaBodyPath = parameterSchema.get("$ref");
                        reqParaBodyKey = reqParaBodyPath.substring(14);
                        Map<String, Object> definitionsMaps = (Map<String, Object>) definitionsObj;
                        LinkedTreeMap<String, Object> definition = (LinkedTreeMap<String, Object>) definitionsMaps.get(reqParaBodyKey);
                        LinkedTreeMap<String, LinkedTreeMap<String, String>> properties = (LinkedTreeMap<String, LinkedTreeMap<String, String>>) definition.get("properties");
                        String content = null;
                        for (Map.Entry<String, LinkedTreeMap<String, String>> entry : properties.entrySet()) {
                            String name = entry.getKey();
                            String type = entry.getValue().get("type");
                            String ref = entry.getValue().get("$ref");
                            if(type == null && ref != null){
                                parametersContent += "\tprivate String " + name + "; //需要特殊处理的参数\n";
                            }else {
                                switch (type) {
                                    case "string":
                                        parametersContent += "\tprivate String " + name + ";\n";
                                        break;
                                    case "integer":
                                        parametersContent += "\tprivate Integer " + name + ";\n";
                                        break;
                                    default:
                                        parametersContent += "\tprivate String " + name + "; //默认给出String\n";
                                }
                            }

                        }

                    }

                }

            }

            //RequestBean Head Content
            String content =
                            "package com.edward.requestbean." + packageName + ".bean;\n" +
                            "\n" +
                            "import lombok.AllArgsConstructor;\n" +
                            "import lombok.Builder;\n" +
                            "import lombok.Data;\n" +
                            "import lombok.NoArgsConstructor;\n" +
                            "\n" +
                            "@Data\n" +
                            "@Builder\n" +
                            "@NoArgsConstructor\n" +
                            "@AllArgsConstructor\n" +
                            "public class " + requestBeanName + " {\n" +
                            "\n" +
                             parametersContent +
                            "}";

            try {
                createFile(requestBeanPath, requestBeanFileName, content);
                //2、根据apiModel 生成追加app内容并返回httpApiName
                String httpApiName = genAppFile(packageName,url,requestType);
                //3、根据apiModel 和生成的requestBean 生成追加appcaller内容
                 genAppcallerFile(url,packageName,requestBeanName,httpApiName);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 2、向指定文件目录写入 xxxApp.java
     * @param packageName
     * @param path
     * @param requestType
     * @return
     */
    public String genAppFile(String packageName,String path,String requestType) throws IOException {
        String appFileLocalPath = "\\eaf-app\\src\\main\\java\\com\\edward\\app\\";
        String appFilePath = currentProjectRootPath + appFileLocalPath;
        String appName = StringUtil.changeaToA(packageName) + "App";
        String appFileName = appName + ".java";
        String pathName = StringUtil.changeAaaBbbToAAA_BBB(path).substring(1);
        String httpApiName = requestType.toUpperCase() + "_" + pathName;
        String httpMethod = "";
        switch (requestType){
            case "post":
                httpMethod = "HttpMethod.POST_JSON";
                break;
            case "get":
                httpMethod = "HttpMethod.GET";
        }
        String httpApiValue = "new HttpApi(" + pathName + "," + httpMethod + ")";
        String appFileContent =
                "package com.edward.app;\n" +
                "\n" +
                "import com.edward.http.HttpApi;\n" +
                "import com.edward.http.HttpMethod;\n" +
                "\n" +
                "public class " + appName + "{\n" +
                "\n" +
                "}"+
                "\n";

        String content =
                        "private static final String " + pathName + " = " + "\"" + path + "\"" + ";\n" +
                        "public static final HttpApi " + httpApiName + " = " + httpApiValue + ";\n" +
                        "\n";

        createFile(appFilePath, appFileName, appFileContent, content);
        System.out.println("生成app： " + appName);

        return httpApiName;
    }

    //

    /**
     * 3、向指定文件目录写入 xxxAppcaller.java
     * @param url
     * @param packageName
     * @param requestBeanName
     * @param httpApiName
     * @return
     * @throws IOException
     */
    public void genAppcallerFile(String url,String packageName,String requestBeanName,String httpApiName) throws IOException {
            String appcallerFileLocalPath = "\\eaf-app\\src\\main\\java\\com\\edward\\appcaller\\";
            String appcallerPath = currentProjectRootPath + appcallerFileLocalPath;
            String appcallerPackageName = packageName;
            String appcallerName = StringUtil.changeaToA(appcallerPackageName) + "AppCaller";
            String appcallerFileName = appcallerName + ".java";
            String appcallerFileContent =
                    "package com.edward.appcaller;\n" +
                            "\n" +
                            "import com.edward.app.AbstractServiceCaller;\n" +
                            "import com.edward.http.HttpApi;\n" +
                            "import com.edward.requestbean."+appcallerPackageName+".bean.*;\n" +
                            "import static com.edward.app."+StringUtil.changeaToA(appcallerPackageName) + "App"+".*;\n" +
                            "\n" +
                            "public class " + appcallerName + " extends AbstractServiceCaller {\n" +
                            "\n" +
                            "}\n";
            String content =
                    "\tpublic String get"+StringUtil.changeaToAFromString(url)+"("+requestBeanName+" requestBean){\n" +
                            "\t\treturn this.get"+StringUtil.changeaToAFromString(url)+"("+httpApiName+",requestBean);\n" +
                            "\t}\n" +
                            "\tprivate String get"+StringUtil.changeaToAFromString(url)+"(HttpApi "+httpApiName+", "+requestBeanName+" requestBean){\n" +
                            "\t\treturn doPost("+httpApiName+",requestBean);\n" +
                            "\t}\n";
            createFile(appcallerPath, appcallerFileName,appcallerFileContent, content);
            System.out.println("生成appcaller： " + appcallerName);
    }


    /**
     * @param filePath       文件目录
     * @param fileName       文件名
     * @param appFileContent 文件不存在时，创建文件内容
     * @param content        文件已创建时，追加文件内容
     * @throws IOException
     */
    public void createFile(String filePath, String fileName, String appFileContent, String content) throws IOException {
        File dir = new File(filePath);
        // 一、检查放置文件的文件夹路径是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdirs();// mkdirs创建多级目录
        }
        File checkFile = new File(filePath + fileName);
        FileWriter writer = null;
        try {
            // 二、检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                checkFile.createNewFile(); // 创建目标文件
                writer = new FileWriter(checkFile, true);
                writer.append(appFileContent);
                writer.append(content);
            } else {
                // 向目标文件中追加内容
                writer = new FileWriter(checkFile, true);
                writer.append(content);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer)
                writer.close();
        }
    }

    /**
     *  在指定路径下创建文件
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @param appFileContent 文件内容
     * @throws IOException
     */
    public void createFile(String filePath, String fileName, String appFileContent) throws IOException {
        File dir = new File(filePath);
        // 一、检查放置文件的文件夹路径是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdirs();// mkdirs创建多级目录
        }
        File checkFile = new File(filePath + fileName);
        FileWriter writer = null;
        try {
            // 二、检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                checkFile.createNewFile(); // 创建目标文件
            }
            // 写入内容
            writer = new FileWriter(checkFile, true);
            writer.append(appFileContent);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer)
                writer.close();
        }
    }


    /**
     * 通过httpclient发送get请求
     * @param httpApi swagger api
     * @return
     */
    public String doGetBySwaggerResources(HttpApi httpApi) {
        HttpHeader header = HttpHeader.custom();
        HttpConfig httpConfig = HttpConfig.custom();

        httpConfig.method(httpApi.httpMethod.getHttpMethods());
        httpConfig.url(address + httpApi.path);

        String response = null;
        try {
            response = HttpClientUtil.get(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }

        return response;

    }

}
