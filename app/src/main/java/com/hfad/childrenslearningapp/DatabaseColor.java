package com.hfad.childrenslearningapp;

import java.util.ArrayList;

public class DatabaseColor {

    public int score;
    private static DatabaseColor myOneAndOnlyDBObject;
    private ArrayList<QuestionColor> questions;
    int blueImage = R.drawable.blue;
    int redImage = R.drawable.red;
    int yellowImage = R.drawable.yellow;
    int orangeImage = R.drawable.orange;
    int purpleImage = R.drawable.purple;
    int greenImage = R.drawable.green;

    public static DatabaseColor getDatabase()
    {
        if (myOneAndOnlyDBObject == null)
        {
            myOneAndOnlyDBObject = new DatabaseColor();
        }
        return myOneAndOnlyDBObject;
    }

    public int updateScore()
    {
        score++;
        return score;
    }
    private DatabaseColor()
    {
        questions = new ArrayList<QuestionColor>();
        if (score < 3)
        {
            loadLevelOneQuestions();
        }
        else if (score == 3)
        {
            loadLevelTwoQuestions();
        }
    }

    public ArrayList<QuestionColor> getQuestions()
    {
        if(questions == null)
        {
            questions = new ArrayList<QuestionColor>();
            loadLevelOneQuestions();
        }return questions;
    }
    public void addQuestion(QuestionColor q)
    {
        questions.add(q);
    }
    public ArrayList<QuestionColor> retrieveQuestions()
    {
        ArrayList<QuestionColor> ques = new ArrayList<QuestionColor>();

        for (int i = 0; i < questions.size(); i++)
        {

                ques.add(questions.get(i));

        }
        return ques;

    }
    private void loadLevelOneQuestions()
    {
        ArrayList<String> questionChoices1 = new ArrayList<String>();
        questionChoices1.add("Blue");
        questionChoices1.add("Red");
        questionChoices1.add("Yellow");
        questions.add(new QuestionColor("Which Color is This?", blueImage, questionChoices1, "Blue"));

        ArrayList<String> questionChoices2 = new ArrayList<String>();
        questionChoices2.add("Red");
        questionChoices2.add("Yellow");
        questionChoices2.add("Blue");
        questions.add(new QuestionColor("Which Color is This?",redImage, questionChoices2, "Red"));

        ArrayList<String> questionChoices3 = new ArrayList<String>();
        questionChoices3.add("Blue");
        questionChoices3.add("Yellow");
        questionChoices3.add("Red");
        questions.add(new QuestionColor("Which Color is This?",yellowImage, questionChoices3, "Yellow"));
    }

    private void loadLevelTwoQuestions()
    {
        ArrayList<String> questionChoices4 = new ArrayList<String>();
        questionChoices4.add("Blue and Red");
        questionChoices4.add("Blue and Yellow");
        questionChoices4.add("Red and Yellow");
        questions.add(new QuestionColor("What two Colors Make This Color?", orangeImage, questionChoices4, "Red and Yellow"));

        ArrayList<String> questionChoices5 = new ArrayList<String>();
        questionChoices5.add("Blue and Red");
        questionChoices5.add("Blue and Yellow");
        questionChoices5.add("Red and Yellow");
        questions.add(new QuestionColor("What two Colors Make This Color?", purpleImage, questionChoices5, "Blue and Red"));

        ArrayList<String> questionChoices6 = new ArrayList<String>();
        questionChoices6.add("Blue and Red");
        questionChoices6.add("Blue and Yellow");
        questionChoices6.add("Red and Yellow");
        questions.add(new QuestionColor("What two Colors Make This Color?", greenImage, questionChoices6, "Blue and Yellow"));
    }
}




