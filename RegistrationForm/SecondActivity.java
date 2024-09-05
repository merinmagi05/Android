package com.example.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView txtFname, txtLname, txtEmail, txtPhno, txtDob, txtGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        txtFname = findViewById(R.id.txtFname);
        txtLname = findViewById(R.id.txtLname);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhno = findViewById(R.id.txtPhno);
        txtDob = findViewById(R.id.txtDob);
        txtGender = findViewById(R.id.txtGender);


        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        String fname = sharedPreferences.getString("fname", "Not available");
        String lname = sharedPreferences.getString("lname", "Not available");
        String email = sharedPreferences.getString("email", "Not available");
        String phno = sharedPreferences.getString("phno", "Not available");
        String dob = sharedPreferences.getString("dob", "Not available");
        String gender = sharedPreferences.getString("gender", "Not available");


        txtFname.setText("First Name: " + fname);
        txtLname.setText("Last Name: " + lname);
        txtEmail.setText("Email: " + email);
        txtPhno.setText("Phone Number: " + phno);
        txtDob.setText("Date of Birth: " + dob);
        txtGender.setText("Gender: " + gender);
    }

    public void logout(View view) {
        Toast.makeText(SecondActivity.this,"Logout Successfully",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(SecondActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
