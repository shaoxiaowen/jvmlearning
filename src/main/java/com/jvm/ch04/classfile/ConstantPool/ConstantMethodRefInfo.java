package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 09:53
 **/
/*
CONSTANT_Fieldref_info表示字段符号引用
CONSTANT_Fieldref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}

CONSTANT_Methodref_info表示普通方法(非接口)方法符号引用
CONSTANT_Methodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}

CONSTANT_InterfaceMethodref_info表示接口方法符号引用
CONSTANT_InterfaceMethodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}

三种常量结构一模一样
class_index和name_and_type_index都是常量池索引，
分别指向CONSTANT_Class_info和CONSTANT_NameAndType_info常量。
*/
public class ConstantMethodRefInfo extends ConstantInfo {
    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMethodRefInfo(ClassReader reader, int tag) {
        super(tag);
        this.classIndex = reader.byteToInt(reader.nextU2());
        this.nameAndTypeIndex = reader.byteToInt(reader.nextU2());

    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public String toString() {
        return "ConstantMethodRefInfo{" +
                "tag="+getTag()+
                ", classIndex=" + classIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                '}';
    }
}
