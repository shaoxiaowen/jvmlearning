package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 10:29
 **/
/*
CONSTANT_MethodType_info{
    u1 tag;
    u2 descriptor_index //常量池索引，指向CONSTANT_Utf8_info结构
}
 */

public class ConstantMethodTypeInfo extends ConstantInfo {
    private int descriptor_index;

    public ConstantMethodTypeInfo(ClassReader reader, int tag) {
        super(tag);
        this.descriptor_index = reader.byteToInt(reader.nextU2());
    }

    public int getDescriptor_index() {
        return descriptor_index;
    }

    @Override
    public String toString() {
        return "ConstantMethodTypeInfo{" +
                "tag="+getTag()+
                ", descriptor_index=" + descriptor_index +
                '}';
    }
}
