package com.example.myapplication_registerpage;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText epass,eemail;
        TextView goToRegister;
        Button register;
        epass=findViewById(R.id.login_pass);
        eemail=findViewById(R.id.login_email);
        register=findViewById(R.id.login);

        FirebaseAuth firebaseAuth;
        //initialization
        firebaseAuth=FirebaseAuth.getInstance();
        //to make register button clickable

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = epass.getText().toString();
                String email=eemail.getText().toString();
                //to store login credentials
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"User Created",Toast.LENGTH_SHORT).show();
                            // go to next page
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"error "+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }

}