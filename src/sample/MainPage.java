package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainPage {

    public static void home(){
        Stage window = new Stage();
        window.setTitle("Financial Calculator");
//Add image
        Image image = new Image("home1.jpg");
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(500);
        iv.setFitWidth(550);

        Font font = new Font("serif", 35);//font for the heading
        Font font2 = new Font("serif", 15);//font for the buttons
        Font font3 = new Font("serif", 17);//font for the text

        Label lb1 = new Label("HOME PAGE");//main heading
        lb1.setLayoutX(185);
        lb1.setLayoutY(45);

        Button mbt1 = new Button("Fixed Deposits");//fixed deposit button
        mbt1.setLayoutX(210);
        mbt1.setLayoutY(150);
        mbt1.setPrefWidth(150);
        mbt1.setOnAction(e -> {
            window.close();
                FixedDeposit.fixeddeposit();
            });

        Button mbt2 = new Button("Savings");//savings button
        mbt2.setLayoutX(210);
        mbt2.setLayoutY(210);
        mbt2.setPrefWidth(150);
        mbt2.setOnAction(e -> {
            window.close();
            Savings.savings();
        });

        Button mbt3 = new Button("Loans");//loans button
        mbt3.setLayoutX(210);
        mbt3.setLayoutY(270);
        mbt3.setPrefWidth(150);
        mbt3.setOnAction(e -> {
            window.close();
            Loans.loan();
        });

        Button mbt4 = new Button("Mortgage");//mortgage button
        mbt4.setLayoutX(210);
        mbt4.setLayoutY(330);
        mbt4.setPrefWidth(150);
        mbt4.setOnAction(e -> {
            window.close();
            Mortgage.mortgage();});

        Button mbt6 = new Button("Exit");
        mbt6.setLayoutX(450);
        mbt6.setLayoutY(425);
        mbt6.setPrefWidth(45);
        mbt6.setOnAction(e -> {
            window.close();});

        Button mbt7 = new Button("Help");
        mbt7.setLayoutX(450);
        mbt7.setLayoutY(45);

        lb1.setFont(font);
        mbt1.setFont(font2);
        mbt2.setFont(font2);
        mbt3.setFont(font2);
        mbt4.setFont(font2);

        mbt6.setFont(font2);
        mbt7.setFont(font2);

        Pane root = new Pane();
        root.getChildren().addAll(iv,lb1,mbt1,mbt2,mbt3,mbt4 ,mbt6,mbt7);
        Scene scene= new Scene(root, 550, 500);
        window.setScene(scene);
        window.show();
    }

}

