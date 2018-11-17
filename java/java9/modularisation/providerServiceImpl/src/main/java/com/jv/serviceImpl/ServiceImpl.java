package com.jv.serviceImpl;

import com.jv.service.IService;

public class ServiceImpl implements IService {
    @Override
    public void methodService() {
        System.out.println("impl method of IService");
    }
}
