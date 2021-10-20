package com.fpt.t1911e.lehuyduc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Ed_Name, Ed_Description, Ed_Email;
    private Spinner Spinner_select;
    private CheckBox Cb_check;
    private Button Bt_SendFeedback, Bt_ListFeedback;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        initView();
        Bt_SendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFeedback();
            }
        });

        Bt_ListFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListFeedback.class);
                startActivity(i);
            }
        });
    }

    private void AddFeedback() {
        String Name = Ed_Name.getText().toString();
        String Description = Ed_Description.getText().toString();
        String Email = Ed_Email.getText().toString();
        Boolean checked = Cb_check.isChecked();
        String selected_item = (String) Spinner_select.getSelectedItem();

        if (Name.equalsIgnoreCase("") != true
                && Description.equalsIgnoreCase("") != true
                && Email.equalsIgnoreCase("") != true
                && checked == true
                && selected_item.equalsIgnoreCase("") != true) {
            Feedback new_feedback = new Feedback();
            new_feedback.Description = Description;
            new_feedback.Name = Name;
            new_feedback.Email = Email;
            new_feedback.Sex = selected_item;
            db.iFeedback().Insert(new_feedback);
            Intent i = new Intent(MainActivity.this, ListFeedback.class);
            startActivity(i);
        } else {
            Toast.makeText(MainActivity.this, "Information can't be null", Toast.LENGTH_LONG).show();
        }
    }

    private void initView() {
        Cb_check = findViewById(R.id.Cb_check);
        Ed_Name = findViewById(R.id.Ed_Name);
        Ed_Description = findViewById(R.id.Ed_Description);
        Ed_Email = findViewById(R.id.Ed_Email);
        Bt_SendFeedback = findViewById(R.id.Bt_SendFeedback);
        Bt_ListFeedback = findViewById(R.id.Bt_ListFeedback);
        Spinner_select = findViewById(R.id.Spinner_select);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Sex, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner_select.setAdapter(adapter);
    }
}