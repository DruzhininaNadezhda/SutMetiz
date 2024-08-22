package com.example.sutmetiz.productAnalysis;

import java.util.regex.Pattern;

public class Separators {
    private String result;

    public boolean hardwareForSupports(String nomenclature, Double qty) {
        nomenclature=nomenclature.trim();
        int quantity = (int) Math.round(qty);
        if (Pattern.compile("^РЛ[ П].*").matcher(nomenclature).find() ||
                Pattern.compile("^РН[ П].*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 3 + " Метизы М8*16"+metis(nomenclature);
            return true;
        } else if (Pattern.compile("^РТ[ П].*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 3 + " Метизы М8*20"+metis(nomenclature);
            return true;
        } else {
            return false;
        }
    }
    public String metis(String nomenclature){
        if (nomenclature.matches(".*НЖ.*")){
            return "НЖ";
        }
        return "";
    }
    public String getResult() {
        return result;
    }
}
