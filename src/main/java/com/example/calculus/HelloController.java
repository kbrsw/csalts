package com.example.calculus;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


public class HelloController {



    @FXML
    private TextField Val1;
    @FXML
    private TextField Val2;
    @FXML
    private TextField Val3;


    public void calc(ActionEvent event) {
        String a = Val1.getText();
        String b = Val2.getText();
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        double c1 = a1+b1;
        Val3.setText(String.valueOf(c1));
    }

}