import task1.FileOperator;
import task2_3.TicTacToe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //task1 - здесь введите наименование папки из которой вы копируете файла в папку в которую копируете файла
        FileOperator.copyFiles("C:\\Users\\SESA574650\\Documents\\GB\\Certificates", "C:\\Users\\SESA574650\\Documents\\GB\\Certificates1");

        /*
         * Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой, например,
         * состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом,
         * 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int всё поле 3х3. Записать в файл 9 значений так,
         * чтобы они заняли три байта. Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет".
         */
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println(ticTacToe);

        ticTacToe.setCross(3, 3);
        System.out.println(ticTacToe);
        System.out.println(ticTacToe.toBinary());
        ticTacToe.setCross(2, 3);
        System.out.println(ticTacToe.toBinary());
        ticTacToe.setZero(1, 2);
        System.out.println(ticTacToe);
        System.out.println(ticTacToe.toBinary());
        ticTacToe.writeToFile("tictactoe.txt");

        /*
        3. Прочитать числа из файла, полученного в результате выполнения задания 2.
         */
        System.out.println("Считываем с файла бинарную строку:");
        String file = ticTacToe.readBinaryFromFile("tictactoe.txt");
        System.out.println(file);

    }
}