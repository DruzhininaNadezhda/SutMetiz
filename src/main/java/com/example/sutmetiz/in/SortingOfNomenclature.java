package com.example.sutmetiz.in;

import com.example.sutmetiz.productAnalysis.*;
import com.example.sutmetiz.productAnalysis.impl.*;

import java.util.HashMap;
import java.util.Map;

public class SortingOfNomenclature {
    private final Supports supports = new SupportsImpl();
    private final Separators separators = new SeparatorsImpl();
    private final KKB kkb = new KKBImpl();
    private final SutLm sutLm = new SutLmImpl();
    private final Overpass overpass = new OverpassImpl();

    public Map<Integer, String> allSutAndMetiz(Map<Integer, String> nomenclatureInFail, Map<Integer, Double> sutQuantityInFail) {
        int i = 0;
        int lineNumber = 1;
        Map<Integer, String> result = new HashMap<Integer, String>();
        while (i < nomenclatureInFail.size()) {
            if (separators.hardwareForSupports(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))) {
                result.put(lineNumber, separators.getResult());
            } else if (supports.hardwareForSupports(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))) {
                result.put(lineNumber, supports.getResult());
            } else if (kkb.hardwareForKKB(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))) {
                result.put(lineNumber, kkb.getResult());
            } else if (sutLm.sutAndMetForNt(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))) {
                result.put(lineNumber, sutLm.getResult());
            } else if (sutLm.sutAndMetForLmAndNl(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))) {
                result.put(lineNumber, sutLm.getResult());
            } else if (sutLm.sutAndMetForOther(nomenclatureInFail.get(lineNumber), lineNumber)) {
                result.put(lineNumber, sutLm.getResult());
            } else if (overpass.hardwareForOverpass(nomenclatureInFail.get(lineNumber), sutQuantityInFail.get(lineNumber))) {
                result.put(lineNumber, overpass.getResult());
            }
            lineNumber++;
            i++;
        }
        return result;
    }

}
