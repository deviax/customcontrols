package application;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class CenteredControl extends Region {

    private StackPane mainPane;

    public CenteredControl() {
        initGraphic();
        regsiterListeners();
    }

    private void initGraphic() {
        Rectangle rect = new Rectangle(200, 200, Color.CORNFLOWERBLUE);
        Label temperature = new Label();
        temperature.setText("23,7°");
        temperature.setTextFill(Color.GHOSTWHITE);
        temperature.setFont(Font.font("sans-serif", 34));
        mainPane = new StackPane(rect, temperature);
        getChildren().setAll(mainPane);
    }

    private void regsiterListeners() {
        widthProperty().addListener(e -> resize());
        heightProperty().addListener(e -> resize());
    }

    private Object resize() {
        mainPane.setPrefSize(getWidth(), getHeight());
        return null;
    }
}
