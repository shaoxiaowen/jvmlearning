package com.jvm.ch04;

import com.jvm.ch03.Classpath.Classpath;
import com.jvm.ch03.classfile.ClassFile;
import com.jvm.ch04.rtda.Frame;
import com.jvm.ch04.rtda.LocalVars;
import com.jvm.ch04.rtda.OperandStack;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-09 11:04
 **/
public class Main {
    public static void main(String[] argv) {

        startJVM();
    }

    private static void startJVM(){
        Frame frame=new Frame(100,100);
        testLocalVars(frame.getLocalVars());
        testOperandStack(frame.getOperandStack());
    }

    private static void testLocalVars(LocalVars vars){
        vars.SetInt(0, 100);
        vars.SetInt(1, -100);
        vars.SetLong(2, 2997924580l);
        vars.SetLong(4, -2997924580l);
        vars.SetFloat(6, 3.1415926f);
        vars.SetDouble(7, 2.71828182845f);
        vars.SetRef(9, null);
        System.out.println("============LocalVars==============");
        System.out.println(vars.GetInt(0));
        System.out.println(vars.GetInt(1));
        System.out.println(vars.GetLong(2));
        System.out.println(vars.GetLong(4));
        System.out.println(vars.GetFloat(6));
        System.out.println(vars.GetDouble(7));
        System.out.println(vars.GetRef(9));
    }
    private static void testOperandStack(OperandStack ops){
        ops.PushInt(100);
        ops.PushInt(-100);
        ops.PushLong(2997924580l);
        ops.PushLong(-2997924580l);
        ops.PushFloat(3.1415926f);
        ops.PushDouble(2.71828182845);
        ops.PushRef(null);
        System.out.println("============OperandStack==============");
        System.out.println(ops.PopRef());
        System.out.println(ops.PopDouble());
        System.out.println(ops.PopFloat());
        System.out.println(ops.PopLong());
        System.out.println(ops.PopLong());
        System.out.println(ops.PopInt());
        System.out.println(ops.PopInt());
    }

}
