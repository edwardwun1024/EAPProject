package com.edward.scenario;

import com.edward.service.PersonService;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2020/6/3 20:05
 */
public class PersonScenarioTest {
    @Test(description = "创建人员并加到人组中")
    public void genPersonAndAddPersonToGroups(){
        PersonService personService = new PersonService();
        personService.genPersonAndAddPersonToGoups();
    }
}
