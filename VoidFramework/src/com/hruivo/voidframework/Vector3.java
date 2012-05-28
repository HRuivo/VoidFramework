package com.hruivo.voidframework;

public class Vector3 {

	/*public final static Vector3 Zero = new Vector3(0, 0, 0);
	public final static Vector3 One = new Vector3(1, 1, 1);
	public final static Vector3 Forward = new Vector3(0, 0, -1);
	public final static Vector3 Right = new Vector3(1, 0, 0);
	public final static Vector3 Up = new Vector3(0, 1, 0);*/
	
	
	public float X, Y, Z;
	
	
	public Vector3() {
		this(0.0f, 0.0f, 0.0f);
	}
	
	public Vector3(float x, float y, float z) {
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	
}
