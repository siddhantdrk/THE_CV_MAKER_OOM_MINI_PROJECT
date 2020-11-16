package com.example.thecvmaker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecvmaker.R;
import com.example.thecvmaker.models.SkillsItem;

import java.util.List;

public class SkillsRvAdapter extends RecyclerView.Adapter<SkillsRvAdapter.SkillsViewholder> {
    Context context;
    List<SkillsItem> SkillsList;

    public SkillsRvAdapter(Context context, List<SkillsItem> skillsList) {
        this.context = context;
        SkillsList = skillsList;
    }

    @NonNull
    @Override
    public SkillsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.skills_others_item, parent, false);
        return new SkillsViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsViewholder holder, int position) {
        holder.SkillHobbyText.setText(SkillsList.get(position).getHobby());
        holder.SkillDescriptionText.setText(SkillsList.get(position).getSkill_description());

        holder.removeImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkillsList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SkillsViewholder extends RecyclerView.ViewHolder {
        TextView SkillHobbyText, SkillDescriptionText;
        ImageView removeImgBtn;

        public SkillsViewholder(@NonNull View itemView) {
            super(itemView);

            SkillHobbyText = itemView.findViewById(R.id.skill_hobby_text);
            SkillDescriptionText = itemView.findViewById(R.id.skill_description_txt);
            removeImgBtn = itemView.findViewById(R.id.remove_btn_img);


        }
    }
}
