package com.mingle.freemarker;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by mingle.
 * Time 2017/10/21 下午3:36
 * Desc 文件描述
 */
public class FreemarkerTest {
    
    public static void main(String[] args) throws IOException, TemplateException {
        
        String path = FreemarkerTest.class.getResource("/").getPath();
        
        File cfgFile = new File(path);
        
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDirectoryForTemplateLoading(cfgFile);
        
        Template template = configuration.getTemplate("ftl/user.ftl");
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userList", Arrays.asList("hello", "world"));
        
        StringWriter stringWriter = new StringWriter();
        template.process(map, stringWriter);
        
        System.out.println(stringWriter.toString());
    }
}
