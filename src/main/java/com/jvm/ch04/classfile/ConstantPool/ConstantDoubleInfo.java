package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-16 16:43
 **/
/*
结构
tag     u1  值为6
bytes   u8  按照高位在前存储的double值
 */
public class ConstantDoubleInfo extends ConstantInfo {
    private Double value;

    public ConstantDoubleInfo(ClassReader reader, int tag) {
        super(tag);
        this.value =ByteBuffer.wrap(reader.nextU8()).order(ByteOrder.BIG_ENDIAN).getDouble();
    }

    public Double getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "ConstantDoubleInfo{" +
                "tag="+getTag()+
                ", value=" + value +
                '}';
    }
}
