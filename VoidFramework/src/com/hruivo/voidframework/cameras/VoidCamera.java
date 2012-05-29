package com.hruivo.voidframework.cameras;

import com.hruivo.voidframework.Vector3;

public class VoidCamera {
	
	private String name;
	
	public Vector3 Position;
	public Vector3 Target;
	public Vector3 Up;
	
	public float speed = 1.0f;
	
	public float fov;
	public float zNear, zFar;
	
	static int numCameras = 0;
	
	
	public VoidCamera() {
		this(new Vector3(0,0,5), new Vector3(0,0,0), new Vector3(0,1,0));
	}
	
	public VoidCamera(Vector3 Position, Vector3 Target, Vector3 Up) {
		this.name = "Camera " + VoidCamera.numCameras++;
		
		this.Position = Position;
		this.Target = Target;
		this.Up = Up;
	}
	
	public void update(float dt) {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
