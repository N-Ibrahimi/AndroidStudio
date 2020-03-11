package com.example.perso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity {
    private EditText edNom;
    private Spinner spClass;
    private RadioGroup rdgroup;
    private SeekBar sbniveau;
    private Button btnAjouter;
    private ListView lvInscrir;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        /* initialisation des widgets */
       edNom= (EditText) findViewById(R.id.edNom);
       spClass=(Spinner) findViewById(R.id.spClasse);
       rdgroup=(RadioGroup) findViewById(R.id.rdgClub);
       sbniveau=(SeekBar) findViewById(R.id.sbNiveau);
       btnAjouter=(Button) findViewById(R.id.btnAjouter);
       lvInscrir=(ListView) findViewById(R.id.lvInscrir);
       adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
       lvInscrir.setAdapter(adapter);

//Ecouter
        edNom.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent){
                String s=edNom.getText().toString();
                edNom.setText(s.toUpperCase());
                edNom.setSelection(s.length());
                return false;
            }
        });
    spClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView,View view, int i,long l){
        Toast t=Toast.makeText(getApplicationContext(), "L"+(i+1), Toast.LENGTH_SHORT);
        t.show();
    }
    @Override
        public void onNothingSelected(AdapterView<?> adapterView){}
});

    rdgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Toast t=null;
            switch (checkedId){
                case R.id.musique:
                    t=Toast.makeText(getApplicationContext(),"musique",Toast.LENGTH_SHORT);
                    break;
                case R.id.sport:
                    t=Toast.makeText(getApplicationContext(),"Sport",Toast.LENGTH_SHORT);
                    break;
                case R.id.theatre:
                    t=Toast.makeText(getApplicationContext(),"Theatre",Toast.LENGTH_SHORT);
                    break;
            }
            t.show();
        }
    });

    sbniveau.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            Toast t=Toast.makeText(getApplicationContext(),""+progress,Toast.LENGTH_SHORT);
            t.show();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });

    btnAjouter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String  club=null;
           switch (rdgroup.getCheckedRadioButtonId()){
               case R.id.musique:club="musique"; break;
               case R.id.theatre:club="theatre"; break;
               case R.id.sport:club="sport"; break;
           }
    String s=edNom.getText().toString()+"|"+spClass.getSelectedItem().toString()+"|"+club+"|"+sbniveau.getProgress();
           adapter.add(s);
        }
    });

    lvInscrir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast t=Toast.makeText(getApplicationContext(),lvInscrir.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT);
        t.show();edNom.setText("");
        }
    });

    lvInscrir.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            adapter.remove(adapter.getItem(position));
            return false;
        }
    });
    }
}
