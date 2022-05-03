package Day01.test10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * ********概述：图的遍历
 */
public class Graph {

    private ArrayList<String> vertexList;// 存储定点集合
    private int[][] edges;// 存储图对应的领接矩阵
    private int numberOfEdges;// 表示边的数目
    private boolean[] isVisited;// 用于记录该节点是否被访问

    public static void main(String[] args) {
        int n = 8;// 结点个数
        //String vertexs[] = {"A", "B", "C", "D", "E"};
        String vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        // 创建图对象
        Graph graph = new Graph(n);
        // 循环添加结点
        for (String vertex :vertexs) {
            graph.insertVertex(vertex);
        }
        // 添加边
        graph.insertEdge(0, 1, 1);// 将A与B相连
        graph.insertEdge(0, 2, 1);//
        graph.insertEdge(3, 7, 1);//
        graph.insertEdge(1, 3, 1);//
        graph.insertEdge(1, 4, 1);//
        graph.insertEdge(2, 5, 1);//
        graph.insertEdge(4, 7, 1);//
        graph.insertEdge(2, 6, 1);//
        graph.insertEdge(5, 6, 1);//

        // 矩阵的显示
        graph.showGraph();
        System.out.println();

        // 若bool数组在一次遍历后全部改变，可将其定义在对应的算法中
        // dfs
        System.out.println("深度优先遍历");
        graph.dfs();
        System.out.println();

        // bfs
        System.out.println("广度优先遍历");
        graph.bfs();
        System.out.println();

    }

    public Graph(int n) {
        // 初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numberOfEdges = 0;
    }

    //得到第一个邻接结点的下标w
    /**
     *
     * @param index  该结点索引
     * @return       若存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1] [j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 对一个结点进行广度优先遍历算法
    private void bfs(boolean[] isVisited, int i) {
        int u;// 表示队列的头结点对应下标
        int w;// 邻接结点w
        // 队列：记录结点访问的顺序
        LinkedList quene = new LinkedList();
        // 访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "->");
        // 标记为已访问
        isVisited[i] = true;
        // 将结点加入队列
        quene.addLast(i);

        while (!quene.isEmpty()) {
            // 取出队列头节点下标
            u = (Integer) quene.removeFirst();
            // 得到第一个邻接结点的下标w
            w = getFirstNeighbor(u);
            while (w != -1) {// 找到该下标
                if (!isVisited[w]) {// 未访问
                    System.out.print(getValueByIndex(w) + "->");
                    // 标记已经访问
                    isVisited[w] = true;
                    // 入队
                    quene.addLast(w);
                }
                // 若已访问，则找w后面的邻接结点访问
                w = getNextNeighbor(u , w);//  将w置为当前结点的邻接结点w的下一个邻接结点
            }
        }
    }

    // 多次广度优先遍历所有结点
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumberOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    // 深度优先遍历算法
    // i第一次就是0
    private void dfs(boolean[] isVisited, int i) {//只是走到无法访问就退出，并未访问完全部结点
        // 首先我们访问第一个结点,输出
        System.out.print(getValueByIndex(i) + "->");
        // 标记该结点为已访问
        isVisited[i] = true;

        // 查找i结点的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1) {//说明有该结点
            if (!isVisited[w]) {// 该结点未被访问
                dfs(isVisited, w);
            }
            // 若w结点已经被访问
            w = getNextNeighbor(i, w);// 将w置为以w为第一个邻接结点的结点
        }
    }

    // 对dfs进行重载，遍历所有的结点,并进行dfs
    public void dfs() {// 遍历所有结点进行dfs
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumberOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    // 返回结点的个数
    public int getNumberOfVertex() {
        return vertexList.size();
    }

    //返回边的数目
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    //返回结点i对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回两结点的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // 添加边
    /**
     *
     * @param v1    表示点的下标表示的顶点
     * @param v2     表示第二个顶点的下标对应的顶点
     * @param weight  表示两者之间是否直接相连
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numberOfEdges++;
    }

    // 显示矩阵
    public void showGraph() {
        for (int[] link :edges) {
            System.err.println(Arrays.toString(link));
        }
    }

}
