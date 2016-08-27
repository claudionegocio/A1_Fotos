package br.com.claudionegocio.a1_fotos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class a1 extends AppCompatActivity {
    public Chronometer ch;
    public RelativeLayout rl;
    public Runnable runnableCode;
    //public int isCLicked;

    public Button btnVoltar, btnBdg;
    private Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
        ch = (Chronometer) findViewById(R.id.c);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.start();
        btnVoltar = (Button) findViewById(R.id.button_voltar);
        btnBdg = (Button) findViewById(R.id.button_bgd);
        rl = (RelativeLayout) findViewById(R.id.activity_a1);
        abreMain();
        // mudarBgd();
        final Activity myActivity = this;
        final int[] teste = new int[1];

        final Handler handler = new Handler();
        // Define the code block to be executed
        runnableCode = new Runnable() {
            @Override
            public void run() {
                // Do something here on the main thread

                Log.d("Handlers", "Called on main thread");
                Random random = new Random();
                Integer number = random.nextInt(5);
               Integer img = 2130837584 + number;
                rl.setBackgroundResource(img);
                String myString = String.valueOf(img);
                Toast.makeText(a1.this, "id: " + myString, Toast.LENGTH_SHORT).show();
                handler.postDelayed(runnableCode, 5000);
            }
        };
// Start the initial runnable task by posting through the handler
        handler.post(runnableCode);


        /*thread=  new Thread(){
            @Override
            public void run(){

                try {
                    synchronized(this){
                        wait(5000);

                    }
                }

                catch(InterruptedException ex){
                }
                //teste[0] = 1;

               // rl.setBackgroundResource(R.drawable.p04);

                Toast.makeText(a1.this, "passei por aqui", Toast.LENGTH_LONG).show();
            }
        };

        thread.start();
    }*/
    }
    /*
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            synchronized(thread){
                thread.notifyAll();
            }
        }
        return true;
    }*/



   /* private void mudarBgdSozinho() throws InterruptedException {
        int isCLicked = 0;
        Handler delay = new Handler();
        Runnable startDelay;


        while (isCLicked <= 5) {
            isCLicked++;

            final int finalIsCLicked = isCLicked;


                    Random random = new Random();
                    Integer number = random.nextInt(5) + 4;
                    Integer img = 2130837583 + finalIsCLicked;
                    rl.setBackgroundResource(img);
                    String myString = String.valueOf(finalIsCLicked);
                    Toast.makeText(a1.this, myString, Toast.LENGTH_LONG).show();
               wait(5000);
                }






            rl.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            //isCLicked = 1;
                            Toast.makeText(a1.this, "clicado", Toast.LENGTH_LONG).show();
                        }
                    }

            );

            // }



    }

  /*  private void mudarBgd() {
        rl.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Random random = new Random();
                        Integer number = random.nextInt(5)+4;
                        Integer img = 2130837580+number;


                        rl.setBackgroundResource(img);

                        String myString = String.valueOf(img);
                        Toast.makeText(a1.this,myString,Toast.LENGTH_LONG).show();
                    }
                }

        );
    }*/

    private void abreMain() {

        btnVoltar.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(a1.this, MainActivity.class));
                    }
                }

        );


    }



}