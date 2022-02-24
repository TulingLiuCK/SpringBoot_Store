package com.lck.springboot_store.entity;

import lombok.Data;

/***
 #Create by LCK on 2022/2/3
 # 用法: 省市区的数据实体类
 */
@Data
public class District extends BaseEntity{
    private Integer id;
    private String parent;
    private String code;
    private String name;

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        District district = (District) o;

        if (id != null ? !id.equals(district.id) : district.id != null) return false;
        if (parent != null ? !parent.equals(district.parent) : district.parent != null) return false;
        if (code != null ? !code.equals(district.code) : district.code != null) return false;
        return name != null ? name.equals(district.name) : district.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
