import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 1;//вес ирисок в граммах
        int y = 1;//вес мандаринов в граммах
        int z = 1;//вес пряников в граммах
        int w = 1;//допустимый вес подарка
        int n = 0;//кол-во возможных вариантов набора подарка весом W грамм
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вес ириски:");
        x = scanner.nextInt();
        System.out.println("Введите вес мандарина:");
        y = scanner.nextInt();
        System.out.println("Введите вес пряника:");
        z = scanner.nextInt();
        System.out.println("Введите допустимый вес подарка:");
        w = scanner.nextInt();
        //1.Определяем предельные количества отдельных составляющих:
        int xLimit = w/x;
        int yLimit = w/y;
        int zLimit = w/z;
        //2.Собираем массив возможных количеств составляющих:
        int[][] numArray = new int[3][];
            //2.1 Определяем размер столбцов двумерного массива
            numArray[0] = new int[xLimit+1];// +1 т.к учитываем ноль
            numArray[1] = new int[yLimit+1];
            numArray[2] = new int[zLimit+1];
            //2.2 Заполняем массивы внутри двумерного массива
            int limit= 1;
            for (int i = 0; i < 3; i++) {
                if (i==0){limit = xLimit;}
                if (i==1){limit = yLimit;}
                if (i==2){limit = zLimit;}
                for (int j = 0; j <= limit; j++) {
                    numArray[i][j] = j;
                }
        }
           int j=0;
            for ( j = 0; j < xLimit+1; j++) {
                int k =0;
                for ( k = 0; k < yLimit+1; k++) {
                    int l=0;
                    for ( l = 0; l < zLimit+1; l++) {
                        if((numArray[0][j]*x+numArray[1][k]*y+numArray[2][l]*z) == w) {
                            n++;
                        }
                    }
                }
            }
        System.out.println(n);
    }
}