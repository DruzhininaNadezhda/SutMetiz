package com.example.sutmetiz;

import com.example.sutmetiz.productAnalysis.Supports;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SupportsTest {

    @Test
    void hardwareForSupports1() {
        Supports supports = new Supports();
        Assertions.assertTrue(supports.hardwareForSupports("ОВ8 ГЦ", 6d));
    }
    @Test
    void hardwareForSupports1_1() {
        Supports supports = new Supports();
        supports.hardwareForSupports("ОВ8 НЖ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 18 Метизы М8*20НЖ ");
    }

    @Test
    void hardwareForSupports2() {
        Supports supports = new Supports();
        Assertions.assertTrue(supports.hardwareForSupports("ОВ8 60*50-ГЦ", 6d));
    }

    @Test
    void hardwareForSupports2_1() {
        Supports supports = new Supports();
        supports.hardwareForSupports("ОВ8 60*50-ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 36 Метизы М8*20 ");
    }
    @Test
    void hardwareForSupports3() {
        Supports supports = new Supports();
        Assertions.assertTrue(supports.hardwareForSupports("ОВ6 41*41-ГЦ", 6d));
    }

    @Test
    void hardwareForSupports3_1() {
        Supports supports = new Supports();
        supports.hardwareForSupports("ОВ6 ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), 6*3+" Болт М8*25 Din933 "+ "//// " +6*3+ " Гайка канальная М8 ");
    }
    @Test
    void hardwareForSupports4() {
        Supports supports = new Supports();
        Assertions.assertTrue(supports.hardwareForSupports("ОВ6 41*41-ГЦ", 6d));
    }

    @Test
    void hardwareForSupports4_1() {
        Supports supports = new Supports();
        supports.hardwareForSupports("ОВ7 НЖ", 6d);
        Assertions.assertEquals(supports.getResult(), 6*6+" Болт М8*25 Din933НЖ "+ "//// " +6*6+ " Гайка канальная М8НЖ ");
    }
    @Test
    void hardwareForSupports5() {
        Supports supports = new Supports();
        Assertions.assertTrue(supports.hardwareForSupports("СК8 60*50-ГЦ", 6d));
    }

    @Test
    void hardwareForSupports5_1() {
        Supports supports = new Supports();
        supports.hardwareForSupports("СШВн 41*41-ГЦ", 6d);
        Assertions.assertEquals(supports.getResult(), " //// 36 Метизы М8*20 ");
    }


//
//                    } else if (Pattern.compile("^СК[86].*").matcher(nomenclature).find()||
//        Pattern.compile("^СТК[86].*").matcher(nomenclature).find()
//                ||Pattern.compile("^СШ[Вв].*").matcher(nomenclature).find()) {
//result= " //// "+quantity*6+ " Метизы М8*20"+metis(nomenclature);
//            return true;
//                    } else if (Pattern.compile("^КГ9 *").matcher(nomenclature).find()||
//        Pattern.compile("^КГ7 .*").matcher(nomenclature).find()) {
//result= quantity*2+" Болт М8*25 Din933"+metis(nomenclature)+"//// " +quantity*2+ " Гайка канальная М8"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^ТМ *").matcher(nomenclature).find()) {
//result = quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// ";
//        return true;
//        }
//        else if (Pattern.compile("^КГ6 6[0-5][0-5]\\**").matcher(nomenclature).find()) {
//result= quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// "+quantity*4+ " Метизы М8*20"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^КГ6 6[0-5]\\**").matcher(nomenclature).find()) {
//result= quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// "+quantity*3+ " Метизы М8*20"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^КГ6.*").matcher(nomenclature).find()) {
//result= quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// "+quantity*4+ " Метизы М8*20"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^КГ2т *").matcher(nomenclature).find()) {
//result= quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// "+quantity*4+ " Метизы М8*25"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^УК1 *").matcher(nomenclature).find()) {
//result= " //// "+quantity*2+ " Метизы М8*20"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^УК1 *").matcher(nomenclature).find()) {
//result= " //// "+quantity*2+ " Метизы М8*20"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^УК[34] *").matcher(nomenclature).find()) {
//result= " //// "+quantity*4+ " Метизы М8*20"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^КГ[1-8].*").matcher(nomenclature).find()
//                ||Pattern.compile("^К116[0-4].*").matcher(nomenclature).find()
//                ||Pattern.compile("^ОПС.*").matcher(nomenclature).find()) {
//result= quantity*2+ " Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// ";
//        return true;
//        }
//        else if (Pattern.compile("^ПП[0-9].*").matcher(nomenclature).find()) {
//result= quantity*2+ " Шайба усиленная М8"+metis(nomenclature)+ "//// " +quantity*2+" Гайка самостопорящаяся М8"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^ПУГ[21].*").matcher(nomenclature).find()) {
//result= " //// "+quantity*2+ " Метизы М8*25"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^ПЛ1.*").matcher(nomenclature).find()) {
//result= quantity*2+ " Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// "+quantity*2+ " Метизы М8*25"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^ПЛ3.*").matcher(nomenclature).find()) {
//result= quantity*2+ " Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// "+quantity*2+" Гайка самостопорящаяся М8 + Шайба усиленная М8"+metis(nomenclature);
//            return true;
//                    }
//                    else if (Pattern.compile("^ПЛ[0-9].*").matcher(nomenclature).find()) {
//result= quantity*2+ " Метизы М8*20 или НЛ-ПР+Метизы М8*25"+metis(nomenclature)+ "//// "+quantity*4+" Гайка самостопорящаяся М8 + Шайба усиленная М8"+metis(nomenclature);
//            return true;
//                    }else {
//                    return false;}
}