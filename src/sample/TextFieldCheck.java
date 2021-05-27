package sample;

import javafx.scene.control.TextField;
//check for the empty txt field
public  class TextFieldCheck {
    public static int check(TextField... textFields) {
        int countValue = 0;
        for (TextField textField1 : textFields) {
            if (textField1.getText().trim().isEmpty()) {
                countValue++;
            }
        }
        return countValue;
    }
}
