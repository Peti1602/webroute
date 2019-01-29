package com.codecool.enterprise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathControlTest {

    @Test
    void actualPath1() {
        PathControl pc = new PathControl();
        String actualPath = pc.actualPath("/");
        assertEquals("/", actualPath);
    }

    @Test
    void actualPath2() {
        PathControl pc = new PathControl();
        String actualPath = pc.actualPath("/user");
        assertEquals("/user", actualPath);
    }

    @Test
    void actualPath3() {
        PathControl pc = new PathControl();
        String actualPath = pc.actualPath("/user/peti");
        assertEquals("/user", actualPath);
    }

    @Test
    void actualPath4() {
        PathControl pc = new PathControl();
        String actualPath = pc.actualPath("/user/peti/blasko");
        assertEquals("/user/peti/blasko", actualPath);
    }

    @Test
    void actualPath5() {
        PathControl pc = new PathControl();
        String actualPath = pc.actualPath("/test");
        assertEquals("/test", actualPath);
    }

    @Test
    void username1() {
        PathControl pc = new PathControl();
        String username = pc.username("/user");
        assertEquals("", username);
    }

    @Test
    void username2() {
        PathControl pc = new PathControl();
        String username = pc.username("/user/peti");
        assertEquals("peti", username);
    }

}