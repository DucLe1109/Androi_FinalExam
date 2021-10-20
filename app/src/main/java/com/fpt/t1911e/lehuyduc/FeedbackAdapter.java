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
        holder1.Fb_Name.setText(holder1.Fb_Name.getText() + item.Name);
        holder1.Fb_Description.setText(holder1.Fb_Description.getText()+item.Description);
        holder1.Fb_Email.setText(holder1.Fb_Email.getText()+item.Email);
    }

    @Override
    public int getItemCount() {
        return List_Feedback.size();
    }

    public class FeedbackHolder extends RecyclerView.ViewHolder {

        private TextView Fb_Name, Fb_Description, Fb_Email;

        public FeedbackHolder(@NonNull View itemView) {
            super(itemView);
            Fb_Name = itemView.findViewById(R.id.Fb_Name);
            Fb_Description = itemView.findViewById(R.id.Fb_Description);
            Fb_Email = itemView.findViewById(R.id.Fb_Email);
        }
    }
}
