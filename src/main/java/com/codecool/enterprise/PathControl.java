package com.codecool.enterprise;

class PathControl {

    String actualPath(String url){
        String[] urlSegments = url.split("/");
        if(urlSegments.length == 3 && urlSegments[1].equals("user")){
            return "/user";
        } else {
            return url;
        }
    }

    String username(String url){
        String[] urlSegments = url.split("/");
        if(urlSegments.length <= 2){
            return "";
        } else {
            return urlSegments[2];
        }
    }

}
