package com.hfad.childrenslearningapp;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CountingFragment extends Fragment {

    Button btnViewResults;
    Button btnCheckAns;
    boolean isCorrect = true;
    int grade = 0;
    int totalQues = 0;
    int currQuesCTR = 0;
    String selectAns;
    String rightAnswer;
    TextView tvQuestion;
    ImageView ivCurrImage;
    ArrayList<RadioButton> radioButtons = new ArrayList<RadioButton>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_counting, container, false);

        btnCheckAns = view.findViewById(R.id.btn_check_ans_count);
        tvQuestion = view.findViewById(R.id.tv_question_count);
        ivCurrImage = view.findViewById(R.id.iv_count_ques);

        TextView tvCountingQues = view.findViewById(R.id.tv_question_count);
        TextView tvCheckAns = view.findViewById(R.id.tv_check_ans_count);
        TextView tvViewResults = view.findViewById(R.id.tv_show_results_count);

        RadioButton rbOne, rbTwo, rbThree;
        rbOne = view.findViewById(R.id.rb_one_count);
        rbTwo = view.findViewById(R.id.rb_two_count);
        rbThree = view.findViewById(R.id.rb_three_count);

        radioButtons.add(rbOne);
        radioButtons.add(rbTwo);
        radioButtons.add(rbThree);

        btnViewResults = view.findViewById(R.id.btn_counting_results);

        final MediaPlayer mpCountingQues = MediaPlayer.create(this.getContext(), R.raw.howmanyapple);
        final MediaPlayer mpCheckAns = MediaPlayer.create(this.getContext(), R.raw.checkanswer);
        final MediaPlayer mpViewResults = MediaPlayer.create(this.getContext(), R.raw.viewresults);
        final MediaPlayer mpCheck = MediaPlayer.create(this.getContext(), R.raw.check);
        final MediaPlayer mpResults = MediaPlayer.create(this.getContext(), R.raw.results);


        ArrayList<QuestionCount> quizQuestions = DatabaseCount.getDatabase().retrieveQuestions();
        totalQues = quizQuestions.size();
        loadQues(quizQuestions.get(currQuesCTR));

        tvCountingQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpCountingQues.start();
            }
        });

        tvCheckAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpCheckAns.start();
            }
        });

        tvViewResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpViewResults.start();
            }
        });

        btnCheckAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mpCheck.start();
                selectAns = getSelectedAns();

                rightAnswer = quizQuestions.get(currQuesCTR).getAnswer();

                if (selectAns.equals(rightAnswer))
                {
                    isCorrect = true;
                    grade++;
                }
                else
                {
                    isCorrect = false;
                }
                if (isCorrect)
                {
                    Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    btnCheckAns.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    Toast.makeText(getContext(), "So Close! Try Again Next Time.", Toast.LENGTH_SHORT).show();
                    btnCheckAns.setBackgroundColor(getResources().getColor(R.color.red));
                }
                currQuesCTR++;
                if (currQuesCTR == totalQues)
                {

                }
                else
                {
                    loadQues(quizQuestions.get(currQuesCTR));
                }
            }

        });


        btnViewResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mpResults.start();
                CountingFragmentDirections.ActionCountingFragmentToResultsFragment action =
                        CountingFragmentDirections.actionCountingFragmentToResultsFragment(String.valueOf(grade));

                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }

    private void loadQues(QuestionCount q)
    {
        tvQuestion.setText(q.getQuestion());
        ivCurrImage.setImageResource(q.getImageNum());

        for (int i = 0; i < q.getOptions().size(); i++)
        {
            radioButtons.get(i).setVisibility(View.VISIBLE);
            radioButtons.get(i).setText(q.getOptions().get(i));
        }

        for (int i = 0; i < radioButtons.size(); i++)
        {
            if ((radioButtons.get(i).getVisibility() != View.VISIBLE))
            {
                radioButtons.get(i).setVisibility(View.GONE);
            }
        }
    }

    private String getSelectedAns() {

        if (radioButtons.get(0).isChecked())
        {
            return radioButtons.get(0).getText().toString();
        }
        else if (radioButtons.get(1).isChecked())
        {
            return radioButtons.get(1).getText().toString();
        }
        else
        {
            return radioButtons.get(2).getText().toString();
        }
    }

}