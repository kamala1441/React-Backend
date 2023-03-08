package com.rejola.BProject.shared;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rejola.BProject.utils.Json;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResultBuilder implements Serializable {
    public static JsonNode errorJson(String errorMessage, int code) {
        ObjectNode json=	Json.newObject();
        json.put("status", false);
        json.put("statusCode", 400);
        json.put("message", errorMessage);
        return json;
    }

    public static JsonNode errorJson(String errorMessage) {
        ObjectNode json=	Json.newObject();
        json.put("status", false);
        json.put("statusCode", 400);
        json.put("message", errorMessage);
        return json;
    }

    public static JsonNode  successJson(String message) {
        ObjectNode json=	Json.newObject();
        json.put("statxus", true);
        json.put("statusCode", 200);
        json.put("message", message);
        return json;
    }
    public static JsonNode  successJson(List<?> message) {
        ObjectNode json=	Json.newObject();
        json.put("status", true);
        json.put("statusCode", 200);
        json.set("message", Json.toJson(message));
        return json;
    }
    public static JsonNode  successJson(Map<?, ?> message) {
        ObjectNode json=	Json.newObject();
        json.put("status", true);
        json.put("statusCode", 200);
        json.set("message", Json.toJson(message));
        return json;
    }
    @SuppressWarnings("unused")
    public static JsonNode  customJson(int code, String message) {
        ObjectNode json=	Json.newObject();
        json.put("statusCode", code);
        json.put("message", message);
        return json;
    }

    public static JsonNode successJson(String message, Object obj, String keyName){
        ObjectNode json=	Json.newObject();
        json.put("status", true);
        json.put("statusCode", 200);
        json.put("message", message);
        json.set("data",Json.newObject().set(keyName,Json.toJson(obj)));
        return json;
    }

    public static JsonNode successJson(String message, Object obj){
        ObjectNode json=	Json.newObject();
        json.put("status", true);
        json.put("statusCode", 200);
        json.put("message", message);
        json.set("data", Json.toJson(obj));
        return json;
    }
    public static JsonNode successJson(Object obj, String keyName){
        ObjectNode json=	Json.newObject();
        json.put("status", true);
        json.put("statusCode", 200);
        json.put("message", "Loaded successfully");
        json.set("data",Json.newObject().set(keyName,Json.toJson(obj)));
        return json;
    }


}
