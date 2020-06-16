package com.redsun.test.classloader.multi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author xuguangrong
 * @description
 * @date Created at 13:30 2019/9/22
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) {
        String pathName = name.replace(".","/");
        String myPath = "./target/classes/"+pathName+".class";
        System.out.println(myPath);
        byte[] cLassBytes = null;
        try {
            FileInputStream fis = new FileInputStream(new File(myPath));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;
            while((b = fis.read()) != -1) {
                baos.write(b);
            }
            cLassBytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, cLassBytes, 0, cLassBytes.length);
    }

}