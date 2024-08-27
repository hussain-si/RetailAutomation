package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    //Declare the object for property file
    public Properties property ;

    public Config() throws IOException {
        //initialize the property file
        property = new Properties();
        //specify the file path
        FileInputStream fis = new FileInputStream("src\\test\\resources\\properties\\config.properties");
        //load or read the property file for specified path
        property.load(fis);
    }


    public String getProperties(String key)  {

        //return value for perticular key from loaded property file
        return property.getProperty(key);
    }


}