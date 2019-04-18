package com.jvm.ch03;

import com.jvm.ch03.classfile.ClassFile;
import com.jvm.ch03.Classpath.Classpath;

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

//        String[] arr={"-Xjre","/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre","java.lang.Object"};
        String[] arr={"-cp","/Users/shaoxiaowen/Desktop/JavaCode/javabasiclearning/target/classes","ClassFileTest"};

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
//            printClassData(classData);
            ClassFile cf=new ClassFile(classData);
            cf.showConstantPool();
        } catch (Exception e) {
            System.out.println("Cloud not find or load main class"+args.getMainClass());
        }
    }

    private static void printClassData(byte[] classData){
        for(int i=0;i<classData.length;i++){
            byte b=classData[i];
            int value=b&0xFF;
            String strHex=Integer.toHexString(value);
            //用两个字节表示16进制
            if(strHex.length()<2){
                strHex="0"+strHex;
            }
            System.out.print(strHex+",");
        }
    }

}
