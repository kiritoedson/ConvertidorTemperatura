package com.example.edson.ejerciciosem4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    SeekBar bar;
    TextView txt,txt2;
    Button boton;
    RadioButton r1,r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar=findViewById(R.id.seekBar);
        txt=findViewById(R.id.textView);
        txt2=findViewById(R.id.textView2);
        boton=findViewById(R.id.button);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);

        bar.setOnSeekBarChangeListener(this);

        if (r1.isChecked()==true){
            txt.setText("Temperatura: C");
            boton.setText("Convertir a F");
        }else if (r2.isChecked()==true){
            txt.setText("Temperatura: F");
            boton.setText("Convertir a C");
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int a=progress;
        if (r1.isChecked()==true){
            txt.setText("Temperatura: "+a+" C");
            boton.setText("Convertir a F");
        }else if (r2.isChecked()==true){
            txt.setText("Temperatura: "+a+" F");
            boton.setText("Convertir a C");
        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        int a=seekBar.getProgress();
        if (r1.isChecked()==true){
            txt.setText("Temperatura: "+a+" C");
            boton.setText("Convertir a F");
        }else if (r2.isChecked()==true){
            txt.setText("Temperatura: "+a+" F");
            boton.setText("Convertir a C");
        }

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        final int t=seekBar.getProgress();
        final double f=(((1.8)*t)+32);
        final double c=((t-32)/(1.8));
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r1.isChecked()==true){
                    txt.setText("Temperatura: "+t+" C");
                    boton.setText("Convertir a F");
                    txt2.setTextColor(Color.MAGENTA);
                    txt2.setText(t+"C"+" :: "+f+"F");
                }else if (r2.isChecked()==true){
                    txt.setText("Temperatura: "+t+" F");
                    boton.setText("Convertir a C");
                    txt2.setTextColor(Color.RED);
                    txt2.setText(t+"F"+" :: "+c+"C");
                }

            }
        });

    }
}
