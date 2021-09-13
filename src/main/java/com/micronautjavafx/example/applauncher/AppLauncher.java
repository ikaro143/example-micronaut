package com.micronautjavafx.example.applauncher;

import com.micronautjavafx.example.ExampleApplication;
import com.micronautjavafx.example.applauncher.StageInitializer.StageReadyEvent;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.LifeCycle;
import io.micronaut.context.event.ApplicationEvent;
import io.micronaut.context.event.ApplicationEventPublisher;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppLauncher extends Application {

    private final ApplicationContext appContext = ApplicationContext.builder().build().start();
    private final ApplicationEventPublisher<ApplicationEvent> publisher = this.appContext.getBean(
            ApplicationEventPublisher.class);

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() {
        Platform.exit();
        Optional.of(this.appContext)
                .filter(LifeCycle::isRunning)
                .ifPresent(ApplicationContext::stop);
    }

    @Override
    public void start(Stage stage) {
        this.publisher.publishEvent(new StageReadyEvent(stage));
    }
}
