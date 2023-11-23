package com.example.songlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aplicacion app =(Aplicacion) getApplication();
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(app.getAdaptador());
        layoutmanager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);

        app.getAdaptador().setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Seleccionado elemento: "
                        +recyclerView.getChildAdapterPosition(view), Toast.LENGTH_SHORT).show();
            }
        });

    }
}