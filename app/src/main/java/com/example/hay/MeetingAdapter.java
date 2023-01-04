package com.example.hay;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetViewHolder> {

private Activity activity;
private ArrayList<MeetModel> meets;

    public MeetingAdapter(Activity activity, ArrayList<MeetModel> meets) {
        this.activity = activity;
        this.meets = meets;
    }

    @NonNull
    @Override
    public MeetingAdapter.MeetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=activity.getLayoutInflater();
      View view =  inflater.inflate(R.layout.list_meeting,parent,false);
       MeetViewHolder holder = new MeetViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingAdapter.MeetViewHolder holder, int position) {
holder.compName.setText(meets.get(position).getCompanyName());
        holder.attendnum.setText(meets.get(position).getAuttNum());
        holder.rescheduled.setText(meets.get(position).getResch());
        holder.packages.setText(meets.get(position).getPackedge());
        holder.availableTime.setText(meets.get(position).getAvtime());
        holder.comment.setText(meets.get(position).getComment());
holder.cardView.setOnClickListener(v -> {

});

    }

    @Override
    public int getItemCount() {
        return meets.size();
    }

    public class MeetViewHolder extends RecyclerView.ViewHolder {
        private final TextView compName;
        private final TextView rescheduled ;
        private final TextView  attendnum;
        private final TextView packages;
        private final TextView availableTime;
        private final CardView cardView;
        private final TextView comment;


        public MeetViewHolder(@NonNull View itemView) {
            super(itemView);
            compName=itemView.findViewById(R.id.tvcompname);
                    rescheduled=itemView.findViewById(R.id.tvres);
            attendnum=itemView.findViewById(R.id.tvattu);
                    packages=itemView.findViewById(R.id.tvpack);
            availableTime=itemView.findViewById(R.id.tvavtime);
                    cardView=itemView.findViewById(R.id.meetingcard);
                    comment=itemView.findViewById(R.id.tvcomment);

        }
    }
}
