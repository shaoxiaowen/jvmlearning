package com.jvm.ch03.classfile;

import java.util.Arrays;

/**
 * @description:
 * @author: xiaowen
 * @create: 2019-04-15 09:27
 **/
public class ClassReader {
    private byte[] classDatas;//class的二进制文件
    private int pos;//用来记录读取的位置

    public ClassReader(byte[] aClassData) {
        this.classDatas = aClassData;
        this.pos = 0;
    }

    /**
     * 读取1个字节数据，对应u1
     * @return
     */
    public byte[] nextU1(){
        return nextBytes(1);
    }

    /**
     * 读取2个字节数据，对应u2
     * @return
     */
    public byte[] nextU2(){
        return nextBytes(2);
    }

    /**
     * 读取4个字节数据，对应u4
     * @return
     */
    public byte[] nextU4(){
        return nextBytes(4);
    }

    /**
     * 读取8个字节数据，对应u8
     * @return
     */
    public byte[] nextU8(){
        return nextBytes(8);

    }

    /**
     * 读取表中表，先读取长度，然后新建一个数组，读取相应的数据
     * 参考，深入理解Java虚拟机 p196 表6-29和表6-30
     * @return
     */
    public int[] nextUint16s(){
        int count=byteToInt(nextU2());
        int[] data=new int[count];
        for(int i=0;i<count;i++){
            data[i]=byteToInt(nextU2());
        }
        return data;
    }

    public byte[] nextBytes(int len){
        if(pos+len>classDatas.length){
            throw new ArrayIndexOutOfBoundsException();
        }

        byte[] data= Arrays.copyOfRange(classDatas,pos,pos+len);
        pos+=len;
        return data;
    }

    public int byteToInt(byte[] datas){
        String str=byteToHexString(datas);
        return Integer.valueOf(str,16).intValue();
    }
    public String byteToHexString(byte[] datas){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<datas.length;i++){
            byte b=datas[i];
            int value=b&0xFF;
            String strHex=Integer.toHexString(value);
            //用两个字节表示16进制
            if(strHex.length()<2){
                strHex="0"+strHex;
            }
            sb.append(strHex);
        }
        return sb.toString();
    }
}
