package com.hruivo.voidframework;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public abstract class VoidActivity extends Activity {
	
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
        setContentView(new VoidSurfaceView(this));
        
        initialize();
        // TODO: scene.initialize();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		// initialize();
		// TODO: scene.onResume();
	}
	
	/**
	 * Gets the current scene.
	 * @return The current scene's root node.
	 */
	public SceneNode getScene() {
		return this.scene;
	}
	
}
