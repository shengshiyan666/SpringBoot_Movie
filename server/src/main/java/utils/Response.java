package utils;


import cn.hutool.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class Response extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Response() {
        put("code", 0);
        put("msg", "success");
    }

    public static Response error() {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, "未知异常");
    }

    public static Response error(String msg) {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, msg);
    }

    public static Response error(int code, String msg) {
        Response response = new Response();
        response.put("code", code);
        response.put("msg", msg);
        return response;
    }

    public static Response ok(String msg) {
        Response response = new Response();
        response.put("msg", msg);
        return response;
    }

    public static Response ok(Map<String, Object> map) {
        Response response = new Response();
        response.putAll(map);
        return response;
    }

    public static Response ok() {
        return new Response();
    }

    public Response put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}