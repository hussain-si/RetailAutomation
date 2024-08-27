package annotations;

import enums.TestCategory;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@Target(METHOD)

public @interface TestAnnoatation {



    public String[] author();

    /**
     * This will define the Author name in the test method section which will be assugned to assignAuthor
     * in the extent report.
     **/

    public TestCategory[] category();

/**
 * This will define the list of values mentioned in the test method sectionwill be assinged to assignCategory
 * in the extent report.
 **/

}
