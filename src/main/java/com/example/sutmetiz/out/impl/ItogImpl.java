package com.example.sutmetiz.out.impl;

import com.example.sutmetiz.out.Itog;
import com.example.sutmetiz.productAnalysis.TrayCoversAnalysis;
import com.example.sutmetiz.productAnalysis.impl.TrayCoversAnalysisImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ItogImpl implements Itog {
    private Map<String, Integer> itog = new HashMap<>();
    private Map<String, Integer> allTrays = new HashMap<>();
    public Map<String, Integer> trays(Map<Integer, String> nomenclature, Map<Integer, Double> quantity) {
        for (Map.Entry<Integer, String> entry : nomenclature.entrySet()) {
            TrayCoversAnalysis trayCoversAnalysis =new TrayCoversAnalysisImpl();
            if (trayCoversAnalysis.coversForAllnomenclatureYesOrNo(entry.getValue())) {

            int qua = (int)Math.ceil(quantity.get(entry.getKey()));
            allTrays.put(trayCoversAnalysis.getCover(),
                    qua* trayCoversAnalysis.getQuantityCovers());}

        }
        return allTrays;
    }
    public Map<String, Integer> finalForSutAndMetiz(Map<Integer, String> sutAndMetiz) {
        for (Map.Entry<Integer, String> entry : sutAndMetiz.entrySet()) {
            if (Pattern.compile("Соединители необходимо посчитать в позиции.*").matcher(entry.getValue()).find()) {
                itog.put(entry.getValue(), 0);
            } else if (entry.getValue().contains(" ////")) {
                separatorAndSupporItog(entry.getValue());
            } else {
                sutItog(entry.getValue());
            }
        }
        return itog;
    }
    private void separatorAndSupporItog(String separatorAndSupporMetiz) {
        StringBuilder supports = new StringBuilder();
        StringBuilder supportsQuantity = new StringBuilder();
        supports.append(separatorAndSupporMetiz);
        supports.delete(supports.indexOf(" ////"), supports.length());
        if (supports != null && !supports.isEmpty() && !supports.equals(" ")) {
            if (!supports.toString().contains("+")) {
                supportsQuantity.append(supports);
                supports.delete(0, supports.indexOf(" ") + 1);
                supportsQuantity.delete(supportsQuantity.indexOf(" "), supportsQuantity.length());
                if (!itog.containsKey(supports.toString())) {
                    itog.put(supports.toString(), Integer.parseInt(String.valueOf(supportsQuantity)));
                } else {
                    int quantity = Integer.parseInt(String.valueOf(supportsQuantity))
                            + itog.get(supports.toString());
                    itog.put(supports.toString(), quantity);
                }
            } else {metizPlus(supports,supportsQuantity);
            }
        }
        StringBuilder hardwareSupports = new StringBuilder();
        StringBuilder hardwareSupportsQuantity = new StringBuilder();
        hardwareSupports.append(separatorAndSupporMetiz);
        hardwareSupports.delete(0, hardwareSupports.lastIndexOf("///") + 4);
        if (!hardwareSupports.isEmpty() && !hardwareSupports.equals(" ")) {
            if(!hardwareSupports.toString().contains("+")) {
                hardwareSupportsQuantity.append(hardwareSupports);
                hardwareSupports.delete(0, hardwareSupports.indexOf(" "));
                hardwareSupportsQuantity.delete(hardwareSupportsQuantity.indexOf(" "), hardwareSupportsQuantity.length());
                if (!itog.containsKey(hardwareSupports.toString().trim())) {
                    itog.put(hardwareSupports.toString().trim(), Integer.parseInt(String.valueOf(hardwareSupportsQuantity)));
                } else {
                    int quantity = Integer.parseInt(String.valueOf(hardwareSupportsQuantity))
                            + itog.get(hardwareSupports.toString().trim());
                    itog.put(hardwareSupports.toString().trim(), quantity);
                }
            }
            else {metizPlus(hardwareSupports,hardwareSupportsQuantity);
            }

        }
    }
    private void metizPlus(StringBuilder hardwareSupports, StringBuilder hardwareSupportsQuantity) {
        hardwareSupportsQuantity.append(hardwareSupports);
        hardwareSupports.delete(0, hardwareSupports.indexOf(" ") + 1);
        String oneMetiz = hardwareSupports.substring(0,hardwareSupports.indexOf("+")-1);

        StringBuilder twoMetizQuantity = new StringBuilder(hardwareSupports.substring(hardwareSupports.indexOf("+")+2, hardwareSupports.length()-1));
        String twoMetiz = twoMetizQuantity.substring(twoMetizQuantity.indexOf(" ")+1,twoMetizQuantity.length());
        twoMetizQuantity.delete(hardwareSupportsQuantity.indexOf(" "), twoMetizQuantity.length());
        hardwareSupportsQuantity.delete(hardwareSupportsQuantity.indexOf(" "), hardwareSupportsQuantity.length());
        if (!itog.containsKey(oneMetiz)) {
            itog.put(oneMetiz, Integer.parseInt(String.valueOf(hardwareSupportsQuantity)));
        } else {
            int quantity = Integer.parseInt(String.valueOf(hardwareSupportsQuantity))
                    + itog.get(oneMetiz);
            itog.put(oneMetiz, quantity);
        }
        if (!itog.containsKey(twoMetiz)) {
            itog.put(twoMetiz, Integer.parseInt(String.valueOf(twoMetizQuantity)));
        } else {

            int quantity = Integer.parseInt(String.valueOf(twoMetizQuantity).trim())
                    + itog.get(twoMetiz);
            itog.put(twoMetiz, quantity);
        }
    }
    private void sutItog(String sutItogMetiz){
        StringBuilder sut = new StringBuilder();
            StringBuilder sutQuantity = new StringBuilder();
            sut.append(sutItogMetiz);
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
            hardware.append(sutItogMetiz);
            hardware.delete(0, hardware.lastIndexOf("///")+3);
            hardwareQuantity.append(hardware);
            hardware.delete(0,hardware.indexOf(" ")+1);
            hardwareQuantity.delete(hardwareQuantity.indexOf(" "),hardwareQuantity.length());
            if (!itog.containsKey(hardware.toString())) {
                itog.put(hardware.toString(),Integer.parseInt(String.valueOf(hardwareQuantity)));
            } else {
                int quantity = Integer.parseInt(String.valueOf(hardwareQuantity))
                        + itog.get(hardware.toString());
                itog.put(hardware.toString(),quantity);}
        }
    }