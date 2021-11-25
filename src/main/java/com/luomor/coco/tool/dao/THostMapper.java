package com.luomor.coco.tool.dao;

import com.luomor.coco.tool.domain.THost;

import java.util.List;

public interface THostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(THost record);

    int insertSelective(THost record);

    THost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(THost record);

    int updateByPrimaryKey(THost record);

    List<THost> selectAll();

    THost selectByName(String name);

    int updateByName(THost tHost);
}