package com.hruivo.voidframework;

import com.hruivo.voidframework.inputs.TouchPanel;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class VoidSurfaceView extends GLSurfaceView {
	
	
	public VoidSurfaceView(Context context) {
		super(context);

		VoidActivity activity = (VoidActivity)context;
		
		setRenderer(new VoidRenderer(activity, activity.getScene()));
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		TouchPanel.update(event);
		
		return super.onTouchEvent(event);
	}
	
}
