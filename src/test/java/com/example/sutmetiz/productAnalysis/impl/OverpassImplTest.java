package com.example.sutmetiz.productAnalysis.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class OverpassImplTest {
    private final OverpassImpl overpass = new OverpassImpl();

    @ParameterizedTest
    @ValueSource(strings = {"ФПО 80*80-3000-ГЦ (КОЛОННА)"})
    void hardwareForOverpassTrue(String nom) {
        Assertions.assertTrue(overpass.hardwareForOverpass(nom, 1.0));
    }
    @ParameterizedTest
    @ValueSource(strings = {"ФПО 80*80-3000-ГЦ"})
    void hardwareForOverpassFalse(String nom) {
        Assertions.assertFalse(overpass.hardwareForOverpass(nom, 1.0));
    }
    @Test
    void hardwareForOverpassResultFpo() {
        overpass.hardwareForOverpass("ФПО 80*80-3000-ГЦ (КОЛОННА)",4.0);
        Assertions.assertEquals(overpass.getResult(),"16 ФСК М12х100х130-ТДЦ (Скоба)  + 32 Гайка М12 DIN934 к.п.8 ТДЦ  //// 32 Шайба М12 DIN125 ТДЦ  + 32 Шайба М12 DIN127 ТДЦ ");
    }
    @Test
    void hardwareForOverpassResultFpo2() {
        overpass.hardwareForOverpass("ФПО 80*80-3000-ГЦ (РИГЕЛЬ)",4.0);
        Assertions.assertEquals(overpass.getResult(),"32 Болт М16 DIN933 к.п.8.8 ТДЦ  + 32 Гайка М16 DIN934 к.п.8 ТДЦ  //// 64 Шайба М16 DIN127 ТДЦ  + 32 Шайба М16 DIN125 ТДЦ ");
    }
    @Test
    void hardwareForOverpassResultFms() {
        overpass.hardwareForOverpass("ФМС 80*80-ГЦ",12.0);
        Assertions.assertEquals(overpass.getResult(),"48 ФСК М12х100х130-ТДЦ (Скоба)  + 96 Гайка М12 DIN934 к.п.8 ТДЦ  //// 96 Шайба М12 DIN125 ТДЦ  + 96 Шайба М12 DIN127 ТДЦ ");

    }
}