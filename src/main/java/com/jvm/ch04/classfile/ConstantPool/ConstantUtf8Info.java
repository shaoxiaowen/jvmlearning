package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-16 10:22
 **/
/*
结构：
tag     u1 值为1
length  u2 UTF-8编码的字符串占用的字节数
bytes   u1 长度为length的UTF-8编码的字符串
 */


public class ConstantUtf8Info extends ConstantInfo {
    private int length;
    private String value;


    public ConstantUtf8Info(ClassReader reader, int tag) {
        super(tag);
        length=reader.byteToInt(reader.nextU2());
        value=new String (reader.nextBytes(length));

    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConstantUtf8Info{" +
                "tag=" + getTag() +
                ", length=" + length +
                ", value='" + value + '\'' +
                '}';
    }
}
