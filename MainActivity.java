package com.example.merin23;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void bt1(View view) {
        EditText username=findViewById(R.id.et1);
        EditText password=findViewById(R.id.pass);


        String u1=username.getText().toString();
        String p1=password.getText().toString();
        String u="admin";
        String p="admin";


        if(u1.isEmpty()|| p1.isEmpty())
        {
            Toast.makeText(this,"Username or password cannot be empty",Toast.LENGTH_SHORT).show();

        }
        else if(u1.equals(u) && p1.equals(p))
        {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }

    }


}