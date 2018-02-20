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
import android.widget.TextView;
import android.widget.Toast;

/**Created by <b>Loborg</b> at 2018.02.01<br>
This Quiz Application is for the 2017 Udacity Challenge Scholarship Android Bac Trek<br>
I made the application to help the learning of my girlfriend.<br>
 <ul>
<li>The theme of the app is the Hungarian Personal Income Tax system.<br>
<li>The primary language of the app is Hungarian, and it is Localised for All region English.<br>
 <li>The majority of questions can only be interpreted in the Hungarian Tax low system.<br>
 <li>The app contains 10 question, some of the questions can be answered whit multiply answers, and some has only one correct answer. If the question has multiply correct answers, then there is a warning at the bottom of the page.<br><br>
At the Main Page you have to give your name and email address, because the app is capable sending a personalized email, whit your score, from your favourite email app.<br>
The Evaluation page contains all the correct and incorrect answers.<br>
In all forms the correct answers is marked whit a green background, and the incorrect is marked whit a red background. On the Evaluation page the passable correct answer is marked whit a grey background<br>
*/
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

        //if insctance is not empty the color of the next button will be reloaded
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

    //Setts the arrow icon clickable, if the two text field is not empty buy adding a listener to the EditText.
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

    //Returns the name EditText's text
    public String nameTextFieldText(){
        return nameTextField.getText().toString();
    }

    //Returns the email EditText's text
    public String emailTextFieldText(){
        return emailTextField.getText().toString();
    }

    //Handels the newxt arrow ImageView clicks
    public void nextIconClick(View v){
        if (!nameTextFieldText().equals("") && !emailTextFieldText().equals("")){
            sendDataToEvaluation();
            openQuizOneActivity();
        } else {
            Toast emptiTextFieldWarning = Toast.makeText(this, R.string.submite_no_text, Toast.LENGTH_SHORT);
            emptiTextFieldWarning.show();
        }
    }

    //Sets the Evaluation page global name and email variables based on the EdiText’s text
    public void sendDataToEvaluation(){
        Evaluation.userName = nameTextFieldText();
        Evaluation.emailAdress = emailTextFieldText();
    }

    //Intents the next quiz
    public void openQuizOneActivity(){
        saveViewStatus();
        Intent openFirstQuiz = new Intent(this, QuizOne.class);
        startActivity(openFirstQuiz);
    }

    //Saves the Views statets for later use
    public void saveViewStatus(){
        nameTextFieldText = nameTextFieldText();
        emailTextFieldText = emailTextFieldText();
    }
}
