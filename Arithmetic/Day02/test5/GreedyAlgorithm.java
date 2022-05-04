package Day02.test5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * ********概述：贪心算法的实现
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建广播电台,放入到Map中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        // 将各个电台放入其中
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        // 加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        HashSet<String> allAreas = new HashSet<>();// 存放所有地区
        for (String s : broadcasts.keySet()) {
            allAreas.addAll(broadcasts.get(s));
        }

        // 创建ArrayList存放选择的电台的集合
        List<String> selects = new ArrayList<>();

        // 定义一个临时的集合，在存放的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        // 定义一个maxKey，保存在一次遍历过程中，能够覆盖最大的未覆盖地区对应的电台的key
        // 若maxKey不为null，则会加入到selects
        String maxKey = null;
        while (allAreas.size() != 0) {// 每添加一个key，就把对应的地区从全部地区中删除
            // 遍历broadcasts，取出对应key
            for (String key : broadcasts.keySet()) {
                // 当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                // 求出tempSet 和 allAreas集合的交集,交集赋给tempSet
                tempSet.retainAll(allAreas);
                HashSet<String> maxKeyArea = broadcasts.get(maxKey);
                // 如果当前集合包含的未覆盖地区的数量，比maxKey指向的集合地区还多，就需要重置maxKey
                if(tempSet.size() > 0 &&
                        // 此时若之前的allAreas已经删除过某些数据，则需要在对应的key中也删除掉那些数据，再进行比较
                        (maxKey == null || tempSet.size() > maxKeyArea.size())){
                    maxKey = key;
                    maxKeyArea = broadcasts.get(maxKey);
                    maxKeyArea.retainAll(allAreas);
                }
                // maxKey != null，应该将maxKey加入到selects
                if (maxKey != null) {
                    selects.add(maxKey);
                    // 将maxKey指向的广播覆盖的地区从allAreas去掉
                    allAreas.removeAll(broadcasts.get(maxKey));
                }
                maxKey = null;// 每进行一次循环就需要对maxKey置空
                tempSet.clear();// 清除掉当前key覆盖的地区
            }
        }
        System.out.println("得到的结果"+selects);
    }
}
