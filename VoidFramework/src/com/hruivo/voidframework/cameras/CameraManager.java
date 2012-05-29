package com.hruivo.voidframework.cameras;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;

public final class CameraManager {

	private GL10 gl;
	
	private Vector<Camera> cameras;
	private Camera currentCamera;
	
	
	public CameraManager(GL10 gl) {
		this(gl, new Camera());
	}
	
	public CameraManager(GL10 gl, Camera camera) {
		this.gl = gl;
		
		cameras = new Vector<Camera>();
		cameras.add(camera);
		
		setCurrentCamera(camera);
	}
	
	public void update(float dt) {
		gl.glLoadIdentity();
		GLU.gluLookAt(gl,
				currentCamera.Position.X,
				currentCamera.Position.Y,
				currentCamera.Position.Z,
				
				currentCamera.Target.X,
				currentCamera.Target.Y,
				currentCamera.Target.Z,
				
				currentCamera.Up.X,
				currentCamera.Up.Y,
				currentCamera.Up.Z);
	}
	
	public void setCurrentCamera(Camera camera) {
		this.currentCamera = camera;
	}
	
	public Camera getCurrentCamera() {
		return this.currentCamera;
	}
	
}
