package com.hfad.childrenslearningapp;
import java.util.ArrayList;


    public class QuestionColor {
        public int score;

        public String getQuestion() {
            return question;
        }
        public void setQuestion(String question) {
            this.question = question;
        }

        public int getScore()
        {
            return score;
        }
        private String question;
        private int imageNum;
        private ArrayList<String> options = new ArrayList<String>();
        private String answer;

        public int getImageNum() {
            return imageNum;
        }
        public void setImageNum(int imageNum) {
            this.imageNum = imageNum;
        }
        public ArrayList<String> getOptions() {
            return options;
        }
        public void setOptions(ArrayList<String> options) {
            this.options = options;
        }
        public String getAnswer() {
            return answer;
        }
        public void setAnswer(String answer) {
            this.answer = answer;
        }
        public QuestionColor(String question, int imageNum, ArrayList<String> options, String answer) {
            this.question = question;
            this.imageNum = imageNum;
            this.options = options;
            this.answer = answer;
        }
    }
