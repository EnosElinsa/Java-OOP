package oop.homework.fileproperties;

import java.io.File;
import java.util.Date;

public class DirectoryParser {

    private File file;
    private String directory;
    private String targetName;
    private boolean isFile;
    private boolean isDirectory;
    private long size;
    private String parentPath;
    private String lastModifiedDate;
    private boolean canWrite;
    private boolean canRead;
    private boolean canExecute;
    private boolean isHidden;
    private String parseInfo;
    private int fileCount;
    private int directoryCount;

    public DirectoryParser(String directory) {
        this.directory = directory;
        intialize();
        parse();
    }

    private void intialize() {
        file = new File(directory);
        targetName = file.getName();
        isFile = file.isFile();
        isDirectory = file.isDirectory();
        parentPath = file.getAbsolutePath();
        size = file.length();
        lastModifiedDate = new Date(file.lastModified()).toString();

        fileCount = 0;
        directoryCount = 0;

        canWrite = file.canWrite();
        canRead = file.canRead();
        canExecute = file.canExecute();
        isHidden = file.isHidden();
    }

    private void parse() {
        if (isFile) {
            parseInfo = String.format("目标名称：\t%s\n--------------------------------------\n目标类型：\t文件(%s)\n所在位置：\t%s\n文件大小：\t%d字节\n修改时间：\t%s\n目标属性：\n\t可读：\t%s\n\t可写：\t%s\n\t可运行：%s\n\t隐藏：\t%s\n", 
                targetName, targetName.substring(targetName.lastIndexOf(".")), parentPath, size, lastModifiedDate, canRead, canWrite, canExecute, isHidden);
        }
        else if (isDirectory) {
            calculateDirectoryInfo(file);
            parseInfo = String.format("目标名称：\t%s\n--------------------------------------\n目标类型：\t目录\n所在位置：\t%s\n目录大小：\t%d字节\n修改时间：\t%s\n包含文件：\t%d个\n包含目录：\t%d个\n目标属性：\n\t可读：\t%s\n\t可写：\t%s\n\t可运行：%s\n\t隐藏：\t%s\n", 
                targetName, parentPath, size, lastModifiedDate, fileCount, directoryCount, canRead, canWrite, canExecute, isHidden);
        }
        else {
            parseInfo = String.format("[%s]不是文件或目录名称", directory);
        }
    }

    private void calculateDirectoryInfo(File file) {
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                fileCount++;
                size += f.length();
            }
            else {
                directoryCount++;
                calculateDirectoryInfo(f);
            }
        }
    }

    public String getDirectory() {
        return directory;
    }
    public File getFile() {
        return file;
    }
    public String getTargetName() {
        return targetName;
    }
    public String getParentPath() {
        return parentPath;
    }
    public long getSize() {
        return size;
    }
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    public boolean isFile() {
        return isFile;
    }
    public boolean canWrite() {
        return canWrite;
    }
    public boolean canRead() {
        return canRead;
    }
    public boolean canRun() {
        return canExecute;
    }
    public boolean isHidden() {
        return isHidden;
    }
    public boolean isDirectory() {
        return isDirectory;
    }
    public boolean canExecute() {
        return canExecute;
    }
    public String getParseInfo() {
        return parseInfo;
    }
    public int getFileCount() {
        return fileCount;
    }
    public int getDirectoryCount() {
        return directoryCount;
    }
}
