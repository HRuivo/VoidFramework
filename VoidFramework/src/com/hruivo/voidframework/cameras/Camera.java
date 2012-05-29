package com.hruivo.voidframework.cameras;

import com.hruivo.voidframework.Vector3;

public class Camera {
	
	public Vector3 Position;
	public Vector3 Target;
	public Vector3 Up;
	
	public float speed = 1.0f;
	
	public float fov;
	public float zNear, zFar;
	
	
	public Camera() {
		this(new Vector3(0,0,5), new Vector3(0,0,0), new Vector3(0,1,0));
	}
	
	public Camera(Vector3 Position, Vector3 Target, Vector3 Up) {
		this.Position = Position;
		this.Target = Target;
		this.Up = Up;
	}
	
	public void update(float dt) {
		
	}
	
}
