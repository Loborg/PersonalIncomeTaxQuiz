package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class QuizSix extends AppCompatActivity {

    public static final String QUIZ_06_ANSWER_A_CLICKABLE_KEY = "quiz_01_answer_a_clickable_key";
    public static final String QUIZ_06_ANSWER_B_CLICKABLE_KEY = "quiz_01_answer_b_clickable_key";
    public static final String QUIZ_06_ANSWER_C_CLICKABLE_KEY = "quiz_01_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public CheckBox quiz06Answer_A;
    public CheckBox quiz06Answer_B;
    public CheckBox quiz06Answer_C;
    public ImageView nextIconImage;
    public static int nextIconImageColor = Color.LTGRAY;
    public Button quizSixSubmiteButton;
    public static boolean isSubmiteButtonClicked;

    private static boolean quiz06Answer_a_isClickable = true;
    private static boolean quiz06Answer_b_isClickable = true;
    private static boolean quiz06Answer_c_isClickable = true;
    private static boolean quiz06Answer_a_isChecked;
    private static boolean quiz06Answer_b_isChecked;
    private static boolean quiz06Answer_c_isChecked;
    private static int quiz06Answer_a_bg_color;
    private static int quiz06Answer_b_bg_color;
    private static int quiz06Answer_c_bg_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_six);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz06Answer_A = findViewById(R.id.quiz_06_answer_a);
        quiz06Answer_B = findViewById(R.id.quiz_06_answer_b);
        quiz06Answer_C = findViewById(R.id.quiz_06_answer_c);
        quizSixSubmiteButton = findViewById(R.id.quiz_six_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_06_ANSWER_A_CLICKABLE_KEY))
                quiz06Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_06_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_06_ANSWER_B_CLICKABLE_KEY))
                quiz06Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_06_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_06_ANSWER_C_CLICKABLE_KEY))
                quiz06Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_06_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz06Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz06Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz06Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(SUBMITE_BUTTON_STATUS_KEY))
                isSubmiteButtonClicked = savedInstanceState.getBoolean(SUBMITE_BUTTON_STATUS_KEY);
            if (savedInstanceState.containsKey(NEXT_ICON_IMAGE_COLOR_KEY))
                nextIconImageColor = savedInstanceState.getInt(NEXT_ICON_IMAGE_COLOR_KEY);
        }

        nextIconImage.setColorFilter(nextIconImageColor);
        nextIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubmiteButtonClicked) {
                    openQ7Activity();
                } else {
                    Toast submiteButtonNotClicked = Toast.makeText(QuizSix.this, "You haven submitted any answers yet", Toast.LENGTH_SHORT);
                    submiteButtonNotClicked.show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_06_ANSWER_A_CLICKABLE_KEY, quiz06Answer_A.isClickable());
        outState.putBoolean(QUIZ_06_ANSWER_B_CLICKABLE_KEY, quiz06Answer_B.isClickable());
        outState.putBoolean(QUIZ_06_ANSWER_C_CLICKABLE_KEY, quiz06Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz06Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz06Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz06Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);

        saveViewStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        quiz06Answer_A.setClickable(quiz06Answer_a_isClickable);
        quiz06Answer_B.setClickable(quiz06Answer_b_isClickable);
        quiz06Answer_C.setClickable(quiz06Answer_c_isClickable);

        quiz06Answer_A.setChecked(quiz06Answer_a_isChecked);
        quiz06Answer_B.setChecked(quiz06Answer_b_isChecked);
        quiz06Answer_C.setChecked(quiz06Answer_c_isChecked);

        quiz06Answer_A.setBackgroundColor(quiz06Answer_a_bg_color);
        quiz06Answer_B.setBackgroundColor(quiz06Answer_b_bg_color);
        quiz06Answer_C.setBackgroundColor(quiz06Answer_c_bg_color);

        nextIconImage.setColorFilter(nextIconImageColor);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        openQ5Activity();
    }

    public void quizSixSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);

        if (quizSixAnswerVariation().equals("a")){
            Toast answer_a = Toast.makeText(QuizSix.this, "There is one more correct answer", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz06Answer_A.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[5] = quizSixAnswerVariation();
        } else if (quizSixAnswerVariation().equals("b")){
            Toast answer_a = Toast.makeText(QuizSix.this, "Your answer is incorrect", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz06Answer_B.setBackgroundColor(Color.RED);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[5] = quizSixAnswerVariation();
        } else if (quizSixAnswerVariation().equals("c")){
            Toast answer_a = Toast.makeText(QuizSix.this, "There is one more correct answer", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz06Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[5] = quizSixAnswerVariation();
        } else if (quizSixAnswerVariation().equals("ab")){
            Toast answer_a = Toast.makeText(QuizSix.this, "Only one of your answers is correct", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz06Answer_A.setBackgroundColor(Color.GREEN);
            quiz06Answer_B.setBackgroundColor(Color.RED);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[5] = quizSixAnswerVariation();
        } else if (quizSixAnswerVariation().equals("ac")){
            Toast answer_a = Toast.makeText(QuizSix.this, "All of your answers are correct", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz06Answer_A.setBackgroundColor(Color.GREEN);
            quiz06Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[5] = quizSixAnswerVariation();
        } else if (quizSixAnswerVariation().equals("bc")){
            Toast answer_a = Toast.makeText(QuizSix.this, "Only one of your answers is correct", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz06Answer_B.setBackgroundColor(Color.RED);
            quiz06Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[5] = quizSixAnswerVariation();
        } else if (quizSixAnswerVariation().equals("abc")){
            Toast answer_a = Toast.makeText(QuizSix.this, "Only two of the answers are correct", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[5] = quizSixAnswerVariation();
        } else if (quizSixAnswerVariation().equals("")){
            Toast answer_a = Toast.makeText(QuizSix.this, "You haven’t choose any of the answers", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[5] = quizSixAnswerVariation();
        }
    }

    public String quizSixAnswerVariation(){
        if (quiz06Answer_A.isChecked() && !quiz06Answer_B.isChecked() && !quiz06Answer_C.isChecked()){
            return "a";  //There is one more correct answer //2 point
        } else if (quiz06Answer_B.isChecked() && !quiz06Answer_A.isChecked() && !quiz06Answer_C.isChecked()){
            return "b"; //Your answer is incorrect //0 point
        } else if (quiz06Answer_C.isChecked() && !quiz06Answer_A.isChecked() && !quiz06Answer_B.isChecked()){
            return "c"; //There is one more correct answer //2 point
        } else if (quiz06Answer_A.isChecked() && quiz06Answer_B.isChecked() && !quiz06Answer_C.isChecked()){
            return "ab"; //Only one of your answers is correct //2 point
        } else if (quiz06Answer_A.isChecked() && quiz06Answer_C.isChecked() && !quiz06Answer_B.isChecked()){
            return "ac"; //All of your answers are correct //3 point
        } else if (quiz06Answer_B.isChecked() && quiz06Answer_C.isChecked() && !quiz06Answer_A.isChecked()){
            return "bc"; //Only one of your answers is correct //2 point
        } else if (quiz06Answer_A.isChecked() && quiz06Answer_B.isChecked() && quiz06Answer_C.isChecked()){
            return "abc"; //Only two of the answers are correct //1 point
        }
        return ""; //You haven’t choose any of the answers //0 point
    }

    public void setAllCheckBoxNonClickable(){
        quiz06Answer_A.setClickable(false);
        quiz06Answer_B.setClickable(false);
        quiz06Answer_C.setClickable(false);
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

    public void openQ7Activity(){
        saveViewStatus();
        Intent openQuizSeven = new Intent(QuizSix.this, QuizSeven.class);
        startActivity(openQuizSeven);
    }

    public void openQ5Activity(){
        Intent openQ5 = new Intent(this, QuizFive.class);
        startActivity(openQ5);
    }

    public void saveViewStatus(){
        quiz06Answer_a_isClickable = quiz06Answer_A.isClickable();
        quiz06Answer_b_isClickable = quiz06Answer_B.isClickable();
        quiz06Answer_c_isClickable = quiz06Answer_C.isClickable();

        quiz06Answer_a_isChecked = quiz06Answer_A.isChecked();
        quiz06Answer_b_isChecked = quiz06Answer_B.isChecked();
        quiz06Answer_c_isChecked = quiz06Answer_C.isChecked();

        quiz06Answer_a_bg_color = getQuizAnswrBGColor(quiz06Answer_A);
        quiz06Answer_b_bg_color = getQuizAnswrBGColor(quiz06Answer_B);
        quiz06Answer_c_bg_color = getQuizAnswrBGColor(quiz06Answer_C);
    }
}
