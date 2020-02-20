package com.drc.dataClean.dao;

import com.drc.dataClean.model.DataContent;
import com.drc.dataClean.model.DataContentExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface DataContentMapper {
    int insert(DataContent record);

    int insertSelective(DataContent record);

    List<DataContent> selectByExampleWithBLOBs(DataContentExample example);

    List<DataContent> selectByExample(DataContentExample example);
    List<DataContent> findList();
}