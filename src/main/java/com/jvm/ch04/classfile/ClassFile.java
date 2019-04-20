package com.jvm.ch04.classfile;

import com.jvm.ch04.classfile.AttributeInfo.AttributeFactory;
import com.jvm.ch04.classfile.AttributeInfo.AttributeInfo;
import com.jvm.ch04.classfile.ConstantPool.ConstantInfo;
import com.jvm.ch04.classfile.ConstantPool.ConstantPool;
import com.jvm.ch04.classfile.MemberInfo.FieldInfo;
import com.jvm.ch04.classfile.MemberInfo.MethodInfo;

/**
 * @description: ClassFile文件结构
 * @author: xiaowen
 * @create: 2019-04-15 09:21
 **/

/*
根据Java虚拟机规范的规定，Class文件格式采用一种类似于C语言结构体的伪结构来存储数据
这种伪结构中只有两种数据类型：无符号数和表，后面的解析都要以这两种数据类型为基础

无符号数属于基本的数据类型，以u1、u2、u4、u8来分别代码1个字节，2个字节、4个字节和8个字节的无符号数
无符号数可以用来描述数字、索引引用、数量值或者按照UTF-8编码构成字符串值

表是由多个无符号数或者其他表作为数据项构成的复合数据类型，所以都习惯性地以"_info"结尾。
表用于描述有层次关系的复合结构的数据

整个Class文件本质上就是一张表

ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
*/
public class ClassFile {
    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private int accessFlag;
    private int classNameIndex;
    private int superClassNameIndex;
    private int[] interfaceIndexes;
    private FieldInfo[] fields;
    private MethodInfo[] methods;
    private ClassReader reader;
    private AttributeInfo[] attributes;

    public ClassFile(byte[] classData) {
        reader = new ClassReader(classData);
        this.readAndCheckMagic();
        this.readAndCheckVersion();
        this.readConstantPool();
        this.readAccessFlag();
        this.readClassNameIndex();
        this.readSuperClassNameIndex();
        this.readInterfaces();
        this.readFields();
        this.readMethods();
        this.readAttributes();
        System.out.println("================classFile分析完毕==================");

    }

    //0xCAFEBABE
    private void readAndCheckMagic() {
        byte[] bytes = reader.nextU4();
        String magic = reader.byteToHexString(bytes);
        if (!"cafebabe".equals(magic)) {
            throw new ClassFormatError("magin!");
        }
    }

    private void readAndCheckVersion() {
        this.minorVersion = reader.byteToInt(reader.nextU2());
        this.majorVersion = reader.byteToInt(reader.nextU2());

        if (this.majorVersion >= 46 && this.majorVersion <= 52 && this.minorVersion == 0) {
            return;
        }
        throw new UnsupportedClassVersionError();
    }

    private void readConstantPool() {
        this.constantPool = new ConstantPool(reader);
        System.out.println();
    }

    private void readAccessFlag(){
        this.accessFlag=reader.byteToInt(reader.nextU2());
    }
    private void readClassNameIndex(){
        this.classNameIndex=reader.byteToInt(reader.nextU2());
    }
    private void readSuperClassNameIndex(){
        this.superClassNameIndex=reader.byteToInt(reader.nextU2());
    }

    private void readInterfaces(){
        this.interfaceIndexes = reader.nextUint16s();
    }
    private void readFields(){
        int count=reader.byteToInt(reader.nextU2());
        this.fields=new FieldInfo[count];
        for(int i=0;i<count;i++){
            fields[i]=new FieldInfo(reader,constantPool);
        }
    }
    private void readMethods(){
        int count=reader.byteToInt(reader.nextU2());
        this.methods=new MethodInfo[count];
        for(int i=0;i<count;i++){
            methods[i]=new MethodInfo(reader,constantPool);
        }
    }

    private void readAttributes(){
        int attributesCount=reader.byteToInt(reader.nextU2());
        this.attributes=AttributeFactory.readAttributes(reader,constantPool,attributesCount);
    }

    public void showConstantPool() {
        ConstantInfo[] constantInfos = constantPool.getConstantInfos();
        System.out.println("===============ConstantPool======================");
        if (constantInfos.length > 0) {
            for (int i = 1; i < constantInfos.length; i++) {
                if (constantInfos[i] != null)
                    System.out.printf("#%d %s\n", i, constantInfos[i].toString());
            }
        }
    }
}


