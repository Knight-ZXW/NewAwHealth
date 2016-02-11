package com.think.awhealth.util;

import java.io.File;

/**
 * Created by XiuWuZhuo on 2016/2/6.
 * Emial:nimdanoob@163.com
 */
public class FileUtils {
    public static long getFileOrDirectorySize(File file){
        if (file.isFile()) {
            return file.length();
        }
        final File[] childrenFiles = file.listFiles();
        int total = 0;

        if (childrenFiles!=null){
            for(File f :childrenFiles){
                total+=getFileOrDirectorySize(f);
            }
        }
        return total;
    }
}
