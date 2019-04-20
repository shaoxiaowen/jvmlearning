package com.jvm.ch04.Classpath;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: xiaowen
 * @create: 2019-04-11 14:47
 **/
public class CompositeEntry implements Entry {

    private final List<Entry> entries=new ArrayList<>();

    public CompositeEntry(String pathList) {
        String[] split = pathList.split(File.pathSeparator);
        for(String path:pathList.split(File.pathSeparator)){
            entries.add(Entry.create(path));
        }
    }

    @Override
    public byte[] readClass(String className){
        for(Entry entry:entries){
            try {
                return entry.readClass(className);
            } catch (Exception e) {
//                System.out.println("在  "+entry+"  下，没有找到  "+className);
//                e.printStackTrace();
            }
        }
        return null;

    }
}
