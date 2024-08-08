package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText n1,n2;
int a,b;
EditText n3;

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
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
    }

    public void Mul(View view) {

        int a=Integer.parseInt(n1.getText().toString());
        int b=Integer.parseInt(n2.getText().toString());
        int r=a*b;
        n3.setText(String.valueOf(r));
    }
    public void Add(View view) {

        int a=Integer.parseInt(n1.getText().toString());
        int b=Integer.parseInt(n2.getText().toString());
        int r=a+b;
        n3.setText(String.valueOf(r));
    }
    public void Div(View view) {

        int a=Integer.parseInt(n1.getText().toString());
        int b=Integer.parseInt(n2.getText().toString());
        int r=a/b;
        n3.setText(String.valueOf(r));
    }
    public void Sub(View view) {

        int a=Integer.parseInt(n1.getText().toString());
        int b=Integer.parseInt(n2.getText().toString());
        int r=a-b;
        n3.setText(String.valueOf(r));
    }
}