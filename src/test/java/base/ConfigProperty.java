package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperty {

        protected static FileInputStream fileInputStream;
        protected static Properties PROPERTIES;

    static {
        try {

            fileInputStream = new FileInputStream("src/test/resources/config.properties"); //указание пути до файла с настройками
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        }
        catch (IOException e) {
        e.printStackTrace();

        }
        finally {
        if (fileInputStream != null)

                try {
            fileInputStream.close();
            }
                catch (IOException e) {
                e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
