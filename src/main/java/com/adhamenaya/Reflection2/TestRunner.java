package com.adhamenaya.reflection2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by AENAYA on 08/11/2016.
 */
public class TestRunner {

    public static void run() {


        Class<TestExample> exampleClass = TestExample.class;

        if (exampleClass.isAnnotationPresent(TestClass.class)) {
            Annotation[] annotations = exampleClass.getAnnotations();
            for (Annotation annotation : annotations) {
                // Case the annotation
                TestClass testClass = (TestClass) annotation;

                out("Date: " + testClass.date());
                out("Tester: " + testClass.tester());

                String tags = "";
                for (int i = 0; i < testClass.tags().length; i++) {
                    tags += (i == 0 ? "[" + testClass.tags()[i] + "," :
                            testClass.tags()[i] + (i == testClass.tags().length - 1 ? "]" : ","));
                }
                out("Tags: " + tags);
            }

            // Get the TestCase methods
            Method methods[] = exampleClass.getDeclaredMethods();
            for (Method method : methods) {
                Annotation[] annotations1 = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations1) {
                    TestCase testCase = (TestCase) annotation;
                    if (testCase.active()) out(">> " + method.getName() + " test is active");
                    else out(">> " + method.getName() + " test is not active");
                }
            }

        } else {
            out("Text class is missing TestClass annotation");
        }
    }

    static void out(String message) {
        System.out.println(message);
    }
}
