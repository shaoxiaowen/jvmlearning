package com.jvm.ch03.classfile.AttributeInfo;

import com.jvm.ch03.classfile.ClassReader;
import com.jvm.ch03.classfile.ConstantPool.ConstantPool;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 16:51
 **/

/*
ConstantValue_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 constantvalue_index;
}
ConstantValue是定长属性，只会出现在field_info结构中，用于表示常量表达式的值

attribute_length的值必须是2。constantvalue_index是常量池索引

*/

public class Attr_ConstantValue extends AttributeInfo {
    private int constant_value_index;

    public Attr_ConstantValue(ClassReader reader, int attribute_name_index, int attribute_length) {
        super(attribute_name_index,attribute_length);
        this.constant_value_index=reader.byteToInt(reader.nextU2());
    }

    public int getConstantvalue_index() {
        return constant_value_index;
    }
}
