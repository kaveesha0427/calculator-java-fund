package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Savings {

    public static void savings() {
        Stage root3 = new Stage();
        root3.setTitle("Savings");
//Add image
        Image image = new Image("pic2.jpg");
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(510);
        iv.setFitWidth(685);


//fonts
        Font font = new Font("serif", 35);//font for the heading
        Font font2 = new Font("serif", 15);//font for the buttons
        Font font3 = new Font("serif", 19);//font for the text

        Label savingsHeadingLabel = new Label("Savings");//Heading
        savingsHeadingLabel.setLayoutX(250);
        savingsHeadingLabel.setLayoutY(30);
//labels
        Label savingsLabel4 = new Label("Future Value");
        savingsLabel4.setLayoutX(85);
        savingsLabel4.setLayoutY(100);

        Label savingsLabel1 = new Label("Principle amount");
        savingsLabel1.setLayoutX(85);
        savingsLabel1.setLayoutY(160);

        Label savingsLabel2 = new Label("Interest Rate");
        savingsLabel2.setLayoutX(85);
        savingsLabel2.setLayoutY(220);

        Label savingsLabel3 = new Label("Number of months");
        savingsLabel3.setLayoutX(85);
        savingsLabel3.setLayoutY(280);
//TextFields for user inputs
        TextField savingsTextField1 = new TextField();      //text field for future value input
        savingsTextField1.setLayoutX(270);
        savingsTextField1.setLayoutY(100);
        savingsTextField1.setPrefWidth(180);

        TextField savingsTextField2 = new TextField();      //text field for principal value input
        savingsTextField2.setLayoutX(270);
        savingsTextField2.setLayoutY(160);
        savingsTextField2.setPrefWidth(180);

        TextField savingsTextField3 = new TextField();       //text field for interest rate input
        savingsTextField3.setLayoutX(270);
        savingsTextField3.setLayoutY(220);
        savingsTextField3.setPrefWidth(180);

        TextField savingsTextField4 = new TextField();        //text field for No of months
        savingsTextField4.setLayoutX(270);
        savingsTextField4.setLayoutY(280);
        savingsTextField4.setPrefWidth(180);
        savingsTextField4.setOnMouseClicked(e -> {

        });
//buttons
        Button savingsButton1 = new Button("Calculate");//button for calculations
        savingsButton1.setLayoutX(250);
        savingsButton1.setLayoutY(400);
        savingsButton1.setPrefWidth(180);

        Button savingsButton2 = new Button("Back");     //button for back to main page
        savingsButton2.setLayoutX(30);
        savingsButton2.setLayoutY(30);
        savingsButton2.setOnAction(e -> {
            root3.close();
            MainPage.home();
        });
        Button  savingsButton3 = new Button("Clear All"); //button for clear all
        savingsButton3.setLayoutX(500);
        savingsButton3.setLayoutY(400);
        savingsButton3.setOnAction(e -> {
            savingsTextField1.clear();
            savingsTextField2.clear();
            savingsTextField3.clear();
            savingsTextField4.clear();
        });

//set fonts
        savingsHeadingLabel.setFont(font);  //font for Heading
        savingsLabel1.setFont(font3);       //fonts for labels
        savingsLabel2.setFont(font3);
        savingsLabel3.setFont(font3);
        savingsLabel4.setFont(font3);
        savingsTextField1.setFont(font3);   //fonts for TextFields
        savingsTextField2.setFont(font3);
        savingsTextField3.setFont(font3);
        savingsTextField4.setFont(font3);
        savingsButton1.setFont(font2);
        savingsButton2.setFont(font2);

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
//calculations
        savingsButton1.setOnAction(e -> {

            String printout = null; //create variable for the history
                    //checking for empty text fields (all empty or not)
            if (TextFieldCheck.check(savingsTextField1, savingsTextField2, savingsTextField3, savingsTextField4) == 0) {
                a.setContentText("                                      All TextFields are Filled  !");
                a.show();
            }
            //checking for empty text fields
            else if (TextFieldCheck.check(savingsTextField1, savingsTextField2, savingsTextField3, savingsTextField4) > 1) {
                a.setContentText("                                    Empty more than one TextField  !");
                a.show();
            }
            // future value calculation
         else if(TextFieldCheck.check(savingsTextField1, savingsTextField2, savingsTextField3, savingsTextField4) == 1 && savingsTextField1.getText().trim().isEmpty()) //check for the is txt field 1 empty or not
               try {
                    double numberOfCompounds = Double.parseDouble(savingsTextField4.getText()); //get inputs from text field 4
                    double interestRate = Double.parseDouble(savingsTextField3.getText()); //get inputs from text field 3
                    double presentValue = Double.parseDouble(savingsTextField2.getText()); //get inputs from text field 2

                    savingsTextField1.setText(String.valueOf(String.format("%.2f", (Calculations.calculateSavingsFutureValue(numberOfCompounds,interestRate,presentValue))))); //calculate future value and set value for txt field 1
                   printout = "Saving Calculator" + "\nFuture Value : " + (Calculations.calculateSavingsFutureValue(numberOfCompounds,interestRate,presentValue)) + "\nInterest : " + interestRate + "\nPresent Value : " + presentValue + "\nNo Of Compound: " + numberOfCompounds; //assign string values for history variable

               }catch (Exception exception){
                   a.setContentText("                                Please Enter Numeric values only !");
                   a.show();
               }
            //principal value calculation
            else if (TextFieldCheck.check(savingsTextField1, savingsTextField2, savingsTextField3, savingsTextField4) == 1 && savingsTextField2.getText().trim().isEmpty()) {//check for the is txt field 2 empty or not
                try{
                    double numberOfCompounds = Integer.parseInt(savingsTextField4.getText());//get inputs from text field 4
                    double futureValue = Double.parseDouble(savingsTextField1.getText());//get inputs from text field 1
                    double interestRate = Double.parseDouble(savingsTextField3.getText());//get inputs from text field 3
                savingsTextField2.setText(String.valueOf(String.format("%.2f",(Calculations.calculateSavingsPrincipalValue(numberOfCompounds,interestRate,futureValue)))));//calculate principal value and set value for txt field 2
                    printout = "Saving Calculator" + "\nFuture Value : " + futureValue + "\nInterest : " + interestRate + "\nPresent Value : " + (Calculations.calculateSavingsPrincipalValue(numberOfCompounds,interestRate,futureValue))
                            + "\nNo Of Compound: " + numberOfCompounds;//assign string values for history variable

                }catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();}
            }
            //interest rate calculation
            else if (TextFieldCheck.check(savingsTextField1, savingsTextField2, savingsTextField3, savingsTextField4) == 1 && savingsTextField3.getText().trim().isEmpty()) {//check for the is txt field 3 empty or not
                try{double numberOfCompounds = Double.parseDouble(savingsTextField4.getText());//get inputs from text field 4
                double futureValue = Double.parseDouble(savingsTextField1.getText());//get inputs from text field 1
                double presentValue = Double.parseDouble(savingsTextField2.getText());//get inputs from text field 2
                savingsTextField3.setText(String.valueOf(String.format("%.2f",(Calculations.calculateSavingsInterestRate(numberOfCompounds,presentValue,futureValue))))+" %");//calculate interest rate and set value for txt field 3
                    printout = "Saving Calculator" + "\nFuture Value : " + futureValue + "\nInterest : " + (Calculations.calculateSavingsInterestRate(numberOfCompounds,presentValue,futureValue)) + "\nPresent Value : " + presentValue + "\nNo Of Compound: " + numberOfCompounds;//assign string values for history variable
                }catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();}
                }

            //number of components calculation
            else if (TextFieldCheck.check(savingsTextField1, savingsTextField2, savingsTextField3, savingsTextField4) == 1 && savingsTextField4.getText().trim().isEmpty()) {//check for the is txt field 4 empty or not
                try{double interestRate = Double.parseDouble(savingsTextField3.getText());//get inputs from text field 3
                double futureValue = Double.parseDouble(savingsTextField1.getText());//get inputs from text field 1
                double presentValue = Double.parseDouble(savingsTextField2.getText());//get inputs from text field 2
                savingsTextField4.setText(String.valueOf(String.format("%.2f",(Calculations.calculateSavingsNumberOfPeriods(interestRate,presentValue,futureValue)))));//calculate No of period and set value for txt field 4
                    printout = "Saving Calculator" + "\nFuture Value : " + futureValue + "\nInterest : " + interestRate + "\nPresent Value : " + presentValue + "\nNo Of Compound: " + (Calculations.calculateSavingsNumberOfPeriods(interestRate,presentValue,futureValue));//assign string values for history variable

                }catch (Exception exception){ a.setContentText("                                Please Enter Numeric values only !");
                    a.show();}}
            try{
                History.CalHistory(printout);//print at history text file
            }catch( IOException e1) {
                e1.printStackTrace();
            }
        });
        Pane savings = new Pane();

//set keyboard for textfields
        savingsTextField1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                savings.getChildren().addAll(KeyBoard.keyboard(savingsTextField1));
            }});

        savingsTextField2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                savings.getChildren().addAll(KeyBoard.keyboard(savingsTextField2));
            }});
        savingsTextField3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                savings.getChildren().addAll(KeyBoard.keyboard(savingsTextField3));
            }});
        savingsTextField4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                savings.getChildren().addAll(KeyBoard.keyboard(savingsTextField4));
            }});
//set elements for the pane
                savings.getChildren().addAll(iv,savingsHeadingLabel, savingsLabel1, savingsLabel2, savingsLabel4, savingsLabel3, savingsTextField1, savingsTextField2, savingsTextField3, savingsTextField4, savingsButton1, savingsButton2,savingsButton3);
                Scene scene3 = new Scene(savings, 685, 510);
                root3.setScene(scene3);
                root3.show();
    }
}



