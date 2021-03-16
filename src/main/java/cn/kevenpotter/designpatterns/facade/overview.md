## 外观（门面）模式：  
>本质：封装交互，简化调用  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。外观模式提供一个高层次的接口，使得子系统更易于使用（Porvide a unified interface to a set of interfaces in a subsystem, Facade defines a higher-level interface that makes the subsystem easier to use. ）。     
#### 通用类图解释：  
**Facade门面角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户端可以调用这个角色的方法。此角色知晓子系统的所有功能和责任。一般情况下，本角色会将所有从客户端发来的请求委派到相应的子系统去，也就是说该角色没有实际的业务逻辑，只是一个委托类。  
**subsystem角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可以同时有一个或者多个子系统。每一个子系统都不是一个单独的类，而是一个类的集合。子系统并不知道门面的存在。对于子系统而言，门面仅仅是另一个客户端而已。  
#### 通用类图代码演示：  
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
#### 优点：  
* 松散耦合  
外观模式松散了客户端与子系统的耦合关系，让子系统内部的模块能更容易扩展和维护。  
* 简单易用  
外观模式让子系统更加易用，客户端不再需要了解子系统内部的实现，也不需要跟众多子系统内部的模块进行交互，只需要跟外观交互就可以了，相当于外观类为外部客户端使用子系统提供了一站式服务。
* 更好地划分访问的层次  
通过合理使用Facade，可以帮助我们更好地划分访问的层次。有些方法是对系统外的，有些方法是系统内部使用的。把需要暴露给外部的功能集中到外观中，这样既方便客户端使用，也很好地隐藏了内部的细节。
#### 缺点：  
* 增加迷惑性  
过多的或者是不太合理的Facade也容易让人迷惑。到底是调用Facade好呢，还是直接调用模块好呢。
#### 使用场景：  
1. 如果你希望为一个复杂的子系统提供一个简单接口的时候，可以考虑使用外观模式。使用外观对象来实现大部分客户需要的功能，从而简化客户的使用。  
2. 如果想要让客户程序和抽象类的实现部分松散耦合，可以考虑使用外观模式，使用外观对象来将这个子系统与它的客户分离开来，从而提高子系统的独立性和可移植性。  
3. 如果构建多层结构的系统，可以考虑使用外观模式，使用外观对象作为每层的入口，这样可以简化层间调用，也可以松散层次之间的依赖关系。  