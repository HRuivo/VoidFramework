package com.hruivo.voidframework.examples;

import com.hruivo.voidframework.Vector3;
import com.hruivo.voidframework.VoidActivity;
import com.hruivo.voidframework.primitives.Cube;
import com.hruivo.voidframework.primitives.TexturedPlane;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SimpleSceneActivity extends VoidActivity {

	private Cube cubeA;
	private Cube cubeB;
	private TexturedPlane plane;
	
	
	@Override
	protected void initialize() {
		cubeA = new Cube(1,1,1);
		cubeA.Position = new Vector3(2, 0, -5);
		cubeA.setColor(0, 0, 1, 1);
		getScene().add(cubeA);
		
		cubeB = new Cube(1,0.5f,1);
		cubeB.Position = new Vector3(-2, 0, -5);
		cubeB.setColor(1, 0, 0, 1);
		getScene().add(cubeB);
		
		plane = new TexturedPlane(2, 2);
		plane.Position.Z = -5;
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.tex_grid);
		plane.loadBitmap(bitmap);
		getScene().add(plane);
	}
	
	@Override
	protected void update(float dt) {
		cubeA.Rotation.Y += 5;
		cubeA.Rotation.X += 5;
		cubeA.Rotation.Z -= 5;
		
		cubeB.Rotation.Y += 5;
		cubeB.Rotation.X += 5;
		cubeB.Rotation.Z -= 5;
		
		plane.Rotation.Z += 1;
	}

	@Override
	protected void draw() {
		// TODO Auto-generated method stub
		
	}

}