package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class QuizThree extends AppCompatActivity {

    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public static final String QUIZ_EDIT_TEXT_COLOR_KEY = "quiz_edit_text_color_key";
    public static final String QUIZ_EDIT_TEXT_IS_ENABLED_KEY = "quiz_edit_text_is_enabled_key";
    public static final String SUBMITE_BUTTON_CLICK_COUNT_KEY = "submite_button_click_count_key";
    public ImageView nextIconImage;
    public static int nextIconImageColor = Color.LTGRAY;
    public static int editTextBGColor;
    public Button quizThreeSubmiteButton;
    public EditText quiz03TextAnswer;
    public static boolean isSubmiteButtonClicked;
    private int submiteButtonClickCounter = 0;
    public static boolean editTextIsEnabled = true;
    public static String editTextText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_three);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz03TextAnswer = findViewById(R.id.quiz_03_text_aswer);
        quizThreeSubmiteButton = findViewById(R.id.quiz_three_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(NEXT_ICON_IMAGE_COLOR_KEY))
                nextIconImageColor = savedInstanceState.getInt(NEXT_ICON_IMAGE_COLOR_KEY);
            if (savedInstanceState.containsKey(QUIZ_EDIT_TEXT_COLOR_KEY))
                editTextBGColor = savedInstanceState.getInt(QUIZ_EDIT_TEXT_COLOR_KEY);
            if (savedInstanceState.containsKey(QUIZ_EDIT_TEXT_IS_ENABLED_KEY))
                quiz03TextAnswer.setEnabled(savedInstanceState.getBoolean(QUIZ_EDIT_TEXT_IS_ENABLED_KEY));
            if (savedInstanceState.containsKey(SUBMITE_BUTTON_CLICK_COUNT_KEY))
                submiteButtonClickCounter = savedInstanceState.getInt(SUBMITE_BUTTON_CLICK_COUNT_KEY);
        }

        nextIconImage.setColorFilter(nextIconImageColor);
        quiz03TextAnswer.setBackgroundColor(editTextBGColor);

        nextIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubmiteButtonClicked) {
                    openQ4Activity();
                } else {
                    Toast submiteButtonNotClicked = Toast.makeText(QuizThree.this, "You haven submitted the right answers yet", Toast.LENGTH_SHORT);
                    submiteButtonNotClicked.show();
                }
            }
        });

        if (!quiz03TextAnswer.isEnabled())
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SUBMITE_BUTTON_CLICK_COUNT_KEY, submiteButtonClickCounter);
        outState.putBoolean(QUIZ_EDIT_TEXT_IS_ENABLED_KEY, quiz03TextAnswer.isEnabled());
        outState.putInt(QUIZ_EDIT_TEXT_COLOR_KEY, editTextBGColor);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);
        saveViewStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        quiz03TextAnswer.setText(editTextText);
        quiz03TextAnswer.setEnabled(editTextIsEnabled);
        nextIconImage.setColorFilter(nextIconImageColor);
        if (!quiz03TextAnswer.isEnabled())
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        openQ2Activity();
    }

    public void quizThreeSubmiteButtonClick(View v){
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);

        String quiz03AswerText = quiz03TextAnswer.getText().toString();
        Evaluation.quizAnswers[2] = quiz03AswerText;

        if (quiz03AswerText.equalsIgnoreCase("tax id")){
            Toast.makeText(this, "Your answer is correct!", Toast.LENGTH_SHORT).show();
            isSubmiteButtonClicked = true;
            editTextBGColor = Color.GREEN;
            quiz03TextAnswer.setBackgroundColor(editTextBGColor);
            quiz03TextAnswer.setEnabled(false);
        } else if (!quiz03AswerText.equalsIgnoreCase("tax id") && submiteButtonClickCounter < 2){
            Toast.makeText(this, "Your answer is incorrect, try again!", Toast.LENGTH_SHORT).show();
            editTextBGColor = Color.RED;
            quiz03TextAnswer.setBackgroundColor(editTextBGColor);
            submiteButtonClickCounter = submiteButtonClickCounter + 1;
        } else if (submiteButtonClickCounter > 1){
            Toast.makeText(this, "You tried to anwers the question to meny times!", Toast.LENGTH_SHORT).show();
            isSubmiteButtonClicked = true;
            quiz03TextAnswer.setEnabled(false);
        }
    }

    public void openQ4Activity(){
        saveViewStatus();
        Intent openQuizFour = new Intent(QuizThree.this, QuizFour.class);
        startActivity(openQuizFour);
    }

    public void openQ2Activity(){
        Intent openQ2 = new Intent(this, QuizTwo.class);
        startActivity(openQ2);
    }

    public void saveViewStatus(){
        editTextText = quiz03TextAnswer.getText().toString();
        editTextIsEnabled = quiz03TextAnswer.isEnabled();
    }
}
