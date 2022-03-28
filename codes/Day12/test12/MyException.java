package Day12.test12;
/*
************************自定义异常类
* 1、继承于现有的异常结构，RuntimeException、Exception
* 2、提供全局常量serialVersionUID
* 3、提供重载构造器
*
 */
public class MyException extends RuntimeException {

    static final long serialVersionUID = -703489719066939L;//提供序列版本号来确定为同一类

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }
}
