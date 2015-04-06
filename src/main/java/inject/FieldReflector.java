package inject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldReflector {
    public static List<Field> collectUpTo(Class<?> clazz, Class<?> upperBound) {
        ArrayList<Field> result = new ArrayList<Field>();
        Class<?> current = clazz;
        while (current != upperBound) {
            for (Field field : current.getDeclaredFields()) {
                result.add(field);
            }
            current = current.getSuperclass();
        }
        return result;
    }

    public static List<Field> filterInject(List<Field> allFilds) {
        ArrayList<Field> result = new ArrayList<Field>();
        for (Field field : allFilds) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                result.add(field);
            }
        }
        return result;
    }
}
