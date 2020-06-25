package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

        TextView textViewTotalSemester;
        TextView textViewTotalSgpa;
        TextView textViewTotalCredit;
        TextView textViewTotalCgpa;
        Button buttonOk;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_custom_dialog_cgpa, container, false);
            textViewTotalCgpa = view.findViewById(R.id.textViewTotalCgpa);
            textViewTotalSemester = view.findViewById(R.id.textViewTotalSemester);
            textViewTotalCredit = view.findViewById(R.id.textViewTotalCredit);
            textViewTotalSgpa = view.findViewById(R.id.textViewTotalSgpa);

            textViewTotalCgpa.setText(String.format("%.2f", getArguments().getDouble("totalCgpa")));
            textViewTotalSemester.setText(Integer.toString(getArguments().getInt("totalSemester")));
            textViewTotalSgpa.setText(Double.toString(getArguments().getDouble("totalSgpa")));
            textViewTotalCredit.setText(Double.toString(getArguments().getDouble("totalCredit")));

            buttonOk = view.findViewById(R.id.buttonOk);
            buttonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });

            return view;
        }

        @Override
        public void onStart() {
            super.onStart();
        }
    }
