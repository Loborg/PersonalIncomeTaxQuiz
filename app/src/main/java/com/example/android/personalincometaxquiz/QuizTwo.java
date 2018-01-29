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
import android.widget.TextView;
import android.widget.Toast;

public class QuizTwo extends AppCompatActivity {

    public static final String QUIZ_02_ANSWER_A_CLICKABLE_KEY = "quiz_02_answer_a_clickable_key";
    public static final String QUIZ_02_ANSWER_B_CLICKABLE_KEY = "quiz_02_answer_b_clickable_key";
    public static final String QUIZ_02_ANSWER_C_CLICKABLE_KEY = "quiz_02_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public CheckBox quiz02Answer_A;
    public CheckBox quiz02Answer_B;
    public CheckBox quiz02Answer_C;
    public ImageView nextIconImage;
    public static int nextIconImageColor = Color.LTGRAY;
    public Button quizTwoSubmiteButton;
    public static boolean isSubmiteButtonClicked;
    private static boolean quiz02Answer_a_isClickable = true;
    private static boolean quiz02Answer_b_isClickable = true;
    private static boolean quiz02Answer_c_isClickable = true;
    private static boolean quiz02Answer_a_isChecked;
    private static boolean quiz02Answer_b_isChecked;
    private static boolean quiz02Answer_c_isChecked;
    private static int quiz02Answer_a_bg_color;
    private static int quiz02Answer_b_bg_color;
    private static int quiz02Answer_c_bg_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_two);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz02Answer_A = findViewById(R.id.quiz_02_answer_a);
        quiz02Answer_B = findViewById(R.id.quiz_02_answer_b);
        quiz02Answer_C = findViewById(R.id.quiz_02_answer_c);
        quizTwoSubmiteButton = findViewById(R.id.quiz_two_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_02_ANSWER_A_CLICKABLE_KEY))
                quiz02Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_02_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_02_ANSWER_B_CLICKABLE_KEY))
                quiz02Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_02_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_02_ANSWER_C_CLICKABLE_KEY))
                quiz02Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_02_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz02Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz02Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz02Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
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
                    openQ3Activity();
                } else {
                    Toast submiteButtonNotClicked = Toast.makeText(QuizTwo.this, R.string.next_no_submite, Toast.LENGTH_SHORT);
                    submiteButtonNotClicked.show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_02_ANSWER_A_CLICKABLE_KEY, quiz02Answer_A.isClickable());
        outState.putBoolean(QUIZ_02_ANSWER_B_CLICKABLE_KEY, quiz02Answer_B.isClickable());
        outState.putBoolean(QUIZ_02_ANSWER_C_CLICKABLE_KEY, quiz02Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz02Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz02Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz02Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);

        saveViewStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        quiz02Answer_A.setClickable(quiz02Answer_a_isClickable);
        quiz02Answer_B.setClickable(quiz02Answer_b_isClickable);
        quiz02Answer_C.setClickable(quiz02Answer_c_isClickable);

        quiz02Answer_A.setChecked(quiz02Answer_a_isChecked);
        quiz02Answer_B.setChecked(quiz02Answer_b_isChecked);
        quiz02Answer_C.setChecked(quiz02Answer_c_isChecked);

        quiz02Answer_A.setBackgroundColor(quiz02Answer_a_bg_color);
        quiz02Answer_B.setBackgroundColor(quiz02Answer_b_bg_color);
        quiz02Answer_C.setBackgroundColor(quiz02Answer_c_bg_color);

        nextIconImage.setColorFilter(nextIconImageColor);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        openQ1Activity();
    }

    public void quizTwoSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);

        if (quizTwoAnswerVariation().equals("a")){
            Toast answer_a = Toast.makeText(QuizTwo.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz02Answer_A.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[1] = quizTwoAnswerVariation();
        } else if (quizTwoAnswerVariation().equals("b")){
            Toast answer_a = Toast.makeText(QuizTwo.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz02Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[1] = quizTwoAnswerVariation();
        } else if (quizTwoAnswerVariation().equals("c")){
            Toast answer_a = Toast.makeText(QuizTwo.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz02Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[1] = quizTwoAnswerVariation();
        } else if (quizTwoAnswerVariation().equals("ab")){
            Toast answer_a = Toast.makeText(QuizTwo.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz02Answer_A.setBackgroundColor(Color.GREEN);
            quiz02Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[1] = quizTwoAnswerVariation();
        } else if (quizTwoAnswerVariation().equals("ac")){
            Toast answer_a = Toast.makeText(QuizTwo.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz02Answer_A.setBackgroundColor(Color.GREEN);
            quiz02Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[1] = quizTwoAnswerVariation();
        } else if (quizTwoAnswerVariation().equals("bc")){
            Toast answer_a = Toast.makeText(QuizTwo.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz02Answer_B.setBackgroundColor(Color.GREEN);
            quiz02Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[1] = quizTwoAnswerVariation();
        } else if (quizTwoAnswerVariation().equals("abc")){
            Toast answer_a = Toast.makeText(QuizTwo.this, R.string.submite_all_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            quiz02Answer_A.setBackgroundColor(Color.GREEN);
            quiz02Answer_B.setBackgroundColor(Color.GREEN);
            quiz02Answer_C.setBackgroundColor(Color.GREEN);
            Evaluation.quizAnswers[1] = quizTwoAnswerVariation();
        } else if (quizTwoAnswerVariation().equals("")){
            Toast answer_a = Toast.makeText(QuizTwo.this, R.string.submite_no_answer, Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[1] = quizTwoAnswerVariation();
        }
    }

    public String quizTwoAnswerVariation(){
        if (quiz02Answer_A.isChecked() && !quiz02Answer_B.isChecked() && !quiz02Answer_C.isChecked()){
            return "a"; //There is three correct answers //1 point
        } else if (quiz02Answer_B.isChecked() && !quiz02Answer_A.isChecked() && !quiz02Answer_C.isChecked()){
            return "b"; //There is three correct answers //1 point
        } else if (quiz02Answer_C.isChecked() && !quiz02Answer_A.isChecked() && !quiz02Answer_B.isChecked()){
            return "c"; //There is three correct answers //1 point
        } else if (quiz02Answer_A.isChecked() && quiz02Answer_B.isChecked() && !quiz02Answer_C.isChecked()){
            return "ab"; //There is three correct answers //2 point
        } else if (quiz02Answer_A.isChecked() && quiz02Answer_C.isChecked() && !quiz02Answer_B.isChecked()){
            return "ac"; //There is three correct answers //2 point
        } else if (quiz02Answer_B.isChecked() && quiz02Answer_C.isChecked() && !quiz02Answer_A.isChecked()){
            return "bc"; //There is three correct answers //2 point
        } else if (quiz02Answer_A.isChecked() && quiz02Answer_B.isChecked() && quiz02Answer_C.isChecked()){
            return "abc"; //All of your answers are correct //3 point
        }
        return ""; //You haven’t choose any of the answers //0 point
    }

    public static void evaluateQuizTwo(String[] quizAnswers,
                                       TextView pointsForQuizTextView,
                                       TextView quizAnswer_a,
                                       TextView quizAnswer_b,
                                       TextView quizAnswer_c,
                                       int pointCounter,
                                       int red, int gray,
                                       int green,
                                       String zeroPoint,
                                       String onePoint,
                                       String twoPoint,
                                       String threePoint)
    {
        switch (quizAnswers[1]) {
            case "a":
                setBeckgroundColor(quizAnswer_a, green);
                setBeckgroundColor(quizAnswer_b, gray);
                setBeckgroundColor(quizAnswer_c, gray);
                pointsForQuizTextView.setText(onePoint);
                Evaluation.pointCounter = pointCounter + 1;
                break;
            case "b":
                setBeckgroundColor(quizAnswer_a, gray);
                setBeckgroundColor(quizAnswer_b, green);
                setBeckgroundColor(quizAnswer_c, gray);
                pointsForQuizTextView.setText(onePoint);
                Evaluation.pointCounter = pointCounter + 1;
                break;
            case "c":
                setBeckgroundColor(quizAnswer_a, gray);
                setBeckgroundColor(quizAnswer_b, gray);
                setBeckgroundColor(quizAnswer_c, green);
                pointsForQuizTextView.setText(onePoint);
                Evaluation.pointCounter = pointCounter + 1;
                break;
            case "ab":
                setBeckgroundColor(quizAnswer_a, green);
                setBeckgroundColor(quizAnswer_b, green);
                setBeckgroundColor(quizAnswer_c, gray);
                pointsForQuizTextView.setText(twoPoint);
                Evaluation.pointCounter = pointCounter + 2;
                break;
            case "ac":
                setBeckgroundColor(quizAnswer_a, green);
                setBeckgroundColor(quizAnswer_b, gray);
                setBeckgroundColor(quizAnswer_c, green);
                pointsForQuizTextView.setText(twoPoint);
                Evaluation.pointCounter = pointCounter + 2;
                break;
            case "bc":
                setBeckgroundColor(quizAnswer_a, gray);
                setBeckgroundColor(quizAnswer_b, green);
                setBeckgroundColor(quizAnswer_c, green);
                pointsForQuizTextView.setText(twoPoint);
                Evaluation.pointCounter = pointCounter + 2;
                break;
            case "abc":
                setBeckgroundColor(quizAnswer_a, green);
                setBeckgroundColor(quizAnswer_b, green);
                setBeckgroundColor(quizAnswer_c, green);
                pointsForQuizTextView.setText(threePoint);
                Evaluation.pointCounter = pointCounter + 3;
                break;
            case "":
                setBeckgroundColor(quizAnswer_a, gray);
                setBeckgroundColor(quizAnswer_b, gray);
                setBeckgroundColor(quizAnswer_c, gray);
                pointsForQuizTextView.setText(zeroPoint);
                break;
        }
    }

    public static void setBeckgroundColor(View quizTextView, int textViewBgColor){
        quizTextView.setBackgroundColor(textViewBgColor);
    }

    public void setAllCheckBoxNonClickable(){
        quiz02Answer_A.setClickable(false);
        quiz02Answer_B.setClickable(false);
        quiz02Answer_C.setClickable(false);
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

    public void openQ3Activity(){
        saveViewStatus();
        Intent openQuizThree = new Intent(QuizTwo.this, QuizThree.class);
        startActivity(openQuizThree);
    }

    public void openQ1Activity(){
        Intent openQ1 = new Intent(this, QuizOne.class);
        startActivity(openQ1);
    }

    public void saveViewStatus(){
        quiz02Answer_a_isClickable = quiz02Answer_A.isClickable();
        quiz02Answer_b_isClickable = quiz02Answer_B.isClickable();
        quiz02Answer_c_isClickable = quiz02Answer_C.isClickable();

        quiz02Answer_a_isChecked = quiz02Answer_A.isChecked();
        quiz02Answer_b_isChecked = quiz02Answer_B.isChecked();
        quiz02Answer_c_isChecked = quiz02Answer_C.isChecked();

        quiz02Answer_a_bg_color = getQuizAnswrBGColor(quiz02Answer_A);
        quiz02Answer_b_bg_color = getQuizAnswrBGColor(quiz02Answer_B);
        quiz02Answer_c_bg_color = getQuizAnswrBGColor(quiz02Answer_C);
    }
}
