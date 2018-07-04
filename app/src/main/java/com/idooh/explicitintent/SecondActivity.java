package com.idooh.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String message = getIntent().getStringExtra("nickname");
        TextView nickname = findViewById(R.id.extraData);
        nickname.setText(message);

        Person person = getIntent().getParcelableExtra("person");
        TextView personView = findViewById(R.id.personView);
        personView.setText(person.getFirstName() + " " +
                person.getLastName() + " " + person.getQualification());
    }
}
