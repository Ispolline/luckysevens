package com.classic.vullks.casinoslots;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements chooseDialogInterface {
    private int slotSelection1 = -1;
    private int slotSelection2 = -1;
    private int slotSelection3 = -1;
    private ImageView slotImageView1;
    private ImageView slotImageView2;
    private ImageView slotImageView3;
RelativeLayout increase;
    private TextView winsTextView;

    private Random r1 = new Random();
    private Random r2 = new Random();
    private Random r3 = new Random();
    private int winCount = 0;
    private int lossCount = 0;
    private int almostCount = 0;
    ImageView materialButton;
    private MediaPlayer tieSound;
    TextView textView;
    DialogFragment balanceDialog ;
    DialogFragment winDialog ;
    DialogFragment playDialog, questionDialog , increasePointsDialog;
    TextView plus, minus;
    ImageView question_mark;
    int balance= 1000;
    int points = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slotImageView1 = findViewById(R.id.slotImageView1);
        slotImageView2 = findViewById(R.id.slotImageView2);
        slotImageView3 = findViewById(R.id.slotImageView3);
plus    = findViewById(R.id.tv_plus);
minus = findViewById(R.id.tv_minus);
        winsTextView = findViewById(R.id.winsTextView);
increase = findViewById(R.id.mcv_click);
        textView = findViewById(R.id.balance1);
        materialButton = findViewById(R.id.mbtn_click);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotSelection1 = r1.nextInt(5);
                slotSelection2 = r2.nextInt(5);
                slotSelection3 = r3.nextInt(5);
                slotSelect(slotSelection1, slotSelection2, slotSelection3);
                delaySpin(20);
                balance=balance- points;
                textView.setText(String.valueOf(balance));
                 if(points==100){
                    winsTextView.setText(String.valueOf(5) );

                }
            }
        });
        increasePointsDialog = new IncreasePointsDialog(getApplicationContext(), this);
         balanceDialog = new BalanceDialog();
         winDialog = new WinDialog();
        questionDialog = new question_dialog(getApplicationContext(), this);
         playDialog = new PlayDialog( getApplicationContext(), this);
        question_mark = findViewById(R.id.iv_question);
        slotImageView1.setImageResource(R.mipmap.m11);
        slotImageView2.setImageResource(R.mipmap.m122);
        slotImageView3.setImageResource(R.mipmap.m133);
        tieSound = MediaPlayer.create(this, R.raw.chuckle);
        tieSound = MediaPlayer.create(this, R.raw.background_music);
     tieSound.start();

plus.setOnClickListener(v -> {
    if(points+5<=100 ){
 points+=5;
    winsTextView.setText(String.valueOf(points) );

  }

});
question_mark.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
questionDialog.show(getSupportFragmentManager(), "question");
    }
});
minus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(points-5 >=5){
       points-=5;
        winsTextView.setText( String.valueOf(points));
        }
    }
});
        balanceDialog.show(getSupportFragmentManager(), "balancedialog");
        new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                balanceDialog.dismiss();
                increasePointsDialog.show(getSupportFragmentManager(), "playdialog");
            }
        }.start();
    }

    public void delaySpin(int times){
        final Handler handler = new Handler();
        times--;
        final int timesTracker = times;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                slotSelection1 = r1.nextInt(5);
                slotSelection2 = r2.nextInt(5);
                slotSelection3 = r3.nextInt(5);
                slotSelect(slotSelection1, slotSelection2, slotSelection3);
                if (timesTracker != 0) {
                    delaySpin(timesTracker);
                } else {
                    gameResults(slotSelection1, slotSelection2, slotSelection3);
                }
            }
        }, 100);
    }

    public void spinSelected(View view){
    }
    public void gameResults(int slotSelection1, int slotSelection2, int slotSelection3) {
        if(slotSelection1 == slotSelection2 && slotSelection2 == slotSelection3) {
            slotImageView1.setImageResource(R.mipmap.m11);
            slotImageView2.setImageResource(R.mipmap.m11);
            slotImageView3.setImageResource(R.mipmap.m11);
            winDialog.show(getSupportFragmentManager(), "wingialog");
            winDialogDismiss();
winScore();
        }
        else if(slotSelection1 == slotSelection2 || slotSelection1 == slotSelection3
                || slotSelection2 == slotSelection3) {
            slotImageView1.setImageResource(R.mipmap.m11);
            slotImageView2.setImageResource(R.mipmap.m11);
            slotImageView3.setImageResource(R.mipmap.m11);
            winDialog.show(getSupportFragmentManager(), "wingialog");
            winDialogDismiss();
            winScore();
        }
        else {
            slotImageView1.setImageResource(R.mipmap.m11);
            slotImageView2.setImageResource(R.mipmap.m11);
            slotImageView3.setImageResource(R.mipmap.m11);
            winDialog.show(getSupportFragmentManager(), "wingialog");
            winDialogDismiss();
            winScore();
        }
    }
    void winScore(){
balance += points*10;
        textView.setText(String.valueOf(balance));
    }
    public void winDialogDismiss(){
        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                winDialog.dismiss();
            }

        }.start();
    }
    public void slotSelect(int slotSelection1, int slotSelection2, int slotSelection3) {
        if(slotSelection1 == 0 ) {
            slotImageView1.setImageResource(R.mipmap.m11);
        }
        if(slotSelection1 == 1 ) {
            slotImageView1.setImageResource(R.mipmap.m122);
        }
        if(slotSelection1 == 2 ) {
            slotImageView1.setImageResource(R.mipmap.m133);
        }
        if(slotSelection1 == 3 ) {
            slotImageView1.setImageResource(R.mipmap.m144);
        }
        if(slotSelection1 == 4 ) {
            slotImageView1.setImageResource(R.mipmap.m155);
        }
        if(slotSelection2 == 0 ) {
            slotImageView2.setImageResource(R.mipmap.m11);
        }
        if(slotSelection2 == 1 ) {
            slotImageView2.setImageResource(R.mipmap.m122);
        }
        if(slotSelection2 == 2 ) {
            slotImageView2.setImageResource(R.mipmap.m133);
        }
        if(slotSelection2 == 3 ) {
            slotImageView2.setImageResource(R.mipmap.m144);
        }
        if(slotSelection2 == 4 ) {
            slotImageView2.setImageResource(R.mipmap.m155);
        }
        if(slotSelection3 == 0 ) {
            slotImageView3.setImageResource(R.mipmap.m11);
        }
        if(slotSelection3 == 1 ) {
            slotImageView3.setImageResource(R.mipmap.m122);
        }
        if(slotSelection3 == 2 ) {
            slotImageView3.setImageResource(R.mipmap.m133);
        }
        if(slotSelection3 == 3 ) {
            slotImageView3.setImageResource(R.mipmap.m144);
        }
        if(slotSelection3 == 4 ) {
            slotImageView3.setImageResource(R.mipmap.m155);
        }

    }
    @Override
    public void foo() {
  materialButton.performClick();
    }

    @Override
    public void increace() {
        plus.performClick();
        playDialog.show(getSupportFragmentManager(), "playdialog");
    }

    @Override
    public void playMusic() {

    }

    @Override
    public void playSound() {

    }
}
