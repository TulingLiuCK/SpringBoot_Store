package com.lck.springboot_store.entity;

import lombok.Data;

/***
 #Create by LCK on 2022/2/5
 # 用法:
 */
@Data
public class Cart extends BaseEntity {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;

}
