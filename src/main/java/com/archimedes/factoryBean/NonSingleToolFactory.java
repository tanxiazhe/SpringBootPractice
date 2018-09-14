package com.archimedes.factoryBean;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class NonSingleToolFactory extends AbstractFactoryBean<Tool> {
 
    private int factoryId;
    private int toolId;
 
    public NonSingleToolFactory() {
        setSingleton(false);
    }
 
    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }
 
    @Override
    protected Tool createInstance() throws Exception {
        return new Tool(toolId);
    }
 
    // standard setters and getters

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }
}