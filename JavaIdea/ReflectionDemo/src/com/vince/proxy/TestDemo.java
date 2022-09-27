package com.vince.proxy;

import org.junit.Test;

public class TestDemo {
    @Test
    public void testProxy() {
        CreateProxy cp = new CreateProxy();
        Hotel person = new Person();
        Hotel proxy = (Hotel) cp.create(person);
        //proxy.Shopping();
        proxy.reserve();
    }
}
