package org.gitresolver.main;

import java.nio.file.Path;

public class WorkSpace {

    private static final String DEFAULT_WORKDIR = ".";
    private final Path workdir;
    public WorkSpace(String workdirOrNull) {
        workdir = Path.of(workdirOrNull == null ? DEFAULT_WORKDIR : workdirOrNull).toAbsolutePath().normalize();
    }

    public Path getWorkdir() {
        return workdir;
    }
}
