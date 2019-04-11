package com.jvm.ch01;

import org.apache.commons.cli.*;

import java.util.List;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-11 09:33
 **/
public class Args {
    boolean helpFlag=false;
    boolean versionFlag=false;
    String classpath;
    List<String> mainClassAndArgs;
    boolean ok;



    //初始化选项
    private static Options initOptions(String[] args){
        Options options=new Options();

        //第一个参数是选项名称的缩写，第二个参数是选项名称的全称，第三个参数表示是否需要额外的输入，第四个参数表示对选项的描述信息
        Option opt_help = new Option("h", "help", false, "print help message");
        opt_help.setRequired(false);
        options.addOption(opt_help);

        Option opt_version = new Option("v", "version", false, "print version and exit");
        opt_version.setRequired(false);
        options.addOption(opt_version);

        Option opt_classpath=new Option("cp","classpath",false,"classpath");
        opt_classpath.setRequired(false);
        options.addOption(opt_classpath);
        return options;
    }

    //解析参数
    public static Args parse(String[] argv){
        Args args=new Args();
        Options options = initOptions(argv);
        CommandLine commandLine=null;
        CommandLineParser parser=new DefaultParser();
        //用来打印帮助信息
        HelpFormatter hf=new HelpFormatter();
        hf.setWidth(110);
        try {
            commandLine=parser.parse(options,argv);
            if(commandLine.hasOption("h")){
                hf.printHelp("testApp",options,true);
            }
            if(commandLine.hasOption("v")){
                System.out.println("version 0.0.1");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return args;
    }
}
