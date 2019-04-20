package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 10:02
 **/
/*
CONSTANT_NameAndType_info给出字段或者方法的名称和描述。

CONSTANT_Class_info和CONSTANT_NameAndType_info加在一起可以唯一确定一个字段或者方法

CONSTANT_NameAndType_info {
    u1 tag;
    u2 name_index;
    u2 descriptor_index;
}

字段或方法名由name_index给出，字段或者方法的描述符由descript_index给出
name_index和descriptor_index都是常量池索引，指向CONSTANT_Utf8_info常量。
*/
public class ConstantNameAndType extends ConstantInfo {
    private int name_index;
    private int descriptor_index;

    public ConstantNameAndType(ClassReader reader, int tag) {
        super(tag);
        this.name_index=reader.byteToInt(reader.nextU2());
        this.descriptor_index = reader.byteToInt(reader.nextU2());
    }

    public int getName_index() {
        return name_index;
    }

    public int getDescriptor_index() {
        return descriptor_index;
    }

    @Override
    public String toString() {
        return "ConstantNameAndType{" +
                "tag="+getTag()+
                ", name_index=" + name_index +
                ", descriptor_index=" + descriptor_index +
                '}';
    }
}
