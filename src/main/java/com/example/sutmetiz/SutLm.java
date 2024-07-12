package com.example.sutmetiz;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
public class SutLm {
    private String itogo;
    private int metiz;
    private int sutQuantity;
    private String slb;
    private String sltk;
    private Map<Integer, String> result;
    public Map<Integer, String> SutAndMetForLMZ(Map<Integer, String> nomenclatureInFail, Map<Integer, Double> sutQuantityInFail) {
        metiz = 1;
        int i = 0;
        int lineNumber = 1;
        result = new HashMap<Integer, String>();
        while (i < nomenclatureInFail.size()) {
            if (Pattern.compile("НТ.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НТ[УСПОР].*").matcher(nomenclatureInFail.get(lineNumber)).find()){
                sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 1);
                result.put(lineNumber, SltkForT(nomenclatureInFail.get(lineNumber), sutQuantity));
            }
            if (Pattern.compile("НТТ.*").matcher(nomenclatureInFail.get(lineNumber)).find()){
                sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 2);
                result.put(lineNumber, SltkForT(nomenclatureInFail.get(lineNumber), sutQuantity));
            }
            if (Pattern.compile("НТХ.*").matcher(nomenclatureInFail.get(lineNumber)).find()){
                sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 3);
                result.put(lineNumber, SltkForT(nomenclatureInFail.get(lineNumber), sutQuantity));
            }
            if (Pattern.compile("ЛМЗ [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛПМЗ [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛПМ [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМЗ[УСПОР].* [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ[УСПОР].* [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
            ) {
                sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 1);
                result.put(lineNumber, SLBForT(nomenclatureInFail.get(lineNumber), sutQuantity));
            } else if (Pattern.compile("ЛМЗ[Т].* [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ[Т].* [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
            ) {
                sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 2);
                result.put(lineNumber, SLBForT(nomenclatureInFail.get(lineNumber), sutQuantity));
            } else if (Pattern.compile("ЛМЗ[Х].* [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ[Х].* [4-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
            ) {
                sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 3);
                result.put(lineNumber, SLBForT(nomenclatureInFail.get(lineNumber), sutQuantity));
            } else if (Pattern.compile("ЛМЗ [5-9]\\d\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛПМЗ [5-9]\\d\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛПМ [5-9]\\d\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ [5-9]\\d\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМЗ [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛПМЗ [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛПМ [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ[УСПОР].* [5-9]\\d\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМЗ[УСПОР].* [5-9]\\d\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМЗ[УСПОР].* [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ[УСПОР].* [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НПЛЗ [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НЛЗ [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НЛ [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НПЛ [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НЛЗ[УСПОР].* [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НЛ[УСПОР].* [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
            ) {
                sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 2);
                result.put(lineNumber, sutForT(nomenclatureInFail.get(lineNumber), sutQuantity));
            } else if (Pattern.compile("ЛМЗ[Т].* [5-9]\\d\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМЗ[Т].* [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("ЛМ[Т].* [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НЛЗ[Т].* [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                    || Pattern.compile("НЛ[Т].* [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()) {
                sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 4);
                result.put(lineNumber, sutForT(nomenclatureInFail.get(lineNumber), sutQuantity));
            }
            else if (Pattern.compile("ЛМЗ[Х].* [5-9]\\d\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                || Pattern.compile("ЛМЗ[Х].* [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                || Pattern.compile("ЛМ[Х].* [1-3]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                || Pattern.compile("НЛЗ[Х].* [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()
                || Pattern.compile("НЛ[Х].* [1-6]\\d{2}\\*.*").matcher(nomenclatureInFail.get(lineNumber)).find()) {
            sutQuantity = (int) (sutQuantityInFail.get(lineNumber) * 6);
            result.put(lineNumber, sutForT(nomenclatureInFail.get(lineNumber), sutQuantity));
        }
            lineNumber++;
            i++;
        }
        return result;
    }

    private String SLBForT(String a, int n) {
        slb = a.substring(a.indexOf(" "), a.indexOf("*"));
        if (Pattern.compile(".*\\*1[0-4][1-9]-.*").matcher(a).find()
                || Pattern.compile(".*\\*1[1-4].-.").matcher(a).find()) {
            metiz = n * 16;
            itogo = "" + n + " СЛБ" + slb + "-100-1,5-" +
                    hzOrS(a) + " ///"
                    +metiz + " метизов";
        } else if (Pattern.compile(".*\\*1[5-9].-.*").matcher(a).find()
                || Pattern.compile(".*\\*2\\d{2}-.*").matcher(a).find()) {
            metiz = n * 16;
            itogo = "" + n + " СЛБ" + slb + "-150-1,5-" +
                    hzOrS(a)+ " ///"
                    +metiz + " метизов";
        } else {
            metiz = n * 8;
            itogo = "" + n + " СЛБ" + slb + "-1,5-" +
                    hzOrS(a) + " ///"
                    +metiz + " метизов";
        }
        return itogo;
    }
    private String SltkForT(String a, int n) {
        sltk = a.substring(a.indexOf("*"),a.indexOf("-"));
            metiz = 0;
            itogo = "" + n + " СЛТК" + sltk +"-"+
                    hzOrS(a) + " ///"
                    +metiz + " метизов";
        return itogo;
    }
    private String sutForT(String a, int nn) {
        if (Pattern.compile(".*\\*1[0-4][1-9]-.*").matcher(a).find()
                || Pattern.compile(".*\\*1[1-4].-.").matcher(a).find()) {
            metiz = nn * 8;
            itogo = "" + nn + " СУТ 100-" +
                    hzOrS(a) + " ///"
                    + metiz + " метизов";
        } else if (Pattern.compile(".*\\*1[5-9].-.*").matcher(a).find()
                || Pattern.compile(".*\\*2\\d{2}-.*").matcher(a).find()) {
            metiz = nn * 8;
            itogo = "" + nn + " СУТ 150-" +
                    hzOrS(a) + " ///"
                    + metiz + " метизов";
        } else {
            metiz = nn * 4;
            itogo = "" + nn + " СУТ1,2 " +
                    hzOrS(a) + " ///" +
                    metiz + " метизов";
        }
        return itogo;
    }

    public String hzOrS(String a) {
        String c = a +" ";
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        String hzOrS1 = null;
         if (c.matches(".*-ГЦ.*")) {
            sb = sb.delete(0,sb.lastIndexOf("ГЦ"));
            sb =sb.delete(sb.indexOf(" "), sb.length());
            hzOrS1= sb.toString();
        }else  if (c.matches(".*-НЖ.*")) {
            sb = sb.delete(0,sb.lastIndexOf("НЖ"));
            sb =sb.delete(sb.indexOf(" "), sb.length());
            hzOrS1= sb.toString();
        }else  if (c.matches(".*-ОЦ.*")) {
             sb = sb.delete(0,sb.lastIndexOf("ОЦ"));
             sb =sb.delete(sb.indexOf(" "), sb.length());
             hzOrS1= sb.toString();
         }else  if (c.matches(".*-RAL.*")) {
             sb = sb.delete(0,sb.lastIndexOf("RAL"));
             sb =sb.delete(sb.indexOf(" "), sb.length());
             hzOrS1= sb.toString();
         }
        return hzOrS1;
    }
    }


