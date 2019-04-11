package com.jvm.ch02.classpath;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-11 10:38
 **/
public class DirEntry implements Entry{
    private Path absPath;

    public DirEntry(String path) {
        absPath=Paths.get(path).toAbsolutePath();
    }


    @Override
    public byte[] readClass(String className) throws Exception {
        return Files.readAllBytes(absPath.resolve(className));
    }

    @Override
    public String toString() {
        return absPath.toString();
    }
}
