package com.example.intentpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextAge;
    private Button buttonSumbit;
    private String name;
    private String lastName;
    private String ageStr;
    private int age;

    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.edittext_id_name);
        editTextLastName = findViewById(R.id.edittext_id_lastname);
        editTextAge = findViewById(R.id.edittext_id_age);
        buttonSumbit = findViewById(R.id.button_submit);

        buttonSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextName.getText().toString().trim();
                lastName = editTextLastName.getText().toString().trim();
                ageStr = editTextAge.getText().toString().trim();

                if(!name.isEmpty() && !lastName.isEmpty() && !ageStr.isEmpty()){
                    age = Integer.parseInt(ageStr);

                    if(ageIsValid()){
                        Intent intent = new Intent(MainActivity.this, ShowData.class);
                        intent.putExtra("name", name);
                        intent.putExtra("lastName", lastName);
                        intent.putExtra("age", age);

                        startActivityForResult(intent, REQUEST_CODE);
                    }
                }
            }
        });
    }

    public boolean ageIsValid(){
        if(age <1 || age > 130)
        {
            Toast.makeText(MainActivity.this, R.string.toast_invalid_age, Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            Toast.makeText(MainActivity.this, R.string.toast_return_success, Toast.LENGTH_SHORT).show();
        }
    }
}
