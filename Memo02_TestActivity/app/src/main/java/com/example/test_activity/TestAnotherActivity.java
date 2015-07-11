package com.example.test_activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TestAnotherActivity extends ActionBarActivity {


    EditText tf_input;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_another);

        //Assign the EditText(Text Field) defined in layout XML to variable tf_input
        tf_input  = (EditText) findViewById(R.id.tf_input);

        // Assign the Button defined in layout XML to variable btn_test
        btn_ok = (Button) findViewById(R.id.btn_ok);



        //Add OnClick Listener to button
        btn_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent result = getIntent();
                result.putExtra("inputText", tf_input.getText().toString());
                setResult(Activity.RESULT_OK, result);

                finish();
            }
        });


        Intent intent_current = getIntent();
        tf_input.setText(intent_current.getStringExtra("inputText"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_another, menu);
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
