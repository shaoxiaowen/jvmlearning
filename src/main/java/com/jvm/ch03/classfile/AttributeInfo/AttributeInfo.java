package com.jvm.ch03.classfile.AttributeInfo;

import com.jvm.ch03.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 20:21
 **/
/*
属性(attribute)在classFile结构，field_info结构，method_info结构和Code_attribute结构中都有使用
 */
public class AttributeInfo {
    protected int attribute_name_index;
    protected int attribute_length;

    public AttributeInfo(ClassReader reader,int attribute_name_index, int attribute_length) {
        this.attribute_name_index = attribute_name_index;
        this.attribute_length = attribute_length;
        reader.nextBytes(attribute_length);
    }

    public AttributeInfo(int attribute_name_index, int attribute_length) {
        this.attribute_name_index = attribute_name_index;
        this.attribute_length = attribute_length;
    }


    public int getAttribute_name_index() {
        return attribute_name_index;
    }

    public int getAttribute_length() {
        return attribute_length;
    }
}
