package com.example.sutmetiz;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.awt.Desktop;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
public class HelloController {

    @FXML
    private TextArea textAreaNom;
    @FXML
    private TextArea textAreaKol;
    private Desktop desktop = Desktop.getDesktop();
    @FXML
    protected void onHelloButtonClick() throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select directory for save");
        fileChooser.setInitialFileName("");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Книга Excel", "*.xlsx"));
        File file = fileChooser.showSaveDialog(stage);


        String[] arrStr = textAreaNom.getText().split("\n");
        HashMap<Integer,String> nomenclature = new HashMap<>();
        HashMap<Integer,String> nomenclatureALL = new HashMap<>();
        int lineNumber=1;
        for (String h:arrStr){
            nomenclatureALL.put(lineNumber,h);
            if(h==null||h.isEmpty()) {h="0.0";}
            nomenclature.put(lineNumber,h);
            lineNumber++;
        }


        String[] arrStrKol = textAreaKol.getText().split("\n");
        HashMap<Integer,Double> kol = new HashMap<>();
        HashMap<Integer,String> kolAll = new HashMap<>();
        lineNumber=1;
        for (String o:arrStrKol){
            kolAll.put(lineNumber,o);
            o=o.trim().replaceAll(" ","").replaceAll(",",".");
            if(o==null||o.isEmpty()||!o.matches("-?\\d+(\\.\\d+)?")) {o="0.0";}
            kol.put(lineNumber,Double.parseDouble(o));
            lineNumber++;
        }
        Itog itog = new Itog();
        SutLm sutLm = new SutLm();
        WriteIntoExcel write = new WriteIntoExcel();
        sutLm.SutAndMetForLMZ(nomenclature,kol);
        write.writeIntoExcel(file.getPath(), nomenclatureALL,kolAll, sutLm.SutAndMetForLMZ(nomenclature,kol), itog.itog(sutLm.SutAndMetForLMZ(nomenclature,kol)));

    }
}