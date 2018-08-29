package com.example.dimap.calck02;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView, textView2, textView3;
    Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonDelete, buttonConfirm;
    EditText editText;
    DataToTask dataToTask = new DataToTask();
    Randomise randomise = new Randomise();
    private SharedPreferences sPref;
    CheckingResult checkingResult = new CheckingResult();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView = findViewById(R.id.textView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        textView2 = findViewById(R.id.textView2);
        


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        saveData.loadEquation();
        createAndSetEquation();


        textView.setText(dataToTask.setText());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonConfirm:
                        try {
                            if (dataToTask.getResult() == checkingResult.setCheckingResult()) {
                                Toast toast = Toast.makeText(MainActivity.this, "Вірно!!!", Toast.LENGTH_SHORT);
                                toast.show();
                                createNEWAndSetEquation();
                                saveData.loadEquation();
                                textView.setText(dataToTask.setText());
                                checkingResult.setResult();
                                textView2.setText(checkingResult.getResult());

                            } else {
                                Toast toast = Toast.makeText(MainActivity.this, "Ви помилилися, спробуйте ще", Toast.LENGTH_SHORT);
                                toast.show();
                                checkingResult.setResult();
                                textView2.setText(checkingResult.getResult());
                            }
                        } catch (NumberFormatException ex) {}

                        break;
                    case R.id.buttonDelete:
                        checkingResult.setResult();
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button0:
                        checkingResult.setResult("0");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button1:
                        checkingResult.setResult("1");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button2:
                        checkingResult.setResult("2");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button3:
                        checkingResult.setResult("3");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button4:
                        checkingResult.setResult("4");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button5:
                        checkingResult.setResult("5");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button6:
                        checkingResult.setResult("6");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button7:
                        checkingResult.setResult("7");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button8:
                        checkingResult.setResult("8");
                        textView2.setText(checkingResult.getResult());
                        break;
                    case R.id.button9:
                        checkingResult.setResult("9");
                        textView2.setText(checkingResult.getResult());
                        break;

                }

            }
        };


        buttonConfirm.setOnClickListener(onClickListener);
        buttonDelete.setOnClickListener(onClickListener);
        button0.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
        button9.setOnClickListener(onClickListener);

    }

    SaveData saveData = new SaveData() {
        @Override
        public void saveDataToLocalFile() {
            sPref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putInt("number1", dataToTask.getA());
            ed.putInt("number2", dataToTask.getB());
            ed.putInt("number3", dataToTask.getC());
            ed.apply();
        }

        @Override
        public void loadEquation() {
            sPref = getPreferences(MODE_PRIVATE);
            dataToTask.setA(sPref.getInt("number1", 0));
            dataToTask.setB(sPref.getInt("number2", 0));
            dataToTask.setC(sPref.getInt("number3", 0));

        }
    };

    private void createAndSetEquation() {
        if (dataToTask.getA() == 0) {
            dataToTask.setA(randomise.randomize());
            dataToTask.setB(randomise.randomize());
            dataToTask.setC(randomise.randomize());
            saveData.saveDataToLocalFile();
        }
    }

    private void createNEWAndSetEquation() {

        dataToTask.setA(randomise.randomize());
        dataToTask.setB(randomise.randomize());
        dataToTask.setC(randomise.randomize());
        saveData.saveDataToLocalFile();

    }

}

