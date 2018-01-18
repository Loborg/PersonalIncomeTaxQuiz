package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameTextField;
    private EditText emailTextField;
    private ImageView nextIconImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextIconImage = findViewById(R.id.next_image_01);
        nameTextField = findViewById(R.id.name_textfield);
        emailTextField = findViewById(R.id.email_textfield);
        setNextIconImageColorBasedOnEditTextStatus();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("next_icon_color_key", nextIconImage.getColorFilter().hashCode());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        nextIconImage.setColorFilter(savedInstanceState.getInt("next_icon_color_key"));
    }

    public void setNextIconImageColorBasedOnEditTextStatus(){
        nameTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (!emailTextFieldText().equals("")){
                    nextIconImage.setColorFilter(Color.BLACK);
                } else {
                    nextIconImage.setColorFilter(Color.LTGRAY);
                }
            }
        });

        emailTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (!nameTextFieldText().equals("")){
                    nextIconImage.setColorFilter(Color.BLACK);
                } else {
                    nextIconImage.setColorFilter(Color.LTGRAY);
                }
            }
        });
    }

    public String nameTextFieldText(){
        return nameTextField.getText().toString();
    }

    public String emailTextFieldText(){
        return emailTextField.getText().toString();
    }

    public void nextIconClick(View v){
        if (!nameTextFieldText().equals("") && !emailTextFieldText().equals("")){
            Intent openFirstQuiz = new Intent(this, QuizOne.class);
            startActivity(openFirstQuiz);
        } else {
            Toast emptiTextFieldWarning = Toast.makeText(this, "You didn’t fill out all the required fields!", Toast.LENGTH_SHORT);
            emptiTextFieldWarning.show();
        }
    }
}
