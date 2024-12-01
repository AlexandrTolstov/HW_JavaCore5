package task2_3;

import java.io.*;

public class TicTacToe {
    CrossOrZero[][] field;
    String binaryField;

    public TicTacToe(){
        field = new CrossOrZero[3][3];
        String binaryField = "";
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                field[i][j] = CrossOrZero.DASH;
            }
        }
    }

    @Override
    public String toString() {

        String stringField = "";

        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                stringField += field[i][j].getName() + " ";
            }
            stringField += "\n";
        }
        return stringField;
    }

    private String singleNumberToBinary(int num){
        String binary = Integer.toBinaryString(num);
        if (binary.length() == 1){
            binary = "0" + binary;
        }
        return binary;
    }

    public String toBinary(){
        binaryField = "";
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                binaryField += singleNumberToBinary(field[i][j].getValue());
            }

        }
        return binaryField;
    }

    public int binaryToInt(){
        int result = 0;
        int digit;
        for (int i = 0 ; i < binaryField.length();i++){
            digit = Character.digit(binaryField.charAt(i),2);
            result *= 2;
            result += digit;
        }
        return result;
    }

    /**
     * Установить крестик
     * @param i номер строки
     * @param j номер столбца
     */
    public void setCross(int i, int j){
        field[i - 1][j - 1] = CrossOrZero.X;
    }

    /**
     * Установить ноль
     * @param i номер строки
     * @param j номер столбца
     */
    public void setZero(int i, int j){
        field[i - 1][j - 1] = CrossOrZero.O;
    }

    /**
     *Записать бинарное представление в файл
     * @param path
     */
    public void writeToFile(String path){
        try (FileWriter writer = new FileWriter(path)){
            writer.write(this.toBinary());
            System.out.println("Файл успешно записан");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Считать файл
     * @param path путь
     * @return Бинарная строка
     */
    public String readBinaryFromFile(String path){
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader(path)){
            int c;
            while ((c=reader.read())!=-1){
                sb.append((char)c);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }
}
