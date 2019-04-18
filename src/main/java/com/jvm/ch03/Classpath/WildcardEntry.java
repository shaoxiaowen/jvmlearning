package com.jvm.ch03.Classpath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-11 14:59
 **/
public class WildcardEntry extends CompositeEntry {
    public WildcardEntry(String pathList) {
        super(toPathList(pathList));
    }

    /**
     * 找出lib目录下的所有jar包
     * @param wildcardPath
     * @return
     */
    private static String toPathList(String wildcardPath){
        String baseDir=wildcardPath.replace("*","");// remove *
        try {
            String path = Files.walk(Paths.get(baseDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
                    .collect(Collectors.joining(File.pathSeparator));
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
