package com.example.jbossTest;


import org.jboss.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(IRom.class)
public class Rom implements IRom {

    Logger logger = Logger.getLogger(Rom.class);

    @Override
    public String say(String name) {
        String str = "Hello " + name;
        logger.error(str);

        logger.warn("warn");
        logger.error("error");
        logger.info("info");
        return str;//这个返回给调用该服务方法的客户端
    }
}
