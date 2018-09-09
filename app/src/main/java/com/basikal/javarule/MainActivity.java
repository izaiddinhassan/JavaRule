package com.basikal.javarule;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Something";
    private EditText mNameView, mCreditView, mCashView;
    private Button mCalcButton;
    private Spinner mSpinnerFirst, mSpinnerCar;
    private TextView mResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameView = findViewById(R.id.etName);
        mCalcButton = findViewById(R.id.btnSubmit);
        mResultView = findViewById(R.id.tvResult);
        mSpinnerFirst = findViewById(R.id.spFirst);
        mSpinnerCar = findViewById(R.id.spCar);

        //populate spinner value
        String[] spinnerValue={"Clear","Rain","Cloudy"};
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerValue);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        mSpinnerFirst.setAdapter(aa);

        //populate spinner value
        String[] spinnerValue2={"No","Yes"};
        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerValue2);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        mSpinnerCar.setAdapter(aa2);



        mCalcButton.setOnClickListener(this);

    }
    private void calc(){
        String name = mNameView.getText().toString().trim();
        String ruleFact = mSpinnerFirst.getSelectedItem().toString();
        String ruleFact2 = mSpinnerCar.getSelectedItem().toString();

        RuleBook FactResult = RuleBookBuilder.create(FactResult.class).withResultType(String.class)
                .withDefaultResult("-")
                .build();
        NameValueReferableMap facts = new FactMap();
        facts.setValue(name, new ApplicantBean(ruleFact,null,ruleFact2,null));
        FactResult.run(facts);

        FactResult.getResult().ifPresent(result -> mResultView.setText("Student "+name+" will: " + result));
    }

    @Override
    public void onClick(View v) {
        if(v == mCalcButton){
            calc();
        }
    }
}
