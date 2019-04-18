package com.jvm.ch03.classfile.ConstantPool;

import com.jvm.ch03.classfile.ClassReader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-16 15:50
 **/
/*
结构
tag     u1  值为5
bytes   u8  按照高位在前存储的long值
 */
public class ConstantLongInfo extends ConstantInfo{
    private Long value;

    public ConstantLongInfo(ClassReader reader,int tag) {
        super(tag);
        this.value = ByteBuffer.wrap(reader.nextU8()).order(ByteOrder.BIG_ENDIAN).getLong();
    }


    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConstantLongInfo{" +
                "tag="+getTag()+
                ", value=" + value +
                '}';
    }
}
