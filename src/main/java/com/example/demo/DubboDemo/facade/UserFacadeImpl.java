package com.example.demo.DubboDemo.facade;

import com.example.demo.DubboDemo.api.UserFacade;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zh
 * @date 2021-03-20 12:11
 **/
@Service(version = "1.0.0")
public class UserFacadeImpl implements UserFacade {

    @Override
    public String getUserName(Long userId) {
        return "my userId is " + userId;
    }
}
