package org.gitresolver.main;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GitResolverTest {

    @Test
    public void workdirNotSetTest() {
        GitResolver gr = new GitResolver("run=script", "workdir=/test");
        gr.run();
        assertNotNull(gr.getWorkSpace().getWorkdir());
    }

    @Test
    public void workdirSetTest() {
        String workdir = "/workdir";
        GitResolver gr = new GitResolver("run=script", "workdir="+workdir);
        gr.run();
        assertEquals(gr.getWorkSpace().getWorkdir(), Path.of(workdir));
    }

}
