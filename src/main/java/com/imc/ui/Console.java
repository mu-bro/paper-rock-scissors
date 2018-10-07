package com.imc.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements UserInterface {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readInputData() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error occurs during reading input data");
        }
    }
}
