package com.example.mudrassahapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private Context context;
    private List RollNo,Name,Age,ClassName,Sabaq,Sabaqi,Manzil;

   public  RecycleViewAdapter(List RollNo, List Name,List Age,List ClassName,List Sabaq,List Sabaqi,List Manzil) {
       this.RollNo = RollNo;
       this.Age = Age;
       this.Name = Name;
       this.ClassName = ClassName;
       this.Sabaq = Sabaq;
       this.Sabaqi = Sabaqi;
       this.Manzil = Manzil;
   }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Implement the creation of your ViewHolder instance here
        // using the provided parent view and viewType
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_mydata,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Implement binding data to your ViewHolder instance here
        holder.roll_no_txt.setText(String.valueOf(RollNo.get(position)));
        holder.name_txt.setText(String.valueOf(Name.get(position)));
        holder.age_txt.setText(String.valueOf(Age.get(position)));
        holder.Class_txt.setText(String.valueOf(ClassName.get(position)));
        holder.sabaq_txt.setText(String.valueOf(Sabaq.get(position)));
        holder.sabaqi_txt.setText(String.valueOf(Sabaqi.get(position)));
        holder.manzil_txt.setText(String.valueOf(Manzil.get(position)));
    }

    @Override
    public int getItemCount() {
        return RollNo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView roll_no_txt,name_txt,age_txt,Class_txt,sabaq_txt,sabaqi_txt,manzil_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            roll_no_txt = itemView.findViewById(R.id.roll_no_txt);
            name_txt = itemView.findViewById(R.id.name_txt);
            age_txt = itemView.findViewById(R.id.age_txt);
            Class_txt = itemView.findViewById(R.id.class_txt);
            sabaq_txt = itemView.findViewById(R.id.sabaq_txt);
            sabaqi_txt = itemView.findViewById(R.id.sabaqi_txt);
            manzil_txt = itemView.findViewById(R.id.manzil_txt);
        }
    }
}
