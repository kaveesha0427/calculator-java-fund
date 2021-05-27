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

public class Mortgage {

    public static void mortgage() {
        Stage root2 = new Stage();
        root2.setTitle("Mortgage");
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

        Label mortgageHeadingLabel = new Label("Mortgage");
        mortgageHeadingLabel.setLayoutX(250);
        mortgageHeadingLabel.setLayoutY(30);
//labels
        Label mortgageLabel4 = new Label("Principle amount");
        mortgageLabel4.setLayoutX(85);
        mortgageLabel4.setLayoutY(100);

        Label mortgageLabel1 = new Label("Interest");
        mortgageLabel1.setLayoutX(85);
        mortgageLabel1.setLayoutY(160);

        Label mortgageLabel2 = new Label("Monthly Payment");
        mortgageLabel2.setLayoutX(85);
        mortgageLabel2.setLayoutY(220);

        Label mortgageLabel3 = new Label("Number of Years");
        mortgageLabel3.setLayoutX(85);
        mortgageLabel3.setLayoutY(280);
//TextFields for user inputs
        TextField mortgageTextField1 = new TextField(); //text field for principal value input
        mortgageTextField1.setLayoutX(270);
        mortgageTextField1.setLayoutY(100);
        mortgageTextField1.setPrefWidth(180);

        TextField mortgageTextField2 = new TextField(); //text field for interest input
        mortgageTextField2.setLayoutX(270);
        mortgageTextField2.setLayoutY(160);
        mortgageTextField2.setPrefWidth(180);

        TextField mortgageTextField3 = new TextField();//text field for monthly payment input
        mortgageTextField3.setLayoutX(270);
        mortgageTextField3.setLayoutY(220);
        mortgageTextField3.setPrefWidth(180);

        TextField mortgageTextField4 = new TextField(); //text field for Number of months input
        mortgageTextField4.setLayoutX(270);
        mortgageTextField4.setLayoutY(280);
        mortgageTextField4.setPrefWidth(180);
//buttons
        Button mortgageButton1 = new Button("Calculate");//button for calculations
        mortgageButton1.setLayoutX(250);
        mortgageButton1.setLayoutY(400);
        mortgageButton1.setPrefWidth(180);

        Button mortgageButton2 = new Button("Back"); //button for back to main page
        mortgageButton2.setLayoutX(30);
        mortgageButton2.setLayoutY(30);
        mortgageButton2.setOnAction(e -> {
            root2.close();
            MainPage.home();});

        Button mortgageButton3 = new Button("Clear All"); //button for clear all
        mortgageButton3.setLayoutX(500);
        mortgageButton3.setLayoutY(400);
        mortgageButton3.setOnAction(e -> {
            mortgageTextField1.clear();
            mortgageTextField2.clear();
            mortgageTextField3.clear();
            mortgageTextField4.clear();

        });

//set fonts
        mortgageHeadingLabel.setFont(font);//font for Heading
        mortgageLabel1.setFont(font3);  //fonts for labels
        mortgageLabel2.setFont(font3);
        mortgageLabel3.setFont(font3);
        mortgageLabel4.setFont(font3);
        mortgageTextField1.setFont(font3);//fonts for TextFields
        mortgageTextField2.setFont(font3);
        mortgageTextField3.setFont(font3);
        mortgageTextField4.setFont(font3);
        mortgageButton1.setFont(font2);
        mortgageButton2.setFont(font2);

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
//calculations
        mortgageButton1.setOnAction(e -> {

            String printout = null;//create variable for the history
                    //checking for empty text fields (all empty or not)
            if (TextFieldCheck.check(mortgageTextField1,mortgageTextField2,mortgageTextField3,mortgageTextField4)==0){
                a.setContentText("                                      All TextFields are Filled  !");
                a.show();
            }
            //checking for empty text fields
            else if(TextFieldCheck.check(mortgageTextField1,mortgageTextField2,mortgageTextField3,mortgageTextField4)>1){
                a.setContentText("                                     Empty more than one TextField  !");
                a.show();
            }
            // principal value calculation
            else if (TextFieldCheck.check(mortgageTextField1,mortgageTextField2,mortgageTextField3,mortgageTextField4)==1 && mortgageTextField1.getText().trim().isEmpty()){//check for the is txt field 1 empty or not
                try{double numberOfYears = Double.parseDouble(mortgageTextField4.getText());//get inputs from text field 4
                double interestRate = Double.parseDouble(mortgageTextField2.getText());//get inputs from text field 2
                double  monthlyPayment = Double.parseDouble(mortgageTextField3.getText());//get inputs from text field 3
                mortgageTextField1.setText(String.valueOf(String.format("%.2f",(Calculations.calculateMortgagePrincipalValue(monthlyPayment,interestRate,numberOfYears)))));//calculate future value and set value for txt field 1
                    printout = "Mortgage Calculator" + "\nPresent Amount : " + (Calculations.calculateMortgagePrincipalValue(monthlyPayment, interestRate, numberOfYears)) + "\nInterest : " + interestRate + "\nMonthly Payment : " + monthlyPayment + "\nNo Of Years: " + numberOfYears;//assign string values for history variable
                }
                catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();
                }
            }
            //interest value calculation
            else if (TextFieldCheck.check(mortgageTextField1,mortgageTextField2,mortgageTextField3,mortgageTextField4)==1 && mortgageTextField2.getText().trim().isEmpty()){
                try {
                    double numberOfYears = Double.parseDouble(mortgageTextField4.getText());//get inputs from text field 4
                    double presentValue = Double.parseDouble(mortgageTextField1.getText());//get inputs from text field 1
                    double monthlyPayment = Double.parseDouble(mortgageTextField3.getText());//get inputs from text field 3
                    mortgageTextField2.setText(String.valueOf(String.format("%.2f",(Calculations.calculateLoanInterestRate(monthlyPayment,numberOfYears,presentValue))))) ;//calculate principal value and set value for txt field 2
                    printout = "Mortgage Calculator" + "\nPresent Amount : " + presentValue+ "\nInterest : " + (Calculations.calculateMortgageInterestRate(monthlyPayment, numberOfYears, presentValue)) + "\nMonthly Payment : " + monthlyPayment + "\nNo Of Years: " + numberOfYears;//assign string values for history variable


                }catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();
                }
            }
            //monthly pay value calculation
            else if (TextFieldCheck.check(mortgageTextField1,mortgageTextField2,mortgageTextField3,mortgageTextField4)==1 && mortgageTextField3.getText().trim().isEmpty()) {
                try {
                    double numberOfYears = Double.parseDouble(mortgageTextField4.getText());//get inputs from text field 4
                    double interestRate = Double.parseDouble(mortgageTextField2.getText());//get inputs from text field 2
                    double presentValue = Double.parseDouble(mortgageTextField1.getText());//get inputs from text field 1
                    printout = "Mortgage Calculator" + "\nPresent Amount : " + presentValue + "\nInterest : " + interestRate + "\nMonthly Payment : " + (Calculations.calculateMortgageMonthlyPaymentValue(presentValue,interestRate,numberOfYears )) + "\nNo Of Years: " + numberOfYears;//assign string values for history variable

                    mortgageTextField3.setText(String.valueOf(String.format("%.2f", (Calculations.calculateMortgageMonthlyPaymentValue(presentValue,interestRate,numberOfYears)))));//calculate principal value and set value for txt field 3
                } catch (Exception exception) {
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();
                }}
            //no of months calculation
            else if (TextFieldCheck.check(mortgageTextField1, mortgageTextField2, mortgageTextField3, mortgageTextField4) == 1 && mortgageTextField4.getText().trim().isEmpty()) {
                    try{
                        double interestRate = Double.parseDouble(mortgageTextField2.getText());//get inputs from text field 2
                        double presentValue = Double.parseDouble(mortgageTextField1.getText());//get inputs from text field 1
                        double monthlyPayment = Double.parseDouble(mortgageTextField3.getText());//get inputs from text field 3
                        mortgageTextField4.setText(String.valueOf(String.format("%.2f", Calculations.calculateMortgageNoOfMonths(monthlyPayment,interestRate,presentValue))));//calculate principal value and set value for txt field 4
                        printout = "Mortgage Calculator " + "\nPresent Amount : " +presentValue + "\nInterest : " + interestRate + "\nMonthly Payment : " + monthlyPayment + "\nNo Of Years: " + (Calculations.calculateMortgageNoOfMonths(monthlyPayment,interestRate,presentValue));//assign string values for history variable

                    }catch (Exception exception){
                        a.setContentText("                                Please Enter Numeric values only !");
                        a.show();
                    }

                }try{
                History.CalHistory(printout);//print at history text file
            }catch( IOException e1) {
                e1.printStackTrace();
            } });

        Pane Mortgage = new Pane();
//set variable for imported keyboard for class
        mortgageTextField1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Mortgage.getChildren().addAll(KeyBoard.keyboard(mortgageTextField1));

            }
        });
        mortgageTextField2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
             Mortgage.getChildren().addAll(KeyBoard.keyboard(mortgageTextField2));

            }
        });
        mortgageTextField3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Mortgage.getChildren().addAll(KeyBoard.keyboard(mortgageTextField3));
            }
        });
        mortgageTextField4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Mortgage.getChildren().addAll(KeyBoard.keyboard(mortgageTextField4));
            }
        });
//set elements for the pane
        Mortgage.getChildren().addAll(iv,mortgageHeadingLabel, mortgageLabel1, mortgageLabel2, mortgageLabel4,mortgageLabel3, mortgageTextField1,mortgageTextField2,mortgageTextField3,mortgageTextField4, mortgageButton1, mortgageButton2,mortgageButton3);
        Scene scene5 = new Scene(Mortgage, 685, 510);
        root2.setScene(scene5);
        root2.show();
    }
}
