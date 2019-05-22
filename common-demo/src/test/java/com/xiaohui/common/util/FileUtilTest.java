package com.xiaohui.common.util;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class FileUtilTest {
    String dirPath = "D:\\devWorkspace\\idea\\demo-common";
    @Test
    public void testFileUtilDirIterated() throws IOException {
        List<String> list = FileUtil.dirIterated(dirPath);
        for (String s : list) {
            System.out.println(s);
        }
    }
    @Test
    public void testFileUtilDirRecursion() throws IOException {
        List<String> list = FileUtil.dirRecursion(dirPath);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
