package com.abel.serviceloader;

/**
 * Created by sunzqc on 2017/7/28 17:41.
 */
public class LocalService implements IService {
    @Override
    public String sayHello() {
        return "Hello Local!!";
    }

    @Override
    public String getScheme() {
        return "local";
    }
}
