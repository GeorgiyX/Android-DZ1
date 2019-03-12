package com.example.dz1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

//Находит вьюхи, используется один раз ?, тем самым улучшает производительность
class ViewHolderCustom extends RecyclerView.ViewHolder{

    TextView mTextView;

    public ViewHolderCustom(@NonNull View itemView) {
        super(itemView);
        Log.d("INVOKE", "ViewHolderCustom вызван" );
        mTextView = itemView.findViewById(R.id.textEl);
    }
}

public class DataAdapter extends RecyclerView.Adapter<ViewHolderCustom>{

    ArrayList<Integer> mItems;
    Context mContext;

    public DataAdapter(ArrayList<Integer> items, Context context){
        mItems = items;
        mContext=context;
    }

    @NonNull
    @Override
    public ViewHolderCustom onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //Для чего i?
        //LayoutInflater – это класс, который умеет из содержимого layout-файла создать View-элемент. Метод который это делает называется inflate.
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext()); //Можно было передать и сохранить контекст в конструкторе
        //        Как видим, на вход метод принимает три параметра:
        //        resource - ID layout-файла, который будет использован для создания View. Например - R.layout.main
        //        root – родительский ViewGroup-элемент для создаваемого View. LayoutParams от этого ViewGroup присваиваются создаваемому View.
        //        attachToRoot – присоединять ли создаваемый View к root. Если true, то root становится родителем создаваемого View.
        //        Т.е. это равносильно команде root.addView(View).  Если false – то создаваемый View просто получает LayoutParams от root, но его дочерним элементом не становится.
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        Log.d("CREATE", "Создан элемент на позиции " + i);

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
        Log.d("SET", " Установлен элемент на позиции " + position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
