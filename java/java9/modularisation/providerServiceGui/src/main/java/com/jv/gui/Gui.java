package com.jv.gui;

import com.jv.service.IService;

import java.util.ServiceLoader;

public class Gui {

    public static void main(String args[]){
        ServiceLoader<IService> serviceProviders = ServiceLoader.load(IService.class);
        IService serviceImpl = serviceProviders.stream().findFirst().get().get();
        serviceImpl.methodService();
    }
}
