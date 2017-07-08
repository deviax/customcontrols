package application;

import java.util.ArrayList;
import java.util.List;

import application.CenteredControl;
import application.DynamicControl;
import application.PropertyControl;
import application.SimpleControl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DemoCustomControls extends Application {
    private List<Region> controls;
    private StackPane root;
    int idx = 0;

    @Override
    public void start(Stage primaryStage) {
        try {
            root = new StackPane();
            root.setPadding(new Insets(10));

            SimpleControl sctrl = new SimpleControl();
            CenteredControl cctrl = new CenteredControl();
            DynamicControl dctrl = new DynamicControl();
            PropertyControl pctrl = new PropertyControl();

            controls = new ArrayList<>();

            controls.add(sctrl);
            controls.add(cctrl);
            controls.add(dctrl);
            controls.add(pctrl);

            root.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                switchControl();
            });

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

    private void switchControl() {

        root.getChildren()
            .setAll(controls.get(idx));

        idx++;
        idx = idx >= controls.size() ? 0 : idx;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
