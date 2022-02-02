package com.example.Todolist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList list_id, title, description, priority;

    CustomAdapter(Activity activity, Context context, ArrayList list_id, ArrayList title, ArrayList description,
                  ArrayList priority){
        this.activity = activity;
        this.context = context;
        this.list_id = list_id;
        this.title = title;
        this.description = description;
        this.priority = priority;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.list_id_txt.setText(String.valueOf(list_id.get(position)));
        holder.title_txt.setText(String.valueOf(title.get(position)));
        holder.description_txt.setText(String.valueOf(description.get(position)));
        holder.priority_txt.setText(String.valueOf(priority.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(list_id.get(position)));
                intent.putExtra("title", String.valueOf(title.get(position)));
                intent.putExtra("description", String.valueOf(description.get(position)));
                intent.putExtra("priority", String.valueOf(priority.get(position)));


                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView list_id_txt, title_txt,description_txt,  priority_txt,created_txt,modified_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            list_id_txt = itemView.findViewById(R.id.list_id);
            title_txt = itemView.findViewById(R.id.title_txt);
            description_txt = itemView.findViewById(R.id.desc_txt);
            priority_txt = itemView.findViewById(R.id.prio_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
