import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.lang.reflect.Constructor;

public class ServiceTest {
    Service service;
    @Test
    void ensureThatServiceHasOnlyOneConstructor() throws NoSuchMethodException {
       int countAnnotation = 0;
       int countConstructor = 0;
       Constructor<?>[] constructors = Service.class.getConstructors();
       for (Constructor<?> constructor : constructors){
           Inject annotation = constructor.getAnnotation(Inject.class);
           countConstructor++;
           if (annotation != null){
               countAnnotation++;
           }
       }
        int finalCountAnnotation = countAnnotation;
        int finalCountConstructor = countConstructor;
        assertAll(
               () ->  assertEquals(2, finalCountAnnotation),
               () -> assertEquals(2, finalCountConstructor)
       );
    }
}
