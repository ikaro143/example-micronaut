package com.micronautjavafx.example.applauncher;

import com.micronautjavafx.example.applauncher.StageInitializer.StageReadyEvent;
import com.micronautjavafx.example.components.MainUI;
import io.micronaut.context.event.ApplicationEvent;
import io.micronaut.context.event.ApplicationEventListener;
import jakarta.inject.Singleton;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Singleton
public class StageInitializer implements ApplicationEventListener<StageReadyEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StageInitializer.class);

    @Override
    public void onApplicationEvent(StageReadyEvent event) {

        // Start the user interface
        try {
            Stage stage = event.getStage();
            stage.setTitle("This is an example of JavaFX & SpringBoot");

            Scene scene = new Scene(new MainUI(),
                    Color.web("#666970"));
            stage.setScene(scene);
            stage.show();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    static class StageReadyEvent extends ApplicationEvent {

        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return (Stage) this.getSource();
        }
    }
}
