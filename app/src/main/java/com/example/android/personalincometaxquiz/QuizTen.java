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

public class QuizTen extends AppCompatActivity {

    public static final String QUIZ_10_ANSWER_A_CLICKABLE_KEY = "quiz_02_answer_a_clickable_key";
    public static final String QUIZ_10_ANSWER_B_CLICKABLE_KEY = "quiz_02_answer_b_clickable_key";
    public static final String QUIZ_10_ANSWER_C_CLICKABLE_KEY = "quiz_02_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public CheckBox quiz10Answer_A;
    public CheckBox quiz10Answer_B;
    public CheckBox quiz10Answer_C;
    public ImageView nextIconImage;
    public Button quizTenSubmiteButton;
    public static boolean isSubmiteButtonClicked;

    private static boolean quiz10Answer_a_isClickable = true;
    private static boolean quiz10Answer_b_isClickable = true;
    private static boolean quiz10Answer_c_isClickable = true;
    private static boolean quiz10Answer_a_isChecked;
    private static boolean quiz10Answer_b_isChecked;
    private static boolean quiz10Answer_c_isChecked;
    private static int quiz10Answer_a_bg_color;
    private static int quiz10Answer_b_bg_color;
    private static int quiz10Answer_c_bg_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_ten);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz10Answer_A = findViewById(R.id.quiz_10_answer_a);
        quiz10Answer_B = findViewById(R.id.quiz_10_answer_b);
        quiz10Answer_C = findViewById(R.id.quiz_10_answer_c);
        quizTenSubmiteButton = findViewById(R.id.quiz_ten_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_10_ANSWER_A_CLICKABLE_KEY))
                quiz10Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_10_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_10_ANSWER_B_CLICKABLE_KEY))
                quiz10Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_10_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_10_ANSWER_C_CLICKABLE_KEY))
                quiz10Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_10_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz10Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz10Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz10Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(SUBMITE_BUTTON_STATUS_KEY))
                isSubmiteButtonClicked = savedInstanceState.getBoolean(SUBMITE_BUTTON_STATUS_KEY);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_10_ANSWER_A_CLICKABLE_KEY, quiz10Answer_A.isClickable());
        outState.putBoolean(QUIZ_10_ANSWER_B_CLICKABLE_KEY, quiz10Answer_B.isClickable());
        outState.putBoolean(QUIZ_10_ANSWER_C_CLICKABLE_KEY, quiz10Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz10Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz10Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz10Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);

        saveViewStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        quiz10Answer_A.setClickable(quiz10Answer_a_isClickable);
        quiz10Answer_B.setClickable(quiz10Answer_b_isClickable);
        quiz10Answer_C.setClickable(quiz10Answer_c_isClickable);

        quiz10Answer_A.setChecked(quiz10Answer_a_isChecked);
        quiz10Answer_B.setChecked(quiz10Answer_b_isChecked);
        quiz10Answer_C.setChecked(quiz10Answer_c_isChecked);

        quiz10Answer_A.setBackgroundColor(quiz10Answer_a_bg_color);
        quiz10Answer_B.setBackgroundColor(quiz10Answer_b_bg_color);
        quiz10Answer_C.setBackgroundColor(quiz10Answer_c_bg_color);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        openQ9Activity();
    }

    public void quizTenSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;

        if (quizTenAnswerVariation().equals("a")){
            Toast answer_a = Toast.makeText(QuizTen.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz10Answer_A.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[9] = quizTenAnswerVariation();
        } else if (quizTenAnswerVariation().equals("b")){
            Toast answer_a = Toast.makeText(QuizTen.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz10Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[9] = quizTenAnswerVariation();
        } else if (quizTenAnswerVariation().equals("c")){
            Toast answer_a = Toast.makeText(QuizTen.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz10Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[9] = quizTenAnswerVariation();
        } else if (quizTenAnswerVariation().equals("ab")){
            Toast answer_a = Toast.makeText(QuizTen.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz10Answer_A.setBackgroundColor(Color.GREEN);
            quiz10Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[9] = quizTenAnswerVariation();
        } else if (quizTenAnswerVariation().equals("ac")){
            Toast answer_a = Toast.makeText(QuizTen.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz10Answer_A.setBackgroundColor(Color.GREEN);
            quiz10Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[9] = quizTenAnswerVariation();
        } else if (quizTenAnswerVariation().equals("bc")){
            Toast answer_a = Toast.makeText(QuizTen.this, R.string.submite_three_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz10Answer_B.setBackgroundColor(Color.GREEN);
            quiz10Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[9] = quizTenAnswerVariation();
        } else if (quizTenAnswerVariation().equals("abc")){
            Toast answer_a = Toast.makeText(QuizTen.this, R.string.submite_all_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            quiz10Answer_A.setBackgroundColor(Color.GREEN);
            quiz10Answer_B.setBackgroundColor(Color.GREEN);
            quiz10Answer_C.setBackgroundColor(Color.GREEN);
            Evaluation.quizAnswers[9] = quizTenAnswerVariation();
        } else if (quizTenAnswerVariation().equals("")){
            Toast answer_a = Toast.makeText(QuizTen.this, R.string.submite_no_answer, Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[9] = quizTenAnswerVariation();
        }
    }

    public String quizTenAnswerVariation(){
        if (quiz10Answer_A.isChecked() && !quiz10Answer_B.isChecked() && !quiz10Answer_C.isChecked()){
            return "a"; //There is three correct answers //1 point
        } else if (quiz10Answer_B.isChecked() && !quiz10Answer_A.isChecked() && !quiz10Answer_C.isChecked()){
            return "b"; //There is three correct answers //1 point
        } else if (quiz10Answer_C.isChecked() && !quiz10Answer_A.isChecked() && !quiz10Answer_B.isChecked()){
            return "c"; //There is three correct answers //1 point
        } else if (quiz10Answer_A.isChecked() && quiz10Answer_B.isChecked() && !quiz10Answer_C.isChecked()){
            return "ab"; //There is three correct answers //2 point
        } else if (quiz10Answer_A.isChecked() && quiz10Answer_C.isChecked() && !quiz10Answer_B.isChecked()){
            return "ac"; //There is three correct answers //2 point
        } else if (quiz10Answer_B.isChecked() && quiz10Answer_C.isChecked() && !quiz10Answer_A.isChecked()){
            return "bc"; //There is three correct answers //2 point
        } else if (quiz10Answer_A.isChecked() && quiz10Answer_B.isChecked() && quiz10Answer_C.isChecked()){
            return "abc"; //All of your answers are correct //3 point
        }
        return ""; //You haven’t choose any of the answers //0 point
    }

    public static void evaluateQuizTen(String[] quizAnswers,
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
        switch (quizAnswers[9]) {
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
        quiz10Answer_A.setClickable(false);
        quiz10Answer_B.setClickable(false);
        quiz10Answer_C.setClickable(false);
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

    public void evaluationButtonClick(View v){
        if (isSubmiteButtonClicked){
            openEvaluationActivity();
        } else {
            Toast submiteButtonIsNotClicked = Toast.makeText(QuizTen.this, "You havent submited your last answer yet", Toast.LENGTH_SHORT);
            submiteButtonIsNotClicked.show();
        }
    }

    public void openEvaluationActivity(){
        saveViewStatus();
        Intent openEvaluation = new Intent(QuizTen.this, Evaluation.class);
        startActivity(openEvaluation);
    }

    public void openQ9Activity(){
        Intent openQ9 = new Intent(this, QuizNine.class);
        startActivity(openQ9);
    }

    public void saveViewStatus(){
        quiz10Answer_a_isClickable = quiz10Answer_A.isClickable();
        quiz10Answer_b_isClickable = quiz10Answer_B.isClickable();
        quiz10Answer_c_isClickable = quiz10Answer_C.isClickable();

        quiz10Answer_a_isChecked = quiz10Answer_A.isChecked();
        quiz10Answer_b_isChecked = quiz10Answer_B.isChecked();
        quiz10Answer_c_isChecked = quiz10Answer_C.isChecked();

        quiz10Answer_a_bg_color = getQuizAnswrBGColor(quiz10Answer_A);
        quiz10Answer_b_bg_color = getQuizAnswrBGColor(quiz10Answer_B);
        quiz10Answer_c_bg_color = getQuizAnswrBGColor(quiz10Answer_C);
    }
}
