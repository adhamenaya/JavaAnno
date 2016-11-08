package com.adhamenaya.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RunTest {

    public static void main(String args[]) throws Exception {
        System.out.println("\n\nTesting...");

        int pass = 0, fail = 0, ignore = 0, count = 0;

        Class<TestExample> obj = TestExample.class;

        if (obj.isAnnotationPresent(TesterInfo.class)) {
            Annotation annotation = obj.getAnnotation(TesterInfo.class);
            TesterInfo testerInfo = (TesterInfo) annotation;
            System.out.printf("\nPriority: %s", testerInfo.priority());
            System.out.printf("\nCreated by: %s", testerInfo.createdBy());
            System.out.printf("\nTags: ");

            int length = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (length > 1) System.out.printf("%s, ", tag);
                else System.out.printf("%s", tag);
                length--;
            }
            System.out.printf("\nLast modified: %s \n\n", testerInfo.lastModified());
        }

        // get @Test declared methods
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = (Test) (Annotation) method.getAnnotation(Test.class);
                if (test.enabled()) {
                    try {
                        method.invoke(obj.newInstance());
                        System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                        pass++;
                    } catch (Throwable ex) {
                        System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                        fail++;
                    }
                } else {
                    System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
                    ignore++;
                }
            }
        }
        System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignored %d%n", count, pass, fail, ignore);
    }
}