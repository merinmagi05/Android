package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView t2;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //taking text 2
        t2=findViewById(R.id.tv2);

        //welcome message through an intent
        String msg=getIntent().getStringExtra("mykey");
        t2.setText("Welcome"+msg);
        
        lv1=findViewById(R.id.listview);
        String[] courses={"MCA","MBA","BCA","BBA"};
        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1,courses);
        lv1.setAdapter(ad);
        lv1.setOnItemClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String itemname=lv1.getItemAtPosition(i).toString();
            Toast.makeText(this,itemname, Toast.LENGTH_SHORT).show();
    }
}
