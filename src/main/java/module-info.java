module com.example.sutmetiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires java.desktop;
    requires log4j;
    requires static lombok;


    opens com.example.sutmetiz to javafx.fxml;
    exports com.example.sutmetiz;
    exports com.example.sutmetiz.productAnalysis;
    opens com.example.sutmetiz.productAnalysis to javafx.fxml;
    exports com.example.sutmetiz.in;
    opens com.example.sutmetiz.in to javafx.fxml;
    exports com.example.sutmetiz.out;
    opens com.example.sutmetiz.out to javafx.fxml;
    exports com.example.sutmetiz.productAnalysis.impl;
    opens com.example.sutmetiz.productAnalysis.impl to javafx.fxml;
    exports com.example.sutmetiz.out.impl;
    opens com.example.sutmetiz.out.impl to javafx.fxml;
}