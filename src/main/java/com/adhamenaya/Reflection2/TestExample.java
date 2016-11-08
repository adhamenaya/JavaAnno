package com.adhamenaya.Reflection2;

import com.adhamenaya.annotations.Test;

/**
 * Created by AENAYA on 08/11/2016.
 */

@TestClass(date = "08.11.2016",
        tags = {"Unit", "Final", "Functional"},
        tester = "Adham Enaya")
public class TestExample {

    @TestCase(active = false)
    public void testA() {
    }

    @TestCase(active = true)
    public void testB() {
    }
}
