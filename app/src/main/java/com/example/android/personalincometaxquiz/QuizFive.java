package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizFive extends AppCompatActivity {

    public static final String QUIZ_04_ANSWER_A_CLICKABLE_KEY = "quiz_04_answer_a_clickable_key";
    public static final String QUIZ_04_ANSWER_B_CLICKABLE_KEY = "quiz_04_answer_b_clickable_key";
    public static final String QUIZ_04_ANSWER_C_CLICKABLE_KEY = "quiz_04_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public RadioButton quiz05Answer_A;
    public RadioButton quiz05Answer_B;
    public RadioButton quiz05Answer_C;
    public ImageView nextIconImage;
    public int nextIconImageColor = Color.LTGRAY;
    public Button quizThreeSubmiteButton;
    public boolean isSubmiteButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_five);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz05Answer_A = findViewById(R.id.quiz_05_answer_a);
        quiz05Answer_B = findViewById(R.id.quiz_05_answer_b);
        quiz05Answer_C = findViewById(R.id.quiz_05_answer_c);
        quizThreeSubmiteButton = findViewById(R.id.quiz_five_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_A_CLICKABLE_KEY))
                quiz05Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_B_CLICKABLE_KEY))
                quiz05Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_C_CLICKABLE_KEY))
                quiz05Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz05Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz05Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz05Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(SUBMITE_BUTTON_STATUS_KEY))
                isSubmiteButtonClicked = savedInstanceState.getBoolean(SUBMITE_BUTTON_STATUS_KEY);
            if (savedInstanceState.containsKey(NEXT_ICON_IMAGE_COLOR_KEY))
                nextIconImageColor = savedInstanceState.getInt(NEXT_ICON_IMAGE_COLOR_KEY);
        }

        nextIconImage.setColorFilter(nextIconImageColor);
        if (isSubmiteButtonClicked){
            nextIconImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent openQuizTwo = new Intent(QuizFive.this, QuizSix.class);
                    startActivity(openQuizTwo);
                }
            });
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_04_ANSWER_A_CLICKABLE_KEY, quiz05Answer_A.isClickable());
        outState.putBoolean(QUIZ_04_ANSWER_B_CLICKABLE_KEY, quiz05Answer_B.isClickable());
        outState.putBoolean(QUIZ_04_ANSWER_C_CLICKABLE_KEY, quiz05Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz05Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz05Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz05Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);
    }

    public void beckIconClick(View v){
        Intent openQuizOne = new Intent(this, QuizFour.class);
        startActivity(openQuizOne);
    }

    public void quizFiveSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);
        nextIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openQuizTwo = new Intent(QuizFive.this, QuizSix.class);
                startActivity(openQuizTwo);
            }
        });
        if (quizFiveCorrectAnswer().equals("a")){
            Toast answer_a = Toast.makeText(QuizFive.this, "Your answer is incorrect", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz05Answer_A.setBackgroundColor(Color.RED);
            setAllRadioButtonNonClickable();
        } else if (quizFiveCorrectAnswer().equals("b")){
            Toast answer_a = Toast.makeText(QuizFive.this, "Your answer is correct", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz05Answer_B.setBackgroundColor(Color.GREEN);
            setAllRadioButtonNonClickable();
        } else if (quizFiveCorrectAnswer().equals("c")){
            Toast answer_a = Toast.makeText(QuizFive.this, "Your answer is incorrect", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz05Answer_C.setBackgroundColor(Color.RED);
            setAllRadioButtonNonClickable();
        } else if (quizFiveCorrectAnswer().equals("")){
            Toast answer_a = Toast.makeText(QuizFive.this, "You haven’t choose any of the answers", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllRadioButtonNonClickable();
        }
    }

    public String quizFiveCorrectAnswer(){
        if (quiz05Answer_A.isChecked()){
            return "a"; //Your answer is incorrect //0 point
        }

        if (quiz05Answer_B.isChecked()){
            return "b"; //Your answer is correct //3 point
        }

        if (quiz05Answer_C.isChecked()){
            return "c"; //Your answer is incorrect //0 point
        }
        return "";
    }

    public void setAllRadioButtonNonClickable(){
        quiz05Answer_A.setClickable(false);
        quiz05Answer_B.setClickable(false);
        quiz05Answer_C.setClickable(false);
    }

    public int getQuizAnswrBGColor(View quizAnswerView){
        int QuizAnswrColor = 0;
        Drawable answerBeckground = quizAnswerView.getBackground().mutate();
        if (answerBeckground instanceof ColorDrawable) {
            QuizAnswrColor = ((ColorDrawable) quizAnswerView.getBackground()).getColor();
            return QuizAnswrColor;
        }
        return QuizAnswrColor;
    }
}
