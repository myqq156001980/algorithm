package com.abel.serviceloader;

import java.sql.DriverManager;
import java.util.ServiceLoader;

/**
 * Created by sunzqc on 2017/7/28 17:54.
 * mysql 加载驱动时使用ServiceLoader Class.forName(“com.mysql.jdbc.Driver”);
 * 在mysql connector jar包下 Driver的实现类中有如下代码
 * static {
 *      try {
 *          java.sql.DriverManager.registerDriver(new Driver());
 *      } catch (SQLException E) {
 *          throw new RuntimeException("Can't register driver!");
 *      }
 *}
 * 注册了其实现的Driver，在DriverManager类中的 loadInitialDrivers()方法中通过ServiceLoader的方式加载/META-INF/services
 * 配置文件中的实现类
 * static {
 *      loadInitialDrivers();
 *      println("JDBC DriverManager initialized");
 *}
 *
 */
public class ServiceLoaderTest {

    public static void main(String[] args) {
        //need to define related class full name in /META-INF/services/....
        ServiceLoader<IService> serviceLoader = ServiceLoader
                .load(IService.class);
        for (IService service : serviceLoader) {
            System.out.println(service.getScheme() + "=" + service.sayHello());
        }
    }
}
