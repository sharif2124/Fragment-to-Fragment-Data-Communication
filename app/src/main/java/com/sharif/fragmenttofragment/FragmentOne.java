package com.sharif.fragmenttofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentOne extends Fragment {

EditText editText;
Button button;
String input;
CustomListner listner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        editText = v.findViewById(R.id.et);
        button = v.findViewById(R.id.sendbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=editText.getText().toString();
                listner= (CustomListner) getActivity();
                listner.sendMessage(input);

            }
        });
        return v;
    }
    interface  CustomListner
    {
        void sendMessage(String text);
    }

}