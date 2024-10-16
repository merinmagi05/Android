package com.example.linearlayoutloginpage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.et1);
        t2=findViewById(R.id.et2);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }
    public void login(View view)
    {
        String name=t1.getText().toString();
        String pass=t2.getText().toString();
        if(name.equals("merin") && pass.equals("123"))
        {
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(this, "Invalid username", Toast.LENGTH_SHORT).show();
        }
    }
}