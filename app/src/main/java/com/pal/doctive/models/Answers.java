package com.pal.doctive.models;

import com.google.gson.Gson;

import java.util.LinkedHashMap;

public class Answers {

    private volatile static Answers uniqueInstance;
    private final LinkedHashMap<String, Object> answered_hashmap = new LinkedHashMap<>();

    private Answers() {
    }

    public void put_answer(String key, Object value) {

        answered_hashmap.put(key, value);
    }


    public String get_json_object() {
        Gson gson = new Gson();
        return gson.toJson(answered_hashmap, LinkedHashMap.class);
    }

    public static void remove(){
        uniqueInstance = null;
    }

    public String getValue(String path) {
        return (String) answered_hashmap.get(path);
    }

    @Override
    public String toString() {
        return String.valueOf(answered_hashmap);
    }

    public static Answers getInstance() {
        if (uniqueInstance == null) {
            synchronized (Answers.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Answers();
                }
            }
        }
        return uniqueInstance;
    }
}
