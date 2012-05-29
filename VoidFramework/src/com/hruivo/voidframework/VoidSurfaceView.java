package com.hruivo.voidframework;

import com.hruivo.voidframework.inputs.TouchPanel;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;

public class VoidSurfaceView extends GLSurfaceView {
	
	
	public VoidSurfaceView(Context context) {
		super(context);

		try {
			VoidActivity activity = (VoidActivity)context;
			
			setRenderer(new VoidRenderer(activity));
		} catch (Exception e) {
			Log.d("VOIDSURFACE", "error while creating renderer");
		}
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		TouchPanel.update(event);
		
		return super.onTouchEvent(event);
	}
	
}
