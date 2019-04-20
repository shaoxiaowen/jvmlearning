package com.jvm.ch04.classfile.ConstantPool;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 15:32
 **/
public class ConstantFieldRefInfo extends ConstantInfo {
    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantFieldRefInfo(ClassReader reader, int tag) {
        super(tag);
        this.classIndex = reader.byteToInt(reader.nextU2());
        this.nameAndTypeIndex = reader.byteToInt(reader.nextU2());
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public String toString() {
        return "ConstantFieldRefInfo{" +
                "tag="+getTag()+
                ", classIndex=" + classIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                '}';
    }
}
