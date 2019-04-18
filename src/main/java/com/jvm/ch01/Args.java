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

    //解析参数
    public static Args parse(String[] argv){
        Options options = initOptions();
        Args args=new Args();
        CommandLine commandLine=null;
        CommandLineParser parser=new DefaultParser();

        try {
            commandLine=parser.parse(options,argv);
            args.ok=true;
            if(commandLine.hasOption("h")||commandLine.hasOption("help")){
                args.helpFlag=true;
            }
            else if(commandLine.hasOption("v")||commandLine.hasOption("version")){
                args.versionFlag=true;
            }else if(commandLine.hasOption("cp")||commandLine.hasOption("Classpath")){
                args.classpath=commandLine.getOptionValue("cp")==null?commandLine.getOptionValue("cp"):commandLine.getOptionValue("Classpath");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return args;
    }




    //初始化选项
    private static Options initOptions(){
        Options options=new Options();

        //第一个参数是选项名称的缩写，第二个参数是选项名称的全称，第三个参数表示是否需要额外的输入，第四个参数表示对选项的描述信息
        Option opt_help = new Option("h", "help", false, "print help message");
        opt_help.setRequired(false);
        options.addOption(opt_help);

        Option opt_version = new Option("v", "version", false, "print version and exit");
        opt_version.setRequired(false);
        options.addOption(opt_version);

        Option opt_classpath=new Option("cp","Classpath",true,"Classpath");
        opt_classpath.setRequired(false);
        options.addOption(opt_classpath);
        return options;
    }
    @Override
    public String toString() {
        return "Args{" +
                "helpFlag=" + helpFlag +
                ", versionFlag=" + versionFlag +
                ", Classpath='" + classpath + '\'' +
                ", ok=" + ok +
                '}';
    }
}
