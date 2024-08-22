package com.example.sutmetiz.productAnalysis;

import java.util.regex.Pattern;

public class KKB {
    private String result;
    private final String BOLT=" Болт М10*30 DIN933 кл.пр.8.8";
    private final String SCREW934= " Гайка М10 DIN934 к.п.8";
    private final String WASHER125= " Шайба М10 DIN125";
    private  final String WASHER127= " Шайба М10 DIN127";

    public boolean hardwareForKKB(String nomenclature, Double quantity) {
        nomenclature=nomenclature.trim();
        int qty = (int) Math.round(quantity);
        if (Pattern.compile("^ККБ-П-0,65/0,4-*").matcher(nomenclature).find() ||
                Pattern.compile("^ККБ-УВ-0,65/0,4-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УН-0,65/0,4-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УГВ-0,65/0,4-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УГН-0,65/0,4*").matcher(nomenclature).find()) {
            result = qty*10+BOLT+metis(nomenclature)+" + "+qty*10+SCREW934+metis(nomenclature)+" //// "
                    +qty*20+WASHER125+metis(nomenclature)+" + "+qty*10+WASHER127+metis(nomenclature);
            return true;
        } else if (Pattern.compile("^ККБ-П-0,65/0,6-*").matcher(nomenclature).find() ||
                Pattern.compile("^ККБ-УВ-0,65/0,6-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УН-0,65/0,6-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УГВ-0,65/0,6-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УГН-0,65/0,6*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-П-0,95/0,6-*").matcher(nomenclature).find() ||
                Pattern.compile("^ККБ-УВ-0,95/0,6-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УН-0,95/0,6-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УГВ-0,95/0,6-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УГН-0,95/0,6*").matcher(nomenclature).find()) {
            result = qty*12+BOLT+metis(nomenclature)+" + "+qty*12+SCREW934+metis(nomenclature)+" //// "
                    +qty*24+WASHER125+metis(nomenclature)+" + "+qty*12+WASHER127+metis(nomenclature);
            return true;
        } else if (Pattern.compile("^ККБ-ПО-0,2/0,5*").matcher(nomenclature).find() ||
                Pattern.compile("^ККБ-3ПО-0,2/0,5-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УВП-0,2/0,5-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-3УВП-0,2/0,5-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УГП-0,2/0,5-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-3УГП-0,2/0,5-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-УНП-0,2/0,5-*").matcher(nomenclature).find()||
                Pattern.compile("^ККБ-3УНП-0,2/0,5-*").matcher(nomenclature).find()) {
            result = qty * 9 + BOLT+metis(nomenclature)+" + " + qty * 9 + SCREW934+metis(nomenclature) +" //// "
                    + qty * 18 + WASHER125+metis(nomenclature)+" + " + qty * 9 + WASHER127+metis(nomenclature);
            return true;
        } else{
        return false;}
    }
    public String metis(String nomenclature){
        if (nomenclature.matches(".*НЖ.*")){
            return "НЖ ";
        }
        return " ";
    }
    public String getResult() {
        return result;
    }
}
