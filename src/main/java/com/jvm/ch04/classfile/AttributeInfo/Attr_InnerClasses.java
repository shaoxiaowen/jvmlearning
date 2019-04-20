package com.jvm.ch04.classfile.AttributeInfo;

import com.jvm.ch04.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 20:12
 **/
/*
InnerClasses_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 number_of_classes;
    {   u2 inner_class_info_index;
        u2 outer_class_info_index;
        u2 inner_name_index;
        u2 inner_class_access_flags;
    } classes[number_of_classes];
}
*/
public class Attr_InnerClasses extends AttributeInfo {
    private int number_of_classes;
    private InnerClassEntry[] classes;

    public Attr_InnerClasses(ClassReader reader, int attribute_name_index, int attribute_length) {
        super(attribute_name_index, attribute_length);
        this.number_of_classes=reader.byteToInt(reader.nextU2());
        this.classes=readInnerClasses(reader);

    }
    private InnerClassEntry[] readInnerClasses(ClassReader reader){
        InnerClassEntry[] innerClasses=new InnerClassEntry[this.number_of_classes];
        for(int i=0;i<number_of_classes;i++){
            innerClasses[i]=new InnerClassEntry(reader);
        }
        return innerClasses;
    }

    public int getNumber_of_classes() {
        return number_of_classes;
    }

    public InnerClassEntry[] getClasses() {
        return classes;
    }

    private static class InnerClassEntry{
        public int inner_class_info_index;
        public int outer_class_info_index;
        public int inner_name_index;
        public int inner_class_access_flags;

        public InnerClassEntry(ClassReader reader) {
            this.inner_class_info_index=reader.byteToInt(reader.nextU2());
            this.outer_class_info_index=reader.byteToInt(reader.nextU2());
            this.inner_name_index=reader.byteToInt(reader.nextU2());
            this.inner_class_access_flags=reader.byteToInt(reader.nextU2());
        }
    }
}
