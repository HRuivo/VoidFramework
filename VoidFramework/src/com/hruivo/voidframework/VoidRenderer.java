package com.hruivo.voidframework;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class VoidRenderer implements Renderer {
	
	private GL10 _gl = null;
	
	// Scene root
	private SceneNode scene = null;
	// Activity
	private VoidActivity activity = null;
	
		
	private float[] clearColor = { 0.0f, 0.0f, 0.0f };
	
	
	public VoidRenderer(VoidActivity activity, SceneNode sceneRoot) {
		this.activity = activity;
		this.scene = sceneRoot;
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearColor(clearColor[0], clearColor[1], clearColor[2], 1f);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
		
		_gl = gl;
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 1.0f, 100.0f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		// update activity
		activity.update(0.0f);
		// update scene
		scene.update(0.0f);

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);	
	
		// Draw
		gl.glLoadIdentity();
		// draw activity
		activity.draw();
		// draw scene
		scene.draw(gl);
	}
	
	
	public float[] getClearColor() { return this.clearColor; }
	public void setClearColor(float r, float g, float b) {
		this.clearColor[0] = r;
		this.clearColor[1] = g;
		this.clearColor[2] = b;
		
		if(_gl != null)
			_gl.glClearColor(clearColor[0], clearColor[1], clearColor[2], 1.0f);
	}
}
