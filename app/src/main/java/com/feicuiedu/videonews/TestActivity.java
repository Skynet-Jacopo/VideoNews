package com.feicuiedu.videonews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.feicuiedu.videonews.videoplayer.part.SimpleVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.simpleVideoPlayer)SimpleVideoView simpleVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        simpleVideoView.setVideoPath("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8");
    }

    @Override protected void onResume() {
        super.onResume();
        simpleVideoView.onResume();
    }

    @Override protected void onPause() {
        super.onPause();
        simpleVideoView.onPause();
    }
}
