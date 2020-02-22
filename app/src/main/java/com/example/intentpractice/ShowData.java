package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {
    private TextView showName;
    private TextView showLastName;
    private TextView showAge;
    private ImageButton backButton;

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
        backButton = findViewById(R.id.show_id_back);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            name = extras.getString("name");
            lastName = extras.getString("lastName");
            age = extras.getInt("age");

            showName.setText(name);
            showLastName.setText(lastName);
            showAge.setText(String.valueOf(age));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("returnMsg", "Back from ShowData activity");
                setResult(RESULT_OK, intent);
                
                finish();
            }
        });
    }
}
