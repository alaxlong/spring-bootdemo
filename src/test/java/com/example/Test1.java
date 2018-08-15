package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: baibing.shang
 * \* Date: 2018/8/15
 * \* Description:
 * \
 */
public class Test1 {
    public static void main(String[] args){
        String path = "D:\\test-data";
        List<File> list = getFileSort(path);

        //时间升序排序后，list中去除最后一个文件
        list.remove(list.size()-1);

        for (File file : list) {

            System.out.println(file.getName() + " : " + file.lastModified());
            System.out.println(readToString(file));

//            file.deleteOnExit();

        }

    }

    /**
     * 返回文件内容 为String
     * @param file
     * @return
     */
    public static String readToString(File file) {
        String encoding = "UTF-8";
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    /**
     *目录下所有文件按时间排序
     * @param path
     * @return
     */
    public static List<File> getFileSort(String path) {
        List<File> list = getFiles(path, new ArrayList<File>());
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator<File>() {
                public int compare(File file, File newFile) {
                    if (file.lastModified() > newFile.lastModified()) {
                        return 1;
                    } else if (file.lastModified() == newFile.lastModified()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
        }
        return list;
    }


    /**
     * 获取目录下所有文件
     * @param realpath
     * @param files
     * @return
     */
    public static List<File> getFiles(String realpath, List<File> files) {

        File realFile = new File(realpath);
        if (realFile.isDirectory()) {
            File[] subfiles = realFile.listFiles();
            for (File file : subfiles) {
                if (file.isDirectory()) {
                    getFiles(file.getAbsolutePath(), files);
                } else {
                    if((file.isFile())
                            && (".json".equals(
                            file.getName().
                                    substring(
                                            file.getName().lastIndexOf("."),
                                            file.getName().length())))){
                        files.add(file);

                    }
                }
            }
        }
        return files;
    }
}



