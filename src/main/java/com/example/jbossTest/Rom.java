package com.example.jbossTest;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(IRom.class)
public class Rom implements IRom {

    @Override
    public String say(String name) {
        String str = "Hello " + name;
        System.out.println(str);//这个在服务端输出
        return str;//这个返回给调用该服务方法的客户端
    }
}
