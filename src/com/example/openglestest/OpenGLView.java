package com.example.openglestest;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;

 

public class OpenGLView extends GLSurfaceView {

    private OpenGLRenderer mRenderer;

    private float mRotate = 0.0f;

    public OpenGLView(Context context) {

       super(context);

       mRenderer = new OpenGLRenderer();

       setRenderer(mRenderer);
       startRotate();
    }
    
    private void startRotate() {
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                while(true) {
                    mRenderer.setRotate(mRotate);
                    mRotate+= 0.01;
                    if (mRotate > 360) {
                        mRotate = 0;
                    }
                    Log.d("SJC", "rotate... mRotate = " + mRotate);
                }
            }
        }).start();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        mRenderer.setRGB(event.getX()/getWidth(), event.getY()/getHeight(), 1.0f);
        return true;
    }

 

}