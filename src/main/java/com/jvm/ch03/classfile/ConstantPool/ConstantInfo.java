package com.jvm.ch03.classfile.ConstantPool;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-17 16:54
 **/
public class ConstantInfo {
    private int tag;

    public ConstantInfo(int tag) {
        this.tag = tag;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
