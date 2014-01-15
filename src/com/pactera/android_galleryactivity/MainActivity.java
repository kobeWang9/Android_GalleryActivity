package com.pactera.android_galleryactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Gallery gallery;
	private ImageViewAdapter adapter;
	private AnimationSet mAnimationSet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gallery = (Gallery) findViewById(R.id.gallery);
		adapter = new ImageViewAdapter(this);
		gallery.setAdapter(adapter);
		gallery.setOnItemClickListener(listener);
	}

	private OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View v, int position,
				long arg3) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "你选择了" + (position + 1) + " 号图片",
					Toast.LENGTH_SHORT).show();
			// 增加点击放大效果
			AnimationSet animationSet = new AnimationSet(true);
			if (mAnimationSet != null && mAnimationSet != animationSet) {
				ScaleAnimation scaleAnimation = new ScaleAnimation(2, 0.5f, 2,
						0.5f, Animation.RELATIVE_TO_PARENT, 0.5f, // 使用动画播放图片
						Animation.RELATIVE_TO_PARENT, 0.5f);
				scaleAnimation.setDuration(1000);
				mAnimationSet.addAnimation(scaleAnimation);
				mAnimationSet.setFillAfter(false); // 让其保持动画结束时的状态。
				v.startAnimation(mAnimationSet);

			}

			ScaleAnimation scaleAnimation = new ScaleAnimation(1, 4f, 1, 5f,

			Animation.RELATIVE_TO_SELF, 0.5f,

			Animation.RELATIVE_TO_SELF, 0.5f);

			scaleAnimation.setDuration(1000);

			animationSet.addAnimation(scaleAnimation);

			animationSet.setFillAfter(true);

			v.startAnimation(animationSet);

			mAnimationSet = animationSet;

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
