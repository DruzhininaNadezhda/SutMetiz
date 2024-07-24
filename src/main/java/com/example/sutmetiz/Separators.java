package com.example.sutmetiz;

import java.util.regex.Pattern;

public class Separators {
    private String result;

    public boolean hardwareForSupports(String nomenclature, Double qty) {
        int quantity = (int) Math.round(qty);
        if (Pattern.compile("РЛ.*").matcher(nomenclature).find() ||
                Pattern.compile("РН.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 3 + " Метизы М8*20";
            return true;
        } else if (Pattern.compile("РТ.*").matcher(nomenclature).find()) {
            result = " //// " + quantity * 3 + " Метизы М8*25";
            return true;
        } else {
            return false;
        }
    }
    public String getResult() {
        return result;
    }
}
