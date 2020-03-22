package com.example.opencvdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public  class SwitchLight {

    static {//加载so库
        System.loadLibrary("native-lib");
    }

    public SwitchLight(){
        OpenCVLoader.initDebug();
    }

    public static Bitmap getGrayImg(Bitmap bitmap){
        Mat src = new Mat();
        Utils.bitmapToMat(bitmap,src);
        Mat dst = new Mat();
        Imgproc.cvtColor(src,dst,Imgproc.COLOR_RGBA2GRAY);
        Utils.matToBitmap(dst, bitmap);
        src.release();
        dst.release();
        return bitmap;
    }

    public static Bitmap getBinaryzation(Bitmap bitmap,int thresh,int maxval){
        Mat src = new Mat();
        Mat dst = new Mat();
        Utils.bitmapToMat(bitmap,src);
        Imgproc.threshold(src,dst,thresh,maxval,Imgproc.THRESH_BINARY);
        Utils.matToBitmap(dst,bitmap);
        src.release();
        dst.release();
        return bitmap;
    }

}
