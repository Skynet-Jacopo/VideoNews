package com.feicuiedu.videonews.videoplayer.part;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.feicuiedu.videonews.videoplayer.R;

import java.io.IOException;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;

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
    private MediaPlayer mediaPlayer;

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
        // Vitamio的初始化
        Vitamio.isInitialized(getContext());
        LayoutInflater.from(getContext()).inflate(R.layout.view_simple_video_player, this, true);
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

    // 初始化MediaPlayer，设置一系列监听器
    private void initMediaPlayer() {
        mediaPlayer = new MediaPlayer(getContext());
        // mediaPlayer.setDisplay();
        // 监听处理
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override public void onPrepared(MediaPlayer mp) {
                startMediaPlayer();
            }
        });
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override public boolean onInfo(MediaPlayer mp, int what, int extra) {
                // vitamio5.0，要进行audio处理,才能对在线视频进行播放
                if (what == MediaPlayer.MEDIA_INFO_FILE_OPEN_OK) {
                    mediaPlayer.audioInitedOk(mediaPlayer.audioTrackInit());
                    return true;
                }
                return false;
            }
        });
        // TODO: 2016/9/7 0007 OnVideoSizeChangedListener来处理surfaceview的size
    }

    private void startMediaPlayer() {
        mediaPlayer.start();
    }

    private void prepareMediaPlayer() {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(videoPath);
            mediaPlayer.setLooping(true);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            // TODO: 2016/9/7 0007 提示develop发生错误!
            Log.d("SimpleVideoView", " prepare MediaPlayer " + e.getMessage());
        }
    }

    public void onPause() {
        pauseMediaPlayer(); // 暂停播放，同时更新UI状态
        releaseMediaPlayer(); // 释放MediaPlayer，同时更新UI状态
    }
    // 暂停播放，同时更新UI状态
    private void pauseMediaPlayer() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
    // 释放MediaPlayer，同时更新UI状态
    private void releaseMediaPlayer() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}