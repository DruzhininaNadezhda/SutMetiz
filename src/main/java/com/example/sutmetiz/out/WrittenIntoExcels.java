package com.example.sutmetiz.out;

import java.io.IOException;
import java.util.Map;

public interface WrittenIntoExcels {
    void writeIntoExcel(String path, Map<Integer, String> nomenclature,
                        Map<Integer, String> nomenclatureQuantity,
                        Map<Integer, String> result,Map<String, Integer> itog,
                        Map<String, Integer> tray ) throws IOException;
}
