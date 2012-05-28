package com.hruivo.voidframework;

import com.hruivo.voidframework.inputs.TouchPanel;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public abstract class VoidActivity extends Activity implements SensorEventListener {
	
	private SceneNode scene = null;
	
	
	protected abstract void initialize();
	protected abstract void update(float dt);
	protected abstract void draw();
	
	
	@Override
	protected final void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		   
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        // Initialize Scene
        this.scene = new SceneNode();
        
        // Initialize View and Renderer
        GLSurfaceView view = new GLSurfaceView(this);
        view.setRenderer(new VoidRenderer(this, this.scene));
        setContentView(view);
	
        
        initialize();
        // TODO: scene.initialize();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		// initialize();
		// TODO: scene.onResume();
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		TouchPanel.update(event);
		
		return super.onTouchEvent(event);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Gets the current scene.
	 * @return The current scene's root node.
	 */
	public SceneNode getScene() {
		return this.scene;
	}
	
}
