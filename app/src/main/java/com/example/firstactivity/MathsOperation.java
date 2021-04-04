package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.firstactivity.R.id.num2;

public class MathsOperation extends Activity implements View.OnClickListener {
    TextView result;
    Button add,sub,mul,div;
    EditText num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_operaation);
        result= findViewById(R.id.result);
        add= findViewById(R.id.add);
        sub= findViewById(R.id.sub);
        mul= findViewById(R.id.mul);
        div= findViewById(R.id.div);
        num1= findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        sub.setOnClickListener(this);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double n1=Double.parseDouble(num1.getText().toString().trim());
        double n2=Double.parseDouble(num2.getText().toString().trim());
    switch (v.getId()){
        case R.id.sub:
            result.setText("ANSWER IS : "+(n1-n2));
            break;
        case R.id.add:
            result.setText("ANSWER IS : "+(n1+n2));
            break;
        case R.id.mul:
            result.setText("ANSWER IS : "+(n1*n2));
            break;
        case R.id.div:
            result.setText("ANSWER IS : "+(n1/n2));
            break;

    }
    }
}