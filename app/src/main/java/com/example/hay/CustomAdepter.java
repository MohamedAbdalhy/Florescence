package com.example.hay;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdepter extends RecyclerView.Adapter<CustomAdepter.MyViewHolder> {

    private Activity activity;
    private ArrayList <CompanyCard> companys;

    public CustomAdepter(Activity activity, ArrayList<CompanyCard> companys) {
        this.activity = activity;
        this.companys = companys;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater inflater = activity.getLayoutInflater();
         View v = inflater.inflate(R.layout.list_item,parent,false);
         MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.textView.setText(companys.get(position).getName());
        holder.imageView.setImageResource(companys.get(position).getPicture());
        holder.max.setText(companys.get(position).getMaxBudget());
        holder.min.setText(companys.get(position).getMinBudget());
holder.cardView.setOnClickListener(v -> {
    Intent i = new Intent(activity,PreCompany.class);
    i.putExtra("image",companys.get(position).getPicture());

});

    }

    @Override
    public int getItemCount() {
        return companys.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
private TextView textView;
 private ImageView imageView;
 private TextView max ;
 private TextView min;
private CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.compname);
            imageView= itemView.findViewById(R.id.iv);
            max= itemView.findViewById(R.id.compmax);
            min= itemView.findViewById(R.id.compmin);
cardView = itemView.findViewById(R.id.compcard);
        }
    }
    public interface OnCompanyPre {
void OnCompanyClick(int position);

    }
}
