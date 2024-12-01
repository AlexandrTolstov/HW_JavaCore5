package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperator {

    /**
     * Список путей к файлам по директории
     * @param path Путь к файлу
     * @return Список путей к файлам
     */
    static List<String> listOfFiles(String path){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        List<String> filePaths = new ArrayList<>();
        for (File file : listOfFiles){
            if(file.isFile()){
                filePaths.add(file.getPath());
            }
        }
        return filePaths;
    }

    /**
     * Копирование одного файла
     * @param source имя файла источника
     * @param target имя файла цели
     */
    static void copyFile(String source, String target){
        InputStream inStream = null;
        OutputStream outStream = null;

        try{
            File sourceFile = new File(source);
            File destFile = new File(target);

            inStream = new FileInputStream(sourceFile);
            outStream = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);
            }

            inStream.close();
            outStream.close();

            //System.out.println("File is copied successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Копирование всех файлов
     * @param source папка с файлами источниками
     * @param target папка в которую необходимо скопировать
     */
    public static void copyFiles(String source, String target){
        List<String> files = listOfFiles(source);

        File directory = new File(target);
        boolean success = directory.mkdir();

        for (String file : files){
            copyFile(file, target + "/" + (new File(file)).getName());
        }
    }
}
