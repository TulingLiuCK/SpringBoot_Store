package com.lck.springboot_store.entity;

import lombok.Data;

import java.io.Serializable;

/***
 #Create by LCK on 2022/2/6
 # 用法:
 */
@Data
public class OrderItem extends BaseEntity implements Serializable {
    private Integer id;
    private Integer oid;
    private Integer pid;
    private String title;
    private String image;
    private Long price;
    private Integer num;
}
