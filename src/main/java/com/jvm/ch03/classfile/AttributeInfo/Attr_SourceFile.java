package com.jvm.ch03.classfile.AttributeInfo;

import com.jvm.ch03.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 20:03
 **/

/*
SourceFile_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 sourcefile_index;
}
SourceFile是可选定长属性，只会出现在ClassFile结构中，用于指出源文件名。
*/

public class Attr_SourceFile extends AttributeInfo{
    private int source_file_index;

    public Attr_SourceFile(ClassReader reader,int attribute_name_index, int attribute_length) {
        super(attribute_name_index,attribute_length);
        this.source_file_index=reader.byteToInt(reader.nextU2());
    }

    public int getSourcefile_index() {
        return source_file_index;
    }
}
