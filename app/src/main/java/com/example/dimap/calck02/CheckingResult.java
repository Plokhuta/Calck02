package com.example.dimap.calck02;

import static java.lang.Integer.parseInt;

public class CheckingResult{

    private String result = "";


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result += result;
    }

    public void setResult() {
        this.result = "";
    }

    public int setCheckingResult(){
        return parseInt(this.result);
    }
}
