package com.codecool.enterprise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHandlerTest {

    private MyHandler myHandler;
    private HttpMethodType methodType;

    @Test
    void checkMethodTypeGet() {
        myHandler = new MyHandler();
        methodType = myHandler.checkMethodType("GET");
        assertEquals(HttpMethodType.GET, methodType);
    }

    @Test
    void checkMethodTypePost() {
        myHandler = new MyHandler();
        methodType = myHandler.checkMethodType("POST");
        assertEquals(HttpMethodType.POST, methodType);
    }

    @Test
    void checkMethodTypePut() {
        myHandler = new MyHandler();
        methodType = myHandler.checkMethodType("PUT");
        assertEquals(HttpMethodType.PUT, methodType);
    }

    @Test
    void checkMethodTypeDelete() {
        myHandler = new MyHandler();
        methodType = myHandler.checkMethodType("DELETE");
        assertEquals(HttpMethodType.DELETE, methodType);
    }

}