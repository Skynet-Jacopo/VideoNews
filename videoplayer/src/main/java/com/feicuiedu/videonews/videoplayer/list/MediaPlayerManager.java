package com.feicuiedu.videonews.videoplayer.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;

import java.util.List;

import io.vov.vitamio.MediaPlayer;

/**
 * 用来管理列表视图上视频播放,共用一个MediaPlayer
 * <p>
 * 此类将提供三对核心方法给UI层调用:
 * <ol>
 * <li/>onResume和onPause: 初始和释放MediaPlayer(生命周期的保证)
 * <li/>startPlayer和stopPlayer: 开始和停止视频播放(提供方法给视图来触发业务)
 * <li/>addPlayerbackListener和removeAllListeners: 添加和移除监听(与视图交互的接口)
 * </ol>
 * <p>
 * 作者：yuanchao on 2016/9/12 0012 10:18
 * 邮箱：yuanchao@feicuiedu.com
 */
public class MediaPlayerManager {
    private static MediaPlayerManager sInstance;

    public synchronized static MediaPlayerManager getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MediaPlayerManager(context.getApplicationContext());
        }
        return sInstance;
    }

    private MediaPlayerManager(Context context) {
        this.context = context;
    }

    private final Context context;
    private MediaPlayer mediaPlayer;
    private List<OnPlaybackListener> onPlaybackListeners;

    // 初始化MediaPlayer
    public void onResume() {
    }

    // 释放MediaPlayer
    public void onPause() {
    }

    // 开始缓冲,且更新UI(通过接口callback)
    private void startBuffering() {
    }

    // 结束缓冲,且更新UI(通过接口callback)
    private void endBuffering() {
    }

    // 开始播放,且更新UI(通过接口callback)
    public void startPlayer(@NonNull Surface surface, @NonNull String path, @NonNull String videoId) {
    }

    // 停止播放,且更新UI(通过接口callback)
    public void stopPlayer() {
    }

    // 添加播放处理的监听(UI层的callback)
    public void addPlayerbackListener(OnPlaybackListener listener) {
        onPlaybackListeners.add(listener);
    }

    public void removeAllListeners() {
        onPlaybackListeners.clear();
    }


    // 视图接口
    // 在视频播放模块完成播放处理, 视图层来实现此接口, 完成视图层UI更新
    public interface OnPlaybackListener {

        void onStartBuffering(String videoId); // 视频缓冲开始

        void onStopBuffering(String videoId); // 视频缓冲结束

        void onStartPlay(String videoId); // 开始播放

        void onStopPlay(String videoId);// 停止播放

        void onSizeMeasured(String videoId, int width, int height);// 大小更改
    }
}