package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

public class ReadWord {
    private String fileAbsolutePath;
    private File filePath;
    private BufferedReader bufferedReader;

    public ReadWord(Vector<String> wordData){
        try{
            fileAbsolutePath = ReadWord.class.getResource("").getPath();
            filePath = new File("D:\\WordGame\\src\\my\\word.txt");
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = bufferedReader.readLine()) != null){
                wordData.add(line);
            }
            //notifyAll();
        }
        catch(Exception e1){
            e1.printStackTrace();
        }
    }
}
