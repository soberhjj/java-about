package com.huangjunjie.io.commonsio;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author huangJunJie 2020-11-29-20:25
 */
public class CommonsIoTest {

    @Test
    public void testCopyFile() throws IOException {
        File src1=new File("src\\main\\resources\\宋智孝.jpg");
        File des1=new File("src\\main\\resources\\宋智孝_copy2.jpg");

        File src2=new File("src\\main\\resources\\hello.txt");
        File des2=new File("src\\main\\resources\\hello_copy1.txt");

        FileUtils.copyFile(src1,des1);
        FileUtils.copyFile(src2,des2);
    }
}
