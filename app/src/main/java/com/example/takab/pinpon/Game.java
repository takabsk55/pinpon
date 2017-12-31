package com.example.takab.pinpon;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by takab on 2017/12/19.
 */

public class Game extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);



    }
    @Override
    protected void onStart(){
        super.onStart();
        ExecutorService ex= Executors.newSingleThreadExecutor();

        for (int i=0;i<1000;i++) {
            int j;
            int pinNum=0;
            Random rnd = new Random();
            j = rnd.nextInt() % 6;
            ex.execute(new MyTask(j));
        }
    }

    private class MyTask implements Runnable {
        private int num=0;
        private int pinNum=0;
        public MyTask(int j){
            this.num=j;
        }
        public void run(){
            buttonSet(num);
            question(num);
            answer();
            reset(num);

        }
        //文字を消す
        private void reset(int num){
            if (num == 0) {
                final TextView pinA1=(TextView)findViewById(R.id.pinA1);
                pinA1.setText("");
            }else if (num==1){
                final TextView pinB1=(TextView)findViewById(R.id.pinB1);
                final TextView pinB2=(TextView)findViewById(R.id.pinB2);

                pinB1.setText("");
                pinB2.setText("");
            }else if (num==2){
                final TextView pinB1=(TextView)findViewById(R.id.pinB1);
                final TextView pinB2=(TextView)findViewById(R.id.pinB2);

                pinB1.setText("");
                pinB2.setText("");
            }else if (num==3){
                final TextView pinC1=(TextView)findViewById(R.id.pinC1);
                final TextView pinC2=(TextView)findViewById(R.id.pinC2);
                final TextView pinC3=(TextView)findViewById(R.id.pinC3);

                pinC1.setText("");
                pinC2.setText("");
                pinC3.setText("");
            }else if (num==4){
                final TextView pinE1=(TextView)findViewById(R.id.pinE1);
                final TextView pinE2=(TextView)findViewById(R.id.pinE2);
                final TextView pinE3=(TextView)findViewById(R.id.pinE3);
                final TextView pinE4=(TextView)findViewById(R.id.pinE4);
                final TextView pinE5=(TextView)findViewById(R.id.pinE5);

                pinE1.setText("");
                pinE2.setText("");
                pinE3.setText("");
                pinE4.setText("");
                pinE5.setText("");
            }else if (num==5){
                final TextView pinD1=(TextView)findViewById(R.id.pinD1);
                final TextView pinD2=(TextView)findViewById(R.id.pinD2);
                final TextView pinD3=(TextView)findViewById(R.id.pinD3);
                final TextView pinD4=(TextView)findViewById(R.id.pinD4);

                pinD1.setText("");
                pinD2.setText("");
                pinD3.setText("");
                pinD4.setText("");

            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    ImageView maru=(ImageView)findViewById(R.id.maru);
                    maru.setImageDrawable(null);
                }
            });
        }
        //答え合わせ
        private void answer(){

            //ここで判断
        }
        public void question(int num) {

            if (num == 0) {
                pinNum++;
                pin();

            }else if (num==1){
                pinNum=0;
                pinpon();
            }else if (num==2){
                pinNum=0;
                ponpin();
            }else if (num==3){
                pinNum=0;
                pinponpan();
            }else if (num==4){
                pinNum=0;
                pinponpanponpin();
            }else if (num==5){
                pinNum=0;
                pinponpanrice();
            }
        }
    }

    Handler handler=new Handler();

    private void buttonSet(final int num){
        final Button button1=(Button) findViewById(R.id.button1);
        final Button button2=(Button)findViewById(R.id.button2);
        final Button button3=(Button)findViewById(R.id.button3);

        final HashMap<Integer,String> ButtonStrings=new HashMap<Integer,String>();
        ButtonStrings.put(0,"背すじ\n伸びてるやん！");
        ButtonStrings.put(1,"誰か\n来ましたよ！");
        ButtonStrings.put(2,"来ましたよ？\nだれか");
        ButtonStrings.put(3,"一個\n少ないな");
        ButtonStrings.put(4,"一個\n多いな");
        ButtonStrings.put(5,"ファミレスで\nピンポン\n押して店員さん\n呼んで\nハンバーグセット\n頼んでパン\norライスって\n聞かれてるやん！");



        handler.post(new Runnable() {
            int buttonAnswer;
            @Override
            public void run() {
                Random rnd = new Random();
                int r = rnd.nextInt() % 6;
                while (true) {
                    r = rnd.nextInt()%6;
                    if (ButtonStrings.get(r)!=null){
                        break;
                    }
                }
                button1.setText(ButtonStrings.get(r));
                if (r==num){
                    buttonAnswer=1;
                }
                ButtonStrings.remove(r);
                while (true) {
                    r = rnd.nextInt()%6;
                    if (ButtonStrings.get(r)!=null){
                        break;
                    }
                }
                button2.setText(ButtonStrings.get(r));
                if (r==num){
                    buttonAnswer=2;
                }
                ButtonStrings.remove(r);
                while (true) {
                    r = rnd.nextInt()%6;
                    if (ButtonStrings.get(r)!=null){
                        break;
                    }
                }
                button3.setText(ButtonStrings.get(r));
                if (r==num){
                    buttonAnswer=3;
                }
                ButtonStrings.remove(r);

                if (ButtonStrings.get(num)!=null){
                    r=rnd.nextInt()%3;
                    if (r==0){
                        button1.setText(ButtonStrings.get(num));
                    }
                    if (r==1){
                        button2.setText(ButtonStrings.get(num));
                    }
                    if (r==2){
                        button3.setText(ButtonStrings.get(num));
                    }
                }
                //変数セットして
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (buttonAnswer==1){
                            Log.d("err","正解");
                            drawAnswer(true);

                        }else{
                            Log.d("err","不正解");
                            drawAnswer(false);

                        }
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (buttonAnswer==2){
                            Log.d("err","正解");
                            drawAnswer(true);

                        }else{
                            Log.d("err","不正解");
                            drawAnswer(false);

                        }
                    }
                });
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (buttonAnswer==3){
                            Log.d("err","正解");
                            drawAnswer(true);

                        }else{
                            Log.d("err","不正解");
                            drawAnswer(false);

                        }
                    }
                });
            }
        });


    }

    private void drawAnswer(final boolean b) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                ImageView maru=(ImageView)findViewById(R.id.maru);

                if (b){
                    maru.setImageResource(R.drawable.maru);

                }else{
                    maru.setImageResource(R.drawable.batu);
                }
            }
        });
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){}


    }

    private void pinponpanrice() {
        final TextView pinD1=(TextView)findViewById(R.id.pinD1);
        final TextView pinD2=(TextView)findViewById(R.id.pinD2);
        final TextView pinD3=(TextView)findViewById(R.id.pinD3);
        final TextView pinD4=(TextView)findViewById(R.id.pinD4);

        pinD1.setText("ピン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinD2.setText("ポン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinD3.setText("パン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinD4.setText("ライス");


    }

    private void pinponpanponpin() {
        final TextView pinE1=(TextView)findViewById(R.id.pinE1);
        final TextView pinE2=(TextView)findViewById(R.id.pinE2);
        final TextView pinE3=(TextView)findViewById(R.id.pinE3);
        final TextView pinE4=(TextView)findViewById(R.id.pinE4);
        final TextView pinE5=(TextView)findViewById(R.id.pinE5);

        pinE1.setText("ピン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinE2.setText("ポン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinE3.setText("パン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinE4.setText("ポン");

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinE4.setText("ポン");

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinE5.setText("ピン");


    }

    private void pinponpan() {
        final TextView pinC1=(TextView)findViewById(R.id.pinC1);
        final TextView pinC2=(TextView)findViewById(R.id.pinC2);
        final TextView pinC3=(TextView)findViewById(R.id.pinC3);

        pinC1.setText("ピン");

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinC2.setText("ポン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinC3.setText("パン");


    }

    private void ponpin() {
        final TextView pinB1=(TextView)findViewById(R.id.pinB1);
        final TextView pinB2=(TextView)findViewById(R.id.pinB2);

        pinB1.setText("ポン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
           pinB2.setText("ピン");

        //ここからクリックからのけす　
    }

    private void pinpon() {
        final TextView pinB1=(TextView)findViewById(R.id.pinB1);
        final TextView pinB2=(TextView)findViewById(R.id.pinB2);

        pinB1.setText("ピン");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        pinB2.setText("ポン");
    }

    public void pin(){
        final TextView pinA1=(TextView)findViewById(R.id.pinA1);

        Log.d("err","pin");
        pinA1.setText("ピン");


        Log.d("err","nul");
    }


}

