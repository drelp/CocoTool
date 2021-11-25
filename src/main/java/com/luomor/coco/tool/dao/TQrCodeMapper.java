package com.luomor.coco.tool.dao;

import com.luomor.coco.tool.domain.TQrCode;

public interface TQrCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TQrCode record);

    int insertSelective(TQrCode record);

    TQrCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TQrCode record);

    int updateByPrimaryKey(TQrCode record);
}