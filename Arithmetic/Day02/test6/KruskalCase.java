package Day02.test6;

import java.util.Arrays;

/**
 * ********概述：克鲁斯卡尔算法实现最小生成树
 */
public class KruskalCase {

    private int edgeNum;// 边的个数
    private char[] vertexs;// 顶点数组
    private int[][] matrix;// 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;// 使用INF表示两顶点不可连通

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        // 创建对象实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();

        EData[] edges = kruskalCase.getEdges();
        System.out.println("排序前");
        System.out.println(Arrays.toString(edges));

        System.out.println("排序后");
        kruskalCase.sortEdges(edges);
        System.out.println(Arrays.toString(edges));

        kruskalCase.kruskal();


    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        // 初始化顶点
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];

        // 在不改变原有数组的情况下改变
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        // 初始化边
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j <vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        // 统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {// 自己与自己不统计
                if (this.matrix[i][j] != INF) {// 代表有效边个数
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;// 表示最后结果的索引
        int[] ends = new int[edgeNum];// 用于保存已有最小生成树中每个顶点在最小生成树中的终点
        // 创建结果数组,保存最终的最小生成树
        EData[] rets = new EData[edgeNum];

        // 获取图中所有边的集合
        EData[] edges = getEdges();

        // 按照边的权值大小进行排序
        sortEdges(edges);

        // 遍历edges数组，将边添加到最小生成树中，判断准备加入的边是否形成了回路，若没有，就加入到rets，否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            // 获取第i条边的起点
            int p1= getPosition(edges[i].start);
            // 获取第二个顶点
            int p2 = getPosition(edges[i].end);

            // 获取p1这个顶点在已有最小生成树的终点
            int m = getEnd(ends, p1);
            // 获取p2这个顶点在已有最小生成树的终点
            int n = getEnd(ends, p2);

            // 是否构成回路
            if (m != n) {// 未构成回路
                ends[m] = n;// 设置m在已有最小生成树的终点<E,F>
                rets[index++] = edges[i];// 有一条边加入到rets数组
            }
        }
        // 统计并打印最小生成树，输出为rets
        System.out.println("最小生成树");
        for (int i = 0; i < index; i++) {// 只显示连接的最小生成树的边
            System.out.println(rets[i]);
        }
    }

    // 打印邻接矩阵
    public void print() {
        System.out.println("领接矩阵为:");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);// 12个字节，不足则空出来，向右对齐
            }
            System.out.println();
        }
    }

    // 对边进行排序处理
    private void sortEdges(EData[] edges) {// 边的集合，直接对边进行排序
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    //传入顶点返回顶点对应的下标，找不到则返回-1
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，放到EData[]数组中，后面需要遍历该数组，通过matrix邻接矩阵来获取
     * [['A','B',12],['B','F',7]......] 边的权值及其连线
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下表为i的顶点的终点,辨别是否是回路，终点即为顶点数组可连接到的最后面的顶点，
     * 用于判断两个顶点的终点是否相同，ends数组在遍历过程中逐步形成
     * @param ends 会动态变化，根据添加的结点会进行改变，始终为已连接的顶点数组最后的那个顶点
     * @param i    表示传入的顶点对应的下标
     * @return     返回的就是下标为i的顶点对应的终点的坐标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

}

// 创建一个类EData,对象实例就表示一条边
class EData {
    char start;// 边的一个点
    char end;// 边的另一个点
    int weight;// 边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    // 重写toString输出边的信息
    @Override
    public String toString() {
        return " EData{" + "<" + start + ", " + end + ">," + weight + '}';
    }

}

