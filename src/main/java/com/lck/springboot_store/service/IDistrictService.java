package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.District;

import java.util.List;

/***
 #Create by LCK on 2022/2/3
 # 用法:
 */
public interface IDistrictService {
    /**
     * 描述: 根据父代号来查询区域信息
     * @param parent
     */
    List<District> getByParent(String parent);

    String getNameByCode(String code);
}
