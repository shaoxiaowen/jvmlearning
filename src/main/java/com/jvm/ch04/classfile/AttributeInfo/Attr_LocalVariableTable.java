package com.jvm.ch04.classfile.AttributeInfo;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 18:52
 **/
/*
LocalVariableTable_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 local_variable_table_length;
    {   u2 start_pc;
        u2 length;
        u2 name_index;
        u2 descriptor_index;
        u2 index;
    } local_variable_table[local_variable_table_length];
}
*/
public class Attr_LocalVariableTable extends AttributeInfo {
    private int local_variable_table_length;
    private Local_variable_table_entry[] local_variable_table;

    public Attr_LocalVariableTable(ClassReader reader, int attribute_name_index, int attribute_length) {
        super(attribute_name_index,attribute_length);
        this.local_variable_table_length=reader.byteToInt(reader.nextU2());
        this.local_variable_table=readLocalVariableTable(reader);
    }

    private Local_variable_table_entry[] readLocalVariableTable(ClassReader reader){
        Local_variable_table_entry[] local_variable_table=new Local_variable_table_entry[local_variable_table_length];
        for(int i=0;i<local_variable_table_length;i++){
            local_variable_table[i]=new Local_variable_table_entry(reader);
        }
        return local_variable_table;
    }

    public int getLocal_variable_table_length() {
        return local_variable_table_length;
    }

    public Local_variable_table_entry[] getLocal_variable_table() {
        return local_variable_table;
    }

    private static class Local_variable_table_entry{
        public int start_pc;
        public int length;
        public int name_index;
        public int descriptor_index;
        public int index;

        public Local_variable_table_entry(ClassReader reader) {
            start_pc=reader.byteToInt(reader.nextU2());
            length=reader.byteToInt(reader.nextU2());
            name_index=reader.byteToInt(reader.nextU2());
            descriptor_index=reader.byteToInt(reader.nextU2());
            index=reader.byteToInt(reader.nextU2());
        }
    }
}
