package com.feicuiedu.videonews.videoplayer.full;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.feicuiedu.videonews.videoplayer.R;

public class VideoViewActivity extends AppCompatActivity {

    private static final String VIDEO_PATH = "video_path";

    /** 启动当前Activity*/
    public static void open(Context context, String videoPath) {
        Intent intent = new Intent(context, VideoViewActivity.class);
        intent.putExtra(VIDEO_PATH, videoPath);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 设置窗口的背景色
        getWindow().setBackgroundDrawableResource(android.R.color.black);
        // 设置当前内容视图
        setContentView(R.layout.activity_video_view);
        initBufferView();
        initVideoView();
    }

    private void initVideoView() {

    }

    private void initBufferView() {

    }
}
