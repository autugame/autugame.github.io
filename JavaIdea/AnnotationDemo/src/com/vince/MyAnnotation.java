package com.vince;

import java.lang.annotation.*;

/**
 * 版权来自秋水工作室
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    public String name();
    public int age() default 2;//给变量设置默认值
    public String[] like();
    public Color color();
}
