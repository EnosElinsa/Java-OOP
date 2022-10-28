package oop.homework.fileproperties;

import java.util.Scanner;

public class CLUI {
    Scanner in = new Scanner(System.in);

    public void run() {
        System.out.print("输入一个文件名或者目录名：");
        String directory = in.next();
        DirectoryParser dP = new DirectoryParser(directory);
        System.out.println(dP.getParseInfo());
    }
}
