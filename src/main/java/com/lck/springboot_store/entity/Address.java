package com.lck.springboot_store.entity;

import lombok.Data;

import java.io.Serializable;

/***
 #Create by LCK on 2022/2/3
 # 用法:
 */
@Data
public class Address extends BaseEntity implements Serializable {
    private Integer aid;
    private Integer uid;
    private String name;
    private String provinceName;
    private String provinceCode;
    private String cityName;
    private String cityCode;
    private String areaName;
    private String areaCode;
    private String zip;
    private String address;
    private String phone;
    private String tel;
    private String tag;
    private Integer isDefault;

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", tag='" + tag + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Address address1 = (Address) o;

        if (aid != null ? !aid.equals(address1.aid) : address1.aid != null) return false;
        if (uid != null ? !uid.equals(address1.uid) : address1.uid != null) return false;
        if (name != null ? !name.equals(address1.name) : address1.name != null) return false;
        if (provinceName != null ? !provinceName.equals(address1.provinceName) : address1.provinceName != null)
            return false;
        if (provinceCode != null ? !provinceCode.equals(address1.provinceCode) : address1.provinceCode != null)
            return false;
        if (cityName != null ? !cityName.equals(address1.cityName) : address1.cityName != null) return false;
        if (cityCode != null ? !cityCode.equals(address1.cityCode) : address1.cityCode != null) return false;
        if (areaName != null ? !areaName.equals(address1.areaName) : address1.areaName != null) return false;
        if (areaCode != null ? !areaCode.equals(address1.areaCode) : address1.areaCode != null) return false;
        if (zip != null ? !zip.equals(address1.zip) : address1.zip != null) return false;
        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;
        if (phone != null ? !phone.equals(address1.phone) : address1.phone != null) return false;
        if (tel != null ? !tel.equals(address1.tel) : address1.tel != null) return false;
        if (tag != null ? !tag.equals(address1.tag) : address1.tag != null) return false;
        return isDefault != null ? isDefault.equals(address1.isDefault) : address1.isDefault == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (aid != null ? aid.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (provinceName != null ? provinceName.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (areaCode != null ? areaCode.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (isDefault != null ? isDefault.hashCode() : 0);
        return result;
    }
}
