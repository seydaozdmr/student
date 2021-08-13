package com.soap.student.WebServiceConfig;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet2(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet,"/service/*");
    }

    @Bean(name="studentDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentsSchema){
        DefaultWsdl11Definition defaultWsdl11Definition=new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("StudentDetailsPort");
        defaultWsdl11Definition.setLocationUri("/service/student-details");
        defaultWsdl11Definition.setTargetNamespace("http://www.howtodoinjava.com/xml/school");
        defaultWsdl11Definition.setSchema(studentsSchema);

        return  defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema studentsShema() {
        return new SimpleXsdSchema(new ClassPathResource("student.xsd"));
    }
}
