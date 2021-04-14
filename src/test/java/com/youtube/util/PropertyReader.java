package com.youtube.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertyReader {
    private HashMap<String, Properties> cache = new HashMap<>();
    private Properties prop;

    public void setProp(String fileName) {
        Properties properties = new Properties();
        if (!cache.containsKey(fileName)) {
            try(InputStream is = PropertyReader.class.getClassLoader().getResourceAsStream(fileName)) {
                properties.load(is);
                cache.put(fileName, properties);
                this.prop = properties;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            this.prop = cache.get(fileName);
        }
    }

    public String getProperty (String propertyName) {
        return this.prop.getProperty(propertyName);
    }
}
