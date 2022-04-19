package Day01.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ********概述：
 *  逆波兰表达式实现对数据的运算
 *
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
        // (3+4)*5-6 = 3 4 + 5 * 6 -
        // 逆波兰表达式中数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        /*
        1、先将字符串放到ArrayList中
        2、将ArrayList传递给一个方法，配合栈完成运算
         */
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnlist="+rpnList);

        int res = calculate(rpnList);
        System.out.println("结果为："+res);

    }

    // 完成对逆波兰表达式的运算
    // 从左往右依次扫描，当数栈存在两个及以上的数时，每读取到一个操作符就将栈顶和次顶的数据运算后存入数栈，再将该操作符存入栈，直至读取到末尾
    public static int calculate(List<String> ls) {
        // 创建栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        // 遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            }else {
                // pop出两个数据并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(item)){
                    res = num1 + num2;
                }else if ("-".equals(item)) {
                    res = num1 - num2; // 后弹出的减去先弹出栈的
                }else if ("*".equals(item)) {
                    res = num1 * num2;
                }else if ("/".equals(item)) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                // 把res入栈
                stack.push("" + res);
            }
        }
        // 最后留在栈中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }


    // 将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        // 将suffixExpression分割
        String[] spilt = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : spilt) {
            list.add(ele);
        }
        return list;
    }
}
