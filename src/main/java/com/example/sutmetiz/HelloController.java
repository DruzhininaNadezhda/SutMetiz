package com.example.sutmetiz;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
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
    @FXML
    protected void onHelloButtonClick() throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select directory for save");
        fileChooser.setInitialFileName("");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Книга Excel", "*.xlsx"));
        File file = fileChooser.showSaveDialog(stage);

        Itog itog = new Itog();
        SutLm sutLm = new SutLm();
        WriteIntoExcel write = new WriteIntoExcel();

        String[] arrStr = textAreaNom.getText().split("\n");
        HashMap<Integer,String> nomenclature = new HashMap<>();
        HashMap<Integer,String> nomenclatureALL = new HashMap<>();

        String[] arrStrKol = textAreaKol.getText().split("\n");
        HashMap<Integer,Double> kol = new HashMap<>();
        HashMap<Integer,String> kolAll = new HashMap<>();
       try {
        int lineNumber=1;
        for (String h:arrStr){
            nomenclatureALL.put(lineNumber,h);
            if(h==null||h.isEmpty()) {h="0.0";}
            nomenclature.put(lineNumber,h);
            lineNumber++;
        }
        lineNumber=1;
        for (String o:arrStrKol){
            kolAll.put(lineNumber,o);
            o=o.replace("\u00a0","");
            o=o.trim().replaceAll(" ","").replaceAll(",",".");
            if(o==null||o.isEmpty()||!o.matches("-?\\d+(\\.\\d+)?")) {o="0.0";}
            kol.put(lineNumber,Double.parseDouble(o));
            lineNumber++;
        }
           if (kol.size()<nomenclature.size()) {
               int size = nomenclature.size() - kol.size();
               for (int i = 1; i <= size; i++) {
                   kol.put(kol.size() + i, 0.0);
               }
           }
        for (int t:nomenclature.keySet()){
            if(!kol.containsKey(t)){
                kol.put(t,0.0);
            }
        }

        sutLm.SutAndMetForLMZ(nomenclature,kol);
        try {
            write.writeIntoExcel(file.getPath(), nomenclatureALL,kolAll, sutLm.SutAndMetForLMZ(nomenclature,kol), itog.itog(sutLm.SutAndMetForLMZ(nomenclature,kol)));
       textAreaNom.setText("");
       textAreaKol.setText("");
        } catch (IOException e) {
            errorsWindow(e.getMessage());
            throw new RuntimeException(e);
        }}catch (Exception e){
           e.printStackTrace();
           errorsWindow(e.getMessage());
    }
    }
    protected void errorsWindow(String errors){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Произошла ошибка");
        alert.setHeaderText(null);
        alert.setContentText(errors);
        alert.showAndWait();
    }
}