package com.feicuiedu.videonews.videoplayer.part;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * 一个自定义的VideoView,使用MediaPlayer+SurfaceView来实现视频的播放
 * <p>
 * MediaPlayer来做视频播放的控制，SurfaceView来显示视频
 * <p>
 * 视图方面(initView方法中进行初始化)将简单实现:放一个播放/暂停按钮，一个进度条,一个全屏按钮,和一个SurfaceView
 * <p>
 * 本API实现结构：
 * <ul>
 * <li/>提供setVideoPath方法(要在onResume方法调用前来调用): 设置播放谁
 * <li/>提供onResume方法(在activity的onResume来调用): 初始化MediaPlayer,准备MediaPlayer
 * <li/>提供onPause方法 (在activity的onPause来调用): 释放MediaPlayer,暂停mediaPlayer
 * </ul>
 * <p>
 * 作者：yuanchao on 2016/9/7 0007 10:17
 * 邮箱：yuanchao@feicuiedu.com
 */
public class SimpleVideoView extends FrameLayout {

    private String videoPath; // 视频播放URL

    public SimpleVideoView(Context context) {
        this(context, null);
    }

    public SimpleVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // TODO: 2016/9/7 0007  设计、加载当前自定义视图xml
        // 初始化SurfaceView
        initSurfaceView();
        // 初始化视频播放控制视图
        initControllerViews();
    }

    private void initControllerViews() {

    }

    private void initSurfaceView() {

    }

    public void onResume() {
        initMediaPlayer(); // 初始化MediaPlayer，设置一系列监听器
        prepareMediaPlayer(); // 准备MediaPlayer，同时更新UI状态
    }

    private void initMediaPlayer() {

    }

    private void prepareMediaPlayer() {

    }

    public void onPause() {
        pauseMediaPlayer(); // 暂停播放，同时更新UI状态
        releaseMediaPlayer(); // 释放MediaPlayer，同时更新UI状态
    }

    private void pauseMediaPlayer() {

    }

    private void releaseMediaPlayer() {

    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}