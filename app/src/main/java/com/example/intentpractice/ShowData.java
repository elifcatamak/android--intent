package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {
    private TextView showName;
    private TextView showLastName;
    private TextView showAge;
    private String name;
    private String lastName;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        showName = findViewById(R.id.show_id_name);
        showLastName = findViewById(R.id.show_id_lastname);
        showAge = findViewById(R.id.show_id_age);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            name = extras.getString("name");
            lastName = extras.getString("lastName");
            age = extras.getInt("age");

            showName.setText(name);
            showLastName.setText(lastName);
            showAge.setText(String.valueOf(age));
        }
    }
}
