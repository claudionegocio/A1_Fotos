package br.com.claudionegocio.a1_fotos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static br.com.claudionegocio.a1_fotos.R.drawable.p01;

public class MainActivity extends AppCompatActivity {
    public Button button_a1;
    public Chronometer chronometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = (Chronometer) findViewById(R.id.chronometer2);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

        button_a1 = (Button) findViewById(R.id.button_a1);
        abreA1();
    }

    private void abreA1() {

        button_a1.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, a1.class));
                    }
                }

        );

    }
}
