package com.jvm.ch02.classpath;

import java.io.File;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-11 10:32
 **/
public interface Entry {

    byte[] readClass(String className) throws Exception;

    //factory method
    static Entry create(String path){
        if(path.contains(File.pathSeparator)){
            return new CompositeEntry(path);
        }
        if(path.endsWith("*")){
            return new WildcardEntry(path);
        }
        if(path.endsWith(".jar")||path.endsWith(".JAR")||path.endsWith(".zip")||path.endsWith(".ZIP")){
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }
}
