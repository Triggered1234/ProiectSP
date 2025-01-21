package com.example.ProiectSP.services;

import java.util.LinkedList;
import java.util.Queue;

public class CommandInvoker {
    private final Queue<Command> commandQueue = new LinkedList<>();

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeCommands() {
        while (!commandQueue.isEmpty()) {
            commandQueue.poll().execute();
        }
    }
}
