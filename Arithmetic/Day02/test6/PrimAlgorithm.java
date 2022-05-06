package Day02.test6;

import java.util.Arrays;

/**
 * ********概述：普利姆算法
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        // 使用二维矩阵表示邻接矩阵之间的关系
        // 用大的数表示无法直接连通
        int[][] weight = new int[][] {
                {1000, 5, 7, 1000, 1000, 1000, 2},
                {5, 1000, 1000, 9, 1000, 1000, 3},
                {7, 1000, 1000, 1000, 8, 1000, 1000},
                {1000, 9, 1000, 1000, 1000, 4, 1000},
                {1000, 1000, 8, 1000, 1000, 5, 4},
                {1000, 1000, 1000, 4, 5, 1000, 6},
                {2, 3, 1000, 1000, 4, 6, 1000}
        };
        MGraph mGraph = new MGraph(verxs);// 创建MGraph对象
        MinTree minTree = new MinTree();// 创建一个MinTree对象
        minTree.createGraph(mGraph, verxs, data, weight);

        // 图的输出
        minTree.showGraph(mGraph);
        System.out.println();

        // 测试普利姆算法
        minTree.prim(mGraph, 0);// 以第一个结点为初始寻找结点
        // 尽管初始寻找结点的不同会导致路径不同，但其权值之和不会不变

    }
}

// 创建最小生成树
class MinTree {
    // 创建图的邻接矩阵
    /**
     *
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data    图的各个顶点的值
     * @param weight  图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {// 顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    
    // 显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 编写普利姆算法,得到最小生成树
    /**
     *
     * @param graph 图
     * @param v     表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.verxs];// 表示结点是否被访问过,默认为0都未访问过
        for (int i = 0; i < graph.verxs; i++) {
            visited[i] = 0;
        }
        // 把当前结点标记为已访问
        visited[v] = 1;
        int h1 = -1, h2 = -1;// 记录两顶点下标
        int minWeight = 1000;// 初始设置成一个较大的数，以便后来在便利过程中被替代
        for (int k = 1; k < graph.verxs; k++) {// 普利姆算法结束后，最小生成树的边比顶点个数少一

            for (int i = 0; i < graph.verxs; i++) { // 遍历所有顶点
                for (int j = 0; j < graph.verxs; j++) { // 遍历一个顶点的所有与其直接相连的结点(当做相连但距离非常远)
                    //当前结点已访问且与其直接相连的结点未访问且两结点连线的权值小于最小权值
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];// 替换最短距离并保存两者下标
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 找到了最小的边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            // 并将已访问结点与其相连的该未访问结点标记为已访问
            visited[h2] = 1;
            // 重新设置minWeight为最大值
            minWeight = 1000;
        }

    }

}

class MGraph {
    int verxs;// 表示图的结点个数
    char[] data;// 存放结点数据
    int[][] weight;// 存放边，即为邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
