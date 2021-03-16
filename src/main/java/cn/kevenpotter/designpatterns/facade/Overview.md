## 外观（门面）模式：
>本质：封装交互，简化调用  
#### 概念：
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。外观模式提供一个高层次的接口，使得子系统更易于使用（Porvide a unified interface to a set of interfaces in a subsystem, Facade defines a higher-level interface that makes the subsystem easier to use. ）。     
####通用类图解释：
**Facade门面角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户端可以调用这个角色的方法。此角色知晓子系统的所有功能和责任。一般情况下，本角色会将所有从客户端发来的请求委派到相应的子系统去，也就是说该角色没有实际的业务逻辑，只是一个委托类。  
**subsystem角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可以同时有一个或者多个子系统。每一个子系统都不是一个单独的类，而是一个类的集合。子系统并不知道门面的存在。对于子系统而言，门面仅仅是另一个客户端而已。  
####通用类图代码演示：
subsystem角色：
```java
public class ClassA {
    public void doSomethingA(){
        //业务逻辑
    }
}

public class ClassB {
    public void doSomethingB(){
        //业务逻辑
    }
}

public class ClassC {
    public void doSomethingC(){
        //业务逻辑
    }
}
```
Facade角色：
```java
public class Facade {

    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();

    public void methodA() {
        this.a.doSomethingA();
    }
    public void methodA() {
        this.a.doSomethingB();
    }
    public void methodA() {
        this.a.doSomethingC();
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