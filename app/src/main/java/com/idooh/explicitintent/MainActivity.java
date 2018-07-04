package com.idooh.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //** Sample explicit Intent **//
        // This will open second Activity on button click
        Button btnSecondActivity = findViewById(R.id.btnSecondActivity);
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // target class is required on explicit intent (2nd param)
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("nickname", "Raizen");

                Person person = new Person();
                person.setFirstName("Raizeniorix");
                person.setLastName("Nana");
                person.setQualification("Student");

                intent.putExtra("person", person);
                startActivity(intent);
            }
        });

        //** Sample Implicit Intent **//
        // Implicit Intents are triggered via <intent-filter> tags from Manifest
        // intent-filter must have sub tags - action, category, data
        Button btnImplicit = findViewById(R.id.btnImplicit);
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.idooh.explicitintent");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.putExtra("nickname", "Onin");

                Person person = new Person();
                person.setFirstName("Jesus");
                person.setLastName("Nana");
                person.setQualification("Programmer");

                intent.putExtra("person", person);
                startActivity(intent);
            }
        });

    }

//    void onViewTextChanged(AccessibilityEvent accessibilityEvent, AccessibilityNodeInfo accessibilityNodeInfo) {
//        List text = accessibilityEvent.getText();
//        CharSequence latestText = (CharSequence) text.get(0);
//        Log.i(MY_TAG, latestText.toString());
//    }
}
