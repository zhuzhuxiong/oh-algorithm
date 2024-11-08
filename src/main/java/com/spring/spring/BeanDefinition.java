package com.spring.spring;

/**
 * @author
 */
public class BeanDefinition {

    private Class type;

    private String scope;

    private Integer isLazy;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getIsLazy() {
        return isLazy;
    }

    public void setIsLazy(Integer isLazy) {
        this.isLazy = isLazy;
    }
}
