package com.jvm.ch04.classfile.AttributeInfo;

import com.jvm.ch04.classfile.ClassReader;
import com.jvm.ch04.classfile.ConstantPool.ConstantPool;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 22:39
 **/
public class Attr_Code extends AttributeInfo {
    private int maxStack;//操作数栈的最大深度
    private int max_stack;//局部变量表大小
    private int code_length;//字节码长度
    private byte[] code;//字节码
    private int exception_table_length;
    private ExceptionTableEntry[] exceptionTable;//异常处理表
    private int attributes_count;
    private AttributeInfo[] attributes;//子属性
    /*
    code的attributes属性中可以包含以下六种预定义属性：
    LineNumberTable
    LocalVariableTable
    StackVariableTypeTable
    StackMapTable
    RuntimeVisibleTypeAnnotations
    RuntimeInvisibleTypeAnnotations
     */

    public Attr_Code(ClassReader reader, ConstantPool pool, int attribute_name_index, int attribute_length) {
        super(attribute_name_index,attribute_length);
        this.maxStack = reader.byteToInt(reader.nextU2());
        this.max_stack = reader.byteToInt(reader.nextU2());
        this.code_length = reader.byteToInt(reader.nextU4());
        this.code = reader.nextBytes(code_length);
        this.exception_table_length = reader.byteToInt(reader.nextU2());
        this.exceptionTable = getExceptionTable(reader,exception_table_length);
        this.attributes_count = reader.byteToInt(reader.nextU2());
        this.attributes = AttributeFactory.readAttributes(reader,pool,attributes_count);
    }


    private ExceptionTableEntry[] getExceptionTable(ClassReader reader, int exception_table_length){
        ExceptionTableEntry[] exceptionTable=new ExceptionTableEntry[exception_table_length];
        for(int i=0;i<exception_table_length;i++){
            exceptionTable[i]=new ExceptionTableEntry(reader);
        }
        return exceptionTable;
    }

    static class ExceptionTableEntry{
        private int startPc;
        private int endPc;
        private int handlePc;
        private int catchType;

        public ExceptionTableEntry(ClassReader reader) {
            this.startPc = reader.byteToInt(reader.nextU2());
            this.endPc = reader.byteToInt(reader.nextU2());
            this.handlePc = reader.byteToInt(reader.nextU2());
            this.catchType = reader.byteToInt(reader.nextU2());
        }
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMax_stack() {
        return max_stack;
    }

    public int getCode_length() {
        return code_length;
    }

    public byte[] getCode() {
        return code;
    }

    public int getException_table_length() {
        return exception_table_length;
    }

    public ExceptionTableEntry[] getExceptionTable() {
        return exceptionTable;
    }

    public int getAttributes_count() {
        return attributes_count;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }
}
