package com.alpha.component.UIEoe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.alpha.component.app.R;

public class UIEoe extends ActionBarActivity implements View.OnClickListener{

    final static String TAG = "EoeExample";

    Button mButtonOne;
    Button mButtonTwo;
    Button mButtonThree;
    Button mButtonFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uieoe);

        mButtonOne = (Button)findViewById(R.id.button_one);
        mButtonTwo = (Button)findViewById(R.id.button_two);
        mButtonThree = (Button)findViewById(R.id.button_three);
        mButtonFour = (Button)findViewById(R.id.button_four);

        mButtonOne.setOnClickListener(this);
        mButtonTwo.setOnClickListener(this);
        mButtonThree.setOnClickListener(this);
        mButtonFour.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.uieoe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_one:
                Intent mIntentOne = new Intent(this,Example_one.class);
                startActivity(mIntentOne);
                break;
            case R.id.button_two:
                Intent mIntentTwo = new Intent(this,ExampleTwo.class);
                startActivity(mIntentTwo);
                break;
            case R.id.button_three:
                Intent mIntentThree = new Intent(this,ExampleThree.class);
                startActivity(mIntentThree);
                break;
            case R.id.button_four:
                Intent mIntentFour = new Intent(this,Lesson4Draw.class);
                startActivity(mIntentFour);
                break;
            default:
                Log.e(TAG, "no defined button");
        }

    }
}
