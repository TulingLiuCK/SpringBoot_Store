package com.lck.springboot_store.vo;

import lombok.Data;

import java.io.Serializable;

/***
 #Create by LCK on 2022/2/6
 # 用法:表示购物车数据的VO类（Value Object）
 */
@Data
public class CartVO implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    private String title;
    private String image;
    private Long realPrice;

}
