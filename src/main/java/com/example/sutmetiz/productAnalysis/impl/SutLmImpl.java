package com.example.sutmetiz.productAnalysis.impl;

import com.example.sutmetiz.productAnalysis.SutLm;

import java.util.regex.Pattern;
public class SutLmImpl implements SutLm {
    private String itogo;
    private String metis16;
    private int metizQty;
    private int sutQuantity;
    private String result;
    @Override
    public String getResult() {
        return result;
    }
@Override
    public boolean sutAndMetForNt(String nomenclature, Double quantity) {
        int qty = (int) Math.round(quantity);
        if (Pattern.compile("^НТХ.*[0-9]{3}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛТХ.*[0-9]{3}\\*.*").matcher(nomenclature).find()) {
            sutQuantity = qty * 3;
            result = sltkForT(nomenclature, sutQuantity);
            return true;
        } else if (Pattern.compile("^НТТ.*[0-9]{3}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛТТ.*[0-9]{3}\\*.*").matcher(nomenclature).find()) {
            sutQuantity = qty * 2;
            result = sltkForT(nomenclature, sutQuantity);
            return true;
        } else if (Pattern.compile("^НТ.*[0-9]{3}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НТ[УСПОР].*[0-9]{3}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛТ.*[0-9]{3}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛТ[УСПОР].*[0-9]{3}\\*.*").matcher(nomenclature).find()) {
            sutQuantity = qty * 1;
            result = sltkForT(nomenclature, sutQuantity);
            return true;
        } else {
            return false;
        }
    }
    public boolean sutAndMetForLmAndNl(String nomenclature, Double quantity) {
        int qty = (int) Math.round(quantity);
        if (Pattern.compile("^ЛМЗ [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛПМЗ [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛПМ [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМЗ[УСПОР].* [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ[УСПОР].* [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
        ) {
            sutQuantity = qty * 1;
            result = SLBForT(nomenclature, sutQuantity);
            return true;
        } else if (Pattern.compile("^ЛМЗ[Т].* [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ[Т].* [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
        ) {
            sutQuantity = qty * 2;
            result = SLBForT(nomenclature, sutQuantity);
            return true;
        } else if (Pattern.compile("^ЛМЗ[Х].* [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ[Х].* [4-6]\\d{2}\\*.*").matcher(nomenclature).find()
        ) {
            sutQuantity = qty * 3;
            result = SLBForT(nomenclature, sutQuantity);
            return true;
        } else if (Pattern.compile("^ЛМЗ [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛПМЗ [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛПМ [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМЗ [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛПМЗ [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛПМ [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ[УСПОР].* [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМЗ[УСПОР].* [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМЗ[УСПОР].* [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ[УСПОР].* [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НПЛЗ [1-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НЛЗ [1-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НЛ [1-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НПЛ [1-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НЛЗ[УСПОР].* [1-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НЛ[УСПОР].* [1-6]\\d{2}\\*.*").matcher(nomenclature).find()
        ) {
            sutQuantity = qty * 2;
            result = sutForT(nomenclature, sutQuantity);
            return true;
        } else if (Pattern.compile("^ЛМЗ[Т].* [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМЗ[Т].* [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ[Т].* [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НЛЗ[Т].* [1-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НЛ[Т].* [1-6]\\d{2}\\*.*").matcher(nomenclature).find()) {
            sutQuantity = qty * 4;
            result = sutForT(nomenclature, sutQuantity);
            return true;
        } else if (Pattern.compile("^ЛМЗ[Х].* [5-9]\\d\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМЗ[Х].* [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ[Х].* [1-3]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НЛЗ[Х].* [1-6]\\d{2}\\*.*").matcher(nomenclature).find()
                || Pattern.compile("^НЛ[Х].* [1-6]\\d{2}\\*.*").matcher(nomenclature).find()) {
            sutQuantity = qty * 6;
            result = sutForT(nomenclature, sutQuantity);
            return true;
        } else {
            return false;
        }
    }
    public boolean sutAndMetForOther(String nomenclature, int lineNumber) {
        if (Pattern.compile("^ЛМЗ[ТХР].*").matcher(nomenclature).find()
                || Pattern.compile("^ЛМ[ТХР].*").matcher(nomenclature).find()
                || Pattern.compile("^НЛ[ХТР].*").matcher(nomenclature).find()
                || Pattern.compile("^НЛЗ[ХТР].*").matcher(nomenclature).find()
                || Pattern.compile("^НТ[ХТР].*").matcher(nomenclature).find()
                || Pattern.compile("^ЛТ[ХТР].*").matcher(nomenclature).find()
                || Pattern.compile("^ЛТГ[ХТР].*").matcher(nomenclature).find()) {
            result = "Соединители необходимо посчитать в позиции" + lineNumber + " ///";
            return true;
        } else {
            return false;
        }
    }
    private String sltkForT(String a, int n) {
        String sltk = a.substring(a.indexOf("*")+1,a.indexOf("-"));
        metizQty = 0;
        itogo = "" + n + " СЛТК " + sltk +"-"+
                hzOrS(a) + " ///"
                +metizQty + metis16;

        return itogo;
    }
    private String SLBForT(String a, int n) {
        String slb = a.substring(a.indexOf(" "), a.indexOf("*"));
        if (Pattern.compile(".*\\*1[0-4][1-9]-.*").matcher(a).find()
                || Pattern.compile(".*\\*1[1-4].-.").matcher(a).find()) {
            metizQty = n * 16;
            itogo = "" + n + " СЛБ" + slb + "*100-1,5-" +
                    hzOrS(a) + " ///"
                    +metizQty + metis16;
        } else if (Pattern.compile(".*\\*1[5-9].-.*").matcher(a).find()
                || Pattern.compile(".*\\*2\\d{2}-.*").matcher(a).find()) {
            metizQty = n * 16;
            itogo = "" + n + " СЛБ" + slb + "*150-1,5-" +
                    hzOrS(a)+ " ///"
                    +metizQty + metis16;
        } else {
            metizQty = n * 8;
            itogo = "" + n + " СЛБ" + slb + "-1,5-" +
                    hzOrS(a) + " ///"
                    +metizQty + metis16;
        }
        return itogo;
    }

    private String sutForT(String a, int nn) {
        if (Pattern.compile(".*\\*1[0-4][1-9]-.*").matcher(a).find()
                || Pattern.compile(".*\\*1[1-4].-.").matcher(a).find()) {
            metizQty = nn * 8;
            itogo = "" + nn + " СУТ1,5 100-" +
                    hzOrS(a) + " ///"
                    + metizQty + metis16;
        } else if (Pattern.compile(".*\\*1[5-9].-.*").matcher(a).find()
                || Pattern.compile(".*\\*2\\d{2}-.*").matcher(a).find()) {
            metizQty = nn * 8;
            itogo = "" + nn + " СУТ1,5 150-" +
                    hzOrS(a) + " ///"
                    + metizQty + metis16;
        } else {
            metizQty = nn * 4;
            itogo = "" + nn + " СУТ1,2 " +
                    hzOrS(a) + " ///" +
                    metizQty + metis16;
        }
        return itogo;
    }

    private String hzOrS(String a) {
        String c = a +" ";
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        String hzOrS1 = null;
        if (c.matches(".*-ГЦ.*")) {
            sb = sb.delete(0,sb.lastIndexOf("ГЦ"));
            sb =sb.delete(sb.indexOf(" "), sb.length());
            if (sb.indexOf(")")!=-1)  {sb =sb.deleteCharAt(sb.indexOf(")"));}
            hzOrS1= sb.toString();
            metis16 =" Метизы М8*16";
        }else  if (c.matches(".*-НЖ.*")) {
            sb = sb.delete(0,sb.lastIndexOf("НЖ"));
            sb =sb.delete(sb.indexOf(" "), sb.length());
            if (sb.indexOf(")")!=-1)  {sb =sb.deleteCharAt(sb.indexOf(")"));}
            hzOrS1= sb.toString();
            metis16 =" Метизы М8*16 НЖ";
        }else  if (c.matches(".*-ОЦ.*")) {
            sb = sb.delete(0,sb.lastIndexOf("ОЦ"));
            if (sb.indexOf(")")!=-1)  {sb =sb.deleteCharAt(sb.indexOf(")"));}
            sb =sb.delete(sb.indexOf(" "), sb.length());
            hzOrS1= sb.toString();
            metis16 =" Метизы М8*16";
        }else  if (c.matches(".*-RAL.*")) {
            sb = sb.delete(0,sb.lastIndexOf("RAL"));
            if (sb.indexOf(")")!=-1)  {sb =sb.deleteCharAt(sb.indexOf(")"));}
            sb =sb.delete(sb.indexOf(" "), sb.length());
            hzOrS1= sb.toString();
            metis16 =" Метизы М8*16";
        }else  if (c.matches(".*-ХК.*")) {
        sb = sb.delete(0,sb.lastIndexOf("ХК"));
        if (sb.indexOf(")")!=-1)  {sb =sb.deleteCharAt(sb.indexOf(")"));}
        sb =sb.delete(sb.indexOf(" "), sb.length());
        hzOrS1= sb.toString();
        metis16 =" Метизы М8*16";}
        return hzOrS1;
    }
}


