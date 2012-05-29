package com.hruivo.voidframework;

import com.hruivo.voidframework.scene.Scene;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public abstract class VoidActivity extends Activity {
	
	private VoidSurfaceView voidSurfaceView = null;
	private Scene scene = null;
	
	
	protected abstract void initialize();
	protected abstract void update(float dt);
	protected abstract void draw();
	
	@Override
	protected final void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		   
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                
        // Initialize View and Renderer
        setContentView((voidSurfaceView = new VoidSurfaceView(this)));
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		voidSurfaceView.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		// initialize();
		// TODO: scene.onResume();
		
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
	 * Internally sets the scene. Called from VoidRender
	 * as soon as it creates a new scene.
	 * @param scene
	 */
	void setScene(Scene scene) {
		this.scene = scene;
	}
	
}
