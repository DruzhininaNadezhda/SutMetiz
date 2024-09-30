package com.example.sutmetiz.productAnalysis.impl;

import com.example.sutmetiz.productAnalysis.Overpass;

import java.util.regex.Pattern;

public class OverpassImpl implements Overpass {
    private String result;
    private final String FSKFOR80M12 = " ФСК М12х100х130-ТДЦ (Скоба)";
    private final String FSKFOR100M12 = " ФСК М12х120х160-ТДЦ (Скоба)";
    private final String SCREW934M12 = " Гайка М12 DIN934 к.п.8 ТДЦ";
    private final String WASHER125M12 = " Шайба М12 DIN125 ТДЦ";
    private  final String WASHER127M12 = " Шайба М12 DIN127 ТДЦ";
    private final String BOLT933M16 = " Болт М16 DIN933 к.п.8.8 ТДЦ";
    private final String SCREW934M16 = " Гайка М16 DIN934 к.п.8 ТДЦ";
    private final String WASHER125M16 = " Шайба М16 DIN125 ТДЦ";
    private  final String WASHER127M16 = " Шайба М16 DIN127 ТДЦ";
    @Override
    public boolean hardwareForOverpass(String nomenclature, Double quantity) {
        int qty = (int) Math.round(quantity);
        if (Pattern.compile("^ФПО 80\\*80.*\\(КОЛОННА\\).*").matcher(nomenclature).find()) {
            result = qty * 4 + FSKFOR80M12 + metis(nomenclature) + " + " + qty * 8 + SCREW934M12 + metis(nomenclature) + " //// "
                    + qty * 8 + WASHER125M12 + metis(nomenclature) + " + " + qty * 8 + WASHER127M12 + metis(nomenclature);
            return true;
        }else if (Pattern.compile("^ФПО 100\\*100.*\\(КОЛОННА\\).*").matcher(nomenclature).find()) {
            result = qty * 4 + FSKFOR100M12 + metis(nomenclature) + " + " + qty * 8 + SCREW934M12 + metis(nomenclature) + " //// "
                    + qty * 8 + WASHER125M12 + metis(nomenclature) + " + " + qty * 8 + WASHER127M12 + metis(nomenclature);
            return true;
        }else if (Pattern.compile("^ФПО .*\\(РИГЕЛЬ\\).*").matcher(nomenclature).find()){
                result = qty * 8 + BOLT933M16+metis(nomenclature)+" + " + qty * 8 + SCREW934M16+metis(nomenclature) +" //// "
                        + qty * 16 + WASHER127M16+metis(nomenclature)+" + " + qty * 8 + WASHER125M16+metis(nomenclature);
                return true;
        } else if (Pattern.compile("^ФМС .*").matcher(nomenclature).find()) {
            result = qty * 4 + FSKFOR80M12+metis(nomenclature)+" + " + qty * 8 + SCREW934M12+metis(nomenclature) +" //// "
                    + qty * 8 + WASHER125M12+metis(nomenclature)+" + " + qty * 8 + WASHER127M12+metis(nomenclature);
            return true;
        }
        return false;
    }
    private String metis(String nomenclature){
        return " ";
    }
    @Override
    public String getResult() {
        return result;
    }
}
