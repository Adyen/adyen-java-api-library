package com.adyen;

import com.adyen.model.acswebhooks.JSON;
import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.*;

public class JSONTest {

    JSON json;
    private Set<Class<?>> visitedClasses;

    @Test
    public void nonCircularDependencyTest() {
        class A {}
        class B {
            A a;
        }
        class C {
            B b;
        }
        assertTrue(json.isInstanceOf(C.class, new C(), visitedClasses));
    }

}
