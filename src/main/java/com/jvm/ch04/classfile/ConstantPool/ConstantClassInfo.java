package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-16 16:53
 **/

/*
结构
tag     u1  值为7
name_index   u2  指向全限定常量项的索引
 */

/*
CONSTANT_Class_info常量表示类或者接口的符号引用


CONSTANT_Class_info {
    u1 tag;
    u2 name_index;
}

和CONSTANT_String_info类似，name_index是常量池索引，指向CONSTANT_Utf8_info常量。

类和超类索引，以及接口表中的接口索引指向的都是CONSTANT_Class_info常量
*/
public class ConstantClassInfo extends ConstantInfo {
    private int name_index;

    public ConstantClassInfo(ClassReader reader, int tag) {
        super(tag);
        this.name_index = reader.byteToInt(reader.nextU2());
    }

    public int getName_index() {
        return name_index;
    }

    @Override
    public String toString() {
        return "ConstantClassInfo{" +
                "tag="+getTag()+
                ", name_index=" + name_index +
                '}';
    }
}
