package com.jvm.ch04.rtda;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-20 10:11
 **/
public class Stack {
    private int maxSize;//栈的容量大小
    private int size;//栈的大小
    private Frame _top;//栈顶指针

    public Stack(int maxSize) {
        this.maxSize=maxSize;
    }
    //push()方法把栈帧推入栈顶
    public void push(Frame frame){
        if (size>maxSize){
            throw new RuntimeException("java.lang.StackOverflowError");
        }
        if (_top!=null){
            frame.setLower(_top);
        }
        _top=frame;
        size++;
    }
    //pop方法把栈顶的栈帧弹出
    public Frame pop(){
        if (_top==null){
            throw new RuntimeException("jvm stack is empty!");
        }
        Frame top=_top;
        _top=top.getLower();
        top.setLower(null);
        size--;
        return top;
    }
    //top方法 或者栈顶元素，但是不弹出
    public Frame top(){
        if (_top==null){
            throw new RuntimeException("jvm stack is empty!");
        }
        return _top;
    }
}
