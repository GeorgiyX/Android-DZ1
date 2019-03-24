package com.example.dz1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.provider.Telephony.Mms.Part.TEXT;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolderCustom>{

    ArrayList<Integer> mItems;
    Context mContext;
    ItemClickListener mItemClickListener;


    public DataAdapter(ArrayList<Integer> items, Context context, ListFragment fragmentContext){
        mItems = items;
        mContext = context;
        mItemClickListener = (ItemClickListener) fragmentContext;
    }

    @NonNull
    @Override
    public ViewHolderCustom onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //Для чего i?
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);

        return new ViewHolderCustom(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCustom viewHolderCustom, int position) {
        Integer num = mItems.get(position);
        if (num%2==0){
            viewHolderCustom.mTextView.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        }
        else {
            viewHolderCustom.mTextView.setTextColor(mContext.getResources().getColor(R.color.colorBlue));
        }
        viewHolderCustom.mTextView.setText(Integer.toString(num));
//        Log.d("SET", " Установлен элемент на позиции " + position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolderCustom extends RecyclerView.ViewHolder{

        TextView mTextView;

        public ViewHolderCustom(@NonNull View itemView) {
            super(itemView);
//            Log.d("INVOKE", "ViewHolderCustom вызван" );
            mTextView = itemView.findViewById(R.id.textEl);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
    public interface ItemClickListener{
        void onItemClick(int position);
    }
}
