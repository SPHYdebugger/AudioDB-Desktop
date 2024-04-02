module com.sphy.audiodbdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires retrofit2;
    requires io.reactivex.rxjava2;
    requires okhttp3;
    requires logging.interceptor;
    requires retrofit2.converter.gson;
    requires gson;
    requires retrofit2.adapter.rxjava2;


    opens com.sphy.audiodbdesktop to javafx.fxml;
    exports com.sphy.audiodbdesktop;
}