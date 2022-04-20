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

        String s ="abc";
        System.out.println(s.substring(0,1));

        /*
        直接对str操作不方便，故先将中缀表达式转化为对应的List
        将中缀表达式 对应的List转化为后缀表达式对应的List
         */
        String expression = "1+((2+3)*4)-5";
        List<String> toInfixExpressionList = toInfixExpression(expression);
        System.out.println(toInfixExpressionList);
        List<String> expressionList = parseSuffixExpressionList(toInfixExpressionList);
        System.out.println("后缀表达式对应的List="+ expressionList);
        System.out.printf("expression = %d",calculate(expressionList));

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

    //实现中缀表达式的List转化为后缀表达式的List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<>();
        // 因为s2这个栈，在整个过程中，没有pop操作，而且后面还需要逆序输出
        // 故不用栈而用List<String>() 替代
        List<String> s2 = new ArrayList<>();

        // 遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")) { // 若为一个数，加入s2
                s2.add(item);
            }else if (item.equals("(")) {
                s1.push(item);
            }else if (item.equals(")")) {
                //  如果是")",则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); // 将"("弹出s1这个栈,消除小括号
            }else {
                // 当item优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，并再次与新的栈顶运算符比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 还需要将item加入栈中
                s1.push(item);
            }
        }
        // 将s1中剩余的运算符依次弹出并加入到s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;// 因为是存放到List中，所以按顺序输出就是对应的后缀表达式对应的List
    }

    // 将中缀表达式转成对应的List
    public static List<String> toInfixExpression(String s) {
        // 定义一个List 存放中缀表达式对应的内容
        ArrayList<String> ls = new ArrayList<>();
        int i = 0;// 定义一个指针用于遍历中缀表达式字符串
        String str; // 实现多位数的拼接
        char c;// 每遍历到一个字符，就放入c
        do {
            // 若c是一个非数字，就需要加入到ls中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            }else { // 如果是数，就需要考虑多位数
                str = "";// 先将str置空   0~9的ASCII码位于[48,58)之间
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
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

// 可返回一个运算符对应的有衔接
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    // 写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":result = ADD;break;
            case "-":result = SUB;break;
            case "*":result = MUL;break;
            case "/":result = DIV;break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}