package com.critc.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by 孔垂云 on 2017/5/14.
 * Json工具的具体操作
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 把对象转成json串
     *
     * @param obj
     * @return
     */
    public static String toStr(Object obj) {
        String json_str = "";
        try {
            json_str = objectMapper.writer().writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json_str;
    }

    /**
     * 把字符串转成List，统一保存时使用
     *
     * @param str
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<LinkedHashMap<String, Object>> toList(String str) {
        List<LinkedHashMap<String, Object>> list = null;
        try {
            list = objectMapper.readValue(str, List.class);// 把list对象转成LinkedhashMap,然后根据HashMap来取值
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * json转对象
     *
     * @param jsonStr
     * @param valueType
     * @return
     */
    public static <T> T toObject(String jsonStr, Class<T> valueType) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //对象转json
        User user = new User(1, "张三", new Date());
        System.out.println(JsonUtil.toStr(user));

        List<User> listUser = new ArrayList<>();
        listUser.add(user);
        System.out.println(JsonUtil.toStr(listUser));

        //json转对象
        User user2 = JsonUtil.toObject("{\"id\":1,\"name\":\"张三\",\"createDate\":\"2017-05-14 20:18:49\"}", User.class);
        System.out.println(user2.toString());

        List<User> list2 = JsonUtil.toObject("[{\"id\":1,\"name\":\"张三\",\"createDate\":\"2017-05-14 20:22:12\"}]", List.class);
        System.out.println(list2.toString());
    }

}
