package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class ConsolePane {
    private VBox vBox;
    private HBox[] hBox;
    private GridPane gridPane;
    private Label[] labels;
    private ComboBox<String> sizeBox;
    private ComboBox<Double> birthRateBox;
    private ComboBox<String> modeBox;
    private ComboBox<String> instanceBox;
    private ArrayList<String> sizeItems;
    private ArrayList<Double> birthRateItems;
    private ArrayList<String> modeItems;
    private ArrayList<String> instanceItems;
    private Button[] buttons;

    private ConsolePane(){
        vBox = new VBox(20);
        hBox = new HBox[2];
        hBox[0] = new HBox(20);
        hBox[1] = new HBox(45);
        gridPane = new GridPane();

        labels = new Label[4];
        for(int i=0; i<4; ++i)
            labels[i] = new Label();

        sizeBox = new ComboBox<>();
        birthRateBox = new ComboBox<>();
        modeBox = new ComboBox<>();
        instanceBox = new ComboBox<>();

        sizeItems = new ArrayList<>();
        birthRateItems = new ArrayList<>();
        modeItems = new ArrayList<>();
        instanceItems = new ArrayList<>();

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

    public VBox getvBox() {
        return vBox;
    }

    public ComboBox<String> getSizeBox() {
        return sizeBox;
    }

    public ComboBox<Double> getBirthRateBox() {
        return birthRateBox;
    }

    public ComboBox<String> getModeBox() { return modeBox; }

    public ComboBox<String> getInstanceBox() {
        return instanceBox;
    }

    public Button getButtons(int i) {
        return buttons[i];
    }

    private void setModule(){
        labels[0].setText("Size:");
        labels[0].setFont(Font.font(16));
        labels[1].setText("Birth Rate:");
        labels[1].setFont(Font.font(16));
        labels[2].setText("Game mode:");
        labels[2].setFont(Font.font(15));
        labels[3].setText("Instance:");
        labels[3].setFont(Font.font(16));

        sizeBox.setPrefSize(100, 20);
        birthRateBox.setPrefSize(70, 20);
        modeBox.setPrefSize(100, 20);
        instanceBox.setPrefSize(100, 20);

        sizeItems.add("20 × 20");
        sizeItems.add("30 × 30");
        sizeItems.add("40 × 40");
        sizeItems.add("50 × 50");

        birthRateItems.add(0.1);
        birthRateItems.add(0.2);
        birthRateItems.add(0.5);

        modeItems.add("mode 1");
        modeItems.add("mode 2");
        modeItems.add("mode 3");
        modeItems.add("mode 4");

        instanceItems.add("Glider");
        instanceItems.add("Acorn");
        instanceItems.add("Gun");

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
        modeBox.getItems().addAll(modeItems);
        modeBox.setValue(modeItems.get(0));
        instanceBox.getItems().addAll(instanceItems);
        instanceBox.setValue(instanceItems.get(0));
        instanceBox.setDisable(true);

        gridPane.setVgap(20);
        GridPane.setMargin(birthRateBox, new Insets(0, 0, 0, 62));
        GridPane.setMargin(sizeBox, new Insets(0, 0, 0, 32));

        for(i=0; i<3; ++i){
            GridPane.setMargin(buttons[i], new Insets(10, 0, 0, 30));
        }

        hBox[0].getChildren().addAll(labels[2], modeBox);
        hBox[1].getChildren().addAll(labels[3], instanceBox);
        vBox.getChildren().addAll(hBox[0], hBox[1], gridPane);
        vBox.setAlignment(Pos.CENTER_LEFT);
    }
}
