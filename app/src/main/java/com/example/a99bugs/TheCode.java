package com.example.a99bugs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TheCode extends AppCompatActivity implements View.OnClickListener
{
    private Button patchButton;
    private TextView bugsTextView;
    String bugsMessage;
    private static int numberOfBugs = 99;
    int takeDownNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_main);

        patchButton =  findViewById(R.id.patchButton);
        bugsTextView = findViewById(R.id.bugsTextView);

        patchButton.setOnClickListener(this);


    }
    @Override
    protected void onResume()
    {
        super.onResume();

        // Get the state sent from the main activity
        Intent intent = getIntent();
        takeDownNumber = intent.getIntExtra("TAKE_DOWN_NUMBER", 0);

        bugsTextView.setText(Integer.toString(numberOfBugs));

    }
    @Override
    public void onClick(View v)
    {
        if(takeDownNumber == 1)
            numberOfBugs--;
        else
            numberOfBugs -= 2;


        bugsMessage = numberOfBugs + " little bugs in the code";
        Intent returnIntent = new Intent(this, MainActivity.class);
        returnIntent.putExtra(MainActivity.BUGS_MESSAGE, bugsMessage);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
