package com.example.registrationform;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText fname, lname, email, phno, dob, pass;
    private RadioGroup gender;

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

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        phno = findViewById(R.id.phno);
        pass = findViewById(R.id.pass);
        gender = findViewById(R.id.gender);
        dob = findViewById(R.id.date);
    }

    private boolean isNameValid(EditText nameField) {
        String name = nameField.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(this, "Name is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!name.matches("[a-zA-Z\\s]+")) {
            Toast.makeText(this, "Name must contain only letters and spaces", Toast.LENGTH_SHORT).show();
            return false;
        } else if (name.length() < 3) {
            Toast.makeText(this, "Name must be at least 3 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isEmailValid(EditText emailField) {
        String emailStr = emailField.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}";
        if (emailStr.isEmpty()) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!emailStr.matches(emailPattern)) {
            Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isPasswordValid(EditText passwordField) {
        String password = passwordField.getText().toString().trim();
        if (password.isEmpty()) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isPhoneNumberValid(EditText phoneField) {
        String phone = phoneField.getText().toString().trim();
        if (phone.isEmpty()) {
            Toast.makeText(this, "Phone number is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!phone.matches("\\d{10}")) {
            Toast.makeText(this, "Enter a valid phone number (10 digits)", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isDateValid(EditText dateField) {
        String date = dateField.getText().toString().trim();
        if (date.isEmpty()) {
            Toast.makeText(this, "Date of birth is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void b1(View view) {
        String fnamee = fname.getText().toString().trim();
        String lnamee = lname.getText().toString().trim();
        String emaill = email.getText().toString().trim();
        String phnoo = phno.getText().toString().trim();
        String passs = pass.getText().toString().trim();
        String dobb = dob.getText().toString().trim();

        int selectedGenderId = gender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(selectedGenderId);
        String genderValue = (selectedGender != null) ? selectedGender.getText().toString() : "";

        if (!isNameValid(fname) || !isNameValid(lname)) {
            return;
        } else if (!isEmailValid(email)) {
            return;
        } else if (!isPhoneNumberValid(phno)) {
            return;
        } else if (!isPasswordValid(pass)) {
            return;
        } else if (!isDateValid(dob)) {
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("fname", fnamee);
        editor.putString("lname", lnamee);
        editor.putString("email", emaill);
        editor.putString("phno", phnoo);
        editor.putString("pass", passs);
        editor.putString("dob", dobb);
        editor.putString("gender", genderValue);
        editor.apply();

        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
