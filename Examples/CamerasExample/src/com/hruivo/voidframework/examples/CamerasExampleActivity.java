package com.hruivo.voidframework.examples;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.method.Touch;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RemoteViews.ActionException;

import com.hruivo.voidframework.Vector3;
import com.hruivo.voidframework.cameras.VoidCamera;
import com.hruivo.voidframework.inputs.TouchPanel;
import com.hruivo.voidframework.VoidActivity;
import com.hruivo.voidframework.primitives.Cube;
import com.hruivo.voidframework.primitives.Plane;

public class CamerasExampleActivity extends VoidActivity {

	@Override
	protected void initialize() {
		Cube cube = new Cube(1,1,1);
		cube.setColor(1, 1, 1, 1);
		getScene().add(cube);
		
		Plane plane = new Plane(50, 50);
		plane.Position.Z = 0;
		plane.Rotation.X = -90;
		plane.Position.Y = -1;
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		plane.loadBitmap(bmp);
		plane.setTextureTilling(25, 25);
		getScene().add(plane);
		
		getScene().getCameraManager().getCurrentCamera().Position.Z = 5;
		getScene().getCameraManager().add(
				new VoidCamera(
					new Vector3(5.0f,5.0f,5.0f),
					new Vector3(0.0f,0.0f,0.0f),
					new Vector3(0.0f,1.0f,0.0f)), true);
	}
	
	@Override
	protected void update(float dt) {
		if(TouchPanel.isTouchDown()) {
			getScene().getCameraManager().setCurrentCamera("Camera 0");
		} else if(TouchPanel.isTouchUp()) {
			getScene().getCameraManager().setCurrentCamera("camera 1");
		}
	}

	@Override
	protected void draw() {
		// TODO Auto-generated method stub
		
	}
	
}