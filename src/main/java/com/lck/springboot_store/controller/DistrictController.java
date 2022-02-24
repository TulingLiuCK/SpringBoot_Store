package com.lck.springboot_store.controller;

import com.lck.springboot_store.entity.District;
import com.lck.springboot_store.service.IDistrictService;
import com.lck.springboot_store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 #Create by LCK on 2022/2/3
 # 用法:
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{

    @Autowired
    IDistrictService districtService;

    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> data = districtService.getByParent(parent);
        return  new JsonResult<>(ok,data);
    }

}
