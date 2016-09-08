package edu.uwyo.toddt.helloworldplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity implements HelloFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);


        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new HelloFragment())
                .commit();

    }

    @Override
    public void onFragmentInteraction(String name){
        Log.d("HelloActivity", "Logged Name: " + name);
    }
}
