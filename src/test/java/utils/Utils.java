package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    final static String userDir = System.getProperty("user.dir");

    public static String getUrl() {
        try {
            return getProperty("applicationUrl");
        } catch (IOException e) {
            System.out.println("Application url not found.");
            return null;
        }

    }

    public static String getGeckoPath(){
        try {
            return getProperty("gecko.path");
        } catch (IOException e) {
            return null;
        }
    }

    private static String getProperty(String key) throws IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream(userDir+"\\src\\main\\resources\\application.properties"));
        return properties.getProperty(key);
    }
}
