package de.deviax.fx.customcontrols;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class SimpleControl extends Region {

    private StackPane mainPane;

    public SimpleControl() {
        initGraphic();
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

}
