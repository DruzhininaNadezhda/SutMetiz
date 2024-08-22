package com.example.sutmetiz.in;

import com.example.sutmetiz.productAnalysis.KKB;
import com.example.sutmetiz.productAnalysis.Separators;
import com.example.sutmetiz.productAnalysis.Supports;
import com.example.sutmetiz.productAnalysis.SutLm;

import java.util.HashMap;
import java.util.Map;

public class SortingOfNomenclature {
    Supports supports = new Supports();
    Separators separators = new Separators();
    KKB kkb = new KKB();
    SutLm sutLm = new SutLm();

    public Map<Integer, String> allSutAndMetiz(Map<Integer, String> nomenclatureInFail, Map<Integer, Double> sutQuantityInFail) {
        int i = 0;
        int lineNumber = 1;
        Map<Integer, String> result = new HashMap<Integer, String>();
        while (i < nomenclatureInFail.size()) {
            if (separators.hardwareForSupports(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))) {
                result.put(lineNumber, separators.getResult());
            } else if (supports.hardwareForSupports(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))) {
                result.put(lineNumber, supports.getResult());
            } else if (kkb.hardwareForKKB(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))){
                result.put(lineNumber, kkb.getResult());
            }else if (sutLm.sutAndMetForNt(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))){
                result.put(lineNumber, sutLm.getResult());
            }else if (sutLm.sutAndMetForLmAndNl(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))){
                result.put(lineNumber, sutLm.getResult());
            }else if (sutLm.sutAndMetForOther(nomenclatureInFail.get(lineNumber), lineNumber)){
                result.put(lineNumber, sutLm.getResult());
            }
            lineNumber++;
            i++;
        }
        return result;
    }

}
