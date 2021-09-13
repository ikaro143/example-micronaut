package com.micronautjavafx.example.components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainUI extends VBox {

    public MainUI() {
        this.setPadding(new Insets(10));
        this.setSpacing(20);

        this.getChildren().add(new Label("This is a test application to compile Native JavaFX and SpringBoot"));
    }
}
