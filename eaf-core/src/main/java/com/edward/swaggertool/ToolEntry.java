package com.edward.swaggertool;

import com.edward.swaggertool.models.SwaggerApiModleForApp;
import com.edward.swaggertool.models.SwaggerItemModel;
import com.edward.swaggertool.models.SwaggerProjectBean;
import com.edward.swaggertool.models.SwaggerProjectModel;
import com.edward.swaggertool.services.SwaggerService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangcheng
 * @date 2020/6/5 11:45
 */
public class ToolEntry {

    public static void main(String[] args){
        SwaggerService swaggerService = new SwaggerService("http://10.151.3.203:8777");
        List<SwaggerProjectModel> projectModelList = swaggerService.getAllProjects();
        System.out.println(projectModelList.toString());

        //获取所有app的api
        List<SwaggerApiModleForApp> swaggerApiModleForApps = swaggerService.getAllSwaggerProjectBean(projectModelList);
        //写文件
//        swaggerService.writeFileBySwaggerApiModleForApps(swaggerApiModleForApps);
        System.out.println(swaggerApiModleForApps.toString());

    }
}
