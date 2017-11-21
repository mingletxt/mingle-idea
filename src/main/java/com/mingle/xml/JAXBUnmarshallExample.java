package com.mingle.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * Created by mingle.
 * Time 2017/10/30 上午12:47
 * Desc 文件描述
 */
public class JAXBUnmarshallExample {
    
    public static void main(String[] args) {
        try {
            String path = SAXTest.class.getResource(File.separator + "config.xml").getPath();
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Config config = (Config) jaxbUnmarshaller.unmarshal(file);
            System.out.println(config);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}