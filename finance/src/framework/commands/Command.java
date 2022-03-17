package framework.commands;

import framework.ui.UIController;

public interface Command {
    void execute(UIController uiController);
}
