package com.example.dbconnection;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText Name,Mark,Surname;
    TextView DataV;
    MyDatabase database=new MyDatabase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.et1);
        Surname=findViewById(R.id.et2);
        Mark=findViewById(R.id.et3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void SaveData(View view) {
        String userVal=Name.getText().toString();
        String surnameVal=Name.getText().toString();
        Integer passVal=Integer.parseInt(Mark.getText().toString());
        Boolean result=database.insertdata(userVal,passVal,surnameVal);
        if(result==true)
        {
            Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Data Insertion Failed", Toast.LENGTH_SHORT).show();
        }

    }
}