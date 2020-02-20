package com.drcnet.mc.bigdata.bmap.dao;

import com.drcnet.mc.bigdata.bmap.entity.GovPurchaseData;
import com.drcnet.mc.bigdata.bmap.entity.GovPurchaseDataExample;
import com.drcnet.mc.bigdata.bmap.entity.GovPurchaseDataWithBLOBs;
import java.util.List;

public interface GovPurchaseDataMapper {
    int deleteByPrimaryKey(Integer urlId);

    int insert(GovPurchaseDataWithBLOBs record);

    int insertSelective(GovPurchaseDataWithBLOBs record);

    List<GovPurchaseDataWithBLOBs> selectByExampleWithBLOBs(GovPurchaseDataExample example);

    List<GovPurchaseData> selectByExample(GovPurchaseDataExample example);

    GovPurchaseDataWithBLOBs selectByPrimaryKey(Integer urlId);

    int updateByPrimaryKeySelective(GovPurchaseDataWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GovPurchaseDataWithBLOBs record);

    int updateByPrimaryKey(GovPurchaseData record);
}