package com.codecool.enterprise;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

import static com.codecool.enterprise.HttpMethodType.GET;

public class RequestHandler {

    private String response;

    @WebrouteAnnotations(method = GET, path = "/")
    public void indexRoute(HttpExchange requestData) throws IOException {
        response = "This is the INDEX side!";
        sendResponse(requestData);
    }

    @WebrouteAnnotations(method = GET, path = "/user")
    public void userRoute(HttpExchange requestData) throws IOException {
        PathControl pc = new PathControl();
        String username = pc.username(requestData.getRequestURI().toString());
        if(username.equals("")){
            username = "World";
        } else {
            username = username.substring(0, 1).toUpperCase() + username.substring(1);
        }
        response = "This is the USER side! Hello " + username + "!";
        sendResponse(requestData);
    }

    @WebrouteAnnotations(method = GET, path = "/test")
    public void testRoute(HttpExchange requestData) throws IOException {
        response = "This is the TEST side!";
        sendResponse(requestData);
    }

    private void sendResponse(HttpExchange requestData) throws IOException{
        requestData.sendResponseHeaders(200, response.length());
        OutputStream os = requestData.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
