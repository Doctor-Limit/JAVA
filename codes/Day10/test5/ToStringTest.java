package Day10.test5;
/*
***************Object类中toString()的使用
1、输出一个对象的引用时（地址），实际就是引用toString()方法
2、Object类中toString()的定义：默认返回地址
    public String toString(){
      return getClass().getName()+"@"+Integer.toHexString(hashCode())  getClass()当前类
      }
3、像String、Date、File、包装类等都重写了Object中的toString方法
   使得调用对象的toString返回实体内容信息
4、自定义类可重写toString方法，实现返回实体内容功能
 */
public class ToStringTest {
    public static void main(String[] args) {

    }
}
