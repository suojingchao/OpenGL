package com.example.openglestest;

import android.content.res.Resources;  
import android.graphics.Bitmap;  
import android.graphics.BitmapFactory;  
   
public class DataManager {  
        
       private static Bitmap mBitmap;  
        
       public static void init(Resources res){  
              mBitmap = BitmapFactory.decodeResource(res, R.drawable.ic_launcher);  
       }  
        
       public static Bitmap getBitmap(){  
              return mBitmap;  
       }  
}   