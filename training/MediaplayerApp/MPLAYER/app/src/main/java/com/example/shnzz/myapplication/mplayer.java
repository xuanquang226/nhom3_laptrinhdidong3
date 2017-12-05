package com.example.shnzz.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class mplayer extends AppCompatActivity {
    TextView txtTitle, txttimeSong , txttimeTotal;
    SeekBar sksong;
    ImageButton btnPlay,btnPrev,btnStop,btnNext;
    ImageView imgHinh;
    ArrayList<Song> arraySong;
    int vitri = 0;
    MediaPlayer mediaPlayer;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mplayer_layout);

        Anhxa();
        AddSong();

        animation = AnimationUtils.loadAnimation(this,R.anim.rotate);

        KhoiTaoMediaplayer();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    // nếu đang phát thì tạm dừng - > đổi icon
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.playnhac);
                }
                // nếu đang pause thì play
                else {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.pause);
                }
                SetTimeTotal();
                updateTimeSong();
                imgHinh.startAnimation(animation);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();

                // giai phong
                mediaPlayer.release();

                btnPlay.setImageResource(R.drawable.playnhac);
                KhoiTaoMediaplayer();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitri++;
                if( vitri > arraySong.size() - 1 )
                {
                    vitri = 0;
                }
                if ( mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                KhoiTaoMediaplayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
            }
        });


        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitri--;
                if( vitri < 0 )
                {
                    vitri = arraySong.size() - 1;
                }
                if ( mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                KhoiTaoMediaplayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
            }
        });

        sksong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(sksong.getProgress());
            }
        });
    }

    private  void updateTimeSong()
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdanggio = new SimpleDateFormat("mm:ss");
                txttimeSong.setText(dinhdanggio.format(mediaPlayer.getCurrentPosition()));
                // cap nhat skSong
                sksong.setProgress(mediaPlayer.getCurrentPosition());
                // kt time bai bai neu ket thuc next bai tiep
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mdp) {
                        vitri++;
                        if( vitri > arraySong.size() - 1 )
                        {
                            vitri = 0;
                        }
                        if ( mediaPlayer.isPlaying())
                        {
                            mediaPlayer.stop();
                        }
                        KhoiTaoMediaplayer();
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.pause);
                        SetTimeTotal();
                    }
                });
                handler.postDelayed(this,500);
            }
        },100);
    }

    private void SetTimeTotal() {
        SimpleDateFormat dinhdanggio = new SimpleDateFormat("mm:ss");
        txttimeTotal.setText(dinhdanggio.format(mediaPlayer.getDuration()));
        // gan max cua sk = mediaplayer duration
        sksong.setMax(mediaPlayer.getDuration());
    }

    private void KhoiTaoMediaplayer()
    {
        mediaPlayer = MediaPlayer.create(mplayer.this,arraySong.get(vitri).getFile());
        txtTitle.setText(arraySong.get(vitri).getTitle());
    }

    private  void AddSong()
    {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Mặt trời của em",R.raw.mattroicuaem));
        arraySong.add(new Song("Yêu em rất nhiều ",R.raw.yeuemratnhieu));
        arraySong.add(new Song("Yêu từ phía xa ",R.raw.yeutuphiaxa));
    }


    private void Anhxa()
    {
        txttimeSong = (TextView) findViewById(R.id.txtTimeSong);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txttimeTotal = (TextView) findViewById(R.id.txtTimeTotal);
        sksong = (SeekBar) findViewById(R.id.seekBar);
        btnPrev = (ImageButton) findViewById(R.id.btnPrev);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnStop = (ImageButton) findViewById(R.id.btnStop);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        imgHinh = (ImageView) findViewById(R.id.imgHinh);
    }
}
