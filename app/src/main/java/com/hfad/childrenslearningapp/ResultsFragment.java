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
import android.widget.TextView;


public class ResultsFragment extends Fragment {

    public int currScore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        String grade  = ResultsFragmentArgs.fromBundle(requireArguments()).getGradeCount();
        Button btnHomePage = view.findViewById(R.id.btn_return_home_results);
        TextView tvScore = view.findViewById(R.id.tv_amt_correct);
        ImageView ivSkillBar = view.findViewById(R.id.iv_skill_bar);

        TextView tvResults = view.findViewById(R.id.tv_results_title);
        TextView tvSkill = view.findViewById(R.id.tv_skill_level);
        TextView tvAmtCorrect = view.findViewById(R.id.tv_amount_correct_title);

        final MediaPlayer mpReturnHome = MediaPlayer.create(this.getContext(), R.raw.returnhome);
        final MediaPlayer mpSkill = MediaPlayer.create(this.getContext(), R.raw.skilllevel);
        final MediaPlayer mpResults = MediaPlayer.create(this.getContext(), R.raw.results);
        final MediaPlayer mpAmtCorrect = MediaPlayer.create(this.getContext(), R.raw.amountcorrect);

        tvScore.setText(grade);

        tvResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResults.start();
            }
        });

        tvSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpSkill.start();
            }
        });

        tvAmtCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpAmtCorrect.start();
            }
        });


        if (grade == String.valueOf(3))
        {
            currScore++;
            if (currScore == 1)
            {
                ivSkillBar.setImageResource(R.drawable.started_);
            }
            else if (currScore == 2)
            {
                ivSkillBar.setImageResource(R.drawable.half_progress);
            }
            else if (currScore == 3)
            {
                ivSkillBar.setImageResource(R.drawable.empty);
            }

        }
        else
            ivSkillBar.setImageResource(R.drawable.full_progress);

        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpReturnHome.start();
                Navigation.findNavController(view).navigate(R.id.action_resultsFragment_to_homeFragment);
            }
        });

                return view;
    }
}