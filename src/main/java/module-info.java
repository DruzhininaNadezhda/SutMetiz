module com.example.sutmetiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires java.desktop;


    opens com.example.sutmetiz to javafx.fxml;
    exports com.example.sutmetiz;
}