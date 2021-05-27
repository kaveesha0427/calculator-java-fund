package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class KeyBoard {
    public static Pane keyboard(TextField selected_text) {
        Pane keyboard = new Pane();
        keyboard.setPrefHeight(150);
        keyboard.setPrefWidth(250);
        keyboard.setLayoutX(450);
        keyboard.setLayoutY(50);

        //(keypad)
        Button keyboardButton1 = new Button("1");
        keyboardButton1.setLayoutX(30);
        keyboardButton1.setLayoutY(130);
        keyboardButton1.setPrefSize(55, 35);
        keyboardButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("1");


            }
        });


        Button keyboardButton2 = new Button("2");
        keyboardButton2.setLayoutX(95);
        keyboardButton2.setLayoutY(130);
        keyboardButton2.setPrefSize(55, 35);
        keyboardButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("2");

            }
        });

        Button keyboardButton3 = new Button("3");
        keyboardButton3.setLayoutX(160);
        keyboardButton3.setLayoutY(130);
        keyboardButton3.setPrefSize(55, 35);
        keyboardButton3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("3");

            }
        });

        Button keyboardButton4 = new Button("4");
        keyboardButton4.setLayoutX(30);
        keyboardButton4.setLayoutY(170);
        keyboardButton4.setPrefSize(55, 35);
        keyboardButton4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("4");

            }
        });

        Button keyboardButton5 = new Button("5");
        keyboardButton5.setLayoutX(95);
        keyboardButton5.setLayoutY(170);
        keyboardButton5.setPrefSize(55, 35);
        keyboardButton5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("5");
            }
        });

        Button keyboardButton6 = new Button("6");
        keyboardButton6.setLayoutX(160);
        keyboardButton6.setLayoutY(170);
        keyboardButton6.setPrefSize(55, 35);
        keyboardButton6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("6");

            }
        });

        Button keyboardButton7 = new Button("7");
        keyboardButton7.setLayoutX(30);
        keyboardButton7.setLayoutY(210);
        keyboardButton7.setPrefSize(55, 35);
        keyboardButton7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("7");

            }
        });

        Button keyboardButton8 = new Button("8");
        keyboardButton8.setLayoutX(95);
        keyboardButton8.setLayoutY(210);
        keyboardButton8.setPrefSize(55, 35);
        keyboardButton8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("8");
            }
        });

        Button keyboardButton9 = new Button("9");
        keyboardButton9.setLayoutX(160);
        keyboardButton9.setLayoutY(210);
        keyboardButton9.setPrefSize(55, 35);
        keyboardButton9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("9");

            }
        });

        Button keyboardButton10 = new Button(".");
        keyboardButton10.setLayoutX(30);
        keyboardButton10.setLayoutY(250);
        keyboardButton10.setPrefSize(55, 35);
        keyboardButton10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText(".");

            }
        });

        Button keyboardButton0 = new Button("0");
        keyboardButton0.setLayoutX(95);
        keyboardButton0.setLayoutY(250);
        keyboardButton0.setPrefSize(55, 35);
        keyboardButton0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.appendText("0");
            }
        });

        Button keyboardButtonc = new Button("C");
        keyboardButtonc.setLayoutX(160);
        keyboardButtonc.setLayoutY(250);
        keyboardButtonc.setPrefSize(55, 35);
        keyboardButtonc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selected_text.setText(selected_text.getText().substring(0, selected_text.getText().length() - 1));
            }
        });

        keyboard.getChildren().addAll(keyboardButton1, keyboardButton2, keyboardButton3, keyboardButton4,keyboardButton5, keyboardButton6, keyboardButton7,keyboardButton8,keyboardButton9, keyboardButton10, keyboardButton0, keyboardButtonc);
        return keyboard;
        }
    }

