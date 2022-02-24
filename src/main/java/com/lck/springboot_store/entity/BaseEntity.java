package com.lck.springboot_store.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 #Create by LCK on 2022/1/28
 # 用法: 作为实体类的基类
 */
@Data
public class BaseEntity  implements Serializable {
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;


    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;
        if (modifiedUser != null ? !modifiedUser.equals(that.modifiedUser) : that.modifiedUser != null) return false;
        return modifiedTime != null ? modifiedTime.equals(that.modifiedTime) : that.modifiedTime == null;
    }

    @Override
    public int hashCode() {
        int result = createdUser != null ? createdUser.hashCode() : 0;
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (modifiedUser != null ? modifiedUser.hashCode() : 0);
        result = 31 * result + (modifiedTime != null ? modifiedTime.hashCode() : 0);
        return result;
    }
}
