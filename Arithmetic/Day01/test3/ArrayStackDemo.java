package Day01.test3;

import java.util.Scanner;

/**
 * ********概述：
 *
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        System.out.println("stack测试~~~");
        ArrayStack stack = new ArrayStack(4);

        String key = "";
        boolean loop = true;// 控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show : 显示栈");
            System.out.println("exit : 退出程序");
            System.out.println("push : 入栈");
            System.out.println("pop : 出栈");
            System.out.println("请输入选择");

            key = scanner.next();
            switch (key) {
                case "show":stack.list();break;
                case "push":
                    System.out.println("请输入你要添加的数字：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop" :
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n", res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("程序退出~~~");
                    loop = false;
                    break;
            }
        }
    }
}

// 定义一个ArrayStack表示栈
class ArrayStack {
    private int maxSize;// 栈的大小
    private int[] stack;// 数组模拟栈，数据放在数组中
    private int top = -1;

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize-1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        // 先判断是否栈满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 栈的遍历   需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无数据");
            return;
        }
        // 栈顶显示
        for (int i = top;i >= 0;i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
