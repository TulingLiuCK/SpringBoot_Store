package com.lck.springboot_store.service.impl;

import com.lck.springboot_store.entity.District;
import com.lck.springboot_store.mapper.DistrictMapper;
import com.lck.springboot_store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 #Create by LCK on 2022/2/3
 # 用法:
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        //进行网络数据传输时，为了尽量避免无效数据的传递，可以将无效数据设置为null  可以节省流量的开销。另一方面提升了效率。
        for (District d : list) {
            d.setParent(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
