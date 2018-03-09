package com.abel.serviceloader;

/**
 * Created by sunzqc on 2017/7/28 17:41.
 */
public class HDFSService implements IService{
    @Override
    public String sayHello() {
        return "Hello HDFS!!";
    }

    @Override
    public String getScheme() {
        return "hdfs";
    }
}
