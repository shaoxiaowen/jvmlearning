package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 10:21
 **/
/*
CONSTANT_MethodHandle_info{
    u1 tag;
    u1 reference_kind;//句柄类型
    u2 reference_index;//常量池表的索引
}
 */
public class ConstantMethodHandleInfo extends ConstantInfo {
    private int referrecn_kind;
    private int reference_index;

    public ConstantMethodHandleInfo(ClassReader reader, int tag) {
        super(tag);
        this.referrecn_kind = reader.byteToInt(reader.nextU1());
        this.reference_index=reader.byteToInt(reader.nextU2());
    }


    public int getReferrecn_kind() {
        return referrecn_kind;
    }

    public int getReference_index() {
        return reference_index;
    }

    @Override
    public String toString() {
        return "ConstantMethodHandleInfo{" +
                "tag="+getTag()+
                ", referrecn_kind=" + referrecn_kind +
                ", reference_index=" + reference_index +
                '}';
    }
}
