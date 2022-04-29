package Day01.test9;

import java.io.*;
import java.util.*;

/**
 * ********概述： 霍夫曼编码及其使用
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

        byte[] bytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是"+Arrays.toString(bytes));
        System.out.println("长度为"+ bytes.length);

        byte[] decode = decode(huffmanCodes, bytes);
        System.out.println("原来的字符串"+new String(decode));

 //       // 压缩文件的测试
//        String srcFile = "E://chap//Arithmetic//Day01//test9//1.jpg";
//        String dstFile = "E://chap//Arithmetic//test.zip";

//        zipFile(srcFile, dstFile);
//        System.out.println("压缩文件成功");

        // 测试解压文件
        String zipFile = "E://chap//Arithmetic//test.zip";
        String dstFile = "E://chap//Arithmetic//Day01//test9//2.jpg";
        unZipFile(zipFile, dstFile);
        System.out.println("解压成功");



//        System.out.println(contentBytes.length);
//
//        List<Node1> nodes = getNodes(contentBytes);
//        System.out.println(nodes);
//
//        Node1 huffmanTree = createHuffmanTree(nodes);// 返回根结点
//        System.out.println();
//
//        preOrder(huffmanTree);
//        System.out.println();
//
//        getCodes(huffmanTree,"",stringBuilder);
//        System.out.println("生成的霍夫曼编码表" + huffmanCodes);
//        System.out.println();
//
//        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);
//        System.out.println("根结点方法重载后的编码表" + huffmanCodes);
//        System.out.println();
//
//        byte[] zip = zip(contentBytes, huffmanCodes);
//        System.out.println(Arrays.toString(zip));

    }

    // 编写方法完成对文件的解压
    /**
     *
     * @param zipFile
     * @param dstFile
     */
    public static void unZipFile(String zipFile, String dstFile) {
        // 定义文件输入流
        InputStream is = null;
        // 定义对象输入流
        ObjectInputStream ois = null;
        // 定义文件输出流
        OutputStream os = null;
        try {
            // 创建文件输入流
            is = new FileInputStream(zipFile);
            // 创建is相关对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            // 读取保存的霍夫曼编码表
            Map<Byte, String > huffmanCodes = (Map<Byte, String>) ois.readObject();

            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            // 将bytes数组写入到目标文件
            os = new FileOutputStream(dstFile);
            // 写数据到目标文件中
            os.write(bytes);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 编写方法对文件进行压缩
    /**
     *
     * @param srcFile 被压缩文件的路径
     * @param dstFile  完成压缩后文件路径
     */
    public static void zipFile(String srcFile, String dstFile) {
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            // 创建输出流

            //创建输入流
            is = new FileInputStream(srcFile);
            // 创建一个和源文件大小相同的byte[]
            byte[] b = new byte[is.available()];
            is.read(b);
            // 对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            // 创建文件的输出流，存放压缩文件
            os = new FileOutputStream(dstFile);
            // 创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            // 把霍夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);

            // 以对象流的方式写入霍夫曼编码，以便后来恢复源文件时使用
            // 防止后来无法恢复
            oos.writeObject(huffmanCodes);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 完成数据的解压缩(补码运算)
    // 1、将字节数组专户为对应的二进制编码字符串，霍夫曼编码对应的二进制字符串对照霍夫曼编码还原

    // 对压缩数据的解码
    /**
     *
     * @param huffmanCodes  霍夫曼编码表
     * @param huffmanBytes  霍夫曼编码得到的字节数组
     * @return              原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        // 得到huffmanBytes对应的二进制字符串
        StringBuilder stringBuilder1 = new StringBuilder();
        // 将byte数组转成二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            // 判断是否为最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder1.append(byteToBitString(!flag,  huffmanBytes[i]));
        }
        // 将字符串按照指定霍夫曼编码进行解码
        // 把霍夫曼编码表进行调换，反向查询
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        // 创建集合存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0;i < stringBuilder1.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                // 取出一个"1","0"
                String key = stringBuilder1.substring(i, i + count);// i不动，是count移动，直到匹配到一个字符
                b = map.get(key);
                if (b == null) {
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;// i直接移动到count，此时不包括count那位，左闭右开，故直接移动即可
        }
        // for结束后，list中存放了所有的字符，把list中的数据放入到byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个byte转换成二进制字符串
     * @param b
     * @param flag 标志是否需要补高位，若为真表示需要补高位，false表示不补,最后一个字节不需要补高位
     * @return b对应的二进制的字符串，按补码返回
     */
    private static String byteToBitString(boolean flag, byte b) {
        // 将b转成int以便转化为字符串
        int temp = b;
        // 如果是正数还需要补位
        if (flag) {
            temp |= 256;// 按位或 8字节有1或运算则为1
        }
        String str = Integer.toBinaryString(temp);// 返回的是temp对应的二进制补码

        if (flag || temp < 0) {
            return str.substring(str.length() - 8);// 返回后8位
        }else {
            return str;// 末尾不足八位
        }
    }

    // 使用一个方法将主函数中方法封装
    /**
     *
     * @param bytes  原始的字符串对应的字节数组
     * @return       经过霍夫曼编码压缩后的数组
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node1> nodes = getNodes(bytes);
        // 根据nodes创建霍夫曼树
        Node1 huffmanTreeRoot = createHuffmanTree(nodes);
        // 根据霍夫曼树创建霍夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        // 根据对应的霍夫曼编码形成新的字节数组
        byte[] zip = zip(bytes, huffmanCodes);
        return zip;
    }

    //将字符串对应的byte[]数组，通过生成的霍夫曼编码表，返回一个霍夫曼编码压缩后的byte[]
    /**
     *
     * @param bytes          原始字符串对应的byte[]
     * @param huffmanCodes   生成的霍夫曼编码map
     * @return               返回霍夫曼编码处理后的byte[]
     *
     *  传入的byte数组为contentBytes，返回的是霍夫曼编码 8位 对应一个byte
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        // 1、利用huffmanCodes将bytes转成霍夫曼编码对应的字符串
        StringBuilder builder = new StringBuilder();
        // 遍历bytes数组
        for (byte b : bytes) {
            builder.append(huffmanCodes.get(b));
        }
        //System.out.println(builder.toString());

        // 将目标字符串转化为byte[]数组
        // 统计霍夫曼编码长度
        int len ;
        if (builder.length() % 8 == 0) {
            len = builder.length() / 8;
        }else {
            len = builder.length() / 8 + 1;
        }
        // 等价于 int len = (builder.length() + 7) / 8;

        // 创建存储压缩后的byte数组
        byte[] huffmanCodesBytes = new byte[len];
        int index = 0;// 记录是第几个byte

        for (int i = 0; i < builder.length(); i += 8) {// 每8位对应一个byte，所以步长+8
            String strByte;
            if (i + 8 > builder.length()) {// 末尾下标不够八位
                strByte = builder.substring(i);
            }else {
                strByte = builder.substring(i, i + 8);
            }

            // 将stringByte转化为一个byte,放入到字节数组
            huffmanCodesBytes[index] = (byte)Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodesBytes;

    }

    // 前序遍历
    private static void preOrder(Node1 root) {
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("霍夫曼树为空，无法遍历");
        }
    }

    // 生成霍夫曼树对应的霍夫曼编码
    // 1、将霍夫曼编码表存放在Map<Byte,String>形式
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    // 定义向左为0，向右为1，确定编码表
    // 生成霍夫曼编码表示，需要去拼接路径，定义一个StringBuilder，存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    //直接根据根结点调用，方法重载
    private static Map<Byte, String> getCodes(Node1 root) {
        if (root == null) {
            return null;
        }
        // 处理root左子树
        getCodes(root.left,"0",stringBuilder);
        // 处理root右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }

    /**
     *  将传入的node结点的所有叶子结点的霍夫曼编码得到，并放入到huffmanCodes集合
     * @param node   传入节点
     * @param code   左子结点为0，右子结点为1
     * @param stringBuilder  用于拼接路径
     */
    private static void getCodes(Node1 node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null) { // 若结点为空，不处理
            // 判断当前node是叶子结点还是非叶子结点
            if (node.data == null) {// 非叶子结点
                // 递归处理
                getCodes(node.left,"0",stringBuilder2);// 向左递归
                getCodes(node.right,"1",stringBuilder2);// 向右递归
            }else { //叶子结点:也找到子树末尾
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /**
     *
     * @param bytes  字节数组
     * @return       返回字符与次数对应的集合
     */
    private static List<Node1> getNodes(byte[] bytes) {
        // 创建一个ArrayList
        ArrayList<Node1> node1s = new ArrayList<>();

        // 遍历字节数组，统计每个byte出现的次数-->map[key,value]
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {// map第一次收录该字符
                counts.put(b, 1);
            }else {
                counts.put(b, count + 1);
            }
        }
        // 把每一个键值对转化为Node对象，并加入到nodes集合
        // 遍历map并将其结点加入
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            node1s.add(new Node1(entry.getKey(), entry.getValue()));
        }
        return node1s;
    }

    //通过List创建对应的霍夫曼树
    public static Node1 createHuffmanTree(List<Node1> node1s) {
        while (node1s.size() > 1) {
            Collections.sort(node1s);
            // 取出最小二叉树
            Node1 leftNode = node1s.get(0);
            // 取出次小二叉树
            Node1 rightNode = node1s.get(1);

            Node1 parent = new Node1(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            // 将已处理的二叉树移除
            node1s.remove(leftNode);
            node1s.remove(rightNode);
            // 加入新的二叉树
            node1s.add(parent);
        }
        // nodes最后的结点就是该霍夫曼树的根结点
        return node1s.get(0);
    }
}

// 创建Node，存放数据及其权值(出现次数)
class Node1 implements Comparable<Node1>{

    Byte data;// 存放数据本身，实际底层以ASCII码保存
    int weight;// 权值，表示字符出现次数
    Node1 left;
    Node1 right;

    public Node1(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node1 o) {
        return this.weight - o.weight;// 从小到大排序
    }

    @Override
    public String toString() {
        return "Node1{" + "data=" + data + ", weight=" + weight + '}';
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
