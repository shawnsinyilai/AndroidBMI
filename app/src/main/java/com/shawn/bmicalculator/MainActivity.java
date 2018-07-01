package com.shawn.bmicalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button btn;
    TextView tv;
    double bmi,myweight,metersheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText4);
        et2=(EditText)findViewById(R.id.editText5);
        btn=(Button)findViewById(R.id.button2);
        tv=(TextView)findViewById(R.id.result);

    }
    public void calBmi(View view){

        String height= et1.getText().toString();
        String weight=et2.getText().toString();

        if(height != null && !"".equals(height) && weight != null && !"".equals( weight)){

            metersheight= Double.parseDouble(height)/100;
            // convert integer string to actual numerical value
            myweight=Double.parseDouble(weight);

            bmi=  myweight/Math.pow(metersheight,2);

            displayBmi(bmi);


        }else {Toast.makeText(getBaseContext(),
                "Enter your height and weight to compute your BMI", Toast.LENGTH_SHORT).show();}

    }
    private void displayBmi(double bmi){

        if(bmi!=0 && bmi>0){
            if(bmi<=18.5){
                tv.setText("You are Underweight "+"\n\n"+" Your BMI is "+Math.round(bmi));
            }else if (bmi>=18.5 && bmi<=24.9){
                tv.setText("You are Normal weight "+"\n\n"+" Your BMI is "+Math.round(bmi));

            }else if(bmi>=25 && bmi<=29.9 ){
                tv.setText("You are Overweight "+"\n\n"+" Your BMI is "+Math.round(bmi) );
            }else if(bmi>30){
                tv.setText("You are Obese "+"\n\n"+" Your BMI is "+Math.round(bmi) );
            }

        }else{

            Toast.makeText(getBaseContext(),
                    "invalid height or weight", Toast.LENGTH_SHORT).show();
        }

        closeKeyboard();
    }

        private void closeKeyboard(){
            View view= this.getCurrentFocus();
            if(view != null){
                InputMethodManager imm= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        }
}
  /*Underweight = <18.5
        Normal weight = 18.5–24.9
        Overweight = 25–29.9
        Obesity = BMI of 30 or greater*/
