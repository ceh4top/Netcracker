package netcracker.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public abstract class Property {
    protected abstract String getFileName();

    private Map<String, String> hashMap;

    InputStream inputStream;
    private void construct() throws IOException {
        hashMap = new HashMap<String, String>();

        try {
            Properties props = new Properties();
            String propFileName = getFileName() + ".properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                props.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Enumeration<?> e = props.propertyNames();

            while(e.hasMoreElements())
            {
                String key = (String) e.nextElement();

                if (key != null && !hashMap.containsKey(key))
                {
                    hashMap.put(key, props.getProperty(key));
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

    public void updateProperty() {
        if (hashMap != null) {
            hashMap.clear();
            hashMap = null;
        }
    }

    public String getProperty(String name) {
        if (hashMap == null) {
            try {
                construct();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }

        return hashMap.get(name);
    }
}
