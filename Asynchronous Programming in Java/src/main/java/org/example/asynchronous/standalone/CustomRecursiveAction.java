package org.example.asynchronous.standalone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class CustomRecursiveAction extends AbstractRecursiveAction {

  public CustomRecursiveAction() {
    super(false);
  }

  @Override
  protected void compute() {
    if (!super.isTask) {
      ForkJoinTask.invokeAll(createSubtasks());
    }
  }

  private List<CustomRecursiveTask> createSubtasks() {
    List<CustomRecursiveTask> subtasks = new ArrayList<>();
    subtasks.add(new CustomRecursiveTask());
    subtasks.add(new CustomRecursiveTask());
    return subtasks;
  }
}
