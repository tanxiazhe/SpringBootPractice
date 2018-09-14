package com.archimedes.factoryBean;

import org.springframework.context.annotation.Bean;

public class AbstractFactoryBeanJavaConfig {
    @Bean(name="singleTool")
    SingleToolFactory singleToolFactory(){
        SingleToolFactory factory = new SingleToolFactory();
        factory.setFactoryId(7070);
        factory.setToolId(1);
        return  factory;
    }

    @Bean(name="nonSingleTool")
    NonSingleToolFactory nonSingleToolFactory(){
        NonSingleToolFactory factory = new NonSingleToolFactory();
        factory.setFactoryId(7070);
        factory.setToolId(2);
        return  factory;
    }



}
