module com.mycompany.gastoss {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.gastoss to javafx.fxml;
    exports com.mycompany.gastoss;
}
