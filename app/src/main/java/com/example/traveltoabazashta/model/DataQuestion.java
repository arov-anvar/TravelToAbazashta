package com.example.traveltoabazashta.model;

public class DataQuestion {

    private String question, answer1, answer2, answer3, answer4, info;
    private int rightAnswer;

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public String getInfo() {
        return info;
    }

    public DataQuestion(String q, String a1, String a2, String a3, String a4, int right, String i) {
        question = q;
        answer1 = a1;
        answer2 = a2;
        answer3 = a3;
        answer4 = a4;
        rightAnswer = right;
        info = i;
    }
}
