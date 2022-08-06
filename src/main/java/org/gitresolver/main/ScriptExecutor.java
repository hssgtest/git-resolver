package org.gitresolver.main;

import org.jkube.logging.Log;

public class ScriptExecutor {

    private final WorkSpace workSpace;
    public ScriptExecutor(WorkSpace workSpace) {
        this.workSpace = workSpace;
    }

    public void execute(String script) {
        Log.log("Executing script "+script+" in  workdir "+workSpace.getWorkdir());
    }
}
