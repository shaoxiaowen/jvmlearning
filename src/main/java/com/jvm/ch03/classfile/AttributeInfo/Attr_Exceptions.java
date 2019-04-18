package com.jvm.ch03.classfile.AttributeInfo;

import com.jvm.ch03.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 18:25
 **/
/*
Exceptions_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 number_of_exceptions;
    u2 exception_index_table[number_of_exceptions];
}

Exception是变长属性，记录方法抛出的异常表
*/

public class Attr_Exceptions extends AttributeInfo {
    private int number_of_exceptions;
    private int[] exceptionIndexTable;

    public Attr_Exceptions(ClassReader reader,int attribute_name_index, int attribute_length) {
        super(attribute_name_index,attribute_length);
        this.number_of_exceptions = reader.byteToInt(reader.nextU2());
        exceptionIndexTable=new int[number_of_exceptions];
    }

    private int[] readExceptionIndexTable(ClassReader reader){
        int[] exceptionIndexTable=new int[number_of_exceptions];
        for(int i=0;i<number_of_exceptions;i++){
            exceptionIndexTable[i]=reader.byteToInt(reader.nextU2());
        }
        return exceptionIndexTable;
    }

    public int getNumber_of_exceptions() {
        return number_of_exceptions;
    }

    public int[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }
}
