package com.example.lesson06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<UserAdapter.NumberViewHolder>{

    private Context context;
    private int resource;
    private List<Post> posts;
    private LayoutInflater inflater;
    private int countHolder;

    public PostAdapter(Context context, int resource, List<Post> data) {
        this.context = context;
        this.resource = resource;
        this.posts = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserAdapter.NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = inflater.inflate(resource, parent, false);
        UserAdapter.NumberViewHolder holder = new UserAdapter.NumberViewHolder(item);
        holder.tvHolder.setText("holder#" + ++countHolder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.NumberViewHolder holder, int position) {
        Post post = posts.get(position);
        //holder.tvData.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
