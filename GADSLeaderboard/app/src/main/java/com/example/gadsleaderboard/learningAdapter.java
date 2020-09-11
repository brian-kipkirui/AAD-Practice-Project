package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class learningAdapter extends RecyclerView.Adapter<learningAdapter.learningViewHolder>{

    private ArrayList<learningLeader> mLearningLeaders = new ArrayList<>();
    private Context mContext;

    public learningAdapter (Context context, ArrayList<learningLeader> learningLeaders){
        mContext = context;
        mLearningLeaders = learningLeaders;
    }

    @NonNull
    @Override
    public learningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.leader_item_layout, parent , false);

        return new learningViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull learningViewHolder holder, int position) {
    holder.bindLearning(mLearningLeaders.get(position));

    }

    @Override
    public int getItemCount() {
        return mLearningLeaders.size();
    }

    public class learningViewHolder extends RecyclerView.ViewHolder{

       // public ImageView imageViewBadge;
        public TextView textViewName;
        public TextView textViewDescription;


        public learningViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.tv_name);
            textViewDescription = (TextView) itemView.findViewById(R.id.tv_description);


        }

        public void bindLearning(learningLeader mLearningLeader){
            textViewName.setText(mLearningLeader.getName());
            textViewDescription.setText(mLearningLeader.getHours() + " leaning hours, " + mLearningLeader.getCountry());



        }


    }


}
