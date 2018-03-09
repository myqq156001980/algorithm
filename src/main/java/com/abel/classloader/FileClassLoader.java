package com.abel.classloader;

import java.io.*;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by sunzqc on 2017/7/28 16:19.
 */
public class FileClassLoader extends ClassLoader {

    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String rootDir = "E:\\idea_workspace\\idea\\algorithm\\src\\main\\java\\";
        String rootDir2 = "C:\\Users\\sunzqc\\Desktop\\";

        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);
        FileClassLoader loader2 = new FileClassLoader(rootDir);

        FileClassLoader loader3 = new FileClassLoader(rootDir2);
        FileClassLoader loader4 = new FileClassLoader(rootDir2);

        try {
            //加载指定的class文件
            Class<?> object1 = loader.loadClass("com.abel.classloader.Single");
            Class<?> object2 = loader2.loadClass("com.abel.classloader.Single");
            System.out.println("loadClass->obj1:" + object1.hashCode());
            System.out.println("loadClass->obj2:" + object2.hashCode());

            Method m1 = object1.getMethod("getInstance");
            Single s1 = (Single) m1.invoke(object1);


            Method m2 = object2.getMethod("getInstance");
            Single s2 = (Single) m2.invoke(object2);

            System.out.println(s2 == s1);

            Class<?> object3 = loader3.findClass("com.abel.classloader.Single");
            System.out.println("loadClass->obj3:" + object3.hashCode());

//            Thread.sleep(10000);
            Class<?> object4 = loader4.findClass("com.abel.classloader.Single");
            System.out.println("loadClass->obj4:" + object4.hashCode());

            Method m3 = object3.getMethod("getInstance");
            Object s3 =  m3.invoke(object3);


            Method m4 = object4.getMethod("getInstance");
            Object s4 =  m4.invoke(object4);

            System.out.println(s4 == s3);


//            String rootDir1 = "C:\\Users\\sunzqc\\Desktop\\";
//            //创建自定义文件类加载器
//            FileClassLoader loader1 = new FileClassLoader(rootDir1);
//            Class<?> object3 = loader1.loadClass("DemoObj");
//            System.out.println(object3.newInstance().toString());

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 编写findClass方法的逻辑
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 编写获取class文件并转换为字节码流的逻辑
     *
     * @param className
     * @return
     */
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类文件的完全路径
     *
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

}
