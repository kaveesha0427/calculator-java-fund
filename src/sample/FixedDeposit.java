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

public class FixedDeposit{
    private static Pane keyboardPane;
    public static void fixeddeposit() {
        Stage root = new Stage();
        root.setTitle("Fixed Deposit");
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

        Label fixedDepositHeadingLable = new Label("Fixed Deposit");//Heading
        fixedDepositHeadingLable.setLayoutX(250);
        fixedDepositHeadingLable.setLayoutY(30);
//labels
        Label fixedDepositLabel1 = new Label("Present Value");
        fixedDepositLabel1 .setLayoutX(85);
        fixedDepositLabel1 .setLayoutY(100);

        Label fixedDepositLabel2  = new Label("Future Value");
        fixedDepositLabel2.setLayoutX(85);
        fixedDepositLabel2 .setLayoutY(160);

        Label fixedDepositLabel3  = new Label("Interest Rate");
        fixedDepositLabel3 .setLayoutX(85);
        fixedDepositLabel3 .setLayoutY(220);

        Label fixedDepositLabel4  = new Label("Number of Years");
        fixedDepositLabel4  .setLayoutX(85);
        fixedDepositLabel4 .setLayoutY(280);

        Label fixedDepositLabel5  = new Label("Payments");
        fixedDepositLabel5  .setLayoutX(85);
        fixedDepositLabel5 .setLayoutY(340);
//TextFields for user inputs
        TextField fixedDepositTextField1 = new TextField();//text field for present value input
        fixedDepositTextField1.setLayoutX(270);
        fixedDepositTextField1.setLayoutY(100);
        fixedDepositTextField1.setPrefWidth(180);

        TextField fixedDepositTextField2 = new TextField();//text field for future value input
        fixedDepositTextField2.setLayoutX(270);
        fixedDepositTextField2.setLayoutY(160);
        fixedDepositTextField2.setPrefWidth(180);

        TextField fixedDepositTextField3 = new TextField();//text field for interest rate value input
        fixedDepositTextField3.setLayoutX(270);
        fixedDepositTextField3.setLayoutY(220);
        fixedDepositTextField3.setPrefWidth(180);

        TextField fixedDepositTextField4 = new TextField();//text field for number of years value input
        fixedDepositTextField4.setLayoutX(270);
        fixedDepositTextField4.setLayoutY(280);
        fixedDepositTextField4.setPrefWidth(180);

        TextField fixedDepositTextField5 = new TextField();//text field for payment value input
        fixedDepositTextField5.setLayoutX(270);
        fixedDepositTextField5.setLayoutY(340);
        fixedDepositTextField5.setPrefWidth(180);
//buttons
        Button fixedDepositButton1 = new Button("Calculate");//button for calculations
        fixedDepositButton1.setLayoutX(250);
        fixedDepositButton1.setLayoutY(430);
        fixedDepositButton1.setPrefWidth(180);

        Button fixedDepositButton2 = new Button("Back");//button for back to main page
        fixedDepositButton2.setLayoutX(30);
        fixedDepositButton2.setLayoutY(30);
        fixedDepositButton2.setOnAction(e -> {
            root.close();
            MainPage.home();
        });

        Button fixedDepositButton3 = new Button("Clear All");//button for clear all
        fixedDepositButton3.setLayoutX(500);
        fixedDepositButton3.setLayoutY(430);
        fixedDepositButton3.setOnAction(e -> {
            fixedDepositTextField1.clear();
            fixedDepositTextField2.clear();
            fixedDepositTextField3.clear();
            fixedDepositTextField4.clear();
            fixedDepositTextField5.clear();
        });
//set font
        fixedDepositHeadingLable.setFont(font); //font for Heading
        fixedDepositLabel1.setFont(font3); //fonts for labels
        fixedDepositLabel2.setFont(font3);
        fixedDepositLabel3.setFont(font3);
        fixedDepositLabel4.setFont(font3);
        fixedDepositLabel5.setFont(font3);
        fixedDepositTextField1.setFont(font3);//fonts for TextFields
        fixedDepositTextField2.setFont(font3);
        fixedDepositTextField3.setFont(font3);
        fixedDepositTextField4.setFont(font3);
        fixedDepositTextField5.setFont(font3);
        fixedDepositButton1.setFont(font2);
        fixedDepositButton2.setFont(font2);

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
//calculations
        fixedDepositButton1.setOnAction(e -> {
            String printout = null;//create variable for the history
            //checking for empty text fields (all empty or not)
            if (TextFieldCheck.check(fixedDepositTextField1,fixedDepositTextField2,fixedDepositTextField3,fixedDepositTextField4,fixedDepositTextField5)==0){
                a.setContentText("                                      All TextFields are Filled  !");
                a.show();
            }
            //checking for empty text fields
            else if(TextFieldCheck.check(fixedDepositTextField1,fixedDepositTextField2,fixedDepositTextField3,fixedDepositTextField4,fixedDepositTextField5)>1){
                a.setContentText("                                     Empty more than one TextField  !");
                a.show();
            }
            // principal value calculation
            else if (TextFieldCheck.check(fixedDepositTextField1,fixedDepositTextField2,fixedDepositTextField3,fixedDepositTextField4,fixedDepositTextField5)==1 && fixedDepositTextField1.getText().trim().isEmpty()){//check for the is txt field 1 empty or not
                try{
                    double noOfYears = Double.parseDouble(fixedDepositTextField4.getText());//get inputs from text field 4
                    double interestRate = Double.parseDouble(fixedDepositTextField3.getText());//get inputs from text field 3
                    double futureValue = Double.parseDouble(fixedDepositTextField2.getText());//get inputs from text field 2
                    fixedDepositTextField1.setText(String.valueOf(String.format("%.2f",(Calculations.calculateFixedDepositPrincipalValues(interestRate,futureValue,noOfYears)))));//calculate principal value and set value for txt field 1
                    printout = "Fixed Deposit Calculator" + "\nPrincipal Amount : " + (Calculations.calculateFixedDepositPrincipalValues(interestRate,futureValue,noOfYears)) +"\nFuture Value : " + futureValue + "\nInterest : " + interestRate + "\n No Of Years: " + noOfYears;//assign string values for history variable
                }
                catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();
                }}
            //future value calculation
            else if (TextFieldCheck.check(fixedDepositTextField1,fixedDepositTextField2,fixedDepositTextField3,fixedDepositTextField4,fixedDepositTextField5)==1 && fixedDepositTextField2.getText().trim().isEmpty()){//check for the is txt field 2 empty or not
                try{
                    double noOfYears = Double.parseDouble(fixedDepositTextField4.getText());//get inputs from text field 4
                    double interestRate = Double.parseDouble(fixedDepositTextField3.getText());//get inputs from text field 3
                    double principalValue = Double.parseDouble(fixedDepositTextField1.getText());//get inputs from text field 1
                    fixedDepositTextField2.setText(String.valueOf(String.format("%.2f",(Calculations.calculateFixedDepositFutureValue(interestRate,principalValue,noOfYears))))) ;//calculate future value and set value for txt field 2
                    printout = "Fixed Deposit Calculator" + "\nPrincipal Amount : " +principalValue+"\nFuture Value : " + (Calculations.calculateFixedDepositFutureValue(interestRate,principalValue,noOfYears)) + "\nInterest : " + interestRate + "\n No Of Years: " + noOfYears;//assign string values for history variable

                }
                catch (Exception exception){
                    a.setContentText("                                Please Enter Numeric values only !");
                    a.show();
                }}
            // Interest rate value calculation
            else if (TextFieldCheck.check(fixedDepositTextField1,fixedDepositTextField2,fixedDepositTextField3,fixedDepositTextField4,fixedDepositTextField5)==1 && fixedDepositTextField3.getText().trim().isEmpty()){//check for the is txt field 3 empty or not
                 try{
                    double noOfYears = Double.parseDouble(fixedDepositTextField4.getText());//get inputs from text field 4
                    double futureValue = Double.parseDouble(fixedDepositTextField2.getText());//get inputs from text field 2
                    double principalValue = Double.parseDouble(fixedDepositTextField1.getText());//get inputs from text field 1
                    fixedDepositTextField3.setText(String.valueOf(String.format("%.2f",(Calculations.calculateFixedDepositInterestRate(principalValue,futureValue,noOfYears)))));//calculate interest rate value and set value for txt field 3
                     printout = "Fixed Deposit Calculator" + "\nPrincipal Amount : " +principalValue+"\nFuture Value : " + futureValue + "\nInterest : " +(Calculations.calculateFixedDepositInterestRate(principalValue,futureValue,noOfYears)) + "\n No Of Years: " + noOfYears;//assign string values for history variable


                 }
                 catch (Exception exception){
                     a.setContentText("                                Please Enter Numeric values only !");
                     a.show();
                 }}
            // no of years calculation
            else if (TextFieldCheck.check(fixedDepositTextField1,fixedDepositTextField2,fixedDepositTextField3,fixedDepositTextField4,fixedDepositTextField5)==1 && fixedDepositTextField4.getText().trim().isEmpty()){//check for the is txt field 4 empty or not
                 try{
                    double interestRate = Double.parseDouble(fixedDepositTextField3.getText());//get inputs from text field 3
                    double futureValue = Double.parseDouble(fixedDepositTextField1.getText());//get inputs from text field 1
                    double principalValue = Double.parseDouble(fixedDepositTextField2.getText());//get inputs from text field 2
                    fixedDepositTextField4.setText(String.valueOf(String.format("%.2f",(Calculations.calculateFixedDepositNoOfYears(interestRate,futureValue,principalValue)))));//calculate No of years and set value for txt field 4
                     printout = "Fixed Deposit Calculator" + "\nPrincipal Amount : " +principalValue+"\nFuture Value : " + futureValue + "\nInterest : " + interestRate + "\n No Of Years: " +(Calculations.calculateFixedDepositNoOfYears(interestRate,futureValue,principalValue));//assign string values for history variable

                 }
                 catch (Exception exception){
                     a.setContentText("                                Please Enter Numeric values only !");
                     a.show();
                 }}
            // payment value calculation
            else if (TextFieldCheck.check(fixedDepositTextField1,fixedDepositTextField2,fixedDepositTextField3,fixedDepositTextField4,fixedDepositTextField5)==1 && fixedDepositTextField5.getText().trim().isEmpty()){//check for the is txt field 5 empty or not
                 try{ double interestRate = Double.parseDouble(fixedDepositTextField3.getText());//get inputs from text field 3
                    double futureValue = Double.parseDouble(fixedDepositTextField2.getText());//get inputs from text field 2
                    double numberOfYears = Double.parseDouble(fixedDepositTextField4.getText());//get inputs from text field 4
                     fixedDepositTextField5.setText(String.valueOf(String.format("%.2f",(Calculations.calculateFixedDepositPaymentValue(interestRate,futureValue,numberOfYears )))));//calculate payment value and set value for txt field 5
                     printout = "Fixed Deposit Calculator" + "\nPayment Value : " +(Calculations.calculateFixedDepositPaymentValue(interestRate,futureValue,numberOfYears ))+"\nFuture Value : " + futureValue + "\nInterest : " + interestRate + "\n No Of Years: " +numberOfYears;//assign string values for history variable

                 }
                 catch (Exception exception){
                     a.setContentText("                                Please Enter Numeric values only !");
                     a.show();
                 }}
            try{
                History.CalHistory(printout);//print at history text file
            }catch( IOException e1) {
                e1.printStackTrace();
            } });
        Pane fix = new Pane();
//set keyboard for textfields
        fixedDepositTextField1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fix.getChildren().addAll(KeyBoard.keyboard(fixedDepositTextField1));
            }});

        fixedDepositTextField2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fix.getChildren().addAll(KeyBoard.keyboard(fixedDepositTextField2));
            }});

        fixedDepositTextField3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fix.getChildren().addAll(KeyBoard.keyboard(fixedDepositTextField3));
            }});

        fixedDepositTextField4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fix.getChildren().addAll(KeyBoard.keyboard(fixedDepositTextField4));
            }});
        fixedDepositTextField5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fix.getChildren().addAll(KeyBoard.keyboard(fixedDepositTextField5));
            }});
//set elements for the pane
        fix.getChildren().addAll(iv,fixedDepositHeadingLable,fixedDepositLabel1,fixedDepositLabel2,fixedDepositLabel3,fixedDepositLabel4,fixedDepositLabel5,fixedDepositTextField1,fixedDepositTextField2,fixedDepositTextField3,fixedDepositTextField4,fixedDepositTextField5,fixedDepositButton1,fixedDepositButton2,fixedDepositButton3);
        Scene scene2= new Scene(fix, 685, 510);
        root.setScene(scene2);
        root.show();
    }
}
