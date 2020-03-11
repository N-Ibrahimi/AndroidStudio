package com.example.perso;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button my_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//create button by XML
        my_button=findViewById(R.id.myBtn);
        my_button.setText("my name is nasim");
        my_button.animate();

//create button by code
        LinearLayout vue=new LinearLayout(this);
        Button btn=new Button(this);
        btn.setText("this button created by code in main activity");
        //        we can create the view and add button into it
        //         or add th button in existed view by referencing it by it's id
        //        vue.addView(btn);
        //        setContentView(vue) the blow code isn't completed
        findViewById(R.id.main);

        Toast.makeText(MainActivity.this, "on create =>" + this.getClass().getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();

        //create radioGroup
        RadioGroup radioGroup;
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        switch ( radioGroup.getCheckedRadioButtonId()) {
            case R.id.rdDSI:
                System.out.println(" *************** DSI");
                break;
            case R.id.rdRSI:
                System.out.println(" ************** RSI");
                break;
            case R.id.rdMDW:
                System.out.println(" ****************** MDW");
                break;
        }


//create list view and assigne it the values
        ListView lv=(ListView) findViewById(R.id.lv);
        Spinner  sp=(Spinner)  findViewById(R.id.sp);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        lv.setAdapter(adapter);
        adapter.add("Nasim");
        adapter.add("reza");
        adapter.add("Ali");

        Button btn=(Button) findViewById(R.id.myBtn);
        btn.setOnClickListener(new View.OnClickListener() { // chaque method a une methode abstracte =>
            // ici onClick(), onLongClick(), FocusChange(), onTouch(),onItemSelected(), onNothingSelected()
            // chaque method a au moins un paramètre, ici view  qui représente la source de l'événement
            //les autre paramètres peuvent contenir un ensemble de données sur l'événement 
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Button a été cliqué" , Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "on stop =>" + this.getClass().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "on Destroy =>" + this.getClass().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "on pause =>" + this.getClass().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "on Restart =>" + this.getClass().getName(), Toast.LENGTH_SHORT).show();
    }
}
