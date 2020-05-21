package com.company;

import java.lang.reflect.Field;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

public class OpenCVTest {
    // use this only when running from IDE
//    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME + ".dll"); }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to OpenCV" + Core.VERSION);
        //external dll loading
//        System.load("C:\\opencv\\build\\java\\x64\\opencv_java3410.dll");
        loadOpenCV_Lib();
        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        System.out.println("OpenCV mat: " + m);

        Mat mr1 = m.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = m.col(5);
        mc5.setTo(new Scalar(5));
        System.out.println("OpenCV Mat data:\n" + m.dump());
    }

    public static void loadOpenCV_Lib() throws Exception {
        // get the model
        String model = System.getProperty("sun.arch.data.model");
        // the path the .dll lib location
        String libraryPath = "C:/opencv/build/java/x86/";
        // check for if system is 64 or 32
        if(model.equals("64")) {
            libraryPath = "C:/opencv/build/java/x64/";
        }
        // set the path
        System.setProperty("java.library.path", libraryPath);
        Field sysPath = ClassLoader.class.getDeclaredField("sys_paths");
        sysPath.setAccessible(true);
        sysPath.set(null, null);
        // load the lib
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
}
