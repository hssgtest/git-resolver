package org.gitresolver.main;

import org.jkube.application.Application;
import org.jkube.logging.Log;

import java.util.LinkedHashMap;
import java.util.Map;

public class GitResolver {

    private static final String RUN = "run";
    private static final String WORKDIR = "workdir";
    private final Map<String, String> initialVariables;
    private final WorkSpace workSpace;
    private final ScriptExecutor executor;

    public GitResolver(String... args) {
        initialVariables = parseArgs(args);
        workSpace = new WorkSpace(initialVariables.get(WORKDIR));
        executor = new ScriptExecutor(workSpace);
    }

    public WorkSpace getWorkSpace() {
        return workSpace;
    }

    public ScriptExecutor getExecutor() {
        return executor;
    }

    public void run() {
        Log.log("Initial variables: "+initialVariables);
        String script = initialVariables.get(RUN);
        if (script == null) {
            Application.fail("Variable "+RUN+" must be set");
        }
        executor.execute(script);
    }

    private Map<String, String> parseArgs(String[] args) {
        Map<String, String> res = new LinkedHashMap<>();
        for (String arg : args) {
            String[] split = arg.split("=");
            if (split.length != 2) {
                Application.fail("argument is not of form key=value: "+arg);
            }
            res.put(split[0].trim(), split[1].trim());
        }
        return res;
    }
}
