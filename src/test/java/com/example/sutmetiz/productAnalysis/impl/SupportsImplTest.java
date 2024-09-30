package com.example.sutmetiz.productAnalysis.impl;

import com.example.sutmetiz.productAnalysis.impl.SupportsImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class SupportsImplTest {
    private final SupportsImpl supports = new SupportsImpl();

    @ParameterizedTest
    @ValueSource(strings = { "ОВ8 ГЦ", "ОВ8 60*50-ГЦ","ОВ9 ГЦ",
            "ОВ6 ГЦ", "ОВ6М ГЦ",
            "ОВ7 ГЦ", "ОВ7М ГЦ",
            "СК8 ГЦ", "СК8 60*50-ГЦ", "СК6 ГЦ",
            "СШВВ 60*50","СКН8 60*50",
            "КГ9 350-ГЦ","КГ7 460-ОЦ",
            "ТМ 100-ОЦ",
            "КГ6 100-ОЦ", "КГ6 60*50-100-ОЦ",
           "УК1 100-ОЦ", "УК3 НЖ"
    })
    void hardwareForSupportsTrue(String nom) {
        Assertions.assertTrue(supports.hardwareForSupports(nom, 6d));
    }
    @ParameterizedTest
    @ValueSource(strings = { "ОВ4 ГЦ",
            "СК3 ГЦ", "СК2 60*50-ГЦ","СКН6 ГЦ" ,
            "КГ96 350-ГЦ","КГ79 460-ОЦ",
            "ТМ4 100-ОЦ",
            "КГ69 100-ОЦ", "КГ64 60*50-100-ОЦ",
            "УК33",
            "УК9 НЖ","ППП","ПЛ33"
    })
    void hardwareForSupportsFalse(String nom) {
        Assertions.assertFalse(supports.hardwareForSupports(nom, 6d),
                "Errors"+nom+ supports.getResult());
    }

    @Test
    void hardwareForSupports1_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("ОВ8 НЖ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 18 Метизы М8*20НЖ ");
    }

    @Test
    void hardwareForSupports2_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("ОВ8 60*50-ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 36 Метизы М8*20 ");
    }


    @Test
    void hardwareForSupports3_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("ОВ6 ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), 6 * 3 + " Болт М8*25 Din933 " + "//// " + 6 * 3 + " Гайка канальная М8 ");
    }


    @Test
    void hardwareForSupports4_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("ОВ7 НЖ", 6d);
        Assertions.assertEquals(supports.getResult(), 6 * 6 + " Болт М8*25 Din933НЖ " + "//// " + 6 * 6 + " Гайка канальная М8НЖ ");
    }

    @Test
    void hardwareForSupports5_1() {
        SupportsImpl supports = new SupportsImpl();
        supports.hardwareForSupports("СШВн 41*41-ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 36 Метизы М8*20 ");
    }
}