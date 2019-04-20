package com.jvm.ch02;

import com.jvm.ch02.classpath.Classpath;

import java.io.File;
import java.util.Arrays;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-09 11:04
 **/

public class Main {
    public static void main(String[] argv) {
//        for(int i=0;i<argv.length;i++){
//            System.out.println(i+":"+argv[i]);
//        }

        String[] arr={"-Xjre","/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre","java.lang.Object"};

        Args args = Args.parse(arr);
        if (!args.ok || args.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
        } else if (args.versionFlag) {
            System.out.println("java version \"1.8.0\"");
        } else {
            startJVM(args);
        }
    }

    private static void startJVM(Args args){
        Classpath cp=new Classpath(args.jre,args.classpath);
        System.out.printf("Classpath:%s class:%s args:%s\n",cp.getUserClasspath(),args.getMainClass(),args.getAppArgs());

        String className=args.getMainClass().replace(".","/");
        try {
            byte[] classData = cp.readClass(className);
            System.out.println("class data:"+Arrays.toString(classData));
        } catch (Exception e) {
            System.out.println("Cloud not find or load main class"+args.getMainClass());
        }
    }

}
