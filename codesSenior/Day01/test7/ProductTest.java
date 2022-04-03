package Day01.test7;

/**
 * ********概述：线程通信应用
 *
 */

class Clerk{
private int productCount=0;
public synchronized void produceProduct() {//生产产品
if(productCount<20){
  productCount++;
  System.out.println(Thread.currentThread().getName()+"开始生产第"+productCount+"个产品");
  notify();
}else {
  try {
    wait();
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
}
}
public synchronized void consumeProduct(){//消费产品
if(productCount>0){
  System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
  productCount--;
  notify();
}else {
  try {
    wait();
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
}
}
}

class Producer extends Thread{
  private Clerk clerk;
  public Producer(Clerk clerk) {
    this.clerk = clerk;
  }
  @Override
  public void run() {
    System.out.println(getName()+":开始生产产品...");
    while (true){
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      clerk.produceProduct();
    }
  }
}

class Customer extends Thread{
  private Clerk clerk;
  public Customer(Clerk clerk){
    this.clerk=clerk;
  }
  @Override
  public void run() {
    System.out.println(getName()+"开始消费产品...");
    while (true){
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      clerk.consumeProduct();
    }
  }
}

public class ProductTest {
  public static void main(String[] args) {
    Clerk clerk=new Clerk();
    Producer p1=new Producer(clerk);
    Customer c1=new Customer(clerk);
    Customer c2=new Customer(clerk);
    p1.setName("生产者1");
    c1.setName("消费者1");
    c2.setName("消费者2");

    p1.start();
    c1.start();
    c2.start();
  }
}
