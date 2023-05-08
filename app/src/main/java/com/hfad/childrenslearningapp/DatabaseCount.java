package com.hfad.childrenslearningapp;

import java.util.ArrayList;

public class DatabaseCount {
    public int score;
    private static DatabaseCount myOneAndOnlyDBObject;
    private ArrayList<QuestionCount> questions;
    int threeApples = R.drawable.three_apples;
    int sixApples = R.drawable.apples;
    int fiveApples = R.drawable.five;


    public static DatabaseCount getDatabase()
    {
        if (myOneAndOnlyDBObject == null)
        {
            myOneAndOnlyDBObject = new DatabaseCount();
        }
        return myOneAndOnlyDBObject;
    }

    public int updateScore()
    {
        score++;
        return score;
    }
    private DatabaseCount()
    {
        questions = new ArrayList<QuestionCount>();
        if (score < 3)
        {
            loadLevelOneQuestions();
        }
        else if (score == 3)
        {
            //loadLevelTwoQuestions();
        }
    }

    public ArrayList<QuestionCount> getQuestions()
    {
        if(questions == null)
        {
            questions = new ArrayList<QuestionCount>();
            loadLevelOneQuestions();
        }return questions;
    }
    public void addQuestion(QuestionCount q)
    {
        questions.add(q);
    }
    public ArrayList<QuestionCount> retrieveQuestions()
    {
        ArrayList<QuestionCount> ques = new ArrayList<QuestionCount>();

        for (int i = 0; i < questions.size(); i++)
        {

            ques.add(questions.get(i));

        }
        return ques;

    }
    private void loadLevelOneQuestions()
    {
        ArrayList<String> questionChoices7 = new ArrayList<String>();
        questionChoices7.add("4");
        questionChoices7.add("5");
        questionChoices7.add("6");
        questions.add(new QuestionCount("How Many Apples Are There?",sixApples, questionChoices7, "6"));

        ArrayList<String> questionChoices8 = new ArrayList<String>();
        questionChoices8.add("5");
        questionChoices8.add("3");
        questionChoices8.add("4");
        questions.add(new QuestionCount("How Many Apples Are There?", threeApples, questionChoices8, "3"));

        ArrayList<String> questionChoices9 = new ArrayList<String>();
        questionChoices9.add("6");
        questionChoices9.add("3");
        questionChoices9.add("5");
        questions.add(new QuestionCount("How Many Apples Are There?",fiveApples, questionChoices9, "5"));
    }
    /*
    private void loadLevelTwoQuestions()
    {
        ArrayList<String> questionChoices10 = new ArrayList<String>();
        questionChoices10.add("Blue and Red");
        questionChoices10.add("Blue and Yellow");
        questionChoices10.add("Red and Yellow");
        questions.add(new QuestionCount("What two Colors Make This Color?", orangeImage, questionChoices4, "Red and Yellow"));

        ArrayList<String> questionChoices11 = new ArrayList<String>();
        questionChoices11.add("Blue and Red");
        questionChoices11.add("Blue and Yellow");
        questionChoices11.add("Red and Yellow");
        questions.add(new QuestionCount("What two Colors Make This Color?", purpleImage, questionChoices5, "Blue and Red"));

        ArrayList<String> questionChoices12 = new ArrayList<String>();
        questionChoices12.add("Blue and Red");
        questionChoices12.add("Blue and Yellow");
        questionChoices12.add("Red and Yellow");
        questions.add(new QuestionCount("What two Colors Make This Color?", greenImage, questionChoices6, "Blue and Yellow"));
    }
    */
}
