package com.e.gadsleaderboard.alerts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.e.gadsleaderboard.R;
import com.e.gadsleaderboard.activities.SubmitProject;

public class SubmitAlert extends DialogFragment {
    ImageButton cancelBtn;
    Button confirmBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alert_dialog,container,false);
        cancelBtn = view.findViewById(R.id.cancel_btn);
        confirmBtn = view.findViewById(R.id.confirm_yes);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((SubmitProject) getActivity()).checkInput()==true){
                    ((SubmitProject) getActivity()).submitProject();
                    getDialog().dismiss();
                }else {
                    getDialog().dismiss();
                }

            }
        });


        return view;

    }
}
