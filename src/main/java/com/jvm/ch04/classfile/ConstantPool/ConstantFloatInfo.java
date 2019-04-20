package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-16 15:35
 **/
/*
结构
tag     u1  值为4
bytes   u4  按照高位在前存储的float值
 */
public class ConstantFloatInfo extends ConstantInfo {
    private Float value;
    public ConstantFloatInfo(ClassReader reader, int tag) {
        super(tag);
        value=ByteBuffer.wrap(reader.nextU4()).order(ByteOrder.BIG_ENDIAN).getFloat();
    }

    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConstantFloatInfo{" +
                "tag="+getTag()+
                ", value=" + value +
                '}';
    }
}
