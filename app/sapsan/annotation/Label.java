package sapsan.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Этот файл является частью программы "snegir-education".
 * Любое распространение без письменного  разрешения автора запрещено!
 * <p/>
 * Автор: Румата Эсторский <rumata@sputnikchess.ru>
 * Создан: 15.03.13 в 8:12
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Label {
    String value() default "";
}
