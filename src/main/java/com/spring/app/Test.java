package com.spring.app;

import com.spring.app.service.UserService;
import com.spring.spring.MyApplicationContext;

/**
 * @author
 */
public class Test {

    public static void main(String[] args) {
        MyApplicationContext applicationContext = new MyApplicationContext(AppConfig.class);

        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.test();
    }


}
