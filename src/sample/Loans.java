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

public class Loans {

    public static void loan() {
//Add image
        Image image = new Image("pic2.jpg");
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(510);
        iv.setFitWidth(685);


        Font font = new Font("serif", 35);//font for the heading
        Font font2 = new Font("serif", 15);//font for the buttons
        Font font3 = new Font("serif", 19);//font for the text

        Stage root1 = new Stage();
        root1.setTitle("Loan");

        Label loanHeadingLabel = new Label("Loans");//Heading
        loanHeadingLabel.setLayoutX(250);
        loanHeadingLabel.setLayoutY(30);
//labels
        Label loanLabel4 = new Label("Loan amount");
        loanLabel4.setLayoutX(85);
        loanLabel4.setLayoutY(100);

        Label loanLabel1 = new Label("Interest Rate");
        loanLabel1.setLayoutX(85);
        loanLabel1.setLayoutY(160);

        Label loanLabel2 = new Label("Monthly Payment");
        loanLabel2.setLayoutX(85);
        loanLabel2.setLayoutY(220);

        Label loanLabel3 = new Label("Number of Years");
        loanLabel3.setLayoutX(85);
        loanLabel3.setLayoutY(280);
//TextFields for user inputs
        TextField loanTextField1 = new TextField();//text field for Loan amount input
        loanTextField1.setLayoutX(270);
        loanTextField1.setLayoutY(100);
        loanTextField1.setPrefWidth(180);

        TextField loanTextField2 = new TextField();//text field for interest rate input
        loanTextField2.setLayoutX(270);
        loanTextField2.setLayoutY(160);
        loanTextField2.setPrefWidth(180);

        TextField loanTextField3 = new TextField();//text field for monthly payment input
        loanTextField3.setLayoutX(270);
        loanTextField3.setLayoutY(220);
        loanTextField3.setPrefWidth(180);

        TextField loanTextField4 = new TextField();//text field for number of months input
        loanTextField4.setLayoutX(270);
        loanTextField4.setLayoutY(280);
        loanTextField4.setPrefWidth(180);
//buttons
        Button loanButton1 = new Button("Calculate");//button for calculations
        loanButton1.setLayoutX(250);
        loanButton1.setLayoutY(400);
        loanButton1.setPrefWidth(180);

        Button loanButton2 = new Button("Back");//button for back to main page
        loanButton2.setLayoutX(30);
        loanButton2.setLayoutY(30);
        loanButton2.setOnAction(e -> {
            root1.close();
            MainPage.home();});

        Button loanButton3 = new Button("Clear All");//button for clear all
        loanButton3.setLayoutX(500);
        loanButton3.setLayoutY(400);
        loanButton3.setOnAction(e -> {
            loanTextField1.clear();
            loanTextField2.clear();
            loanTextField3.clear();
            loanTextField4.clear();
        });

//set fonts
        loanHeadingLabel.setFont(font);//font for Heading
        loanLabel1.setFont(font3);//fonts for labels
        loanLabel2.setFont(font3);
        loanLabel3.setFont(font3);
        loanLabel4.setFont(font3);
        loanTextField1.setFont(font3);//fonts for TextFields
        loanTextField2.setFont(font3);
        loanTextField3.setFont(font3);
        loanTextField4.setFont(font3);
        loanButton1.setFont(font2);
        loanTextField2.setFont(font2);



        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
//calculations
        loanButton1.setOnAction(e -> {

            String printout = null;//create variable for the history
            // checking for empty text fields (all empty or not)
            if (TextFieldCheck.check(loanTextField1,loanTextField2,loanTextField3,loanTextField4)==0){
                a.setContentText("                                      All TextFields are Filled  !");
                a.show();
            }
            //checking for empty text fields
            else if(TextFieldCheck.check(loanTextField1,loanTextField2,loanTextField3,loanTextField4)>1){
                a.setContentText("                                     Empty more than one TextField  !");
                a.show();
            }
            // principal value calculation
            else if (TextFieldCheck.check(loanTextField1,loanTextField2,loanTextField3,loanTextField4)==1 && loanTextField1.getText().trim().isEmpty()) {//check for the is txt field 1 empty or not
                try {
                    double numberOfYears = Double.parseDouble(loanTextField4.getText()); //get inputs from text field 4
                    double interestRate = Double.parseDouble(loanTextField2.getText()); //get inputs from text field 2
                    double monthlyPayment = Double.parseDouble(loanTextField3.getText()); //get inputs from text field 3
                    loanTextField1.setText(String.valueOf(String.format("%.2f", (Calculations.calculateLoanPrincipalValue(monthlyPayment, interestRate, numberOfYears)))));//calculate future value and set value for txt field 1

                printout = "Loan Calculator" + "\npresentValue : " + (Calculations.calculateLoanPrincipalValue(monthlyPayment, interestRate, numberOfYears)) + "\nInterest : " + interestRate + "\nMonthly Payment : " + monthlyPayment + "\nNo Of Years: " + numberOfYears;

            }catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();
            }}
            //interest rate calculation
            else if (TextFieldCheck.check(loanTextField1,loanTextField2,loanTextField3,loanTextField4)==1 && loanTextField2.getText().trim().isEmpty()){//check for the is txt field 2 empty or not
                try {
                    double numberOfYears = Double.parseDouble(loanTextField4.getText());//get inputs from text field 4
                    double presentValue = Double.parseDouble(loanTextField1.getText());//get inputs from text field 1
                    double monthlyPayment = Double.parseDouble(loanTextField3.getText());//get inputs from text field 3
                    loanTextField2.setText(String.valueOf(String.format("%.2f", (Calculations.calculateLoanInterestRate(monthlyPayment, numberOfYears, presentValue)))));//calculate future value and set value for txt field 2
                    printout = "Loan Calculator" + "\nPrincipal Amount : " + presentValue + "\nInterest : " + (Calculations.calculateLoanInterestRate(monthlyPayment, numberOfYears, presentValue)) + "\nMonthly Payment : " + monthlyPayment + "\nNo Of Years: " + numberOfYears;
                }catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();
                }
            }
            //monthly rate calculation
            else if (TextFieldCheck.check(loanTextField1,loanTextField2,loanTextField3,loanTextField4)==1 && loanTextField3.getText().trim().isEmpty()){//check for the is txt field 3 empty or not
                try{    double numberOfYears  = Double.parseDouble(loanTextField4.getText());//get inputs from text field 4
                        double presentValue = Double.parseDouble(loanTextField1.getText());//get inputs from text field 1
                        double interestRate = Double.parseDouble(loanTextField2.getText());//get inputs from text field 2
                loanTextField3.setText(String.valueOf(String.format("%.2f",(Calculations.calculateLoanMonthlyPaymentValue(presentValue,interestRate,numberOfYears )))));//calculate future value and set value for txt field 3
                    printout = "Loan Calculator" + "\npresentValue : " + presentValue + "\nInterest : " + interestRate + "\nMonthly Payment : " + (Calculations.calculateLoanMonthlyPaymentValue(presentValue,interestRate,numberOfYears ))+ "\nNo Of Years: " + numberOfYears;
                } catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();
                }}
            //no of months calculation
            else if (TextFieldCheck.check(loanTextField1,loanTextField2,loanTextField3,loanTextField4)==1 && loanTextField4.getText().trim().isEmpty()){//check for the is txt field 4 empty or not
                try{
                    double monthlyPayment = Double.parseDouble(loanTextField3.getText());//get inputs from text field 3
                    double presentValue = Double.parseDouble(loanTextField1.getText());//get inputs from text field 1
                    double interestRate = Double.parseDouble(loanTextField2.getText());//get inputs from text field 2
                    loanTextField4.setText(String.valueOf(String.format("%.2f",(Calculations.calculateLoanNoOfMonths(monthlyPayment,interestRate,presentValue)))));//calculate future value and set value for txt field 4
                    printout = "Loan Calculator" + "\npresentValue : " + presentValue + "\nInterest : " + interestRate + "\nMonthly Payment : " + monthlyPayment + "\nNo Of Years: " + (Calculations.calculateLoanNoOfMonths(monthlyPayment,interestRate,presentValue));
                }
                catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show(); }
                }

            try{
                History.CalHistory(printout);//print at history text file
            }catch( IOException e1) {
                e1.printStackTrace();
            }
        });

        Pane loan = new Pane();
//set keyboard for textfields
        loanTextField1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loan.getChildren().addAll(KeyBoard.keyboard(loanTextField1));
            }});

        loanTextField2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loan.getChildren().addAll(KeyBoard.keyboard(loanTextField2));
            }});

        loanTextField3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loan.getChildren().addAll(KeyBoard.keyboard(loanTextField3));
            }});

        loanTextField4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loan.getChildren().addAll(KeyBoard.keyboard(loanTextField4));
            }});
//set elements for the pane
        loan.getChildren().addAll(iv,loanHeadingLabel, loanLabel1, loanLabel2, loanLabel4, loanLabel3,loanTextField1,loanTextField2,loanTextField3,loanTextField4, loanButton1, loanButton2,loanButton3);
        Scene scene2= new Scene(loan, 685, 500);
        root1.setScene(scene2);
        root1.show();
    }
}