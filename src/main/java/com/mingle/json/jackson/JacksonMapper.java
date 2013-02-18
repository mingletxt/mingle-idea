package com.mingle.json.jackson;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * User: mingle
 * Date: 12-9-23
 * Time: 上午10:49
 * desc
 */
public class JacksonMapper {

    /**
     *
     */
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     *
     */
    private JacksonMapper() {

    }

    /**
     * @return
     */
    public static ObjectMapper getInstance() {

        return mapper;
    }

}

