package com.mingle.json.gson;

import com.google.gson.Gson;

/**
 * User: mingle
 * Date: 12-9-23
 * Time: 下午5:10
 * desc
 */
public class MyGson {

    private final static Gson gson = new Gson();

    private MyGson() {

    }

    public static Gson getGson() {
        return gson;
    }
}
