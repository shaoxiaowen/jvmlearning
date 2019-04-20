package com.jvm.ch04.Classpath;

import java.nio.file.*;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-11 10:48
 **/
public class ZipEntry implements Entry {
    private Path absPath;

    public ZipEntry(String absPath) {
        this.absPath = Paths.get(absPath).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        //读取zip
        try (FileSystem zipFs = FileSystems.newFileSystem(absPath, null)) {
            Path path = zipFs.getPath(className);
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }
    @Override
    public String toString() {
        return absPath.toString();
    }
}
