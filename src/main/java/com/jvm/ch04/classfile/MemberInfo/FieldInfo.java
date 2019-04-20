package com.jvm.ch04.classfile.MemberInfo;

import com.jvm.ch04.classfile.AttributeInfo.AttributeFactory;
import com.jvm.ch04.classfile.AttributeInfo.AttributeInfo;
import com.jvm.ch04.classfile.ClassReader;
import com.jvm.ch04.classfile.ConstantPool.ConstantPool;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 18:29
 **/
/*
field_info {
    u2             access_flags;
    u2             name_index;
    u2             descriptor_index;
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
 */
public class FieldInfo {
    private int accessFlags;
    private int nameIndex;
    private int descriptor_index;
    private int attributes_count;
    private AttributeInfo[] attributes;

    public FieldInfo(ClassReader reader, ConstantPool pool) {
        this.accessFlags = reader.byteToInt(reader.nextU2());
        this.nameIndex=reader.byteToInt(reader.nextU2());
        this.descriptor_index=reader.byteToInt(reader.nextU2());
        this.attributes_count=reader.byteToInt(reader.nextU2());
        this.attributes=AttributeFactory.readAttributes(reader,pool,attributes_count);
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptor_index() {
        return descriptor_index;
    }

    public int getAttributes_count() {
        return attributes_count;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "accessFlags=" + accessFlags +
                ", nameIndex=" + nameIndex +
                ", descriptor_index=" + descriptor_index +
                ", attributes_count=" + attributes_count +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}
