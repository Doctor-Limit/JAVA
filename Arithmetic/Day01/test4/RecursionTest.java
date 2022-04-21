package Day01.test4;

/**
 * ********概述：
 * 运用递归实现迷宫
 *
 */
public class RecursionTest {
    public static void main(String[] args) {
        // 先创建一个二位数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用1表示墙
        // 上下全部置为1(行)
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] =1;
        }
        
        // 左右全部置为1(列)
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置除边界之外的墙
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // 使用递归回溯给小球找路
        //setWay(map,1,1);
        setWay1(map,1,1);// 修改后的策略寻路

        // 输出新的地图，小球走过，并对通路进行标识的递归
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯给小球找路
    /**
     *  map 表示地图
     *  小球默认从(1,1)出发,目的坐标为(6,5)
     *   规则：map[i][j]为0表示该点没有走过，为1表示墙，2表示可以走的通路，3表示该点已经走过且无法抵达目的地
     *   走迷宫时需要确定一个走迷宫的方法 例：优先级 下--》右--》上--》左，若该点走不通则回溯
     *
     * @param map  表示地图
     * @param i   i，j为小球的初始坐标
     * @param j
     * @return    找到路则返回真，否则返回假
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 已经找到通路
            return true;
        }else {
            if (map[i][j] == 0) {// 当前这个点未走过
                // 根据走的方式  下--》右--》上--》左
                map[i][j] = 2;// 假设该点可以走通
                if (setWay(map,i+1,j)) { // 向下走
                    return true;
                }else if (setWay(map,i,j+1)) {// 向右走
                    return true;
                }else if (setWay(map,i-1,j)) {// 向上走
                    return true;
                }else if (setWay(map,i,j-1)) {// 向左走
                    return true;
                }else {
                    // 说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {// map[i][j] != 0,可能为1、2、3,
                return false;
            }
        }
    }

    // 修改找路策略，上--》右--》下--》左
    public static boolean setWay1(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 已经找到通路
            return true;
        }else {
            if (map[i][j] == 0) {// 当前这个点未走过
                // 根据走的方式  下--》右--》上--》左
                map[i][j] = 2;// 假设该点可以走通
                if (setWay1(map,i-1,j)) { // 向上走
                    return true;
                }else if (setWay1(map,i,j+1)) {// 向右走
                    return true;
                }else if (setWay1(map,i+1,j)) {// 向下走
                    return true;
                }else if (setWay1(map,i,j-1)) {// 向左走
                    return true;
                }else {
                    // 说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {// map[i][j] != 0,可能为1、2、3,
                return false;
            }
        }
    }
}
