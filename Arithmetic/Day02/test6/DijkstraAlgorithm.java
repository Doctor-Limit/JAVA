package Day02.test6;

import java.util.Arrays;

/**
 * ********概述：迪杰斯特拉算法实现最小生成树
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];// 邻接矩阵
        final int N = 65535;// 表示不可连接
        matrix = new int[][]{
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };
        Graph graph = new Graph(vertex, matrix);

        graph.dsj(6);
        graph.showDijkstra();


    }
}

// 已访问顶点集合
class VisitedVertex {
    public int[] already_arr;// 记录各个顶点是否访问过，1表示已访问，0,表示未访问，会动态更新

    public int[] pre_visited;// 每个下标的值为前一个顶点下标，会动态更新

    public int[] dis;// 记录出发顶点到所有其他点的距离，会动态更新，求出的最短距离会存放到dis

    /**
     *
     * @param length  表示顶点的个数
     * @param index   出发顶点对应的下标
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        // 初始化dis数组
        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;// 设置出发顶点被访问过
        this.dis[index] = 0;// 设置出发顶点的访问距离为0
    }

    // 判断该顶点是否被访问过
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    // 更新出发顶点到index顶点距离(距离变小时才会更新)
    public void updateDis(int index, int length) {
        dis[index] = length;
    }

    // 更新pre结点的前驱结点为index的结点
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    // 返回出发结点到index的距离
    public int getDis(int index) {
        return dis[index];
    }

    // 继续选择并返回新的访问结点，不能是出发结点
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {// 寻找实际上相连的连线
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;// 更新index结点已被访问过
        return index;
    }

    // 显示结果 : 输出三个数组
    public void show() {
        System.out.println("*********************");
        for (int i :already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i :pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();

        char[] vertex = {'A', 'B', 'C', 'D' ,'E', 'F', 'G'};
        int count = 0;
        for (int i :dis) {
           if (i != 65535) {
               System.out.print(vertex[count] + "(" +i+")");
           }else {
               System.out.println("N");
           }
           count++;
        }
        System.out.println();
    }

}

class Graph {
    private char[] vertex;// 顶点数组
    private int[][] matrix;// 邻接矩阵
    private VisitedVertex vv;// 已经访问的顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph() {
        for (int[] link :matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 迪杰斯特拉算法
    public void dsj(int index) {// 表示出发顶点对应的下标
        vv = new VisitedVertex(vertex.length, index);
        update(index); // 更新index顶点到周围顶点的距离和前驱结点
        for (int j = 1; j < vertex.length; j++) {
            index = vv.updateArr();// 选择并返回新的访问结点
            update(index);// 更新index顶点到周围顶点的距离及前驱结点
        }
    }

    // 显示结果
    public void showDijkstra() {
        vv.show();
    }

    // 更新index下标顶点到周围顶点的距离和周围顶点的前驱结点
    private void update(int index) {
        int len = 0;
        // 根据遍历邻接矩阵的matrix[index]行
        for (int j = 0; j < matrix[index].length; j++) {
            // 出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + matrix[index][j];
            // 若该顶点未被访问过，且len小于出发顶点到j顶点的距离，就需要更新
            if (!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j,index);// 更新j顶点的前驱为index顶点
                vv.updateDis(j, len);// 更新出发顶点到j顶点的距离
            }
        }
    }

}
