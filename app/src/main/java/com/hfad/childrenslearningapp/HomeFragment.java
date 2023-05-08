package com.hfad.childrenslearningapp;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnColor = view.findViewById(R.id.btn_start_color);
        Button btnCounting = view.findViewById(R.id.btn_countings);
        Button btnProgress = view.findViewById(R.id.btn_check_prog);

        TextView tvWelcome = view.findViewById(R.id.tv_welcome);
        TextView tvColor = view.findViewById(R.id.tv_colors);
        TextView tvCounting = view.findViewById(R.id.tv_counting);
        TextView tvCheckProg = view.findViewById(R.id.tv_check_prog);

        final MediaPlayer mpWelcome = MediaPlayer.create(this.getContext(), R.raw.welcome);
        final MediaPlayer mpColors = MediaPlayer.create(this.getContext(), R.raw.colors);
        final MediaPlayer mpCounting = MediaPlayer.create(this.getContext(), R.raw.counting);
        final MediaPlayer mpStart = MediaPlayer.create(this.getContext(), R.raw.start);
        final MediaPlayer mpCheckProg = MediaPlayer.create(this.getContext(), R.raw.checkprogress);

        tvWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpWelcome.start();
                System.out.println("AUDIO");
            }
        });

        tvColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpColors.start();
                System.out.println("AUDIO");
            }
        });

        tvCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpCounting.start();
                System.out.println("AUDIO");
            }
        });

        tvCheckProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpCheckProg.start();
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mpStart.start();
               Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_colorFragment);
            }
        });

        btnCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mpStart.start();
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_countingFragment);
            }
        });

        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpStart.start();
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_progressFragment);
            }
        });

        return view;
    }
}