package com.example.sutmetiz;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Itog {
    Map<String,Integer> itog = new HashMap<>();

    public Map<String,Integer> itog(Map<Integer, String> sutAndMetiz) {
        for (Map.Entry<Integer, String> entry : sutAndMetiz.entrySet()) {
            if (Pattern.compile("Соединители необходимо посчитать в позиции.*").matcher(entry.getValue()).find()) {
                itog.put(entry.getValue(), 0);
            } else if (entry.getValue().contains(" ////")) {
                StringBuilder supports = new StringBuilder();
                StringBuilder supportsQuantity = new StringBuilder();
                supports.append(entry.getValue());
                supports.delete(supports.indexOf(" ////"), supports.length());
                if(supports!=null&& !supports.isEmpty()&& !supports.equals(" ")){
                supportsQuantity.append(supports);
                supports.delete(0, supports.indexOf("М"));
                supportsQuantity.delete(supportsQuantity.indexOf(" "), supportsQuantity.length());
                if (!itog.containsKey(supports.toString())) {
                    itog.put(supports.toString(), Integer.parseInt(String.valueOf(supportsQuantity)));
                } else {
                    int quantity = Integer.parseInt(String.valueOf(supportsQuantity))
                            + itog.get(supports.toString());
                    itog.put(supports.toString(), quantity);
                }}
                StringBuilder hardwareSupports = new StringBuilder();
                StringBuilder hardwareSupportsQuantity = new StringBuilder();
                hardwareSupports.append(entry.getValue());
                hardwareSupports.delete(0, hardwareSupports.lastIndexOf("///") + 4);
                if(hardwareSupports!=null&& !hardwareSupports.isEmpty()&& !hardwareSupports.equals(" ")){
                hardwareSupportsQuantity.append(hardwareSupports);
                hardwareSupports.delete(0, hardwareSupports.indexOf(" ") + 1);
                hardwareSupportsQuantity.delete(hardwareSupportsQuantity.indexOf(" "), hardwareSupportsQuantity.length());
                if (!itog.containsKey(hardwareSupports.toString())) {
                    itog.put(hardwareSupports.toString(), Integer.parseInt(String.valueOf(hardwareSupportsQuantity)));
                } else {
                    int quantity = Integer.parseInt(String.valueOf(hardwareSupportsQuantity))
                            + itog.get(hardwareSupports.toString());
                    itog.put(hardwareSupports.toString(), quantity);
                }
            }}
             else {
            StringBuilder sut = new StringBuilder();
            StringBuilder sutQuantity = new StringBuilder();
            sut.append(entry.getValue());
            sut.delete(sut.indexOf(" ///"), sut.length());
            sutQuantity.append(sut);
            sut.delete(0, sut.indexOf("С"));
            sutQuantity.delete(sutQuantity.indexOf(" "), sutQuantity.length());
            if (!itog.containsKey(sut.toString())) {
                itog.put(sut.toString(), Integer.parseInt(String.valueOf(sutQuantity)));
            } else {
                int quantity = Integer.parseInt(String.valueOf(sutQuantity))
                        + itog.get(sut.toString());
                itog.put(sut.toString(), quantity);
            }
            StringBuilder hardware = new StringBuilder();
            StringBuilder hardwareQuantity = new StringBuilder();
            hardware.append(entry.getValue());
            hardware.delete(0, hardware.lastIndexOf("///")+3);
            hardwareQuantity.append(hardware);
            hardware.delete(0,hardware.lastIndexOf(" ")+1);
            hardwareQuantity.delete(hardwareQuantity.indexOf(" "),hardwareQuantity.length());
            if (!itog.containsKey(hardware.toString())) {
                itog.put(hardware.toString(),Integer.parseInt(String.valueOf(hardwareQuantity)));
            } else {
                int quantity = Integer.parseInt(String.valueOf(hardwareQuantity))
                        + itog.get(hardware.toString());
                itog.put(hardware.toString(),quantity);}
        }}
            return itog;
        }

    }
