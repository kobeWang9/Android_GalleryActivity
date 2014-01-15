package com.pactera.android_galleryactivity;

import android.app.ActionBar.LayoutParams;
import android.content.Context;

import android.view.View;

import android.view.ViewGroup;

import android.widget.BaseAdapter;

import android.widget.Gallery;

import android.widget.ImageView;

public class ImageViewAdapter extends BaseAdapter {

	// 定义Context

	private Context mContext;

	// 定义整型数组，即图片资源

	private Integer[] mImageIds = {

	R.drawable.ic_launcher,

	R.drawable.icon_down,

	R.drawable.icon_right,

	R.drawable.icon_down,

	R.drawable.icon_right,

	R.drawable.icon_down,

	};

	// 声明ImageAdapter

	public ImageViewAdapter(Context c) {

		mContext = c;

	}

	@Override
	public int getCount() {

		// TODO Auto-generated method stub

		return mImageIds.length;

	}

	@Override
	public Object getItem(int position) {

		// TODO Auto-generated method stub

		return position;

	}

	@Override
	public long getItemId(int position) {

		// TODO Auto-generated method stub

		return position;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// TODO Auto-generated method stub

		ImageView imageview = new ImageView(mContext);

		// 给ImageView设置资源

		imageview.setImageResource(mImageIds[position]);

		// 设置布局以120*120显示

		imageview.setLayoutParams(new Gallery.LayoutParams(120,120));

		// 设置显示比例

		imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);

		return imageview;

	}

}
