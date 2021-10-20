package com.fpt.t1911e.lehuyduc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Feedback> List_Feedback;

    public FeedbackAdapter(Activity activity, List<Feedback> list_Feedback) {
        this.activity = activity;
        List_Feedback = list_Feedback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.feedback_item, parent, false);
        FeedbackHolder holder = new FeedbackHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FeedbackHolder holder1 = (FeedbackHolder) holder;
        Feedback item = List_Feedback.get(position);
        if(item.Name != null && item.Sex != null && item.Description != null && item.Email != null){
            holder1.Fb_Name.setText("Name: " + item.Name);
            holder1.Fb_Description.setText("Description: "+item.Description);
            holder1.Fb_Email.setText("Email: "+item.Email);
            holder1.Fb_Sex.setText("Gender: "+item.Sex);
            holder1.Fb_Id.setText(String.valueOf(position+1) + ". ");
        }
    }

    @Override
    public int getItemCount() {
        return List_Feedback.size();
    }

    public class FeedbackHolder extends RecyclerView.ViewHolder {

        private TextView Fb_Name, Fb_Description, Fb_Email,Fb_Sex,Fb_Id;

        public FeedbackHolder(@NonNull View itemView) {
            super(itemView);
            Fb_Name = itemView.findViewById(R.id.Fb_Name);
            Fb_Description = itemView.findViewById(R.id.Fb_Description);
            Fb_Email = itemView.findViewById(R.id.Fb_Email);
            Fb_Sex = itemView.findViewById(R.id.Fb_Gender);
            Fb_Id = itemView.findViewById(R.id.Fb_Id);
        }
    }
}
