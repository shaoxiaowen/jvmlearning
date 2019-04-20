package com.jvm.ch04.classfile.AttributeInfo;

import com.jvm.ch04.classfile.ClassReader;
import com.jvm.ch04.classfile.ConstantPool.ConstantPool;
import com.jvm.ch04.classfile.ConstantPool.ConstantUtf8Info;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 15:15
 **/

/*
field_info {
        u2 access_flags;//访问标志
        u2 name_index;//常量池索引 名字
        u2 descriptor_index;//常量池索引  描述符

//属性表
        u2 attributes_count;
        attribute_info attributes[attributes_count];
        }

*/
public class AttributeFactory {

    private static AttributeInfo readAttribute(ClassReader reader, ConstantPool pool) {
        //attribute_name_index是一项指向CONSTANT_Utf8_info型常量的索引
        int attributeNameIndex = reader.byteToInt(reader.nextU2());
        ConstantUtf8Info constantUtf8Info = (ConstantUtf8Info) pool.getConstantInfo(attributeNameIndex);
        String attr_name = constantUtf8Info.getValue();
        int attributeLength = reader.byteToInt(reader.nextU4());
        switch (attr_name) {
            case "Code"://方法体
                return new Attr_Code(reader, pool, attributeNameIndex, attributeLength);
            case "Exceptions"://变长属性，记录方法抛出的异常表
                return new Attr_Exceptions(reader,attributeNameIndex, attributeLength);
            case "LineNumberTable"://方法行号
                return new Attr_LineNumberTable(reader,attributeNameIndex, attributeLength);
            case "LocalVariableTable"://方法局部变量
                return new Attr_LocalVariableTable(reader,attributeNameIndex, attributeLength);
            case "SourceFile"://源文件名，如xxx.java
                return new Attr_SourceFile(reader,attributeNameIndex, attributeLength);
            case "ConstantValue"://常量表达式的值
                return new Attr_ConstantValue(reader,attributeNameIndex, attributeLength);
            case "InnerClasses"://内部类
                return new Attr_InnerClasses(reader,attributeNameIndex, attributeLength);
            case "Synthetic":
                return new Attr_Synthetic(attributeNameIndex, attributeLength);
            case "Deprecated":
                return new Attr_Deprecated(attributeNameIndex, attributeLength);
            case "Signature":
                return new Attr_Signature(reader,attributeNameIndex, attributeLength);
            case "BootstrapMethods":
                return new Attr_BootstrapMethods(reader,attributeNameIndex, attributeLength);
            default:
                return new AttributeInfo(reader,attributeNameIndex, attributeLength);
        }
    }

    public static AttributeInfo[] readAttributes(ClassReader reader, ConstantPool pool, int attributes_count) {
        AttributeInfo[] attributes = new AttributeInfo[attributes_count];
        for (int i = 0; i < attributes_count; i++) {
            attributes[i] = AttributeFactory.readAttribute(reader, pool);
        }
        return attributes;
    }

}
