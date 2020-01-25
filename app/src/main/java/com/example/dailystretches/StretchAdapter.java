package com.example.dailystretches;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StretchAdapter extends RecyclerView.Adapter<StretchAdapter.StretchViewHolder> {

    private Context mContext;
    private String[] mStretchData;

    private final onClickHandler mClickHandler;

    public interface onClickHandler {
        void onClick(View clickedView);

    }

    public StretchAdapter(Context context, onClickHandler clickHandler){
        mContext = context;
        mClickHandler = clickHandler;

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
    public void onBindViewHolder(@NonNull final StretchViewHolder holder, int position) {
        String stretchForItem = mStretchData[position];
        holder.stretchTitleTV.setText(stretchForItem);
        holder.stretchCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(mContext, "Great Job Elastic Legs!", Toast.LENGTH_SHORT)
                        .show();
                holder.itemView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mStretchData == null)return 0;
        return mStretchData.length;
    }

    public void setStretchData(String[] stretches){
        mStretchData = stretches;
    }


    class StretchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView stretchTitleTV;
        private final CheckBox stretchCB;

        public StretchViewHolder(@NonNull View itemView) {
            super(itemView);
            stretchTitleTV = itemView.findViewById(R.id.stretch_title);
            stretchCB = itemView.findViewById(R.id.list_check_stretch);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mClickHandler.onClick(view);
        }
    }


}
