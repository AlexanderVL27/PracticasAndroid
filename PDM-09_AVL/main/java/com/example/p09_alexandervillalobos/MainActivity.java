package com.example.p09_alexandervillalobos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbMarcame = (CheckBox)findViewById(R.id.ChkMarcame);
        TextView lblMensaje = findViewById(R.id.LblSeleccion);

        cbMarcame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked) {
                    cbMarcame.setText("Checkbox marcado!");
                }
                else {
                    cbMarcame.setText("Checkbox desmarcado!");
                }
            }
        });

        //CheckBox cbMarcame = (CheckBox)findViewById(R.id.ChkMarcame);

        //cbMarcame.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
        //public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //if (isChecked) {
        //cbMarcame.setText("Checkbox marcado!");
        //} else {
        //cbMarcame.setText("Checkbox desmarcado!");
        //}
        //}
        //});
        //RadioButton rbOpcion1 = findViewById(R.id.RbOpcion1);
        //RadioButton rbOpcion2 = findViewById(R.id.RbOpcion2);

        //View.OnClickListener list = new View.OnClickListener() {
        //@Override
        //public void onClick(View view) {
        //String opcion = "";
        //switch(view.getId()) {
        //case R.id.RbOpcion1:
        //opcion = "opción 1";
        //break;
        //case R.id.RbOpcion2:
        //opcion = "opción 2";
        //break;
        //}

        //lblMensaje.setText("ID opción seleccionada: " + opcion);
        //}
        //};

        RadioGroup rgOpciones = findViewById(R.id.GrbGrupo1);
        rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String opcion = "";
                switch(checkedId) {
                    case R.id.RbOpcion1:
                        opcion = "opción 1";
                        break;
                    case R.id.RbOpcion2:
                        opcion = "opción 2";
                        break;
                }

                lblMensaje.setText("ID opción seleccionada: " + opcion);
            }
        });


    }
}