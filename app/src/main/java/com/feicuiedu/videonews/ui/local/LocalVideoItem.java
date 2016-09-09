package com.feicuiedu.videonews.ui.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.feicuiedu.videonews.R;
import com.feicuiedu.videonews.videoplayer.full.VideoViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：yuanchao on 2016/9/9 0009 14:38
 * 邮箱：yuanchao@feicuiedu.com
 */
public class LocalVideoItem extends FrameLayout{

    public LocalVideoItem(Context context) {
        this(context, null, 0);
    }

    public LocalVideoItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LocalVideoItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, 0);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_local_video,this,true);
        ButterKnife.bind(this);
    }

    @BindView(R.id.ivPreview) ImageView ivPreView;
    @BindView(R.id.tvVideoName)TextView tvVideoName;
    private String filePath; // 文件路径

    /** 数据绑定(将cursor内容,设置到对应控件上)*/
    public void bind(Cursor cursor){
        // 取出文件路径
        filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        // 取出视频名称
        String videoName = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME));
        tvVideoName.setText(videoName);
        // 清除预览图
        ivPreView.setImageBitmap(null);
    }

    @OnClick
    public void click(){
        VideoViewActivity.open(getContext(),filePath);
    }
}