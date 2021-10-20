package com.fpt.t1911e.lehuyduc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListFeedback extends AppCompatActivity {

    private AppDatabase db;
    private List<Feedback> ListFeedback = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_feedback);
        db = AppDatabase.getAppDatabase(this);
        ListFeedback = db.iFeedback().getAllFeedback();
        RecyclerView recyclerView = findViewById(R.id.List_Feedback);

        FeedbackAdapter feedbackAdapter = new FeedbackAdapter(this, ListFeedback);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recyclerView.setAdapter(feedbackAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}