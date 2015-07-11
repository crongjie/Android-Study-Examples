package com.example.test.testapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    Button btn_test;
    TextView txt_test;
    EditText tf_test;

    //integer variables
    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Assign the TextView defined in layout XML to variable txt_test
        txt_test = (TextView) findViewById(R.id.txt_test);

        //2. Assign the EditText(Text Field) defined in layout XML to variable tf_test
        tf_test  = (EditText) findViewById(R.id.tf_test);

        // 3. Assign the Button defined in layout XML to variable btn_test
        btn_test = (Button) findViewById(R.id.btn_test);

        //Add OnClick Listener to button
        btn_test.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txt_test.setText("Test " + tf_test.getText() + " " + (++num));
            }
        });
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