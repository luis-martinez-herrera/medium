package org.example.asynchronous.standalone;

import java.util.concurrent.RecursiveAction;

public abstract class AbstractRecursiveAction extends RecursiveAction {

    protected final boolean isTask;

    AbstractRecursiveAction(boolean isTask) {
        this.isTask = isTask;
    }
}
