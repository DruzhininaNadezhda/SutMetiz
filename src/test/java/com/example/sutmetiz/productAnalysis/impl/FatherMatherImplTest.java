package com.example.sutmetiz.productAnalysis.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FatherMatherImplTest {
    private final FatherMatherImpl fatherMather = new FatherMatherImpl();
    @ParameterizedTest
    @ValueSource(strings = {"ЛЗ 50*50-0,7-3000-НЖ304"})
    void hardwareForFatherMather(String nom) {
        Assertions.assertTrue(fatherMather.hardwareForFatherMather(nom, 1.0));
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛЗ 50*50-0,7-3000-НЖ304"})
    void hardwareForFatherMather01(String nom) {
        fatherMather.hardwareForFatherMather(nom, 1.0);
        Assertions.assertEquals(fatherMather.getResult()," //// 2 Метизы М8*16 НЖ");
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛПЗ 50*50-0,7-3000-ОЦ"})
    void hardwareForFatherMather1(String nom) {
        Assertions.assertTrue(fatherMather.hardwareForFatherMather(nom, 1.0));
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛПЗ 50*50-0,7-3000-ОЦ"})
    void hardwareForFatherMather11(String nom) {
        fatherMather.hardwareForFatherMather(nom, 1.0);
        Assertions.assertEquals(fatherMather.getResult()," //// 2 Метизы М8*16");
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛЗ 100*100-0,7-3000-НЖ304"})
    void hardwareForFatherMather2(String nom) {
        Assertions.assertTrue(fatherMather.hardwareForFatherMather(nom, 1.0));
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛЗ 100*100-0,7-3000-НЖ304"})
    void hardwareForFatherMather22(String nom) {
    fatherMather.hardwareForFatherMather(nom, 2.0);
        Assertions.assertEquals(fatherMather.getResult()," //// 8 Метизы М8*16 НЖ");
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛЗ 200*50-0,7-3000-ОЦ"})
    void hardwareForFatherMather3(String nom) {
        Assertions.assertTrue(fatherMather.hardwareForFatherMather(nom, 1.0));
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛЗ 200*50-0,7-3000-ОЦ"})
    void hardwareForFatherMather33(String nom) {
        fatherMather.hardwareForFatherMather(nom, 1.0);
        Assertions.assertEquals(fatherMather.getResult()," //// 3 Метизы М8*16");
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛЗ 200*150-0,7-3000-ОЦ"})
    void hardwareForFatherMather4(String nom) {
        Assertions.assertTrue(fatherMather.hardwareForFatherMather(nom, 1.0));
    }
    @ParameterizedTest
    @ValueSource(strings = {"ЛЗ 200*150-0,7-3000-ОЦ"})
    void hardwareForFatherMather44(String nom) {
        fatherMather.hardwareForFatherMather(nom, 1.0);
        Assertions.assertEquals(fatherMather.getResult()," //// 5 Метизы М8*16");
    }






    @ParameterizedTest
    @ValueSource(strings = {"ЛМЗ 200*50-0,7-3000-ОЦ"})
    void hardwareForFatherMather8(String nom) {
        Assertions.assertFalse(fatherMather.hardwareForFatherMather(nom, 1.0));
    }
}