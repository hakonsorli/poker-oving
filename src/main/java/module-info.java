module org.example.pokerjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.pokerjavafx to javafx.fxml;
    exports org.example.pokerjavafx;
}