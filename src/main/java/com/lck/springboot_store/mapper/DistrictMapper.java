package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.District;

import java.util.List;

/***
 #Create by LCK on 2022/2/3
 # 用法:
 */
public interface DistrictMapper {

    /**
    *描述: 根据父代号查询区域信息
     * @param parent
     */
    List<District> findByParent(String parent);

    /**
    *描述:获得省市区的名称
     * @param code
     */
    String findNameByCode(String code);
}
