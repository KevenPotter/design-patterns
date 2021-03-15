##简单工厂模式：
>本质：选择实现
####概念：
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供一个创建对象实例的功能，而无须关心其具体实现。被创建实例的类型可以是接口、抽象类，也可以是具体的类。    
####通用类图解释：
**Api角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义客户所需要的功能接口。  
**Impl角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;具体实现Api的实现类。  
**Factory角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工厂，选择合适的实现类来创建Api接口对象。  
**Client角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户端，通过Factory来获取Api接口对象，然后面向Api接口编程。  
####通用类图代码演示：
Api角色：
```java
public interface Api {
    /**
     * 示意，具体功能方法的定义
     * @param s 示意，需要的参数
     */
    public void operation(String s);
}
```
Impl角色：
```java
public class ImplA implements Api {
    public void operation(String s) {
        System.out.println("ImplA s=="+s);
    }
}

public class ImplB implements Api {
    public void operation(String s) {
        System.out.println("ImplB s=="+s);
    }
}
```
Factory角色：
```java
public class Factory {
    /**
     * 具体创建Api对象的方法
     * @param condition 示意，从外部传入的选择条件
     * @return 创建好的Api对象
     * 通常为String、Enum、Class等，当然也可以为空
     */
    public static Api createApi(int condition) {
        Api api = null;
        if (condition == 1) {
            api = new ImplA();
        } else if (condition == 2) {
            api = new ImplB();
        }
        return api;
    }
}
```
Client角色：
```java
public class Client {
    public static void main(String[] args) {
        Api api = Factory.createApi(1);
        api.operation("正在使用简单工厂。");
    }
}
```
####优点：
* 帮助封装  
简单工厂虽然很简单，但是非常友好地帮助我们实现了组件的封装，然后让组件外部能真正面向接口编程。  
* 解耦  
通过简单工厂，实现了客户端和具体实现类的解耦。  
####缺点：
* 可能增加客户端的复杂度  
如果通过客户端的参数来选择具体的实现类，那么就必须让客户端能理解各个参数所代表的具体功能和含义，这样会增加客户端使用的难度，也部分暴露了内部实现，这种情况可以选用可配置的方式来实现。  
* 不方便扩展子工厂  
私有化简单工厂的构造方法，使用静态方法来创建接口，也就不能通过写简单工厂类的子类来改变创建接口的方法的行为了。不过，通常情况下是不需要为简单工厂创建子类的。  
####使用场景：
1. 如果想要完全封装隔离具体实现，让外部只能通过接口来操作封装体，那么可以选用简单工厂，让客户端通过工厂来获取相应的接口，而无须关心具体的实现。  
2. 如果想要把对外创建对象的职责集中管理和控制，可以选用简单工厂，一个简单工厂可以创建很多的、不相关的对象，可以把对外创建对象的职责集中到一个简单工厂来，从而实现集中管理和控制。  