package com.jvm.ch04.classfile.AttributeInfo;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 18:42
 **/
/*
LineNumberTable_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 line_number_table_length;
    {   u2 start_pc;
        u2 line_number;
    } line_number_table[line_number_table_length];
}
LineNumberTable属性表存放方法的行号信息，属于调试信息
*/
public class Attr_LineNumberTable extends AttributeInfo {
    private int line_number_table_length;
    private LineNumberTableEntry[] line_number_table;
    public Attr_LineNumberTable(ClassReader reader, int attribute_name_index, int attribute_length) {
        super(attribute_name_index,attribute_length);
        this.line_number_table_length=reader.byteToInt(reader.nextU2());
        this.line_number_table=readLineNumberTable(reader);
    }

    private LineNumberTableEntry[] readLineNumberTable(ClassReader reader){
        LineNumberTableEntry[] lineNumberTable=new LineNumberTableEntry[attribute_length];
        for(int i=0;i<line_number_table_length;i++){
            lineNumberTable[i]=new LineNumberTableEntry(reader);
        }
        return lineNumberTable;
    }


    private static class LineNumberTableEntry{
        public int statr_pc;
        public int line_number;

        public LineNumberTableEntry(ClassReader reader) {
            this.statr_pc = reader.byteToInt(reader.nextU2());
            this.line_number = reader.byteToInt(reader.nextU2());
        }
    }

}
