package com.shang.demo.fileTest;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileTest {

    @Test
    public void test1() throws IOException {
        File f = new File("D:/a/b/c/d");
        f.mkdirs();

        File ff = new File(f,"HelloWorld.txt");
        ff.createNewFile();
    }

    @Test
    public void test2(){
        String path = "D:/a/b/c";
        File file = new File(path);
        if (file.isDirectory() && file.exists()){
            System.out.println("录入成功");
        } else {
            System.out.println("请重新录入");
        }
    }

    @Test
    public void test3() throws Exception {
        String path = "D:/a/b/c/d/HelloWorld.txt";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        int len;
        while ((len = fis.read()) != -1){
            System.out.println((char) len);
        }
        fis.close();
    }

    @Test
    public void test4() throws Exception {
        String path = "D:/a/b/c/d/HelloWorld.txt";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        System.out.println( fis.available());

        byte[] b = new byte[3];

        int n = fis.read(b);

        System.out.println(n);
        System.out.println(Arrays.toString(b));
        for (byte b1 : b) {
            System.out.println((char) b1);
        }
        fis.close();
    }
}
