package com.jvm.ch01;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-09 11:04
 **/
public class Main {
    public static void main(String[] argv) {
        Args args = Args.parse(argv);
        if (!args.ok || args.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
        } else if (args.versionFlag) {
            System.out.println("java version \"1.8.0\"");
        } else {
            System.out.println(args.classpath);
        }

    }
}
