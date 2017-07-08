package de.deviax.fx.customcontrols;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DynamicControl extends Region {

    private static final double PREFERRED_WIDTH = 200;
    private static final double PREFERRED_HEIGHT = 200;
    private static final double MINIMUM_WIDTH = 100;
    private static final double MINIMUM_HEIGHT = 100;
    private static final double MAXIMUM_WIDTH = 300;
    private static final double MAXIMUM_HEIGHT = 300;

    private StackPane mainPane;

    public DynamicControl() {
        initGraphic();
        regsiterListeners();
    }

    private void initGraphic() {

        Label temperature = new Label();
        temperature.setText("23,7°");
        temperature.setTextFill(Color.GHOSTWHITE);
        temperature.setFont(Font.font("sans-serif", 34));
        mainPane = new StackPane(temperature);
        mainPane.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        mainPane.setPrefSize(PREFERRED_WIDTH, PREFERRED_HEIGHT);
        getChildren().setAll(mainPane);

    }

    private void regsiterListeners() {
        widthProperty().addListener(e -> resize());
        heightProperty().addListener(e -> resize());
    }

    private Object resize() {
        double size = getWidth() > getHeight() ? getHeight() : getWidth();
        mainPane.setPrefSize(size, size);
        mainPane.setLayoutX((getWidth() - size) / 2);
        mainPane.setLayoutY((getHeight() - size) / 2);
        return null;
    }

    @Override
    protected double computeMinWidth(final double HEIGHT) {
        return MINIMUM_WIDTH;
    }

    @Override
    protected double computeMinHeight(final double WIDTH) {
        return MINIMUM_HEIGHT;
    }

    @Override
    protected double computePrefWidth(final double HEIGHT) {
        return super.computePrefWidth(HEIGHT);
    }

    @Override
    protected double computePrefHeight(final double WIDTH) {
        return super.computePrefHeight(WIDTH);
    }

    @Override
    protected double computeMaxWidth(final double HEIGHT) {
        return MAXIMUM_WIDTH;
    }

    @Override
    protected double computeMaxHeight(final double WIDTH) {
        return MAXIMUM_HEIGHT;
    }
}
