package com.edward.scenario;

import com.edward.service.GunsService;
import org.testng.annotations.Test;

/**
 * 场景测试
 * @author wangcheng
 * @date 2020/5/12 15:23
 */
public class GunsScenarioTest {

    @Test(description = "生成一个admin权限的用户")
    private void genAccountAndSetRoleTest(){
        GunsService gunsService = new GunsService();
        gunsService.genAccountWithAdminRole();
    }
}
