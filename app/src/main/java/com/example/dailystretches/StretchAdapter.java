package com.example.dailystretches;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StretchAdapter extends RecyclerView.Adapter<StretchAdapter.StretchViewHolder> {

    private Context mContext;

    public StretchAdapter(Context context){
        mContext = context;

    }

    @NonNull
    @Override
    public StretchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StretchViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class StretchViewHolder extends RecyclerView.ViewHolder{

        public StretchViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
