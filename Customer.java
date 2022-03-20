package Day05;

public class Customer {

    private String name;
    private char sex;
    private int age;
    private String phone;
    private String email;
    public void SetName(String name){
        this.name=name;
    }
    public void SetSex(char sex){
        this.sex=sex;
    }
    public void SetAge(int age){
        this.age=age;
    }
    public void SetPhone(String Phone){
        this.phone=Phone;
    }
    public void SetEmail(String Email){
        this.email=Email;
    }
    public String getName(){
        return name;
    }
    public char getSex(){
        return sex;
    }
    public int getAge(){
        return age;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public Customer(){
    }
    public Customer(String name,char sex,int age,String phone,String email){
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.phone=phone;
        this.email=email;
    }

}
