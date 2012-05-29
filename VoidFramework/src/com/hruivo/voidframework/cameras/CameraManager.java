package com.hruivo.voidframework.cameras;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;

public final class CameraManager {

	private GL10 gl;

	private Vector<VoidCamera> cameras;
	private VoidCamera currentCamera;

	public CameraManager(GL10 gl) {
		this(gl, new VoidCamera());
	}

	public CameraManager(GL10 gl, VoidCamera camera) {
		this.gl = gl;

		cameras = new Vector<VoidCamera>();
		add(camera);
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

	public void setCurrentCamera(VoidCamera camera) {
		this.currentCamera = camera;
	}
	
	public void setCurrentCamera(final String name) {
		int size = cameras.size();
		for (int i = 0; i < size; i++)
			if (cameras.get(i).getName().equalsIgnoreCase(name)) {
				this.currentCamera = cameras.get(i);
				return;
			}
	}

	public VoidCamera getCurrentCamera() {
		return this.currentCamera;
	}

	public void add(VoidCamera camera) {
		this.add(camera, true);
	}

	public void add(VoidCamera camera, boolean setCurrent) {
		cameras.add(camera);
		if (setCurrent)
			setCurrentCamera(camera);
	}

	public void remove(VoidCamera camera) {
		cameras.remove(camera);

		if (cameras.size() == 0) {
			add(new VoidCamera());
		}
	}

	public void remove(String name) {
		int size = cameras.size();
		for (int i = 0; i < size; i++)
			if (cameras.get(i).getName().equals(name)) {
				cameras.remove(i);
				return;
			}
	}

}
