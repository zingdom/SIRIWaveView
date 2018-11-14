package com.alex.test;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.alex.siriwaveview.SiriWaveView;

public class MainActivity extends AppCompatActivity {

	SiriWaveView waveView;
	ToggleButton button;

	private AnimatorSet _animator;

	private void resetAnimation(float level, int color, long duration) {
		if (_animator != null) {
			_animator.cancel();
			_animator.removeAllListeners();
		}

		ObjectAnimator anim1 = ObjectAnimator.ofFloat(this.waveView, "level", level);
		ObjectAnimator anim2 = ObjectAnimator.ofArgb(this.waveView, "waveColor", color);

		_animator = new AnimatorSet();
		_animator.playTogether(anim1, anim2);
		_animator.setDuration(duration);
		_animator.setInterpolator(new AccelerateInterpolator());

		_animator.start();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		waveView = (SiriWaveView) findViewById(R.id.siriWaveView);
		button = (ToggleButton) findViewById(R.id.button);

		button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					resetAnimation(1.0f, 0xFFFFFF00, 5000);

					Toast.makeText(MainActivity.this, "Animation started", Toast.LENGTH_SHORT).show();
				} else {
					resetAnimation(0.1f, 0xFF0000FF, 5000);

					Toast.makeText(MainActivity.this, "Animation stopped", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
