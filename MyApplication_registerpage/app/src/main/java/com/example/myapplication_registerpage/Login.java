package com.example.myapplication_registerpage;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_registerpage.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Button login = findViewById(R.id.login);
        final EditText email, password;
        TextView goToRegister;
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_pass);
        goToRegister=findViewById(R.id.register_link);
        FirebaseAuth fAuth;
        //initialization
        fAuth=FirebaseAuth.getInstance();

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to to register page using intent
                Intent intent =new Intent(com.example.myapplication_registerpage.Login.this,MainActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String m1email = email.getText().toString().trim();
                String m1password = password.getText().toString().trim();

                if (TextUtils.isEmpty(m1email)) {
                    email.setError("Enter valid Email ID");
                    return;
                }
                if (TextUtils.isEmpty(m1password)) {
                    password.setError("Enter valid Email ID");
                    return;
                }

                //start here

                fAuth.signInWithEmailAndPassword(m1email, m1password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(com.example.myapplication_registerpage.Login.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                            //redirect to next page
                        } else {
                            Toast.makeText(com.example.myapplication_registerpage.Login.this, "error" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });

            }
        });
    }
}
