package application;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PropertyControl extends Region {

    private static final double PREFERRED_WIDTH = 200;
    private static final double PREFERRED_HEIGHT = 200;
    private static final double MINIMUM_WIDTH = 100;
    private static final double MINIMUM_HEIGHT = 100;
    private static final double MAXIMUM_WIDTH = 300;
    private static final double MAXIMUM_HEIGHT = 300;

    private StackPane mainPane;
    private DoubleProperty temperature;

    public PropertyControl() {
        temperature = new SimpleDoubleProperty(0.0);
        initGraphic();
        regsiterListeners();
    }

    private void initGraphic() {

        Label tempLbl = new Label();
        tempLbl.textProperty()
               .bind(Bindings.concat(temperature)
                             .concat("°"));
        tempLbl.setTextFill(Color.GHOSTWHITE);
        tempLbl.setFont(Font.font("sans-serif", 34));
        mainPane = new StackPane(tempLbl);
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

    public final DoubleProperty temperatureProperty() {
        return this.temperature;
    }

    public final double getTemperature() {
        return this.temperatureProperty()
                   .get();
    }

    public final void setTemperature(final double temperature) {
        this.temperatureProperty()
            .set(temperature);
    }

}
