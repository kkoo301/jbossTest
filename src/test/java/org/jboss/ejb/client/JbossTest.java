package org.jboss.ejb.client;

import com.example.jbossTest.IRom;
import org.wildfly.naming.client.ProviderEnvironment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;

public class JbossTest {

    //https://github.com/wildfly/jboss-ejb-client

    public static void main(String[] args) throws Exception {
        Properties environment = new Properties();

        environment.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
        environment.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
        environment.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
        environment.put("jboss.naming.client.ejb.context", true);

        InitialContext initialContext = new InitialContext(environment);

        IRom rom = (IRom) initialContext.lookup("ejb:/jbossTest/Rom!com.example.jbossTest.IRom");
        String say = rom.say("111");
        System.out.println(say);
    }

}