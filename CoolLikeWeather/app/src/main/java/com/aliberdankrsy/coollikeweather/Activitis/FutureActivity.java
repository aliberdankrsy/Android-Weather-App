package com.aliberdankrsy.coollikeweather.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aliberdankrsy.coollikeweather.Apadters.FutureAdapter;
import com.aliberdankrsy.coollikeweather.Domains.FutureDomain;
import com.aliberdankrsy.coollikeweather.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterTommorow;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    private void setVariable() {
        ConstraintLayout backBtn;
        backBtn = findViewById(R.id.backBtnn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(FutureActivity.this,MainActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();
        items.add(new FutureDomain("Sat","storm","Storm",17,13));
        items.add(new FutureDomain("Sun","rainy","Rainy",18,14));
        items.add(new FutureDomain("Mon","cloudy","Cloudy",18,15));
        items.add(new FutureDomain("Tue","sunny","Sunny",24,19));
        items.add(new FutureDomain("Wed","cloudy_sunny","Cloudy Sunny",20,16));
        items.add(new FutureDomain("Thu","windy","Windy",15,11));


        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterTommorow=new FutureAdapter(items);
        recyclerView.setAdapter(adapterTommorow);
    }
}