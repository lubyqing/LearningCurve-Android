package com.arthas.learningcurve.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.learningcurve.R;
import com.github.johnkil.print.PrintView;

/**
 * Created by Tcz on 16/4/20.
 */
public class IconFontAdapter extends BaseGridAdapter<String> {

    public IconFontAdapter(Activity context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_icon_font_item, null);
            viewHolder.mIconView = (PrintView) convertView.findViewById(R.id.pv_node_icon);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mIconView.setIconText(mList.get(position));

        return convertView;
    }

    static class ViewHolder {
        PrintView mIconView;
    }

}
