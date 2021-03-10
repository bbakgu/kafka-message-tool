package application;

import javax.imageio.ImageIO;

import application.logging.Logger;
import application.root.KafkaMessageToolApplication;
import application.root.ApplicationRoot;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    private static final int ERROR_EXIT_STATUS = 1;

    private final ApplicationRoot app = new KafkaMessageToolApplication(this);


    public static void main(String[] args) {
        try {
            com.apple.eawt.Application.getApplication().setDockIconImage(ImageIO.read(Main.class.getResourceAsStream("/kafka_tool_img.png")));
        } catch (Exception e) {
            // Won't work on Windows or Linux.
        }

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            app.start(primaryStage);
            primaryStage.getIcons().add(new Image("kafka_tool_img.png"));
        } catch (Throwable e) {
            Logger.error("Error while starting application", e);
            System.exit(ERROR_EXIT_STATUS);
        }
    }


}
