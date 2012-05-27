package com.hruivo.voidframework.inputs;

import android.graphics.Rect;
import android.view.MotionEvent;

public final class TouchPanel {

	private static MotionEvent currentMotionEvent = null;
	
	public static void update(final MotionEvent event) {
		currentMotionEvent = event;
	}
	
	public static int getAction() {
		return currentMotionEvent.getAction();
	}
	
	public static boolean hasAction(int action) {
		return currentMotionEvent.getAction() == action;
	}
	
	public static boolean isTouchDown() {
		return currentMotionEvent.getAction() == MotionEvent.ACTION_DOWN;
	}
	
	public static boolean isTouchDown(Rect region) {
		if(currentMotionEvent.getAction() == MotionEvent.ACTION_DOWN || currentMotionEvent.getAction() == MotionEvent.ACTION_MOVE)
			return region.contains((int)currentMotionEvent.getX(), (int)currentMotionEvent.getY());
		else return false;
	}
	
	public static boolean isTouchUp() {
		return currentMotionEvent.getAction() == MotionEvent.ACTION_UP;
	}
}
