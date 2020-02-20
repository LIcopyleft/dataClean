package com.drc.dataClean;

import com.drc.dataClean.dao.DataContentMapper;
import com.drc.dataClean.model.DataContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(value="application.yml")
public class DataCleanTest {

    @Autowired
    DataContentMapper mapper;

    @Test
    public void test(){


        List<DataContent> list = mapper.findList();

    }


}
