package com.hruivo.voidframework;

import com.hruivo.voidframework.inputs.Accelerometer;
import com.hruivo.voidframework.scene.Scene;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public abstract class VoidActivity extends Activity implements SensorEventListener {
	
	private VoidSurfaceView voidSurfaceView = null;
	private Scene scene = null;
	private SensorManager sensorManager = null;
	
	
	protected abstract void initialize();
	protected abstract void update(float dt);
	protected abstract void draw();
	
	
	protected final void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.d("VoidFramework.VoidActivity", "onCreate()");
		

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
		// Initialize Sensors
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Accelerometer.initializeSensor(this, sensorManager);
        
        // Initialize View and Renderer
        setContentView((voidSurfaceView = new VoidSurfaceView(this)));
	}
	
	@Override
	protected void onPause() {
		super.onPause();

		Log.d("VoidFramework.VoidActivity", "onPause()");
		
		Accelerometer.pause(this, sensorManager);

		voidSurfaceView.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();

		Log.d("VoidFramework.VoidActivity", "onResume()");
		
		Accelerometer.resume(this, sensorManager);
		
		voidSurfaceView.onResume();
	}
	
	/**
	 * Gets the current scene.
	 * @return The current scene's root node.
	 */
	public Scene getScene() {
		return this.scene;
	}
	
	/**
	 * Internally sets the scene. Called by VoidRender
	 * as soon as it creates a new scene.
	 * @param scene
	 */
	void setScene(Scene scene) {
		this.scene = scene;
	}

	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		Accelerometer.update(event);
	}
	
}
