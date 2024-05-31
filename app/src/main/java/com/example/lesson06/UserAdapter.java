package com.example.lesson06;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.NumberViewHolder> {
    private Context context;
    private int resource;
    private List<User> users;
    private LayoutInflater inflater;
    private int countHolder;

    private AdapterView.OnItemClickListener onItemClickListener;
    public UserAdapter(Context context, int resource, List<User> data) {
        this.context = context;
        this.resource = resource;
        this.users = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = inflater.inflate(resource, parent, false);
        NumberViewHolder holder = new NumberViewHolder(item);
        holder.tvHolder.setText("holder#" + ++countHolder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        User user = users.get(position);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UserActivity.class);
            intent.putExtra("user", user);
            context.startActivity(intent);
        });
        List<String> nameAndSecondName = Arrays.asList(user.getName().split(" "));
        if (nameAndSecondName.stream().anyMatch(x -> x.contains("Mrs."))) {
            holder.tvName.setText(nameAndSecondName.get(1));
            holder.tvSecondName.setText(nameAndSecondName.get(2));
        } else {
            holder.tvName.setText(nameAndSecondName.get(0));
            holder.tvSecondName.setText(nameAndSecondName.get(1));
        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView tvHolder;
        TextView tvName;
        TextView tvSecondName;
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHolder = itemView.findViewById(R.id.tvHolder);
            tvName = itemView.findViewById(R.id.tvName);
            tvSecondName = itemView.findViewById(R.id.tvSecondName);
        }
    }


}
