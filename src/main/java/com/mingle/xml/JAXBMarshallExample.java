package com.mingle.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * Created by mingle.
 * Time 2017/10/30 上午12:45
 * Desc 文件描述
 */
public class JAXBMarshallExample {
    public static void main(String[] args) {
        Config config = new Config();
        config.setAuthor("mingle");
        config.setBasePackage("com.mingle");
        config.setModule("card");
        config.setDatabase("jdbc:mysql://localhost:3306/beauty?useSSL=false");
        config.setUser("root");
        config.setPassword("mingle");
        config.setTable("user_member_card");
        config.setDal(true);
        config.setQuery(true);
        config.setParam(true);
        config.setDto(true);
        config.setTransutil(true);
        
        
        
        try {
            String path = SAXTest.class.getResource(File.separator + "dom.xml").getPath();
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            jaxbMarshaller.marshal(config, file);
            jaxbMarshaller.marshal(config, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
