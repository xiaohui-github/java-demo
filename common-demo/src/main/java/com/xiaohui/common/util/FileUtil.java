package com.xiaohui.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {

    /**
     * 迭代，获取目录中文件
     *
     * @param dirPath 目录
     * @return 文件list
     * @throws IOException
     */
    public static List<String> dirIterated(String dirPath) throws IOException {
        if (dirPath == null || "".equals(dirPath.trim())) {
            return new ArrayList<String>(0);
        }
        File dir = new File(dirPath.trim());
        if (!dir.exists()) {
            return new ArrayList<String>(0);
        }

        if (dir.isFile()) {
            return Arrays.asList(dir.getCanonicalPath());
        }

        LinkedList<String> result = new LinkedList<String>();
        LinkedList<File> dirFiles = new LinkedList<File>(Arrays.asList(dir.listFiles()));
        while (!dirFiles.isEmpty()) {
            File file = dirFiles.remove();
            if (file.isFile()) {
                result.add(file.getCanonicalPath());
            } else {
                dirFiles.addAll(Arrays.asList(file.listFiles()));
            }
        }
        return result;
    }

    /**
     * 递归方式获取目录文件
     *
     * @param dirPath 目录
     * @return 目录中文件
     * @throws IOException
     */
    public static List<String> dirRecursion(String dirPath) throws IOException {
        if (dirPath == null || "".equals(dirPath.trim())) {
            return new ArrayList<String>(0);
        }

        File dir = new File(dirPath.trim());
        if (!dir.exists()) {
            return new ArrayList<String>(0);
        }

        if (dir.isFile()) {
            return Arrays.asList(dir.getCanonicalPath());
        }

        LinkedList<String> result = new LinkedList<String>();
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                result.add(file.getCanonicalPath());
            } else {
                result.addAll(dirRecursion(file.getCanonicalPath()));
            }
        }

        return result;
    }

}
