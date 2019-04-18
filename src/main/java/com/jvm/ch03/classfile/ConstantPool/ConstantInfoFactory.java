package com.jvm.ch03.classfile.ConstantPool;

import com.jvm.ch03.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-16 09:59
 **/
public class ConstantInfoFactory {
    /*
    常量池中常量的标志
     */
    static final int CONSTANT_Utf8 = 1;
    static final int CONSTANT_Integer = 3;
    static final int CONSTANT_Float = 4;
    static final int CONSTANT_Long = 5;
    static final int CONSTANT_Double = 6;
    static final int CONSTANT_Class = 7;
    static final int CONSTANT_String = 8;
    static final int CONSTANT_Fieldref = 9;
    static final int CONSTANT_Methodref = 10;
    static final int CONSTANT_InterfaceMethodref = 11;
    static final int CONSTANT_NameAndType = 12;
    static final int CONSTANT_MethodHandle = 15;
    static final int CONSTANT_MethodType = 16;
    static final int CONSTANT_InvokeDynamic = 18;

    static ConstantInfo createConstantInfo(int tag, ClassReader reader, ConstantPool constantPool) {
        switch (tag) {
            case CONSTANT_Utf8:
                return new ConstantUtf8Info(reader,tag);
            case CONSTANT_Integer:
                return new ConstantIntegerInfo(reader,tag);
            case CONSTANT_Float:
                return new ConstantFloatInfo(reader,tag);
            case CONSTANT_Long:
                return new ConstantLongInfo(reader,tag);
            case CONSTANT_Double:
                return new ConstantDoubleInfo(reader,tag);
            case CONSTANT_Class:
                return new ConstantClassInfo(reader,tag);
            case CONSTANT_String:
                return new ConstantStringInfo(reader,tag);
            case CONSTANT_Fieldref:
                return new ConstantFieldRefInfo(reader,tag);
            case CONSTANT_Methodref:
                return new ConstantMethodRefInfo(reader,tag);
            case CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMethodRefInfo(reader,tag);
            case CONSTANT_NameAndType:
                return new ConstantNameAndType(reader,tag);
            case CONSTANT_MethodHandle:
                return new ConstantMethodHandleInfo(reader,tag);
            case CONSTANT_MethodType:
                return new ConstantMethodTypeInfo(reader,tag);
            case CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamicInfo(reader,tag);
        }
        return null;
    }
}
