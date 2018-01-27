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

public class QuizFour extends AppCompatActivity {

    public static final String QUIZ_04_ANSWER_A_CLICKABLE_KEY = "quiz_04_answer_a_clickable_key";
    public static final String QUIZ_04_ANSWER_B_CLICKABLE_KEY = "quiz_04_answer_b_clickable_key";
    public static final String QUIZ_04_ANSWER_C_CLICKABLE_KEY = "quiz_04_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public CheckBox quiz04Answer_A;
    public CheckBox quiz04Answer_B;
    public CheckBox quiz04Answer_C;
    public ImageView nextIconImage;
    public static int nextIconImageColor = Color.LTGRAY;
    public Button quizFourSubmiteButton;
    public static boolean isSubmiteButtonClicked;

    private static boolean quiz04Answer_a_isClickable = true;
    private static boolean quiz04Answer_b_isClickable = true;
    private static boolean quiz04Answer_c_isClickable = true;
    private static boolean quiz04Answer_a_isChecked;
    private static boolean quiz04Answer_b_isChecked;
    private static boolean quiz04Answer_c_isChecked;
    private static int quiz04Answer_a_bg_color;
    private static int quiz04Answer_b_bg_color;
    private static int quiz04Answer_c_bg_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_four);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz04Answer_A = findViewById(R.id.quiz_04_answer_a);
        quiz04Answer_B = findViewById(R.id.quiz_04_answer_b);
        quiz04Answer_C = findViewById(R.id.quiz_04_answer_c);
        quizFourSubmiteButton = findViewById(R.id.quiz_four_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_A_CLICKABLE_KEY))
                quiz04Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_B_CLICKABLE_KEY))
                quiz04Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_C_CLICKABLE_KEY))
                quiz04Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz04Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz04Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz04Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
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
                    openQ5Activity();
                } else {
                    Toast submiteButtonNotClicked = Toast.makeText(QuizFour.this, "You haven submitted any answers yet", Toast.LENGTH_SHORT);
                    submiteButtonNotClicked.show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_04_ANSWER_A_CLICKABLE_KEY, quiz04Answer_A.isClickable());
        outState.putBoolean(QUIZ_04_ANSWER_B_CLICKABLE_KEY, quiz04Answer_B.isClickable());
        outState.putBoolean(QUIZ_04_ANSWER_C_CLICKABLE_KEY, quiz04Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz04Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz04Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz04Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);

        saveViewStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        quiz04Answer_A.setClickable(quiz04Answer_a_isClickable);
        quiz04Answer_B.setClickable(quiz04Answer_b_isClickable);
        quiz04Answer_C.setClickable(quiz04Answer_c_isClickable);

        quiz04Answer_A.setChecked(quiz04Answer_a_isChecked);
        quiz04Answer_B.setChecked(quiz04Answer_b_isChecked);
        quiz04Answer_C.setChecked(quiz04Answer_c_isChecked);

        quiz04Answer_A.setBackgroundColor(quiz04Answer_a_bg_color);
        quiz04Answer_B.setBackgroundColor(quiz04Answer_b_bg_color);
        quiz04Answer_C.setBackgroundColor(quiz04Answer_c_bg_color);

        nextIconImage.setColorFilter(nextIconImageColor);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        openQ3Activity();
    }

    public void quizFourSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);

        if (quizFourAnswerVariation().equals("a")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_A.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[3] = quizFourAnswerVariation();
        } else if (quizFourAnswerVariation().equals("b")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[3] = quizFourAnswerVariation();
        } else if (quizFourAnswerVariation().equals("c")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[3] = quizFourAnswerVariation();
        } else if (quizFourAnswerVariation().equals("ab")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_A.setBackgroundColor(Color.GREEN);
            quiz04Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[3] = quizFourAnswerVariation();
        } else if (quizFourAnswerVariation().equals("ac")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_A.setBackgroundColor(Color.GREEN);
            quiz04Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[3] = quizFourAnswerVariation();
        } else if (quizFourAnswerVariation().equals("bc")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_B.setBackgroundColor(Color.GREEN);
            quiz04Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[3] = quizFourAnswerVariation();
        } else if (quizFourAnswerVariation().equals("abc")){
            Toast answer_a = Toast.makeText(QuizFour.this, "All of your answers are correct", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            quiz04Answer_A.setBackgroundColor(Color.GREEN);
            quiz04Answer_B.setBackgroundColor(Color.GREEN);
            quiz04Answer_C.setBackgroundColor(Color.GREEN);
            Evaluation.quizAnswers[3] = quizFourAnswerVariation();
        } else if (quizFourAnswerVariation().equals("")){
            Toast answer_a = Toast.makeText(QuizFour.this, "You haven’t choose any of the answers", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            Evaluation.quizAnswers[3] = quizFourAnswerVariation();
        }
    }

    public String quizFourAnswerVariation(){
        if (quiz04Answer_A.isChecked() && !quiz04Answer_B.isChecked() && !quiz04Answer_C.isChecked()){
            return "a"; //There is three correct answers //1 point
        } else if (quiz04Answer_B.isChecked() && !quiz04Answer_A.isChecked() && !quiz04Answer_C.isChecked()){
            return "b"; //There is three correct answers //1 point
        } else if (quiz04Answer_C.isChecked() && !quiz04Answer_A.isChecked() && !quiz04Answer_B.isChecked()){
            return "c"; //There is three correct answers //1 point
        } else if (quiz04Answer_A.isChecked() && quiz04Answer_B.isChecked() && !quiz04Answer_C.isChecked()){
            return "ab"; //There is three correct answers //2 point
        } else if (quiz04Answer_A.isChecked() && quiz04Answer_C.isChecked() && !quiz04Answer_B.isChecked()){
            return "ac"; //There is three correct answers //2 point
        } else if (quiz04Answer_B.isChecked() && quiz04Answer_C.isChecked() && !quiz04Answer_A.isChecked()){
            return "bc"; //There is three correct answers //2 point
        } else if (quiz04Answer_A.isChecked() && quiz04Answer_B.isChecked() && quiz04Answer_C.isChecked()){
            return "abc"; //All of your answers are correct //3 point
        }
        return ""; //You haven’t choose any of the answers //0 point
    }

    public static void evaluateQuizFour(String[] quizAnswers,
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
        switch (quizAnswers[3]) {
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
        quiz04Answer_A.setClickable(false);
        quiz04Answer_B.setClickable(false);
        quiz04Answer_C.setClickable(false);
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

    public void openQ5Activity(){
        saveViewStatus();
        Intent openQuizFive = new Intent(QuizFour.this, QuizFive.class);
        startActivity(openQuizFive);
    }

    public void openQ3Activity(){
        Intent openQ3 = new Intent(this, QuizThree.class);
        startActivity(openQ3);
    }

    public void saveViewStatus(){
        quiz04Answer_a_isClickable = quiz04Answer_A.isClickable();
        quiz04Answer_b_isClickable = quiz04Answer_B.isClickable();
        quiz04Answer_c_isClickable = quiz04Answer_C.isClickable();

        quiz04Answer_a_isChecked = quiz04Answer_A.isChecked();
        quiz04Answer_b_isChecked = quiz04Answer_B.isChecked();
        quiz04Answer_c_isChecked = quiz04Answer_C.isChecked();

        quiz04Answer_a_bg_color = getQuizAnswrBGColor(quiz04Answer_A);
        quiz04Answer_b_bg_color = getQuizAnswrBGColor(quiz04Answer_B);
        quiz04Answer_c_bg_color = getQuizAnswrBGColor(quiz04Answer_C);
    }
}
