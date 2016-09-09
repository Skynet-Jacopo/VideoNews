package com.feicuiedu.videonews.ui.local;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.feicuiedu.videonews.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：yuanchao on 2016/9/9 0009 10:07
 * 邮箱：yuanchao@feicuiedu.com
 */
public class LocalVideoFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{
    private static final String TAG = "LocalVideoFragment";

    private Unbinder unbinder;
    @BindView(R.id.gridView)GridView gridView;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始当前页面的Loader（加载器，去loader视频数据）
        // 参数说明ctrl+q:
        // 个唯一ID来标志加载器
        // 可选的参数，用于加载器初始化时
        // 加载器事件回调接口
        getLoaderManager().initLoader(0, null, this);
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_local_video,container,false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override public void onDestroy() {
        super.onDestroy();
    }

    // loadercallback start ----------------
    @Override public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] projection = {
                MediaStore.Video.Media._ID, // 视频ID
                MediaStore.Video.Media.DATA, // 视频文件路径
                MediaStore.Video.Media.DISPLAY_NAME,// 视频名称
        };

        return new CursorLoader(
                getContext(),
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,// 视频provider URI
                projection,
                null,null,null
        );
    }

    @Override public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.d(TAG, "onLoadFinished: " + data.getCount());
        // 测试
        if(data.moveToFirst()){
            do{
                int columnIndex = data.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME);
                String displayName = data.getString(columnIndex);
                Log.d(TAG, "onLoadFinished: " + displayName);
            }while(data.moveToNext());
        }
    }

    @Override public void onLoaderReset(Loader<Cursor> loader) {

    }
    // loadercallback end ----------------
}
