
package com.example.openglestest;

import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;

public class OpenGLRenderer implements Renderer {

    private float mColorR = 0f;

    private float mColorG = 0f;

    private float mColorB = 0f;

    private float[] mTriangleArray = {
            -0.5f, 0f, 0f,
            -1f, -0.5f, 1f,
            0f, -0.5f, 1f,
            
            -0.5f, 0f, 0f,
            -1f, -0.5f, 1f,
            0f, -0.5f, -1f,
            
            -0.5f, 0f, 0f,
            0f, -0.5f, 1f,
            0f, -0.5f, -1f,
            
            -0.5f, 0f, 0f,
            0f, -0.5f, -1f,
            0f, -0.5f, 1f,
            
    };

    private float[] mQuadsArray = {
            1f, 0f, 1f, // 右上
            0.5f, 0f, 1f, // 左上
            0.5f, -0.5f, 1f, // 左下
            1f, -0.5f, 1f
    // 右下
    };

    private float[] mColorArray = {
            1f, 0f, 0f, 1f, // 红
            0f, 1f, 0f, 1f, // 绿
            0f, 0f, 1f, 1f
    // 蓝
    };
    private FloatBuffer mColorBuffer;

    private FloatBuffer mQuadsBuffer;

    private FloatBuffer mTriangleBuffer;

    private float mRtri = 0.0f;
    private float mRquad = 0.0f;
    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        // gl.glColor4f(1.0f, 1.0f, 0.0f, 0.5f);
        
        // 三角形
        gl.glRotatef(mRtri, 0.0f, 1.0f, 0.0f);   
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mTriangleBuffer);
        // 设置顶点，第一个参数是坐标的维数，这里是3维，第二个参数，表示buffer里面放的是float，第三个参数是0，是因为我们的坐标在数组中是紧凑的排列的，没有使用offset，最后的参数放的是存放顶点坐标的buffer
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 12);
        // 画数组，第一个参数表示画三角形，第二个参数是first，第三个参数是count，表示在buffer里面的坐标的开始和个数
        
        gl.glLoadIdentity();
        //四边形
        gl.glRotatef(mRquad, 1.0f, 0.0f, 0.0f);
        gl.glColor4f(1.0f, 0f, 0.0f, 0.1f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mQuadsBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
        gl.glClearColor(mColorR, mColorG, mColorB, 0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        // 设置输出屏幕大小
        gl.glViewport(0, 0, width, height);
        /*
         * float ratio = (float) width / height;
         * gl.glMatrixMode(GL10.GL_PROJECTION); gl.glLoadIdentity();
         * gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
         */
        Log.d("SJC", "onSurfaceChanged");
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        Log.d("SJC", "onSurfaceCreated");
        mTriangleBuffer = BufferUtil.floatToBuffer(mTriangleArray);
        mQuadsBuffer = BufferUtil.floatToBuffer(mQuadsArray);
        mColorBuffer = BufferUtil.floatToBuffer(mColorArray);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glShadeModel(GL10.GL_SMOOTH);

        gl.glClearColor(0f, 0f, 0f, 0f);

        gl.glClearDepthf(1.0f);

        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glDepthFunc(GL10.GL_LEQUAL);

        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);

    }

    public void setRGB(float r, float g, float b) {
        mColorR = r;
        mColorG = g;
        mColorB = b;
    }
    
    public void setRotate(float r) {
        mRquad = r;
        mRtri = r;
    }

}
