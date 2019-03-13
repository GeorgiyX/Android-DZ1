package com.example.dz1;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> elements = new ArrayList<>();

    void SetItems(ArrayList<Integer> arLst){
        for (int i = 0; i<100; i++){
            arLst.add(i);
        }
    }

    void AddItem(ArrayList<Integer> arLst){
        arLst.add(arLst.get(arLst.size()-1)+1);
    }

    int NumOfColum(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return 3;
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return 4;
        else
            return 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetItems(elements);

        final RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //Либо в разметке, как атрибут recyclerView app:layoutManager="LinearLayoutManager"

        recyclerView.setLayoutManager(new GridLayoutManager(this, NumOfColum()));
        recyclerView.setAdapter( new DataAdapter(elements, this));

        final Context context = this;
        Button button = findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItem(elements);
                Log.d("INFO", "В обработчике клика " + elements.size());
                recyclerView.setAdapter( new DataAdapter(elements, context));
            }
        });

    }
}
