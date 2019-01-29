package com.codecool.enterprise;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyHandler implements HttpHandler {

    private HttpMethodType newMethodType;

    public void handle(HttpExchange exchange) {
        RequestHandler requestHandler = new RequestHandler();
        PathControl pc = new PathControl();
        String requestURI = pc.actualPath(exchange.getRequestURI().toString());
        newMethodType = checkMethodType(exchange.getRequestMethod());

        try {
            for (Method method : Class.forName("com.codecool.enterprise.RequestHandler").getMethods()) {

                HttpMethodType annotationMethod = method.getAnnotation(WebrouteAnnotations.class).method();
                String annotationPath = method.getAnnotation(WebrouteAnnotations.class).path();

                if(newMethodType.equals(annotationMethod) && requestURI.equals(annotationPath)) {
                    method.invoke(requestHandler, exchange);
                }
            }
        }  catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (InvocationTargetException e) {
            e.printStackTrace();
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    HttpMethodType checkMethodType(String methodType){
        if(methodType.equals("GET")){
            newMethodType = HttpMethodType.GET;
        } else if (methodType.equals("POST")){
            newMethodType = HttpMethodType.POST;
        } else if (methodType.equals("PUT")){
            newMethodType = HttpMethodType.PUT;
        } else {
            newMethodType = HttpMethodType.DELETE;
        }
        return newMethodType;
    }

}
