package com.seehope.dao;

import com.seehope.entity.Mobile;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.seehope.entity
 * @Author XSH
 * @Date 2022-09-19 19:30
 * @Version 1.0.0
 * @Description：
 **/
public class MobileDao {

    private static Map<String, Mobile> mobileMap = new HashMap<>();

    static {
        mobileMap.put("1", new Mobile(1, "苹果手机", "青铜型", 9999, "xxx.png"));
        mobileMap.put("2", new Mobile(2, "三星手机", "白银型", 7899, "sss.png"));
        mobileMap.put("3", new Mobile(3, "小米手机", "黄金型", 3999, "mmm.png"));
        mobileMap.put("4", new Mobile(4, "华为手机", "钻石型", 9999, "hhh.png"));

    }

    public static Map<String, Mobile> findAllMobiles() {
        return mobileMap;
    }

    public static Mobile findById(String id) {
        return mobileMap.get(id);
    }
}






