package com.jvm.ch03.classfile.AttributeInfo;

import com.jvm.ch03.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 20:25
 **/
/*
Signature_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 signature_index;
}
*/
public class Attr_Signature extends AttributeInfo{
    private int signature_index;
    public Attr_Signature(ClassReader reader,int attribute_name_index, int attribute_length) {
        super(attribute_name_index, attribute_length);
        this.signature_index=reader.byteToInt(reader.nextU2());
    }

    public int getSignature_index() {
        return signature_index;
    }
}
