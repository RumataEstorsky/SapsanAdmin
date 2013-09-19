package sapsan.annotation;

import sapsan.schema.DataTypeGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SapsanField {
    DataTypeGroup dataType() default DataTypeGroup.String;
}
