package com.zjs.del.mapper;

import com.zjs.del.model.entity.HistAddrWritePro;
import org.apache.ibatis.annotations.Param;

public interface HistAddrMapper {

    HistAddrWritePro findHistAddrByAddress(@Param("tableName")String tableName,
                                        @Param("address")String address);
}
