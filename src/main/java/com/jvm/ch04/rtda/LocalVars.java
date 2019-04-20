package com.jvm.ch04.rtda;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-20 10:19
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
public class LocalVars {
    private Slot[] slots;

    public LocalVars(int maxLocals) {
        if(maxLocals>0){
            slots=new Slot[maxLocals];
            for(int i=0;i<maxLocals;i++){
                slots[i]=new Slot();
            }
        }
    }
    //int
    public void SetInt(int index,int val){
        slots[index].setNum(val);
    }
    public int GetInt(int index){
        return slots[index].getNum();
    }
    //float<-->bit<-->int 转换处理
    public void SetFloat(int index,float val){
        slots[index].setNum(Float.floatToIntBits(val));
    }
    public float GetFloat(int index){
        return Float.intBitsToFloat(slots[index].getNum());
    }
    //long变量需要拆成两个int变量
    public void SetLong(int index,long val){
        slots[index].setNum((int)val);
        slots[index+1].setNum((int)(val>>32));
    }
    public long GetLong(int index){
        int low=slots[index].getNum();
        int high=slots[index+1].getNum();
        long left=(high & 0x00000000ffffffffL) << 32;
        long right=low & 0x00000000ffffffffL;
        return left|right;
    }
    //double型
    public void SetDouble(int index,double val){
        //先将double转为long型,然后按照long型处理
        long l = Double.doubleToLongBits(val);
        SetLong(index,l);
    }
    public double GetDouble(int index){
        long l = GetLong(index);
        return Double.longBitsToDouble(l);
    }
    //ref
    public void SetRef(int index,MyObject ref){
        slots[index].setRef(ref);
    }
    public MyObject GetRef (int index){
        return slots[index].getRef();
    }
}
