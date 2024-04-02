module com.sphy.audiodbdesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sphy.audiodbdesktop to javafx.fxml;
    exports com.sphy.audiodbdesktop;
}