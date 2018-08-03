package com.company.questions;

import java.util.HashMap;
import java.util.Scanner;

// TODO: implement this class
public class MultiChoice extends Question{

    public MultiChoice(
            String description,
            HashMap<Integer,String> choices,
            int[] answer,
            Scanner input
    ) {
        super(description, choices, answer, input);


    }

    public void ask() {

    }

    int[] getResponse() {
        return new int[0];
    }

    void evaluate(int[] response) {

    }
}
