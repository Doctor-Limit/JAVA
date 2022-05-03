package Day02.test3;

/**
 * ********概述：动态规划解决01背包问题
 *
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};// 物品的重量
        int[] val = {1500, 3000, 2000};// 物品的价值  val[i]即为某个物品的价值
        int m = 4;// 背包的容量
        int n = val.length;// 物品的个数

        // 为了记录表中放入商品的情况，定义一个二维数组
        int[][] path = new int[n+1][m+1];

        // 创建二维数组
        // v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n+1][m+1];

        // 初始化第一行和第一列，默认为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;// 将第一列置为0

        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;// 将第一行置为0
        }

        //动态规划处理
        for (int i = 1; i < v.length; i++) {// 不处理第一行
            for (int j = 0; j < v[0].length; j++) {// 不处理第一列
                // 如果当前物品重量大于背包容量，则直接将上一个单元格的值复制下来
                if (w[i - 1] > j) { // i从1开始，所以要让其从第一个物品开始
                    v[i][j] = v[i - 1][j];
                } else {// 若背包容量小于等于当前物品重量，则先尝试将当前物品放入，然后查看剩余空间，在上一个单元格的值与
                        // (新加入的物品价值及非重复情况下与上一行的剩余空间对应的最大价值之和)比较，选择更大的那个做为当前值
                    // v[i][j] = Math.max(v[i -1][j], val[i -1] + v[i - 1][j - w[i -1]]); 因为i从1开始，所以要使val考虑到第一个值
                    // 为了记录物品放到背包中的情况，不能直接使用当前公式
                    if (v[i - 1][j] < val[i -1] + v[i -1][j - w[i - 1]]) {
                        v[i][j] = val[i -1] + v[i -1][j - w[i - 1]];
                        // 记录当前情况
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        // 数组的输出
        for (int i = 0; i <v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.err.print(v[i][j] + " ");
            }
            System.err.println();
        }

        // 输出放入的商品
        // 这样输出会把所有的放入情况都得到，但我们只需要最后放入的情况
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j] == 1) {
//                    System.out.printf("第%d个商品放入背包\n", i);
//                }
//            }
//        }

        int i = path.length - 1;// 行最大下标
        int j = path[0].length - 1;// 类最大下标
        while (i > 0 && j > 0) {// 从后往前遍历
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n", i);
                j = j - w[i - 1];// 放入物品到背包后，剩余空间可存放的物品需要修改
            }
            i--;
        }
    }
}
