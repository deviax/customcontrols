package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DemoCustomControls extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            StackPane root = new StackPane();
            root.setPadding(new Insets(10));

            SimpleControl sctrl = new SimpleControl();
            CenteredControl cctrl = new CenteredControl();
            DynamicControl dctrl = new DynamicControl();
            PropertyControl pctrl = new PropertyControl();

            // root.getChildren()
            // .add(sctrl);
            // root.getChildren()
            // .add(cctrl);
            // root.getChildren()
            // .add(dctrl);
            root.getChildren()
                .add(pctrl);

            root.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                pctrl.setTemperature(pctrl.getTemperature() + 1.30);
                System.out.println("temp: " + pctrl.getTemperature());
            });

            Scene scene = new Scene(root, 400, 400);
            // root.prefWidthProperty()
            // .bind(scene.widthProperty());
            // root.prefHeightProperty()
            // .bind(scene.heightProperty());
            scene.getStylesheets()
                 .add(getClass().getResource("application.css")
                                .toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Custom Controls Demo");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
