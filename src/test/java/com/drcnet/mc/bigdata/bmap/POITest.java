package com.drcnet.mc.bigdata.bmap;

/**
 * @author tengchao.li
 * @description
 * @date 2019/12/11
 */


import com.drcnet.mc.bigdata.bmap.dao.DataContentMapper;
import com.drcnet.mc.bigdata.bmap.entity.DataContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

/**
 * @author tengchao.li
 * @description
 * @date 2019/10/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(value = "application.yml")
@WebAppConfiguration
public class POITest {
   /* @Autowired
    private DataMapper dataMapper;*/
    @Autowired
    private DataContentMapper mapper;

    @Test
    public void test(){

        List<DataContent> dataContents = mapper.selectAll();

        System.out.println(dataContents.hashCode());
    }


}
