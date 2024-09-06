package com.example.sutmetiz.productAnalysis;

public interface SutLm {
    boolean sutAndMetForNt(String nomenclature, Double quantity);
    String getResult();
    public boolean sutAndMetForLmAndNl(String nomenclature, Double quantity);
    public boolean sutAndMetForOther(String nomenclature, int lineNumber);
}
