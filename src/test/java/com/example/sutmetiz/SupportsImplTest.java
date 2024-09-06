package com.example.sutmetiz;

import com.example.sutmetiz.productAnalysis.impl.SupportsImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SupportsImplTest {

    @Test
    void hardwareForSupports1() {
        SupportsImpl supports = new SupportsImpl();
        Assertions.assertTrue(supports.hardwareForSupports("ОВ8 ГЦ", 6d));
    }

    @Test
    void hardwareForSupports1_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("ОВ8 НЖ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 18 Метизы М8*20НЖ ");
    }

    @Test
    void hardwareForSupports2() {
        SupportsImpl supports = new SupportsImpl();
        Assertions.assertTrue(supports.hardwareForSupports("ОВ8 60*50-ГЦ", 6d));
    }

    @Test
    void hardwareForSupports2_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("ОВ8 60*50-ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 36 Метизы М8*20 ");
    }

    @Test
    void hardwareForSupports3() {
        SupportsImpl supports = new SupportsImpl();
        Assertions.assertTrue(supports.hardwareForSupports("ОВ6 41*41-ГЦ", 6d));
    }

    @Test
    void hardwareForSupports3_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("ОВ6 ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), 6 * 3 + " Болт М8*25 Din933 " + "//// " + 6 * 3 + " Гайка канальная М8 ");
    }

    @Test
    void hardwareForSupports4() {
        SupportsImpl supports = new SupportsImpl();
        Assertions.assertTrue(supports.hardwareForSupports("ОВ6 41*41-ГЦ", 6d));
    }

    @Test
    void hardwareForSupports4_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("ОВ7 НЖ", 6d);
        Assertions.assertEquals(supports.getResult(), 6 * 6 + " Болт М8*25 Din933НЖ " + "//// " + 6 * 6 + " Гайка канальная М8НЖ ");
    }

    @Test
    void hardwareForSupports5() {
        SupportsImpl supports = new SupportsImpl();
        Assertions.assertTrue(supports.hardwareForSupports("СК8 60*50-ГЦ", 6d));
    }

    @Test
    void hardwareForSupports5_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("СШВн 41*41-ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 36 Метизы М8*20 ");
    }
}