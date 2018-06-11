package com.ning.springbootdemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ning
 * 创建于 2017年10月19日下午3:31:25
 * //TODO json工具类
 */
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {
    }

    static class UserDTO{
        private String username;
        private Integer age;
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        private Date createTime;

        public UserDTO() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        @Override
        public String toString() {
            return "UserDTO{" +
                    "username='" + username + '\'' +
                    ", age=" + age +
                    ", createTime=" + createTime +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<UserDTO> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            UserDTO user = new UserDTO();
            user.setUsername("张三");
            user.setAge(12 + i);
            user.setCreateTime(new Date());
            userList.add(user);
            System.out.println(toJsonFromObj(user));
        }
        System.out.println(fromJson(toJsonFromObj(userList.get(0)),UserDTO.class));

        System.out.println(toJsonFromArry(userList));

        System.out.println(fromListJson(toJsonFromArry(userList), UserDTO.class));

    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return JSON.parseObject(json,clazz);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("JsonUtil fromJson Type:" + clazz.getName() + ", Json:" + json, e);
            return null;
        }
    }


    public static <T> List<T> fromListJson(String json, Class<T> clazz) {
        try {
            return JSON.parseArray(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("JsonUtil fromJson Type:List<" + clazz.getName() + ">, Json:" + json, e);
            return null;
        }
    }


    public static String toJsonFromObj(Object obj) {
       return JSONObject.toJSONString(obj);
    }

    public static <T> String toJsonFromArry(List<T> list) {
        String pojoJson = JSONArray.toJSONString(list);
        return pojoJson;
    }


}
