package com.jvm.ch03.Classpath;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @description: 存放jar包的相关数据
 * @author: xiaowen
 * @create: 2019-04-11 15:04
 **/
public class Classpath {

    private Entry bootClasspath;
    private Entry extClasspath;
    private Entry userClasspath;

    public Classpath(String jreOption,String cpOption) {
        parseBootAndExtClasspath(jreOption);
        parseUserClasspath(cpOption);
    }

    //获取启动类的相关jar包和扩展类的相关jar包
    private void parseBootAndExtClasspath(String jreOption){
        String jreDir=getJreDir(jreOption);

        String jreLibPath=Paths.get(jreDir,"lib")+File.separator+"*";
        bootClasspath =new WildcardEntry(jreLibPath);

        String jreExtPath=Paths.get(jreDir,"lib","ext")+File.separator+"*";
        extClasspath=new WildcardEntry(jreExtPath);
    }

    private static String getJreDir(String jreOption){
        if(jreOption!=null&& Files.exists(Paths.get(jreOption))){
            return jreOption;
        }
        if(Files.exists(Paths.get("./jre"))){
            return "./jre";
        }
        String jh=System.getenv("JAVA_HOME");
        if(jh!=null){
            return Paths.get(jh,"jre").toString();
        }
        throw new RuntimeException("Can not find JRe folder");
    }

    /**
     * 获取用户类的相关jar包
     * @param cpOption
     */
    private void parseUserClasspath(String cpOption){
        if(cpOption==null){
            cpOption=".";
        }
        userClasspath=Entry.create(cpOption);
    }

    /**
     * 双亲加载
     * @param className
     * @return
     * @throws Exception
     */
    public byte[] readClass(String className) throws Exception{
        className=className+".class";
        byte[] bytes = bootClasspath.readClass(className);
        if (bytes!=null){
            return bytes;
        }
        bytes=extClasspath.readClass(className);
        if (bytes!=null){
            return bytes;
        }
        return userClasspath.readClass(className);
    }

    public static String join(String...paths){
        return Arrays.stream(paths)
                .collect(Collectors.joining(File.pathSeparator));
    }

    public static String[] split(String pathList){
        return pathList.split(File.pathSeparator);
    }

    public Entry getUserClasspath() {
        return userClasspath;
    }
}
