package com.example.takab.pinpon;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by takab on 2017/12/19.
 */

public class Game extends AppCompatActivity {

    private int num = 0;
    private int pinNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);


    }

    @Override
    protected void onStart() {
        super.onStart();

        int j;
        int pinNum = 0;
        Random rnd = new Random();
        num = rnd.nextInt(6);
        j=5;
        //num=5;
        buttonSet();
        question();
        answer();
        //reset(num);

    }


    //文字を消す
    private void reset() {

        Log.d("err", "reset");


        if (num == 0) {
            final TextView pinA1 = (TextView) findViewById(R.id.pinAA);
            pinA1.setText(null);
        } else if (num == 1) {
            final TextView pinB1 = (TextView) findViewById(R.id.pinB1);
            final TextView pinB2 = (TextView) findViewById(R.id.pinB2);

            pinB1.setText(null);
            pinB2.setText(null);
        } else if (num == 2) {
            final TextView pinB1 = (TextView) findViewById(R.id.pinB1);
            final TextView pinB2 = (TextView) findViewById(R.id.pinB2);

            pinB1.setText(null);
            pinB2.setText(null);
        } else if (num == 3) {
            final TextView pinC1 = (TextView) findViewById(R.id.pinC1);
            final TextView pinC2 = (TextView) findViewById(R.id.pinC2);
            final TextView pinC3 = (TextView) findViewById(R.id.pinC3);

            pinC1.setText(null);
            pinC2.setText(null);
            pinC3.setText(null);
        } else if (num == 4) {
            final TextView pinE1 = (TextView) findViewById(R.id.pinE1);
            final TextView pinE2 = (TextView) findViewById(R.id.pinE2);
            final TextView pinE3 = (TextView) findViewById(R.id.pinE3);
            final TextView pinE4 = (TextView) findViewById(R.id.pinE4);
            final TextView pinE5 = (TextView) findViewById(R.id.pinE5);

            pinE1.setText(null);
            pinE2.setText(null);
            pinE3.setText(null);
            pinE4.setText(null);
            pinE5.setText(null);
        } else if (num == 5) {
            final TextView pinD1 = (TextView) findViewById(R.id.pinD1);
            final TextView pinD2 = (TextView) findViewById(R.id.pinD2);
            final TextView pinD3 = (TextView) findViewById(R.id.pinD3);
            final TextView pinD4 = (TextView) findViewById(R.id.pinD4);

            pinD1.setText(null);
            pinD2.setText(null);
            pinD3.setText(null);
            pinD4.setText(null);

        }

        ImageView maru = (ImageView) findViewById(R.id.maru);
        //maru.setImageDrawable(null);

    }

    //答え合わせ
    private void answer() {

        //ここで判断
    }

    public void question() {
        Log.d("err", String.valueOf(num));

        if (num == 0) {
            pinNum++;
            pin();

        } else if (num == 1) {
            pinNum = 0;
            pinpon();
        } else if (num == 2) {
            pinNum = 0;
            ponpin();
        } else if (num == 3) {
            pinNum = 0;
            pinponpan();
        } else if (num == 4) {
            pinNum = 0;
            pinponpanponpin();
        } else if (num == 5) {
            pinNum = 0;
            pinponpanrice();
        }
    }

    private void buttonSet() {

        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);

        final HashMap<Integer, String> ButtonStrings = new HashMap<Integer, String>();
        ButtonStrings.put(0, "背すじ\n伸びてるやん！");
        ButtonStrings.put(1, "誰か\n来ましたよ！");
        ButtonStrings.put(2, "来ましたよ？\nだれか");
        ButtonStrings.put(3, "一個\n少ないな");
        ButtonStrings.put(4, "一個\n多いな");
        ButtonStrings.put(5, "ファミレスで\nピンポン\n押して店員さん\n呼んで\nハンバーグセット\n頼んでパン\norライスって\n聞かれてるやん！");


        final Random random = new Random();
        final int n;
        n = random.nextInt(6);

        int buttonAnswer = 0;
        final Random rnd = new Random();
        int r = rnd.nextInt(6);
        while (true) {
            r = rnd.nextInt(6);
            if (ButtonStrings.get(r) != null) {
                break;
            }
        }
        button1.setText(ButtonStrings.get(r));
        if (r == num) {
            buttonAnswer = 1;
        }
        ButtonStrings.remove(r);
        while (true) {
            r = rnd.nextInt(6);
            if (ButtonStrings.get(r) != null) {
                break;
            }
        }
        button2.setText(ButtonStrings.get(r));
        if (r == num) {
            buttonAnswer = 2;
        }
        ButtonStrings.remove(r);
        while (true) {
            r = rnd.nextInt(6);
            if (ButtonStrings.get(r) != null) {
                break;
            }
        }
        button3.setText(ButtonStrings.get(r));
        if (r == num) {
            buttonAnswer = 3;
        }
        ButtonStrings.remove(r);

        if (ButtonStrings.get(num) != null) {
            r = rnd.nextInt(3);
            if (r == 0) {
                button1.setText(ButtonStrings.get(num));
                buttonAnswer=1;
            }
            if (r == 1) {
                button2.setText(ButtonStrings.get(num));
                buttonAnswer=2;
            }
            if (r == 2) {
                button3.setText(ButtonStrings.get(num));
                buttonAnswer=3;
            }
        }
        //変数セットして


        final int finalButtonAnswer = buttonAnswer;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalButtonAnswer == 1) {
                    Log.d("err", "正解");
                    drawAnswer(true);
                    reset();
                    int n;

                    Random random1 = new Random();
                    num = random1.nextInt(6);
                    buttonSet();
                    question();
                } else {
                    Log.d("err", "不正解");
                    drawAnswer(false);
                    reset();
                    int n;
                    Random random1 = new Random();
                    num = random1.nextInt(6);
                    buttonSet();
                    question();
                }
            }
        });
        final int finalButtonAnswer1 = buttonAnswer;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalButtonAnswer1 == 2) {
                    Log.d("err", "正解");
                    drawAnswer(true);

                    reset();
                    int n;
                    Random random1 = new Random();
                    num = random1.nextInt(6);
                    buttonSet();
                    question();

                } else {
                    
                    Log.d("err", "不正解");
                    drawAnswer(false);
                    reset();
                    int n;
                    Random random1 = new Random();
                    num = random1.nextInt(6);
                    buttonSet();
                    question();

                }
            }
        });
        final int finalButtonAnswer2 = buttonAnswer;
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (finalButtonAnswer2 == 3) {
                    Log.d("err", "正解");
                    drawAnswer(true);
                  //  reset(num);
                    int n;
                    Random random1 = new Random();
                    num = random1.nextInt(6);
                    buttonSet();
                    question();

                } else {
                    Log.d("err", "不正解");

                    drawAnswer(false);
                   // reset(num);
                    int n;
                    Random random1 = new Random();
                    num = random1.nextInt(6);
                    buttonSet();
                    question();

                }
            }
        });
    }


    private void drawAnswer(final boolean b) {

        Log.d("err", "draw");
        ImageView maru = (ImageView) findViewById(R.id.maru);

        if (b) {
            Log.d("err", "maru");

            maru.setImageResource(R.drawable.maru);

            AlphaAnimation animation_alpha=new AlphaAnimation(1,0);
            animation_alpha.setDuration(1000);
            animation_alpha.setFillAfter(true);
            this.findViewById(R.id.maru).startAnimation(animation_alpha);


        } else {
            Log.d("err", "batu");
             maru.setImageResource(R.drawable.batu);

            AlphaAnimation animation_alpha=new AlphaAnimation(1,0);
            animation_alpha.setDuration(1000);
            animation_alpha.setFillAfter(true);
            this.findViewById(R.id.maru).startAnimation(animation_alpha);

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        Log.d("err", "enddraw");
        reset();
    }

    private void pinponpanrice() {

        final ResizeTextView pinD1 = findViewById(R.id.pinD1);
        final ResizeTextView pinD2 = findViewById(R.id.pinD2);
        final ResizeTextView pinD3 = findViewById(R.id.pinD3);
        final ResizeTextView pinD4 = findViewById(R.id.pinD4);


        pinD1.setModelText("ピンあ");
        pinD2.setModelText("ポンあ");
        pinD3.setModelText("パンあ");
        pinD4.setModelText("ライス");


        pinD1.setText("ピン");
        pinD2.setText("ポン");
        pinD3.setText("パン");
        pinD4.setText("ライス");

        /*AlphaAnimation animation_alpha=new AlphaAnimation(0,1);

        this.findViewById(R.id.pinD2).startAnimation(animation_alpha);
        animation_alpha.setStartOffset(500);

        this.findViewById(R.id.pinD3).startAnimation(animation_alpha);
        animation_alpha.setStartOffset(1000);

        this.findViewById(R.id.pinD4).startAnimation(animation_alpha);
*/
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinD2.setText("ポン");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinD3.setText("パン");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinD4.setText("ライス");
*/

    }

    private void pinponpanponpin() {

        final ResizeTextView pinE1 = findViewById(R.id.pinE1);
        final ResizeTextView pinE2 = findViewById(R.id.pinE2);
        final ResizeTextView pinE3 = findViewById(R.id.pinE3);
        final ResizeTextView pinE4 = findViewById(R.id.pinE4);
        final ResizeTextView pinE5 = findViewById(R.id.pinE5);

        pinE1.setModelText("ピン");
        pinE2.setModelText("ポン");
        pinE3.setModelText("パン");
        pinE4.setModelText("ピン");
        pinE5.setModelText("ポン");

        pinE1.setText("ピン");
        pinE2.setText("ポン");
        pinE3.setText("パン");
        pinE4.setText("ポン");
        pinE5.setText("ピン");

       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinE2.setText("ポン");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinE3.setText("パン");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinE4.setText("ポン");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinE4.setText("ポン");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinE5.setText("ピン");
*/

    }

    private void pinponpan() {

        final ResizeTextView pinC1 = findViewById(R.id.pinC1);
        final ResizeTextView pinC2 = findViewById(R.id.pinC2);
        final ResizeTextView pinC3 = findViewById(R.id.pinC3);

        pinC1.setModelText("ピン");
        pinC2.setModelText("ポン");
        pinC3.setModelText("パン");

        pinC1.setText("ピン");
        pinC2.setText("ポン");
        pinC3.setText("パン");

        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinC2.setText("ポン");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinC3.setText("パン");

*/
    }

    private void ponpin() {

        final ResizeTextView pinB1 = findViewById(R.id.pinB1);
        final ResizeTextView pinB2 = findViewById(R.id.pinB2);
        pinB1.setModelText("ピン");
        pinB2.setModelText("ポン");
        pinB1.setText("ポン");
        pinB2.setText("ピン");

       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        pinB2.setText("ピン");
*/
        //ここからクリックからのけす　
    }

    private void pinpon() {
        final ResizeTextView pinB1 = findViewById(R.id.pinB1);
        final ResizeTextView pinB2 = findViewById(R.id.pinB2);
        pinB1.setModelText("ピン");
        pinB2.setModelText("ポン");

        pinB1.setText("ピン");
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }*/
        pinB2.setText("ポン");
    }

    public void pin() {
        final ResizeTextView pinA1 = (ResizeTextView) findViewById(R.id.pinAA);

        Log.d("err", "pin");
        pinA1.setModelText("ピン");
       pinA1.setText("ピン");


        Log.d("err", "nul");
    }


}

