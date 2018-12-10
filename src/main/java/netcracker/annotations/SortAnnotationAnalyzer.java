package netcracker.annotations;

import netcracker.properties.Config;
import netcracker.properties.Property;
import netcracker.sort.BubbleSort;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;

public class SortAnnotationAnalyzer {
    private static final Logger logger = Logger.getLogger(SortAnnotationAnalyzer.class);

    public static <T> void analyze(T object) {
        Property prop = Config.getInstance();
        Class clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SortAnnotation.class)) {
                String sortClassName = prop.getProperty(clazz.getSimpleName() + ".sort");
                if (sortClassName != null) {
                    Class classForField;
                    try {
                        classForField = Class.forName("netcracker.sort." + sortClassName);
                    } catch (Exception e) {
                        classForField = BubbleSort.class;
                        logger.error("Класс " + "netcracker.sort." + sortClassName + " не найден! Поэтому использован класс сортировки по умолчанию!");
                    }
                    field.setAccessible(true);
                    try {
                        field.set(object, classForField.newInstance());
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                } else {
                    logger.error("В properties, значение для поля " + clazz.getSimpleName() + ".sort не найден!");
                }
            }
        }
    }
}
