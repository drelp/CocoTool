package com.luomor.coco.tool.dao;

import com.luomor.coco.tool.domain.TMsgHttp;

import java.util.List;

public interface TMsgHttpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMsgHttp record);

    int insertSelective(TMsgHttp record);

    TMsgHttp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMsgHttp record);

    int updateByPrimaryKey(TMsgHttp record);

    TMsgHttp selectByMsgName(String msgName);

    int updateByMsgName(TMsgHttp tMsgHttp);

    List<TMsgHttp> selectAll();
}