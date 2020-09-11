package com.example.gadsleadershipboardapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleadershipboardapp.R;
import com.example.gadsleadershipboardapp.model.LearningLeader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    private final Context mContext;
    private final List<LearningLeader> mLearningLeaders;
    private final LayoutInflater mLayoutInflater;

    public LearningLeadersAdapter(Context context, List<LearningLeader> learningLeaders) {
        mContext = context;
        mLearningLeaders = learningLeaders;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.learning_leader_single_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearningLeader learningLeader = mLearningLeaders.get(position);
        holder.learnerName.setText(learningLeader.getName());
        holder.learnerDescription.setText(learningLeader.getHours() + " learning hours, "+ learningLeader.getCountry());
        Picasso.with(mContext).load(learningLeader.getBadgeUrl()).into(holder.badgeUrlImage);
    }

    @Override
    public int getItemCount() {
        return mLearningLeaders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // references to the text views
        private TextView learnerName;
        private TextView learnerDescription;
        private ImageView badgeUrlImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.learnerName = (TextView) itemView.findViewById(R.id.txtFullName);
            this.learnerDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            this.badgeUrlImage = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
