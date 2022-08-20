package com.demo.qa.client.impl;

import com.demo.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import jdk.net.SocketFlow;

public class BaseClientImpl implements BaseClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR,"熔断器");
    }
}
