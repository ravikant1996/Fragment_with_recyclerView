package com.example.fragmentwithrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHoder> {

    ArrayList<Person> arrayList;

    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list){
        arrayList= list;
        activity = (ItemClicked) context;
    }
    public class ViewHoder extends RecyclerView.ViewHolder {

        TextView tvName;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
activity.onItemClicked(arrayList.indexOf((Person) view.getTag()));
                }
            });
        }
    }


    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

        holder.itemView.setTag(arrayList.get(position));
        holder.tvName.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
