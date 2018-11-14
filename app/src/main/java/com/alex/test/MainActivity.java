package com.alex.test;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.alex.siriwaveview.SiriWaveView;

public class MainActivity extends AppCompatActivity {

	SiriWaveView waveView;
	ToggleButton button;

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
//                    waveView.startAnimation();

					waveView.animateLevel(1.0f, 500);
//                    waveView.setWaveHeight(150);
					Toast.makeText(MainActivity.this, "Animation started", Toast.LENGTH_SHORT).show();
				} else {
					waveView.animateLevel(0.1f, 500);

					//                    waveView.setWaveHeight(10);
					Toast.makeText(MainActivity.this, "Animation stopped", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
