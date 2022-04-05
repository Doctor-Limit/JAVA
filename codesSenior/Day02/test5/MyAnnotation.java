package Day02.test5;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * ********概述：
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
public @interface MyAnnotation {

    String value() default "hello";

}
