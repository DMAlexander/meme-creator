package com.example.devin.buckysmemetutorial;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment {

    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopSectionListener activityCommander;

    public interface TopSectionListener{ //need to implement this to get TopSectionFragment to talk to MainActivity
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Context context) { //gets called when we attatch fragment to activity
        super.onAttach(context);
        try{
            activityCommander = (TopSectionListener) context;
        } catch(ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v){
                        buttonClicked(v);
                    }
                }
        );

        return view;
    }

    public void buttonClicked(View view) {
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }

}






