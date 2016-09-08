package com.feicuiedu.videonews.videoplayer.full;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.feicuiedu.videonews.videoplayer.R;

import io.vov.vitamio.widget.MediaController;

/**
 * 作者：yuanchao on 2016/9/8 0008 14:44
 * 邮箱：yuanchao@feicuiedu.com
 */
public class CustorMediaController extends MediaController {

    public CustorMediaController(Context context) {
        super(context);
    }

    // 通过重过此方法，来自定义layout
    @Override protected View makeControllerView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_custom_video_controller, this);
        initView(view);
        return view;
    }

    private MediaPlayerControl mediaPlayerControl;

    @Override public void setMediaPlayer(MediaPlayerControl player) {
        super.setMediaPlayer(player);
        mediaPlayerControl = player;
    }

    private void initView(View view) {
        // forward快进
        ImageButton btnFastForward = (ImageButton)view.findViewById(R.id.btnFastForward);
        btnFastForward.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                long postion = mediaPlayerControl.getCurrentPosition();
                postion += 10000;
                if(postion >= mediaPlayerControl.getDuration()){
                    postion = mediaPlayerControl.getDuration();
                }
                mediaPlayerControl.seekTo(postion);
            }
        });
        // rewide
        ImageButton btnFastRewide = (ImageButton)view.findViewById(R.id.btnFastRewind);
        btnFastRewide.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                long postion = mediaPlayerControl.getCurrentPosition();
                postion -= 10000;
                if(postion < 0)postion = 0;
                mediaPlayerControl.seekTo(postion);
            }
        });
    }
}
