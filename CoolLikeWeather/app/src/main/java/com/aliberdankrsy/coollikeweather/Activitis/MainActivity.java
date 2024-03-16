package com.aliberdankrsy.coollikeweather.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aliberdankrsy.coollikeweather.Apadters.HourlyAdapters;
import com.aliberdankrsy.coollikeweather.Domains.Hourly;
import com.aliberdankrsy.coollikeweather.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterHorly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        SetVariable();
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    private void SetVariable() {
        TextView next7dayBtn = findViewById(R.id.nextBtn);
        next7dayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FutureActivity.class));

            }
        });
    }

    private void initRecyclerview() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly("8 pm",28,"cloudy"));
        items.add(new Hourly("9 pm",30,"sunny"));
        items.add(new Hourly("11 pm",29,"wind"));
        items.add(new Hourly("1 am",28,"rainy"));
        items.add(new Hourly("3 am",26,"storm"));
        items.add(new Hourly("4 pm",23,"storm"));
        items.add(new Hourly("6 am",22,"rainy"));
        items.add(new Hourly("7 am",19,"wind"));

        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHorly = new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHorly);



    }
}