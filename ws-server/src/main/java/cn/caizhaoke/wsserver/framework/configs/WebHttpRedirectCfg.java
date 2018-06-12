package cn.caizhaoke.wsserver.framework.configs;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description Https已经在application.properties中配置，
 * 此处配置Http重定向到Https[connector.setSecure(false)],程序启动log可看得到同时开启了两个端口8443和8080
 */
@Configuration
public class WebHttpRedirectCfg {

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(redirectConnector());
        return tomcat;
    }

    private Connector redirectConnector() {
        Connector connector = new Connector(
                TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(8080);
//        connector.setSecure(false); //实现http重定向  ->  false可实现：输入：my.com，跳到： https:// www.my.com
        connector.setSecure(true); //http访问8080端口，https访问8443  ->  true可实现：输入：my.com，跳到： http:// www.my.com；输入：https:// www.my.com，跳到：https:// www.my.com
        connector.setRedirectPort(8443);
        return connector;
    }

}
