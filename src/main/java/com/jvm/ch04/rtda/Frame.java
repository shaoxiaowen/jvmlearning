package com.jvm.ch04.rtda;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-20 10:13
 **/
public class Frame {
    private Frame lower;//用来实现链表数据结构，栈结构
    private LocalVars localVars;//局部变量表的指着
    private OperandStack operandStack;//操作数栈的指针

    public Frame(int maxLocals,int maxStack) {
        this.localVars=new LocalVars(maxLocals);
        this.operandStack=new OperandStack(maxStack);
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }

    public Frame getLower() {
        return lower;
    }

    public void setLower(Frame lower) {
        this.lower = lower;
    }
}
