package com.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edusername,edpassword,edemail,edconfirm;
    Button btn;
    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edusername = findViewById(R.id.editTextRegUserName);
        edemail = findViewById(R.id.editTextRegEmail);
        edpassword = findViewById(R.id.editTextRegPassword);
        edconfirm = findViewById(R.id.editTextRegConirmPassword);
        btn = findViewById(R.id.buttonReg);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edusername.getText().toString();
                String password=edpassword.getText().toString();
                String email=edemail.getText().toString();
                String confirmpass=edconfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || password.length()==0) {
                    Toast.makeText(getApplicationContext(), "please fill All details", Toast.LENGTH_SHORT).show();
                }else {
                    if(password.compareTo(confirmpass)==0)
                    {
                      if(isValid(password)){
                          db.register(username,email,password);
                          Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                      }else{
                          Toast.makeText(getApplicationContext(), "password must contain at least 8 characters,having letter ,digit and special symbol", Toast.LENGTH_SHORT).show();
                      }
                    }else{
                        Toast.makeText(getApplicationContext(), "password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
public static boolean isValid(String passwordhere){
int f1=0,f2=0,f3=0;
if(passwordhere.length()<8)
{
    return false;
}else{
    for(int p=0;p<passwordhere.length();p++)
    {
        if(Character.isLetter(passwordhere.charAt(p))){
            f1=1;
        }
    }
    for(int p=0;p<passwordhere.length();p++)
    {
        if(Character.isDigit(passwordhere.charAt(p))){
            f2=1;
        }
    }
    for(int p=0;p<passwordhere.length();p++)
    {
        char c=passwordhere.charAt(p);
        if(c>=33 && c<=46 || c==64){
            f3=1;
        }
    }
if(f1==1 && f2==1 && f3==1)
{
    return true;
}
    return false;
}

    }
}
