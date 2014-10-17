
package com.example.openglestest;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

    private OpenGLView mView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new OpenGLView(this);
        setContentView(mView);

    }

}
