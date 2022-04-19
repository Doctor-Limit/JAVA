package Day01.test3;

/**
 * ********概述：
 *
 */
public class Calculation {

    public static void main(String[] args) {

        String expression = "30+2*6-2";
        // 创建数栈及符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;// 用于扫描
        int num1 = 0, num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';// 将每次扫描得到的char保存到ch
        String keepNum = "";// 用于拼接多位数
        // 开始while循环的扫描expression
        while (true) {
            // 依次得到expression的每一个字符
           ch = expression.substring(index, index+1).charAt(0);
           // 判断ch是什么判断相应处理
            if (operStack.isOper(ch)) {//运算符
                if (!operStack.isEmpty()) {
                    /*
                    符号栈中有操作符，就进行比较，若当前的操作符的优先级小于或等于栈中的操作符，就需要从数栈中pop除
                    两个数，再从符号栈中pop除一个符号，进行运算并将结果存入数栈，再将当前的操作符入符号栈
                     */
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        // 将运算后的结果入数栈
                        numStack.push(res);
                        // 再将当前的操作符入符号栈
                        operStack.push(ch);
                    }else {
                        // 若当前操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    // 若为空直接入栈
                    operStack.push(ch);
                }
            }else {   // 如果是数，直接入数栈
             //   numStack.push(ch - 48); // 字符1与数字1的ASCII码正好相差48
                // 不能立即入栈，可能是多位数
                // 处理数据时，需要向expression的表达式index后再看，直到扫描到符号才将数字入闸
                // 需要定义一个变量字符串，用于拼接

                // 处理多位数
                keepNum += ch;
                // 此时若ch已经是最后一位，则直接入栈

                if (index == expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    // 判断下一个字符是否为数字,直到扫描到运算符为止
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 若后一位为操作符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";// 将keepNum清空
                    }
                }
            }
            // 让index+1，并判断是否扫描到expression的末端
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        // 扫描完毕后，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            // 若符号栈为空，则得到了最后的结果，此时数栈中只有一个值
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res); // 入栈

        }
        //将数组的最后数，pop出
        int res2 = numStack.pop();
        System.out.printf("表达式%s=%d",expression,res2);
    }
}

//先创建一个栈，需要添加功能
class ArrayStack2 {
    private int maxSize;// 栈的大小
    private int[] stack;// 数组模拟栈，数据放在数组中
    private int top = -1;

    // 构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 返回当前栈顶的值的方法，并未pop出
    public int peek() {
        return stack[top];
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

    // 返回运算符优先级，优先级自己确定，用数字表示
    // 数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }else if (oper == '+' || oper == '-') {
            return 0;
        }else if (oper == '(' || oper == ')'){
            return 2;
        }else {
            return -1;
        }
    }

    // 判断是否为运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法  先出栈的数据是除/减数，后出栈的是被除/减数
    public int cal(int num1, int num2, int oper) {
        int res = 0;// 用于保存计算结果
        switch (oper) {
            case '+': res = num1 + num2; break;
            case '-': res = num2 - num1; break; // 后来的数减去之前的数
            case '*': res = num1 * num2; break;
            case '/': res = num2 / num1; break;
            default:  break;
        }
        return res;
    }
}
