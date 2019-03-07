package com.tran.david.mathes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String equation;
    EditText equationInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Creates menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handles item selection
        switch (item.getItemId()) {
            case R.id.menu_home:
                setContentView(R.layout.activity_main);
                return true;
            case R.id.menu_about:
                setContentView(R.layout.about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void course_button(View vw){
        setContentView(R.layout.courses);
    }
    public void calc_button(View vw){
        setContentView(R.layout.calculator);
    }
    public void gcalc_button(View vw){
        setContentView(R.layout.graphing_calculator);
    }
    public void forum_button(View vw){
        setContentView(R.layout.forum);
    }
    public void about_button(View vw){
        setContentView(R.layout.about);
    }
    public void linalg_button(View vw){
        setContentView(R.layout.linear_algebra);
        equationInput = (EditText) findViewById(R.id.getEquation);
    }
    public void calculus_button(View vw){
        setContentView(R.layout.calculus);
        equationInput = (EditText) findViewById(R.id.getEquation);
    }

    public void done_button(View vw){
        equation = equationInput.getText().toString();
        TextView soln = (TextView) findViewById(R.id.solution);
        soln.setText(equation);
    }
}
