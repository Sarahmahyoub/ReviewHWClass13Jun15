package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String read(String key) {
        String path = "Files/config.properties";
        FileInputStream fis = null;
        String value = null;

        try {
            fis = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fis);

            value = properties.getProperty(key);
        } catch (IOException f) {
            f.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;

    }
}
