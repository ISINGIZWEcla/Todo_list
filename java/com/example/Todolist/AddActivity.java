package com.example.Todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class AddActivity extends AppCompatActivity {

    EditText title, description, priority;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title = findViewById(R.id.title);
        description = findViewById(R.id.descript);
        priority = findViewById(R.id.priot);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addtask(title.getText().toString().trim(),
                        description.getText().toString().trim(),
                        priority.getText().toString().trim());
            }
        });
    }
}
