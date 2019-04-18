package com.jvm.ch03.classfile.ConstantPool;

import com.jvm.ch03.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 09:47
 **/

/*
CONSTANT_String_info常量表示java.lang.String字面量

CONSTANT_String_info {
    u1 tag;
    u2 string_index;
}

可以看到，CONSTANT_String_info本身并不存放字符串数据，只存放了常量池索引，
这个索引指向了CONSTANT_Utf8_info常量

*/
public class ConstantStringInfo extends ConstantInfo{
    private int string_index;

    public ConstantStringInfo(ClassReader reader,int tag) {
        super(tag);
        this.string_index = reader.byteToInt(reader.nextU2());
    }


    public int getString_index() {
        return string_index;
    }

    @Override
    public String toString() {
        return "ConstantStringInfo{" +
                "tag="+getTag()+
                ", string_index=" + string_index +
                '}';
    }
}
