package Day01.test1;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * ********概述：
 *
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11 * 11
        //0：无棋子 1：黑子 2：白子
        int chessArr1[][] =new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[6][9]=1;
        //原始的二维数组
        for (int[] i : chessArr1) {
            for (int data: i){
                System.out.printf("%d \t",data);
            }
            System.out.println();
        }

        //二维数组==》稀疏数组
        //1、遍历二维数组，得到非零数据的个数
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0) sum++;
            }
        }

        //2、创建对应的稀疏数组
        int spareArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        spareArr[0][0]=11;
        spareArr[0][1]=11;
        spareArr[0][2]=sum;
        //遍历二维数组，将非零的值存放到spareArr中
        int count=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]!=0){
                    count++;
                    spareArr[count][0]=i;
                    spareArr[count][1]=j;
                    spareArr[count][2]=chessArr1[i][j];
                }
            }
        }
        System.out.println();

        for(int i=0;i<spareArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
        }
        System.out.println();

        //稀疏数组==》二维数组
        int[][] chessArr2=new int[spareArr[0][0]][spareArr[0][1]];
        for(int i=1;i<spareArr.length;i++){
            chessArr2[spareArr[i][0]][spareArr[i][1]]=spareArr[i][2];
        }
        for(int[] d :chessArr2){
            for (int i:d){
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

    }

    @Test
    public void test1() throws Exception{
        int[][] chessArr1=new int[11][11];
        chessArr1[3][2]=1;
        chessArr1[4][1]=2;
        chessArr1[5][9]=1;

        int sum=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]!=0)sum++;
            }
        }

        int[][] spareArr=new int[sum+1][3];
        int count=0;
        spareArr[0][0]=11;
        spareArr[0][1]=11;
        spareArr[0][2]=sum;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]!=0){
                    count++;
                    spareArr[count][0]=i;
                    spareArr[count][1]=j;
                    spareArr[count][2]=chessArr1[i][j];
                }
            }
        }

        for (int i = 0; i < spareArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
        }
        System.out.println();

        int[][] chessArr2=new int[spareArr[0][0]][spareArr[0][1]];
        for(int i=1;i<spareArr.length;i++){
            chessArr2[spareArr[i][0]][spareArr[i][1]]=spareArr[i][2];
        }

        for (int[] ints :chessArr2) {
            for (int i :ints) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }

        File file=new File("E:\\chap\\Arithmetic\\Day01\\test1\\map.data");
        FileWriter fw=new FileWriter(file);
        for(int i=0;i<sum+1;i++){
            for (int j=0;j<3;j++){
                fw.write(spareArr[i][j]);
            }
        }
        fw.close();
        System.out.println();

        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=new FileOutputStream(new File("E:\\chap\\Arithmetic\\Day01\\test1\\hello.c"));
        byte[] bytes=new byte[16];
        int len;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
    }

}
