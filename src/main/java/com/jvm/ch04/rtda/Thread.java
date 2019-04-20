package com.jvm.ch04.rtda;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-20 10:10
 **/
public class Thread {
    private int pc;
    private Stack stack;

    public Thread() {
        stack=new Stack(1024);
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    //PushFrame()、PopFrame()和CurrentFrame只是调用Stack结构体的相应方法
    public void PushFrame(Frame frame){
        stack.push(frame);
    }
    public Frame PopFrame(){
        return stack.pop();
    }
    //返回当前栈帧
    public Frame CurrentFrame(){
        return stack.top();
    }
}
