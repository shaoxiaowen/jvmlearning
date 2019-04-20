package com.jvm.ch04.rtda;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-20 10:16
 **/
/*
局部变量表(Local Variable Table)是一组变量值存储空间，
用于存放方法参数和方法内部定义的局部变量。
局部变量表的容量大小存放在Code属性的max_locals数据项中。

虚拟机规范中指出，
每个Slot都应该能存放一个boolean、byte、char、short、int、float、reference或returnAddress类型的数据
都使用32位或更小的物理内存来存放。

局部变量表的容量已变量槽(Variable Slot 下称Slot)为最小单位，Slot可以存放一个32位以内的数据类型。

 */
public class Slot {
    private int num;
    private MyObject ref;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public MyObject getRef() {
        return ref;
    }

    public void setRef(MyObject ref) {
        this.ref = ref;
    }
}
