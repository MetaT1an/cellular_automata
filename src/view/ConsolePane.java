package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class ConsolePane {
    private GridPane gridPane;
    private Label[] labels;
    private ComboBox<String> sizeBox;
    private ComboBox<Double> birthRateBox;
    private ArrayList<String> sizeItems;
    private ArrayList<Double> birthRateItems;
    private Button[] buttons;

    private ConsolePane(){
        gridPane = new GridPane();

        labels = new Label[2];
        for(int i=0; i<2; ++i)
            labels[i] = new Label();

        sizeBox = new ComboBox<>();
        birthRateBox = new ComboBox<>();
        sizeItems = new ArrayList<>();
        birthRateItems = new ArrayList<>();

        buttons = new Button[3];
        for(int i=0; i<3; ++i)
            buttons[i] = new Button();

        setModule();
        loadModule();
    }

    private static ConsolePane consolePane = null;

    public static ConsolePane getConsolePane(){
        if(consolePane == null)
            consolePane = new ConsolePane();
        return consolePane;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public ComboBox<String> getSizeBox() {
        return sizeBox;
    }

    public ComboBox<Double> getBirthRateBox() {
        return birthRateBox;
    }

    public Button getButtons(int i) {
        return buttons[i];
    }

    private void setModule(){
        labels[0].setText("Size:");
        labels[0].setFont(Font.font(16));
        labels[1].setText("Birth Rate:");
        labels[1].setFont(Font.font(16));

        sizeBox.setPrefSize(100, 20);
        birthRateBox.setPrefSize(70, 20);

        sizeItems.add("20 × 20");
        sizeItems.add("30 × 30");
        sizeItems.add("40 × 40");

        birthRateItems.add(0.1);
        birthRateItems.add(0.2);
        birthRateItems.add(0.5);

        buttons[0].setText("Set");
        buttons[1].setText("Pause");
        buttons[2].setText("Run");
        for(int i=0; i<3; ++i){
            buttons[i].setPrefSize(150, 36);
            buttons[i].setFont(Font.font(16));
        }

    }

    private void loadModule(){
        int i;
        for(i=0; i<2; ++i)
            gridPane.add(labels[i], 0, i);
        gridPane.add(sizeBox, 1, 0);
        gridPane.add(birthRateBox, 1, 1);

        for(i=0; i<3; ++i)
            gridPane.add(buttons[i], 0, i+2, 2, 1);

        sizeBox.getItems().addAll(sizeItems);
        sizeBox.setValue(sizeItems.get(1));
        birthRateBox.getItems().addAll(birthRateItems);
        birthRateBox.setValue(birthRateItems.get(1));

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);
        GridPane.setMargin(birthRateBox, new Insets(0, 0, 0, 30));

        for(i=0; i<3; ++i){
            GridPane.setMargin(buttons[i], new Insets(10, 0, 0, 15));
        }
    }
}
