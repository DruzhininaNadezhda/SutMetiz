package com.example.sutmetiz.in;
import com.example.sutmetiz.out.Itog;
import com.example.sutmetiz.out.WrittenIntoExcels;
import com.example.sutmetiz.out.impl.ItogImpl;
import com.example.sutmetiz.out.impl.WriteIntoExcelImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import lombok.Getter;
import org.apache.log4j.Logger;
@Getter
public class HelloController {
    private static final Logger log = Logger.getLogger(HelloController.class);
    @FXML
    private TextArea textAreaNom;
    @FXML
    private TextArea textAreaKol;
    @FXML
    private RadioButton trayButton;
    private HashMap<Integer,Double> kol;
    private HashMap<Integer,String> kolAll;
    private HashMap<Integer,String> nomenclature;
   private HashMap<Integer,String> nomenclatureALL;
    @FXML
    protected void onHelloButtonClick(){
        log.info("Start");
        Itog itog = new ItogImpl();
        SortingOfNomenclature sortingOfNomenclature = new SortingOfNomenclature();
        WrittenIntoExcels write = new WriteIntoExcelImpl();
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select directory for save");
        fileChooser.setInitialFileName("Сут_метизы_опорка");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Книга Excel", "*.xlsx"));
        File file = fileChooser.showSaveDialog(stage);
        nomenclatureAnalysis();

        //sortingOfNomenclature.allSutAndMetiz(nomenclature,kol);
        try {
            if (trayButton.isSelected()){
                write.writeIntoExcel(file.getPath(),
                        nomenclatureALL,
                        kolAll,
                        sortingOfNomenclature.allSutAndMetiz(nomenclature,kol),
                        itog.finalForSutAndMetiz(sortingOfNomenclature.allSutAndMetiz(nomenclature,kol)),
                        itog.trays(nomenclature,kol));
            }
            else {
                write.writeIntoExcel(file.getPath(), nomenclatureALL,kolAll,
                        sortingOfNomenclature.allSutAndMetiz(nomenclature,kol),
                        itog.finalForSutAndMetiz(sortingOfNomenclature.allSutAndMetiz(nomenclature,kol)),
                        new HashMap<>());
            }
            textAreaNom.setText("");
            textAreaKol.setText("");
            log.info("Finnish");
        } catch (IOException e) {
            log.info("ErrorFile"+e.getMessage());
            errorsWindow(e.getMessage());
        }

    }
    protected void nomenclatureAnalysis() {
        log.info("nomenclatureAnalysis");
        String[] arrStr = textAreaNom.getText().split("\n");
        nomenclature = new HashMap<>();
        nomenclatureALL = new HashMap<>();

        String[] arrStrKol = textAreaKol.getText().split("\n");
        kol = new HashMap<>();
        kolAll = new HashMap<>();

        try {
            int lineNumber = 1;
            for (String h : arrStr) {
                nomenclatureALL.put(lineNumber, h);
                if (h == null || h.isEmpty()) {
                    h = "0.0";
                }
                nomenclature.put(lineNumber, h.toUpperCase());
                lineNumber++;
            }
            lineNumber = 1;
            for (String o : arrStrKol) {
                kolAll.put(lineNumber, o);
                o = o.replace("\u00a0", "");
                o = o.trim().replaceAll(" ", "").replaceAll(",", ".");
                if (o == null || o.isEmpty() || !o.matches("-?\\d+(\\.\\d+)?")) {
                    o = "0.0";
                }
                kol.put(lineNumber, Double.parseDouble(o));
                lineNumber++;
            }
            if (kol.size() < nomenclature.size()) {
                int size = nomenclature.size() - kol.size();
                for (int i = 1; i <= size; i++) {
                    kol.put(kol.size() + i, 0.0);
                }
            }
            for (int t : nomenclature.keySet()) {
                if (!kol.containsKey(t)) {
                    kol.put(t, 0.0);
                }
            }
            log.info("finishNomenclatureAnalysis");
        } catch (Exception e) {
            log.info("ErrorNomenclatureAnalysis"+e.getMessage());
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