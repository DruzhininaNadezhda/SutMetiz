package com.example.sutmetiz.productAnalysis.impl;

import com.example.sutmetiz.productAnalysis.FatherMather;

import java.util.regex.Pattern;

public class FatherMatherImpl implements FatherMather {
    private String result;
    @Override
    public boolean hardwareForFatherMather(String nomenclature, Double qty) {
        nomenclature=nomenclature.trim();
        int quantity = (int) Math.round(qty);
        if (Pattern.compile("^ЛЗ [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛЗ 1\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛПЗ [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛПЗ 1\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛЗ[УСПО] 1\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛЗ[УСПО] [5-9]\\d\\*.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 2 + " Метизы М8*16"+metis(nomenclature);
            return true;
        } else if (Pattern.compile("^ЛЗТ 1\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛЗТ [5-9]\\d\\*.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛЗ 1\\d{2}\\*100.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛПЗ 1\\d{2}\\*100.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛЗ[УСПО] 1\\d{2}\\*100.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 4 + " Метизы М8*16"+metis(nomenclature);
            return true;
        } else if (Pattern.compile("^ЛЗХ 1\\d{2}\\*[3-9]\\d*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛЗХ [5-9]\\d\\*.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 6 + " Метизы М8*16"+metis(nomenclature);
            return true;}
        else if (Pattern.compile("^ЛЗ [2-5]\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛПЗ [2-5]\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛЗ[УСПО] [2-5]\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 3 + " Метизы М8*16"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^ЛЗ [2-5]\\d{2}\\*[1-2]\\d{2}.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛПЗ [2-5]\\d{2}\\*[1-2]\\d{2}.*").matcher(nomenclature).find()
                ||Pattern.compile("^ЛЗ[УСПО] [2-5]\\d{2}\\*[1-2]\\d{2}.*").matcher(nomenclature).find()
        ) {
            result = " //// " + quantity * 5 + " Метизы М8*16"+metis(nomenclature);
            return true;
          } else if (Pattern.compile("^ЛЗТ 1\\d{2}\\*100.*").matcher(nomenclature).find()) {
        result = " //// " + quantity * 8 + " Метизы М8*16"+metis(nomenclature);
        return true;
         } else if (Pattern.compile("^ЛЗХ 1\\d{2}\\*100.*").matcher(nomenclature).find()) {
        result = " //// " + quantity * 12 + " Метизы М8*16"+metis(nomenclature);
        return true;}
        else if (Pattern.compile("^ЛЗТ [2-5]\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 6 + " Метизы М8*16"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^ЛЗХ [2-5]\\d{2}\\*[3-9]\\d.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 9 + " Метизы М8*16"+metis(nomenclature);
            return true;
        }
        else if (Pattern.compile("^ЛЗТ [2-5]\\d{2}\\*[1-2]\\d{2}.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 10 + " Метизы М8*16"+metis(nomenclature);
            return true;}
        else if (Pattern.compile("^ЛЗХ [2-5]\\d{2}\\*[1-2]\\d{2}.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 15 + " Метизы М8*16"+metis(nomenclature);
            return true;}
        else {
            return false;
        }
    }
    private String metis(String nomenclature){
        if (nomenclature.matches(".*НЖ.*")){
            return " НЖ";
        }
        return "";
    }

    @Override
    public String getResult() {
        return result;
    }
}
