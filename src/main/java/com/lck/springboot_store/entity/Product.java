package com.lck.springboot_store.entity;

import lombok.Data;

import java.io.Serializable;

/***
 #Create by LCK on 2022/2/5
 # 用法:商品数据的实体类
 */
@Data
public class Product extends BaseEntity implements Serializable {
    private Integer id;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String image;
    private Integer status;
    private Integer priority;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (categoryId != null ? !categoryId.equals(product.categoryId) : product.categoryId != null) return false;
        if (itemType != null ? !itemType.equals(product.itemType) : product.itemType != null) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (sellPoint != null ? !sellPoint.equals(product.sellPoint) : product.sellPoint != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (num != null ? !num.equals(product.num) : product.num != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (status != null ? !status.equals(product.status) : product.status != null) return false;
        return priority != null ? priority.equals(product.priority) : product.priority == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (itemType != null ? itemType.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (sellPoint != null ? sellPoint.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }
}
