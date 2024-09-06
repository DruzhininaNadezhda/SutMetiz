package com.example.sutmetiz.productAnalysis.impl;


import com.example.sutmetiz.productAnalysis.Supports;

import java.util.regex.Pattern;

public class SupportsImpl implements Supports {
    private String result;
    private final String metizNlpr=" Метизы М8*20 или НЛ-ПР с Метизами М8*25";
@Override
    public boolean hardwareForSupports (String nomenclature,Double qty){
        nomenclature=nomenclature.trim();
        int quantity = (int) Math.round(qty);
        if(Pattern.compile("^ОВ8 6[0-5]\\**").matcher(nomenclature).find()) {
            result = " //// " + quantity * 6 + " Метизы М8*20"+metis(nomenclature);
            return true;
        }else if(Pattern.compile("^ОВ8 *").matcher(nomenclature).find()||
                Pattern.compile("^ОВ9 *").matcher(nomenclature).find()){
            result= " //// "+quantity*3+ " Метизы М8*20"+metis(nomenclature);
            return true;
        }else if(Pattern.compile("^ОВ6 *").matcher(nomenclature).find()||
                Pattern.compile("^ОВ6м *").matcher(nomenclature).find()){
            result= quantity*3+" Болт М8*25 Din933"+metis(nomenclature)+ "//// " +quantity*3+ " Гайка канальная М8"+metis(nomenclature);
            return true;
        }else if(Pattern.compile("^ОВ7 *").matcher(nomenclature).find()||
                Pattern.compile("^ОВ7М *").matcher(nomenclature).find()){
            result= quantity*6+" Болт М8*25 Din933"+metis(nomenclature)+"//// " +quantity*6+ " Гайка канальная М8"+metis(nomenclature);
            return true;
        } else if (Pattern.compile("^СК[86].*").matcher(nomenclature).find()||
                Pattern.compile("^СТК[86].*").matcher(nomenclature).find()
                ||Pattern.compile("^СШ[Вв].*").matcher(nomenclature).find()) {
            result= " //// "+quantity*6+ " Метизы М8*20"+metis(nomenclature);
            return true;
        } else if (Pattern.compile("^КГ9 *").matcher(nomenclature).find()||
                Pattern.compile("^КГ7 .*").matcher(nomenclature).find()) {
            result= quantity*2+" Болт М8*25 Din933"+metis(nomenclature)+"//// " +quantity*2+ " Гайка канальная М8"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^ТМ *").matcher(nomenclature).find()) {
            result = quantity*2+metizNlpr+metis(nomenclature)+ "//// ";
            return true;
        }
        else if (Pattern.compile("^КГ6 6[0-5][0-5]\\**").matcher(nomenclature).find()) {
            result= quantity*2+metizNlpr+metis(nomenclature)+ "//// "+quantity*4+ " Метизы М8*20"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^КГ6 6[0-5]\\**").matcher(nomenclature).find()) {
            result= quantity*2+metizNlpr+metis(nomenclature)+ "//// "+quantity*3+ " Метизы М8*20"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^КГ6.*").matcher(nomenclature).find()) {
            result= quantity*2+metizNlpr+metis(nomenclature)+ "//// "+quantity*4+ " Метизы М8*20"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^КГ2т *").matcher(nomenclature).find()) {
            result= quantity*2+metizNlpr+metis(nomenclature)+ "//// "+quantity*4+ " Метизы М8*25"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^УК1 *").matcher(nomenclature).find()) {
            result= " //// "+quantity*2+ " Метизы М8*20"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^УК1 *").matcher(nomenclature).find()) {
            result= " //// "+quantity*2+ " Метизы М8*20"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^УК[34] *").matcher(nomenclature).find()) {
            result= " //// "+quantity*4+ " Метизы М8*20"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^КГ[1-8].*").matcher(nomenclature).find()
                ||Pattern.compile("^К116[0-4].*").matcher(nomenclature).find()
                ||Pattern.compile("^ОПС.*").matcher(nomenclature).find()) {
            result= quantity*2+ metizNlpr+metis(nomenclature)+ "//// ";
            return true;
        }
        else if (Pattern.compile("^ПП[0-9].*").matcher(nomenclature).find()) {
            result= quantity*2+ " Шайба усиленная М8"+metis(nomenclature)+ "//// " +quantity*2+" Гайка самостопорящаяся М8"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^ПУГ[21].*").matcher(nomenclature).find()) {
            result= " //// "+quantity*2+ " Метизы М8*25"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^ПЛ1.*").matcher(nomenclature).find()) {
            result= quantity*2+ metizNlpr+metis(nomenclature)+ "//// "+quantity*2+ " Метизы М8*25"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^ПЛ3.*").matcher(nomenclature).find()) {
            result= quantity*2+ metizNlpr+metis(nomenclature)+ "//// "
                    +quantity*2+" Гайка самостопорящаяся М8"+metis(nomenclature)+" + "+quantity*2+ " Шайба усиленная М8"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^ПЛ[0-9].*").matcher(nomenclature).find()) {
            result= quantity*2+ metizNlpr+metis(nomenclature)+ "//// "
                    +quantity*4+" Гайка самостопорящаяся М8"+metis(nomenclature)+" + "+quantity*4+ " Шайба усиленная М8"+metis(nomenclature);
            return true;
        }else {
            return false;}
    }
    private String metis(String nomenclature){
        if (nomenclature.matches(".*НЖ.*")){
          return "НЖ ";
        }
        return " ";
    }
    @Override
    public String getResult() {
        return result;
    }
}