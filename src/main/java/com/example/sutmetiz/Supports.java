package com.example.sutmetiz;

import java.util.Map;
import java.util.regex.Pattern;

public class Supports {
    private String result;
    public boolean hardwareForSupports (String nomenclature,Double qty){
        nomenclature=nomenclature.trim();
        int quantity = (int) Math.round(qty);
        if(Pattern.compile("^ОВ8 6[0-5]\\**").matcher(nomenclature).find()) {
            result = " //// " + quantity * 6 + " Метизы М8*20";
            return true;
        }else if(Pattern.compile("^ОВ8 *").matcher(nomenclature).find()||
                Pattern.compile("^ОВ9 *").matcher(nomenclature).find()){
            result= " //// "+quantity*3+ " Метизы М8*20";
            return true;
        }else if(Pattern.compile("^ОВ6 *").matcher(nomenclature).find()||
                Pattern.compile("^ОВ6м *").matcher(nomenclature).find()){
            result= quantity*3+" Метизы М8*25 + Канальная гайка М8 //// ";
            return true;
        }else if(Pattern.compile("^ОВ7 *").matcher(nomenclature).find()||
                Pattern.compile("^ОВ7м *").matcher(nomenclature).find()){
            result= quantity*6+" Метизы М8*25 + Канальная гайка М8 //// ";
            return true;
        } else if (Pattern.compile("^СК[86].*").matcher(nomenclature).find()||
                Pattern.compile("^СТК[86].*").matcher(nomenclature).find()
                ||Pattern.compile("^СШ[Вв].*").matcher(nomenclature).find()) {
            result= " //// "+quantity*6+ " Метизы М8*20";
            return true;
        } else if (Pattern.compile("^КГ9 *").matcher(nomenclature).find()||
                Pattern.compile("^КГ7 .*").matcher(nomenclature).find()) {
            result= quantity*2+" Метизы М8*25 + Канальная гайка М8 //// ";
            return true;
        }
        else if (Pattern.compile("^ТМ *").matcher(nomenclature).find()) {
            result = quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// ";
            return true;
        }
        else if (Pattern.compile("^КГ6 6[0-5][0-5]\\**").matcher(nomenclature).find()) {
            result= quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// "+quantity*4+ " Метизы М8*20";
            return true;
        }
        else if (Pattern.compile("^КГ6 6[0-5]\\**").matcher(nomenclature).find()) {
            result= quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// "+quantity*3+ " Метизы М8*20";
            return true;
        }
        else if (Pattern.compile("^КГ6.*").matcher(nomenclature).find()) {
            result= quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// "+quantity*4+ " Метизы М8*20";
            return true;
        }
        else if (Pattern.compile("^КГ2т *").matcher(nomenclature).find()) {
            result= quantity*2+" Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// "+quantity*4+ " Метизы М8*25";
            return true;
        }
        else if (Pattern.compile("^УК1 *").matcher(nomenclature).find()) {
            result= " //// "+quantity*2+ " Метизы М8*20";
            return true;
        }
        else if (Pattern.compile("^УК1 *").matcher(nomenclature).find()) {
            result= " //// "+quantity*2+ " Метизы М8*20";
            return true;
        }
        else if (Pattern.compile("^УК[34] *").matcher(nomenclature).find()) {
            result= " //// "+quantity*4+ " Метизы М8*20";
            return true;
        }
        else if (Pattern.compile("^КГ[1-8].*").matcher(nomenclature).find()
                ||Pattern.compile("^К116[0-4].*").matcher(nomenclature).find()
                ||Pattern.compile("^ОПС.*").matcher(nomenclature).find()) {
            result= quantity*2+ " Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// ";
            return true;
        }
        else if (Pattern.compile("^ПП[0-9].*").matcher(nomenclature).find()) {
            result= quantity*2+ " М8 шайба усиленная М8 //// " +quantity*2+" М8 гайка самостопорящаяся М8";
            return true;
        }
        else if (Pattern.compile("^ПУГ[21].*").matcher(nomenclature).find()) {
            result= " //// "+quantity*2+ " Метизы М8*25";
            return true;
        }
        else if (Pattern.compile("^ПЛ1.*").matcher(nomenclature).find()) {
            result= quantity*2+ " Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// "+quantity*2+ " Метизы М8*25";
            return true;
        }
        else if (Pattern.compile("^ПЛ3.*").matcher(nomenclature).find()) {
            result= quantity*2+ " Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// "+quantity*2+" М8 гайка самостопорящаяся + шайба усиленная М8";
            return true;
        }
        else if (Pattern.compile("^ПЛ[0-9].*").matcher(nomenclature).find()) {
            result= quantity*2+ " Метизы М8*20 или НЛ-ПР+Метизы М8*25 //// "+quantity*4+" М8 гайка самостопорящаяся + шайба усиленная М8";
            return true;
        }else {
            return false;}
    }
    public String getResult() {
        return result;
    }
}