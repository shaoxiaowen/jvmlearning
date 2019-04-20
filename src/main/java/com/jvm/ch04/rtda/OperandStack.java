package com.jvm.ch04.rtda;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-20 15:44
 **/
/*
操作数栈的大小是编译器已经确定的，所以可以用[]Slot实现。
size字段用于记录栈顶位置
*/
public class OperandStack {
    private int top;//栈顶位置
    private Slot[] slots;

    public OperandStack(int maxStack) {
        if (maxStack>0){
            slots=new Slot[maxStack];
            for(int i=0;i<maxStack;i++){
                slots[i]=new Slot();
            }
        }
    }

    //和局部变量表类似，需要定义一些方法从操作数栈中弹出，或者往其中推入各种类型的变量

    //int型,入栈
    public void PushInt(int val){
        slots[top].setNum(val);
        top++;
    }
    //int型,出栈
    public int PopInt(){
        top--;
        return slots[top].getNum();
    }
    //float型 入栈
    public void PushFloat(float val){
        slots[top].setNum(Float.floatToIntBits(val));
        top++;
    }
    //float型 出栈
    public float PopFloat(){
        top--;
        return Float.intBitsToFloat(slots[top].getNum());
    }
    //long型 入栈
    public void PushLong(long val){
        slots[top].setNum((int)val);
        slots[top+1].setNum((int)(val>>32));
        top+=2;
    }
    //long型 出栈
    public long PopLong(){
        int high=slots[top-1].getNum();
        top-=1;
        int low=slots[top-1].getNum();
        top-=1;
        long left=(high & 0x00000000ffffffffL) << 32;
        long right=low & 0x00000000ffffffffL;
        return left|right;
    }

    //double型 入栈
    public void PushDouble(double val){
        long l = Double.doubleToLongBits(val);
        PushLong(l);
    }
    //double型 出栈
    public double PopDouble(){
        long l = PopLong();
        return Double.longBitsToDouble(l);
    }
    //ref 入栈
    public void PushRef(MyObject ref){
        slots[top].setRef(ref);
        top++;
    }
    //ref 出栈
    public MyObject PopRef(){
        top--;
        MyObject ref = slots[top].getRef();
        slots[top].setRef(null);
        return ref;
    }


}
