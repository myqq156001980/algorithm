package com.abel.classloader;


import javax.net.ssl.SNIHostName;
import java.io.File;
import java.lang.reflect.Method;
import java.net.*;

/**
 * Created by sunzqc on 2017/7/28 16:23.
 */
public class FileUrlClassLoader extends URLClassLoader {
    public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileUrlClassLoader(URL[] urls) {
        super(urls);
    }

    public FileUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }


    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
//        String rootDir = "E:\\idea_workspace\\idea\\algorithm\\src\\main\\java\\";
        String rootDir = "C:\\Users\\sunzqc\\Desktop\\";
        //创建自定义文件类加载器
        File file = new File(rootDir);
        //File to URI
        URI uri = file.toURI();
        URL[] urls = {uri.toURL()};

        FileUrlClassLoader loader = new FileUrlClassLoader(urls);
        FileUrlClassLoader loader2 = new FileUrlClassLoader(urls);

        try {
            //加载指定的class文件
            Class<?> object1 = loader.loadClass("com.abel.classloader.Single");

            Method m1 = object1.getMethod("getInstance");
            Single s1 = (Single) m1.invoke(object1);

            Class<?> object2 = loader2.loadClass("com.abel.classloader.Single");

            Method m2 = object2.getMethod("getInstance");
            Single s2 = (Single)m2.invoke(object2);

            System.out.println(s2 == s1);

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
