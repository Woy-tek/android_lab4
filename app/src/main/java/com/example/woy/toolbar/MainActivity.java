package com.example.woy.toolbar;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    RadioGroup rg;

    TextView t1, t2, t3, s1, s2, s3;
    Button button;
    TableLayout tabL;
    TableRow tabR;

    int index = 0;
    int choice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

        rg = (RadioGroup) findViewById(R.id.radioGroup);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);

        button = (Button) findViewById(R.id.button);

        tabL = (TableLayout) findViewById(R.id.tabLayout);
        tabL.setColumnStretchable(0,true);
        tabL.setColumnStretchable(1,true);
        tabL.setColumnStretchable(2,true);
        tabL.removeAllViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.add:
                tabR = new TableRow(this);
                tabR.setId(index);
                index++;

                s1 = new TextView(this);
                s2 = new TextView(this);
                s3 = new TextView(this);

                int rid = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(rid);

                EditText e1 = (EditText) findViewById(R.id.editText);
                EditText e2 = (EditText) findViewById(R.id.editText2);
                s1.setText(e1.getText());
                s1.setTextSize(15);
                s1.setGravity(Gravity.CENTER);
                s2.setText(e2.getText());
                s2.setTextSize(15);
                s2.setGravity(Gravity.CENTER);
                s3.setText(rb.getText());
                s3.setTextSize(15);
                s3.setGravity(Gravity.CENTER);

                tabR.addView(s1);
                tabR.addView(s2);
                tabR.addView(s3);

                tabL.addView(tabR);


                tabR.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        //if(choice < tabL.getChildCount() && choice >= 0){
                            for(int i =0; i < tabL.getChildCount(); i++){
                            View lastView = tabL.getChildAt(i);
                            lastView.setBackgroundColor(Color.TRANSPARENT);
                            }
                       // }
                        choice = view.getId();
                        //Toast.makeText(getApplicationContext(), "value was "+choice,
                         //       Toast.LENGTH_SHORT).show();
                        //for(int i=0; i < tabL.getChildCount(); i++){
                         //   tabL.setBackgroundColor(Color.TRANSPARENT);
                        //}
                        view.setBackgroundColor(Color.GRAY);
                    }
                });

                return true;

            case R.id.delete:
                //Toast.makeText(MainActivity.this,"Delete Menu Selected: "+ choice/tabL.getChildCount(), Toast.LENGTH_SHORT).show();
                if(tabL.getChildCount() > 0){
                    for(int i =0; i < tabL.getChildCount(); i++){
                        View v = tabL.getChildAt(i);
                        int identifier = v.getId();
                        if(identifier == choice) tabL.removeViewAt(i);
                    }
                }
                //index--;
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.button:
                tabR = new TableRow(this);
                tabR.setId(index);
                index++;
                s1 = new TextView(this);
                s2 = new TextView(this);
                s3 = new TextView(this);

                int rid = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(rid);

                EditText e1 = (EditText) findViewById(R.id.editText);
                EditText e2 = (EditText) findViewById(R.id.editText2);
                s1.setText(e1.getText());
                s1.setTextSize(15);
                s1.setGravity(Gravity.CENTER);
                s2.setText(e2.getText());
                s2.setTextSize(15);
                s2.setGravity(Gravity.CENTER);
                s3.setText(rb.getText());
                s3.setTextSize(15);
                s3.setGravity(Gravity.CENTER);

                tabR.addView(s1);
                tabR.addView(s2);
                tabR.addView(s3);

                tabL.addView(tabR);

                tabR.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        //if(choice < tabL.getChildCount() && choice >= 0){
                        for(int i =0; i < tabL.getChildCount(); i++){
                            View lastView = tabL.getChildAt(i);
                            lastView.setBackgroundColor(Color.TRANSPARENT);
                        }
                        // }
                        choice = view.getId();
                        //Toast.makeText(getApplicationContext(), "value was "+choice,
                        //       Toast.LENGTH_SHORT).show();
                        //for(int i=0; i < tabL.getChildCount(); i++){
                        //   tabL.setBackgroundColor(Color.TRANSPARENT);
                        //}
                        view.setBackgroundColor(Color.GRAY);
                    }
                });

                break;
            default:
                break;
        }
    }
}
