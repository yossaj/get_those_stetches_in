package com.example.dailystretches;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StretchAdapter extends RecyclerView.Adapter<StretchAdapter.StretchViewHolder> {

    private Context mContext;
    private String[] mStretchData;

    public StretchAdapter(Context context){
        mContext = context;

    }

    @NonNull
    @Override
    public StretchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layouId = R.layout.stretch_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layouId, parent, false);
        return new StretchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StretchViewHolder holder, int position) {
        String stretchForItem = mStretchData[position];
        holder.stretchTitleTV.setText(stretchForItem);

    }

    @Override
    public int getItemCount() {
        if(mStretchData == null)return 0;
        return mStretchData.length;
    }

    public void setStretchData(String[] stretches){
        mStretchData = stretches;
    }


    class StretchViewHolder extends RecyclerView.ViewHolder{

        public final TextView stretchTitleTV;

        public StretchViewHolder(@NonNull View itemView) {
            super(itemView);
            stretchTitleTV = itemView.findViewById(R.id.stretch_title);
        }
    }


}
