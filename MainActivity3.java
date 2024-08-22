package com.example.merin23;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ConstraintLayout mainLayout=findViewById(R.id.main);
        mainLayout.setBackgroundColor(Color.parseColor("#2c2e30"));


        Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        TextView tv1 = findViewById(R.id.tv1);
        if(username!=null)
        {
            tv1.setText("Welcome, " + username + "!");
        }

        Button logoutButton=findViewById(R.id.bt2);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this,"Logout Successfully",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this, MainActivity.class);


                startActivity(intent);
                finish();

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}