package com.jvm.ch03.classfile.AttributeInfo;

import com.jvm.ch03.classfile.ClassReader;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-18 20:29
 **/
/*
BootstrapMethods_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 num_bootstrap_methods;
    {   u2 bootstrap_method_ref;
        u2 num_bootstrap_arguments;
        u2 bootstrap_arguments[num_bootstrap_arguments];
    } bootstrap_methods[num_bootstrap_methods];
}
*/
public class Attr_BootstrapMethods extends AttributeInfo{
    private int num_bootstrap_methods;
    private BootstrapMethodEntry[] bootstrapMethodEntries;
    public Attr_BootstrapMethods(ClassReader reader,int attribute_name_index, int attribute_length) {
        super(attribute_name_index, attribute_length);
        this.num_bootstrap_methods=reader.byteToInt(reader.nextU2());
        this.bootstrapMethodEntries=readBootStrapMethods(reader);

    }
    private BootstrapMethodEntry[] readBootStrapMethods(ClassReader reader){
        BootstrapMethodEntry[] bootStrapMethods=new BootstrapMethodEntry[num_bootstrap_methods];
        for(int i=0;i<num_bootstrap_methods;i++){
            bootStrapMethods[i]=new BootstrapMethodEntry(reader);
        }
        return bootStrapMethods;
    }

    private static class BootstrapMethodEntry{
        public int bootstrap_method_ref;
        public int num_bootstrap_arguments;
        public int[] bootstrap_arguments;

        public BootstrapMethodEntry(ClassReader reader) {
            this.bootstrap_method_ref=reader.byteToInt(reader.nextU2());
            this.num_bootstrap_arguments=reader.byteToInt(reader.nextU2());
            this.bootstrap_arguments=new int[num_bootstrap_arguments];
            for(int i=0;i<num_bootstrap_arguments;i++){
                bootstrap_arguments[i]=reader.byteToInt(reader.nextU2());
            }
        }
    }
}
