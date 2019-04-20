package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-16 11:15
 **/

/*
结构
tag     u1  值为3
bytes   u4  按照高位在前存储的int值
 */
public class ConstantIntegerInfo extends ConstantInfo {
    private Integer value;

    public ConstantIntegerInfo(ClassReader reader, int tag) {
        super(tag);
        this.value = reader.byteToInt(reader.nextU4());
    }


    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConstantIntegerInfo{" +
                "tag="+getTag()+
                ", value=" + value +
                '}';
    }
}
