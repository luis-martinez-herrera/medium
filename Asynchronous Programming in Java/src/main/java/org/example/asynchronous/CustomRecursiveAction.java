package org.example.asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class CustomRecursiveAction extends RecursiveAction {

    private final boolean isTask;

    public CustomRecursiveAction(boolean isTask) {
        this.isTask = isTask;
    }

    @Override
    protected void compute() {
        if (isTask) {
            FactorialCalculator factorialCalculator = new FactorialCalculatorImpl(6);
            try {
                factorialCalculator.calculate();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            ForkJoinTask.invokeAll(createSubtasks());
        }
    }

    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();
        subtasks.add(new CustomRecursiveAction(true));
        subtasks.add(new CustomRecursiveAction(true));
        return subtasks;
    }
}
