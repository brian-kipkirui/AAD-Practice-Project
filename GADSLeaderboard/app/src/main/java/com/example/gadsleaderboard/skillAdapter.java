package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class skillAdapter extends RecyclerView.Adapter<skillAdapter.skillViewHolder> {

    private ArrayList<skillLeader> mSkillLeaders = new ArrayList<>();
    private Context mContext;

    public skillAdapter (Context context, ArrayList<skillLeader> skillLeaders){
        mContext = context;
        mSkillLeaders = skillLeaders;
    }

    @NonNull
    @Override
    public skillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.slilliq_item_layout, parent , false);

        return new skillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull skillViewHolder holder, int position) {
        holder.bindSkill(mSkillLeaders.get(position));

    }

    @Override
    public int getItemCount() {
        return mSkillLeaders.size();
    }


    public class skillViewHolder extends RecyclerView.ViewHolder{

        // public ImageView imageViewBadge;
        public TextView textViewName;
        public TextView textViewDescription;


        public skillViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.tv2_name);
            textViewDescription = (TextView) itemView.findViewById(R.id.tv2_description);


        }

        public void bindSkill(skillLeader mSkillLeader){
            textViewName.setText(mSkillLeader.getName());
            textViewDescription.setText(mSkillLeader.getScore() + " Skill IQ Score, " + mSkillLeader.getCountry());



        }


    }



}

