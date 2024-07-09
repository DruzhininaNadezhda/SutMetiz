package com.example.sutmetiz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.HashMap;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextArea textAreaNom;
    @FXML
    private TextArea textAreakol;
    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");
        String arrStr[] = textAreaNom.getText().split("\n");
        HashMap<Integer,String> nom = new HashMap();
        int l=1;
        for (String h:arrStr){
            if(h==null||h.isEmpty()) {h="0.0";}
            nom.put(l,h);
            l++;
        }
        String arrStrKol[] = textAreakol.getText().split("\n");
        HashMap<Integer,Double> kol = new HashMap();
        int p=1;
        for (String o:arrStrKol){
            o=o.trim().replaceAll(" ","").replaceAll(",",".");

            if(o==null||o.isEmpty()) {o="0.0";}
            kol.put(p,Double.parseDouble(o));
            p++;
        }
        Itog itog = new Itog();
        SutLm sutLm = new SutLm();
        WriteIntoExcel write = new WriteIntoExcel();
        sutLm.SutAndMetForLMZ(nom,kol);
        write.writeIntoExcel("C:\\Users\\wulvj\\OneDrive\\Рабочий стол\\", nom,kol, sutLm.SutAndMetForLMZ(nom,kol), itog.itog(sutLm.SutAndMetForLMZ(nom,kol)));

    }
}