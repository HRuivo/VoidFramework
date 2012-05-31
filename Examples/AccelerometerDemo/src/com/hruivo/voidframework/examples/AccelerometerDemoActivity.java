package com.hruivo.voidframework.examples;

import com.hruivo.voidframework.VoidActivity;
import com.hruivo.voidframework.cameras.VoidCamera;
import com.hruivo.voidframework.inputs.Accelerometer;
import com.hruivo.voidframework.primitives.Plane;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AccelerometerDemoActivity extends VoidActivity {
    
	private Plane plane;
	private VoidCamera camera;
	
	
	@Override
	protected void initialize() {
		plane = new Plane(50, 50);
		plane.Position.Z = 0;
		plane.Rotation.X = -90;
		plane.Position.Y = -1;
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.tex_grid);
		plane.loadBitmap(bitmap);
		plane.setTextureTilling(25, 25);
		getScene().add(plane);
	
		camera = getScene().getCameraManager().getCurrentCamera();
	}
	
	@Override
	protected void update(float dt) {
		camera.Yaw -= Accelerometer.getAccelerometerY() * 0.01f;
		camera.Pitch += Accelerometer.getAccelerometerX() * 0.01f;
	}

	@Override
	protected void draw() {
		
	}
}