package com.drcnet.mc.bigdata.bmap.dao;

import com.drcnet.mc.bigdata.bmap.entity.DataContent;
import com.drcnet.mc.bigdata.bmap.entity.DataContentExample;
import java.util.List;

public interface DataContentMapper {
    int insert(DataContent record);

    int insertSelective(DataContent record);

    List<DataContent> selectByExampleWithBLOBs(DataContentExample example);

    List<DataContent> selectByExample(DataContentExample example);
    List<DataContent> selectAll();
}