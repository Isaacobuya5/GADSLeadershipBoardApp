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
import com.example.gadsleadershipboardapp.model.SkillIQLeader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillLeadersAdapter extends RecyclerView.Adapter<SkillLeadersAdapter.ViewHolder> {

    private final Context mContext;
    private final List<SkillIQLeader> mSkillIQLeaderList;
    private final LayoutInflater mLayoutInflater;

    public SkillLeadersAdapter(Context context, List<SkillIQLeader> skillIQLeaderList) {
        mContext = context;
        mSkillIQLeaderList = skillIQLeaderList;
        mLayoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.skill_iq_leaders_single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillIQLeader skillIQLeader = mSkillIQLeaderList.get(position);
        holder.mSkillLeaderName.setText(skillIQLeader.getName());
        holder.mSkillDescription.setText(skillIQLeader.getScore() + " skill IQ score, " + skillIQLeader.getCountry());
        Picasso.with(mContext).load(skillIQLeader.getBadgeUrl()).into(holder.mSkillBadgeUrlImg);
    }

    @Override
    public int getItemCount() {
        return mSkillIQLeaderList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // reference to the imageView
        private ImageView mSkillBadgeUrlImg;
        // reference to the text view

        private TextView mSkillLeaderName;
        private TextView mSkillDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mSkillBadgeUrlImg = (ImageView) itemView.findViewById(R.id.skillBadge);
            this.mSkillLeaderName = (TextView) itemView.findViewById(R.id.txtFullNameSkill);
            this.mSkillDescription = (TextView) itemView.findViewById(R.id.txtSkillDescription);
        }
    }
}
