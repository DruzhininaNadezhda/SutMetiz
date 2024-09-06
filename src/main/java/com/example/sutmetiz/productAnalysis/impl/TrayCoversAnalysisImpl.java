package com.example.sutmetiz.productAnalysis.impl;

import com.example.sutmetiz.productAnalysis.TrayCoversAnalysis;

import java.util.regex.Pattern;

public class TrayCoversAnalysisImpl implements TrayCoversAnalysis {
    private String cover = "";
    private int quantityCovers;
    @Override
    public String getCover() {
        return cover;
    }
    @Override
    public int getQuantityCovers() {
        return quantityCovers;
    }
    @Override
    public boolean coversForAllnomenclatureYesOrNo(String nomenclature) {
        if (noCover(nomenclature)) {
            if (nomenclature != null && !nomenclature.isEmpty()
                    && !nomenclature.equals("0.0")
                    && (coverNameLM(nomenclature) || coverNameNT(nomenclature) || coverNameNL(nomenclature))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean coverNameLM(String nomenclature) {
        StringBuilder nom = new StringBuilder(nomenclature);
        if (Pattern.compile("^ЛМЗ").matcher(nomenclature).find()
                ||Pattern.compile("^ЛПМЗ").matcher(nomenclature).find()) {
            if (nom.indexOf("С") != -1) {
                cover = "КЛЗС" + nom.delete(0, nom.indexOf("З") + 2);
            } else {
                cover = "КЛЗ" + nom.delete(0, nom.indexOf("З") + 1).delete(nom.indexOf("*"), nom.indexOf("-"));
            }
            quantityCovers = 1;
            return true;
        } else if (Pattern.compile("^ЛМ").matcher(nomenclature).find()
                || Pattern.compile("^ЛПМ").matcher(nomenclature).find()) {
            if (nom.indexOf("С") != -1) {
                cover = "КЛС" + nom.delete(0, nom.indexOf("М") + 2);
            } else {
                cover = "КЛ" + nom.delete(0, nom.indexOf("М") + 1).delete(nom.indexOf("*"), nom.indexOf("-"));
            }
            quantityCovers = 1;
            return true;

        }
        return false;
    }
     public boolean noCover(String nomenclature) {
        return !Pattern.compile("^ЛМЗ[ТСП][а-яА-Я]{1,3} .*").matcher(nomenclature).find();
    }

    private boolean coverNameNT(String nomenclature) {
        StringBuilder nom = new StringBuilder(nomenclature);
        if (Pattern.compile("^НТ").matcher(nomenclature).find()
                || Pattern.compile("ЛТ").matcher(nomenclature).find()) {
            if (nom.indexOf("С") != -1) {
                cover = "КТС" + nom.delete(0, nom.indexOf("Т") + 2);
                quantityCovers = 1;
                return true;
            } else {
                if (nom.indexOf("6000") == -1 && nom.indexOf("4000") == -1) {
                    cover = nom.indexOf("ЛТГ") != -1 ? "КТ" + nom.delete(0, nom.indexOf("г") + 1).delete(nom.indexOf("*"), nom.indexOf("-"))
                            : "КТ" + nom.delete(0, nom.indexOf("Т") + 1).delete(nom.indexOf("*"), nom.indexOf("-"));
                    quantityCovers = 1;
                    return true;
                } else if (nom.indexOf("-6000-") != -1) {
                    nom.replace(nom.indexOf("-6000-"), nom.indexOf("-6000-") + 6, "-3000-");
                    cover = nom.indexOf("ЛТг") != -1 ? "КТ" + nom.delete(0, nom.indexOf("г") + 1).delete(nom.indexOf("*"), nom.indexOf("-"))
                            : "КТ" + nom.delete(0, nom.indexOf("Т") + 1).delete(nom.indexOf("*"), nom.indexOf("-"));
                    quantityCovers = 2;
                    return true;
                } else if (nom.indexOf("-4000-") != -1) {
                    nom.replace(nom.indexOf("-4000-"), nom.indexOf("-4000-") + 6, "-2000-");
                    cover = nom.indexOf("ЛТГ") != -1 ? "КТ" + nom.delete(0, nom.indexOf("г") + 1).delete(nom.indexOf("*"), nom.indexOf("-"))
                            : "КТ" + nom.delete(0, nom.indexOf("Т") + 1).delete(nom.indexOf("*"), nom.indexOf("-"));
                    quantityCovers = 2;
                    return true;
                }


            }
        }
        return false;
    }

    private boolean coverNameNL(String nomenclature) {
        StringBuilder nom = new StringBuilder(nomenclature);
        if (Pattern.compile("^НЛЗ").matcher(nomenclature).find()
                || Pattern.compile("^НПЛЗ").matcher(nomenclature).find()) {
            if (nom.indexOf("С") != -1) {
                cover = "КНЗС" + nom.delete(0, nom.indexOf("З") + 2);
                quantityCovers = 1;
                return true;
            } else {
                cover = "КНЗ" + nom.delete(0, nom.indexOf("З") + 1).delete(nom.indexOf("*"), nom.indexOf("-"));
                quantityCovers = 1;
                return true;
            }
        } else if (Pattern.compile("^НЛ").matcher(nomenclature).find()
                || Pattern.compile("^НПЛ").matcher(nomenclature).find()) {
            if (nom.indexOf("С") != -1) {
                cover = "КНС" + nom.delete(0, nom.indexOf("Л") + 2);
                quantityCovers = 1;
                return true;
            } else {
                cover = "КН" + nom.delete(0, nom.indexOf("Л") + 1).delete(nom.indexOf("*"), nom.indexOf("-"));
                quantityCovers = 1;
                return true;
            }

        }
        return false;
    }
}

