package com.jvm.ch03.classfile.ConstantPool;

import com.jvm.ch03.classfile.ClassReader;

/**
 * @description: 紧接着主次版本号之后的是常量池入口，常量池可以理解为Class文件之中的资源仓库
 * 由于常量池中常量的数量是不固定的，所以在常量池的入口需要放置一项u2类型的数据，代表常量池容量计数值。
 * @author: xiaowen
 * @create: 2019-04-15 23:33
 **/

/*
一、	表头给出的常量池大小比实际大1.假设表头给出的值是n，那么常量池的实际大小是n-1。
二、	有效的常量池索引是1~n-1。0是无效索引，表示不指向任何常量。
三、	CONSTANT_Long_info和CONSTANT_Double_info各占两个位置。也就是说，如果常量池中存在这两种常量，
	实际的常量数量比n-1还要少，而且1~n-1的某些数也会变成无效索引
 */
public class ConstantPool {
    //常量池的容量
    private final int contantPoolCount;
    //常量池中的数据
    private final ConstantInfo[] constantInfos;


    public ConstantPool(ClassReader reader) {
        this.contantPoolCount = reader.byteToInt(reader.nextU2());
        this.constantInfos = new ConstantInfo[contantPoolCount];
        //常量池计数是从1开始而不是从0开始，参考《深入理解Java虚拟机》p168
        for (int i = 1; i < contantPoolCount; i++) {
            try {
                int tag = reader.byteToInt(reader.nextU1());
                constantInfos[i] = ConstantInfoFactory.createConstantInfo(tag, reader, this);
                //CONSTANT_Long_info和CONSTANT_Double_info各占两个位置。也就是说，如果常量池中存在这两种常量，
                //	实际的常量数量比n-1还要少，而且1~n-1的某些数也会变成无效索引
                if (tag == ConstantInfoFactory.CONSTANT_Double || tag == ConstantInfoFactory.CONSTANT_Long) {
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据索引获取常量
     *
     * @param index
     * @return
     */
    public Object getConstantInfo(int index) {
        return this.constantInfos[index];
    }

    public int getContantPoolCount() {
        return contantPoolCount;
    }

    public ConstantInfo[] getConstantInfos() {
        return constantInfos;
    }
}

