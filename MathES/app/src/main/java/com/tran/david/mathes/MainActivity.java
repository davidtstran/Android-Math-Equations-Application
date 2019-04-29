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
            case R.id.menu_course:
                setContentView(R.layout.courses);
                return true;
            case R.id.menu_calculator:
                setContentView(R.layout.calculator);
                return true;
            case R.id.menu_about:
                setContentView(R.layout.about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void course_button(View vw){ equation = ""; setContentView(R.layout.courses); }
    public void gcalc_button(View vw){ equation = ""; setContentView(R.layout.graphing_calculator); }
    public void forum_button(View vw){ setContentView(R.layout.forum); }
    public void about_button(View vw){ setContentView(R.layout.about); }

    /* Linear Algebra Section */
    public void linalg_button(View vw){ setContentView(R.layout.linear_algebra); equationInput = (EditText) findViewById(R.id.getEquation); }
    public void rref_button(View vw){

    }
    public void det_button(View vw){

    }
    /////////

    /* Calculus 1 Section */
    public void calculus_button(View vw){
        equation = "";
        setContentView(R.layout.calculus);
        equationInput = (EditText) findViewById(R.id.getEquation);
    }
    public void deriv_button(View vw){
        TextView soln = (TextView) findViewById(R.id.solution);
        equation = equationInput.getText().toString();
        String printSteps = "Derivative of " + equation + ":\n";
        String solutionE = "";
        // solve derivative here
        String[] equationArray = equation.split("\\+");
        for (int i = 0; i < equationArray.length; i++) {
            int var_x = equationArray[i].indexOf("x");
            int constantE = Integer.parseInt(equationArray[i].substring(0, var_x));
            int exponentE = Integer.parseInt(equationArray[i].substring(var_x + 2, equationArray[i].length()));
            // process
            printSteps += "(" + Integer.toString(constantE) + "*" + Integer.toString(exponentE) + ")";
            printSteps += "x^" + "(" + Integer.toString(exponentE) + "-1)";
            // solution
            solutionE += Integer.toString(constantE * exponentE) + "x^";
            solutionE += Integer.toString(exponentE - 1);
            if (i != equationArray.length - 1){
                printSteps += " + ";
                solutionE += " + ";
            }
        }
        soln.setText(printSteps + "\nSolution:\n" + solutionE);
    }

    public void integ_button(View vw){
        TextView soln = (TextView) findViewById(R.id.solution);
        equation = equationInput.getText().toString();
        String printSteps = "Integral of " + equation + ":\n";
        String solutionE = "";
        // solve derivative here
        String[] equationArray = equation.split("\\+");
        for (int i = 0; i < equationArray.length; i++) {
            int var_x = equationArray[i].indexOf("x");
            double constantE = Double.parseDouble(equationArray[i].substring(0, var_x));
            double exponentE = Double.parseDouble(equationArray[i].substring(var_x + 2, equationArray[i].length()));
            // process
            printSteps += "(" + Double.toString(constantE) + "/" + Double.toString(exponentE+1) + ")";
            printSteps += "x^" + "(" + Double.toString(exponentE) + "+1)";
            // solution
            solutionE += Double.toString(constantE / (exponentE+1)) + "x^";
            solutionE += Double.toString(exponentE + 1);
            if (i != equationArray.length - 1){
                printSteps += " + ";
                solutionE += " + ";
            }
        }
        soln.setText(printSteps + "\nSolution:\n" + solutionE + " + C");
    }
    /////////

    public void done_button(View vw){
        equation = equationInput.getText().toString();
        TextView soln = (TextView) findViewById(R.id.solution);
        soln.setText(equation);
    }

    /* Calculator Button */
    public void calc_button(View vw){ equation = ""; setContentView(R.layout.calculator); }
    public void sin_button(View vw){ equation += " sin"; print_to_screen(vw);}
    public void cos_button(View vw){ equation += " cos"; print_to_screen(vw);}
    public void tan_button(View vw){ equation += " tan"; print_to_screen(vw);}
    public void reset_button(View vw){ equation = ""; print_to_screen(vw);}
    public void log_button(View vw){ equation += " log"; print_to_screen(vw);}
    public void ln_button(View vw){ equation += " ln"; print_to_screen(vw);}
    public void e_button(View vw){ equation += " e^"; print_to_screen(vw);}
    public void x_to_y_button(View vw){ equation += "^"; print_to_screen(vw);}
    public void sqrt_x_button(View vw){ equation += " sqrt "; print_to_screen(vw);}
    public void x_to_2_button(View vw){ equation += "^2"; print_to_screen(vw);}
    public void division_button(View vw){ equation += "/"; print_to_screen(vw);}
    public void multiplication_button(View vw){ equation += "*"; print_to_screen(vw);}
    public void subtraction_button(View vw){ equation += "-"; print_to_screen(vw);}
    public void addition_button(View vw){ equation += "+"; print_to_screen(vw);}
    public void one_button(View vw){ equation += "1"; print_to_screen(vw);}
    public void two_button(View vw){ equation += "2"; print_to_screen(vw);}
    public void three_button(View vw){ equation += "3"; print_to_screen(vw);}
    public void four_button(View vw){ equation += "4"; print_to_screen(vw);}
    public void five_button(View vw){ equation += "5"; print_to_screen(vw);}
    public void six_button(View vw){ equation += "6"; print_to_screen(vw);}
    public void seven_button(View vw){ equation += "7"; print_to_screen(vw);}
    public void eight_button(View vw){ equation += "8"; print_to_screen(vw);}
    public void nine_button(View vw){ equation += "9"; print_to_screen(vw);}
    public void zero_button(View vw){ equation += "0"; print_to_screen(vw);}
    public void decimal_button(View vw){ equation += "."; print_to_screen(vw);}
    public void negative_button(View vw){ equation += "-"; print_to_screen(vw);}
    public void equal_button (View vw){
        print_to_screen(vw);
    }
    public void print_to_screen(View vw){
        TextView calcSoln = (TextView) findViewById(R.id.calcSolution);
        calcSoln.setText(equation);
    }

    /////////
}
