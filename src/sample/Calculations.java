package sample;

public class Calculations {
    //---------------------------------loans--------------------------------------------------------------------------------.
    //Calculate Principal amount.
    public static double calculateLoanPrincipalValue(double monthlyPayment, double interestRate, double numberOfYears) {
        double principalValue = monthlyPayment*(numberOfYears*12)/(1+(interestRate / 100));
        return principalValue;
    }

    // Calculate Monthly Payment.
    public static double calculateLoanMonthlyPaymentValue(double principalValue, double interestRate, double numberOfYears) {
        double monthlyPayment=((principalValue * (interestRate / 100)) / (1 - (1 / (Math.pow((1 + (interestRate / 100)), (numberOfYears))))))/(numberOfYears*12);
        return monthlyPayment;
    }

    //Calculate Number Of Months,
    public static double calculateLoanNoOfMonths(double monthlyPayment, double interestRate, double principalValue) {
        double numberOfYears  = (principalValue+(principalValue*(interestRate / 100)))/(12*monthlyPayment);
        return  numberOfYears;
    }
    //Calculate interest Rate
    public static double calculateLoanInterestRate(double monthlyPayment, double numberOfYears, double principalValue) {
        double interestRate  = (((monthlyPayment *(numberOfYears*12))-principalValue)/principalValue)*100;
        return  interestRate;}


    // -------------------------------------------- Fixed Deposit --------------------------------------------------------

    //Calculate Principal Amount.
    public static double calculateFixedDepositPrincipalValues(double interestRate, double  futureValue , double NoOfYears){
        Double principalValue = futureValue / Math.pow(1 + (interestRate / 100), 1 * NoOfYears);
        return principalValue;
    }

    //Calculate No Of Years.
    public static double calculateFixedDepositNoOfYears(double interestRate, double futureValue , double principalValue){
        double NoOfYears = ((futureValue*100)/(interestRate*principalValue))/12;;
        return NoOfYears;
    }

    //Calculate future value
    public static double calculateFixedDepositFutureValue(double interestRate, double principalValue, double NoOfYears) {
        Double futureValue =  principalValue * Math.pow(1 + (interestRate/100), 1 * NoOfYears);
        return futureValue;
    }
    //Calculate payment value
    public static double calculateFixedDepositPaymentValue(double interestRate, double futureValue, double NoOfYears) {
        Double PaymentValue=(futureValue* (interestRate/100))/ ((Math.pow((1 + interestRate),NoOfYears)- 1));
        return PaymentValue;
    }
    //Calculate interest Rate value
    public static double calculateFixedDepositInterestRate(double principalValue, double futureValue, double NoOfYears) {
        Double interestRateValue= (Math.pow((futureValue / principalValue), 1 / (NoOfYears) ) - 1)*100;
        return interestRateValue;
    }

    //---------------Savings-----------------------------------------------------------------------------------------------------------------------


    //Calculate Savings Future value.
    public static double calculateSavingsFutureValue (double numberOfCompounds, double interestRate, double presentValue){
        double futureValue = presentValue + presentValue*((interestRate/100)*(numberOfCompounds/12));
        return futureValue;
    }

    //Calculate Savings Start Present value.
    public static double calculateSavingsPrincipalValue(double numberOfCompounds, double interestRate, double futureValue){
        double presentValue =futureValue / (1 + (interestRate/100)*(numberOfCompounds/12));
        return presentValue;
    }


    //Calculate Savings Interest.
    public static double calculateSavingsInterestRate(double numberOfCompounds, double presentValue, double futureValue){
        double interestRate = ((1/(numberOfCompounds/12))*(futureValue/presentValue - 1))*100;
        return interestRate;
    }


    //Calculate Savings Number Of Periods.
    public static double calculateSavingsNumberOfPeriods(double interestRate, double presentValue, double futureValue){
        double numberOfCompounds =((futureValue/presentValue)*(1/(interestRate/100)))/12;
        return numberOfCompounds;
    }

//----------------------------------------mortgage ----------------------------------------------------------------------------------
    //Start Of Mortgage Calculations.
    // Calculate principal Payment.
    public static double calculateMortgagePrincipalValue(double monthlyPayment, double interestRate, double numberOfYears) {
        double principalValue = monthlyPayment*(numberOfYears*12)/(1+(interestRate / 100));
        return principalValue;
    }

    // Calculate Monthly Payment.
    public static double calculateMortgageMonthlyPaymentValue(double principalValue, double interestRate, double numberOfYears) {
        double monthlyPayment=((principalValue * (interestRate / 100)) / (1 - (1 / (Math.pow((1 + (interestRate / 100)), (numberOfYears))))))/(numberOfYears*12);
        return monthlyPayment;
    }

    //Calculate Number Of Months,
    public static double calculateMortgageNoOfMonths(double monthlyPayment, double interestRate, double principalValue) {
        double numberOfYears  = (principalValue+(principalValue*(interestRate / 100)))/(12*monthlyPayment);
        return  numberOfYears;
    }
    //Calculate Number Of interest,
    public static double calculateMortgageInterestRate(double monthlyPayment, double numberOfYears, double principalValue) {
        double interestRate  = ((monthlyPayment * numberOfYears*12)-principalValue)/(principalValue*100);
        return  interestRate;}

}
