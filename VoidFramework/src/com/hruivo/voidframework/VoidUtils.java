package com.hruivo.voidframework;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public final class VoidUtils {

	public static void RequestFullscreenMode(Activity activity) {
		activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
		activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}
	
}
