package com.example.test_activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.app.Activity;

public class MainActivity extends ActionBarActivity {

    TextView txt_result;
    Button btn_start_another_activity;
    MainActivity currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentActivity = this;
        // Assign the TextView defined in layout XML to variable txt_result
        txt_result = (TextView) findViewById(R.id.txt_result);

        // Assign the Button defined in layout XML to variable btn_start_another_activity
        btn_start_another_activity = (Button) findViewById(R.id.btn_start_another_activity);

        //Add OnClick Listener to button
        btn_start_another_activity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent_another_activity = new Intent(currentActivity, TestAnotherActivity.class);

                //Send current txt_result's value to new Activity(TestAnotherActivity)
                intent_another_activity.putExtra("inputText", txt_result.getText());
                //Start Activity
                startActivityForResult(intent_another_activity, 0);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            //get input text from TestAnotherActivity
            String input_Text = data.getStringExtra("inputText");
            txt_result.setText(input_Text);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
