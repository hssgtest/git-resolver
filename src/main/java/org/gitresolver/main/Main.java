package org.gitresolver.main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running gitresolver v0.0");
        new GitResolver(args).run();
        System.out.println("Done.");
    }
}