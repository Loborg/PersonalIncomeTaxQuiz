package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    private EditText nameTextField;
    private EditText emailTextField;
    private ImageView nextIconImage;
    public int color;
    public static int nextIconImageColor = Color.LTGRAY;
    private static String nameTextFieldText;
    private static String emailTextFieldText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextIconImage = findViewById(R.id.next_image_01);
        nameTextField = findViewById(R.id.name_textfield);
        emailTextField = findViewById(R.id.email_textfield);

        setNextIconImageColorBasedOnEditTextStatus();

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(NEXT_ICON_IMAGE_COLOR_KEY))
                nextIconImage.setColorFilter(savedInstanceState.getInt(NEXT_ICON_IMAGE_COLOR_KEY));
        }
        nextIconImage.setColorFilter(nextIconImageColor);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);

        saveViewStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameTextField.setText(nameTextFieldText);
        emailTextField.setText(emailTextFieldText);
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
            sendDataToEvaluation();
            openQuizOneActivity();
        } else {
            Toast emptiTextFieldWarning = Toast.makeText(this, R.string.submite_no_text, Toast.LENGTH_SHORT);
            emptiTextFieldWarning.show();
        }
    }

    public void sendDataToEvaluation(){
        Evaluation.userName = nameTextFieldText();
        Evaluation.emailAdress = emailTextFieldText();
    }

    public void openQuizOneActivity(){
        saveViewStatus();
        Intent openFirstQuiz = new Intent(this, QuizOne.class);
        startActivity(openFirstQuiz);
    }

    public void saveViewStatus(){
        nameTextFieldText = nameTextFieldText();
        emailTextFieldText = emailTextFieldText();
    }
}
