package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 10:34
 **/
/*
CONSTANT_InvokeDynamic_info {
    u1 tag;
    u2 bootstrap_method_attr_index;
    u2 name_and_type_index;
}
*/
public class ConstantInvokeDynamicInfo extends ConstantInfo {
    private int bootstrap_method_attr_index;
    private int name_and_type_index;


    public ConstantInvokeDynamicInfo(ClassReader reader, int tag) {
        super(tag);
        this.bootstrap_method_attr_index = reader.byteToInt(reader.nextU2());
        this.name_and_type_index=reader.byteToInt(reader.nextU2());
    }


    public int getBootstrap_method_attr_index() {
        return bootstrap_method_attr_index;
    }

    public int getName_and_type_index() {
        return name_and_type_index;
    }

    @Override
    public String toString() {
        return "ConstantInvokeDynamicInfo{" +
                "tag="+getTag()+
                ", bootstrap_method_attr_index=" + bootstrap_method_attr_index +
                ", name_and_type_index=" + name_and_type_index +
                '}';
    }
}
