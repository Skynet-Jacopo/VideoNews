package com.feicuiedu.videonews.ui.local;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * 作者：yuanchao on 2016/9/9 0009 14:32
 * 邮箱：yuanchao@feicuiedu.com
 */
public class LocalVideoAdapter extends CursorAdapter{

    public LocalVideoAdapter(Context context) {
        super(context, null, true);
    }

    @Override public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return new LocalVideoItem(context);
    }

    @Override public void bindView(View view, Context context, Cursor cursor) {
        LocalVideoItem localVideoItem = (LocalVideoItem) view;
        localVideoItem.bind(cursor);
    }
}
