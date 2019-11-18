package com.redsun.classloader.multi;

import org.junit.Test;
import org.springframework.boot.devtools.restart.classloader.ClassLoaderFile;
import org.springframework.boot.devtools.restart.classloader.ClassLoaderFiles;
import org.springframework.boot.devtools.restart.classloader.RestartClassLoader;
import org.springframework.boot.logging.DeferredLog;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author xuguangrong
 * @description
 * @date Created at 13:20 2019/9/22
 */
public class Main {

    @Test
    public void test1() throws ClassNotFoundException {
        Class clazz = Class.forName("com.redsun.classloader.multi.TestInterface");

        TestInterface testInterface = new TestInterfaceImpl();
        System.out.println(clazz.isInstance(testInterface));
    }

    @Test
    public void test2() throws ClassNotFoundException, MalformedURLException {
        Set<URL> urlsMap = new LinkedHashSet<>();
        URL url = new URL("file:/D:/code/spring-boot/test/target/classes");
        urlsMap.add(url);
        URL[] urls = urlsMap.toArray(new URL[0]);
        ClassLoaderFiles classLoaderFiles = new ClassLoaderFiles();
        ClassLoaderFiles updatedFiles = new ClassLoaderFiles(classLoaderFiles);
        RestartClassLoader loader = new RestartClassLoader(Thread.currentThread().getContextClassLoader(), urls,
                updatedFiles, new DeferredLog());

        //        MyClassLoader loader = new MyClassLoader();
        Class<?> testInterface = loader.loadClass("com.redsun.classloader.multi.TestInterfaceImpl", false);


//        Class<?> testInterface = loader.findClass("classloader.multi.TestInterfaceImpl");

        try {
            Object obj = testInterface.newInstance();

            Class clazz = Class.forName("com.redsun.classloader.multi.TestInterface");
            System.out.println(clazz.isInstance(obj));
            System.out.println("clazz's classloader is " + clazz.getClassLoader());
            System.out.println("obj's classloader is " + obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() throws ClassNotFoundException {
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class clazz = Class.forName("com.redsun.classloader.multi.TestInterface");

        MyClassLoader loader = new MyClassLoader();
        Class<?> testInterface = loader.findClass("classloader.multi.TestInterfaceImpl");
        try {
            Object obj = testInterface.newInstance();

            System.out.println(clazz.isInstance(obj));
            System.out.println(clazz.getClassLoader());
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
