package com.example.rest;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.kqueue.KQueue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@MicronautTest
class AppTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    @EnabledOnOs(value = OS.MAC)
    void kqueueIsAvailableOnMacOs() {
        KQueue.ensureAvailability();
    }

    @Test
    @EnabledOnOs(value = OS.LINUX)
    void epollIsAvailableOnLinux() {
        Epoll.ensureAvailability();
    }
}
