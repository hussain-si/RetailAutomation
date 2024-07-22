package base;




import io.qameta.allure.Allure;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AllureReport {


    @Test
    public void test1()  {
        Allure.step("step1: test");
        System.out.println("hello world");
    }
}
