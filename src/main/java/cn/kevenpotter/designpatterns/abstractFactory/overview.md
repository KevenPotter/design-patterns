## 抽象工厂模式：  
>本质：选择产品簇的实现  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为创建一组相关或相互依赖的对象提供一个接口，而且无需指定它们的具体类（Provide an interface for creating families of related or dependent objects without specifying their concrete classes.）。    
#### 通用类图解释：  
**Abstract Factory角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抽象工厂，定义创建一系列产品对象的操作接口。  
**Concrete Factory角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;具体的工厂，实现抽象工厂定义的方法，具体实现一系列产品对象的创建。  
**Abstract Product角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义一类产品对象的接口。  
**Concrete Product角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;具体的产品实现对象，通常在具体工厂里面，会选择具体的产品实现对象，来创建符合抽象工厂定义的方法返回的产品类型的对象。  
**Client角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户端，主要使用抽象工厂来获取一系列所需要的产品对象，然后面向这些产品对象的接口编程，以实现需要的功能。  
#### 通用类图代码演示：  
Abstract Factory角色：
```java
public interface AbstractFactory {
    // 创建抽象产品A的对象
    AbstractFactoryA createProductA();
    // 创建抽象产品B的对象
    AbstractFactoryB createProductB();
}
```
Abstract Product角色：
```java
public interface AbstractFactoryA {
    // 定义抽象产品A相关的操作
}

public interface AbstractFactoryB {
    // 定义抽象产品B相关的操作
}
```
Concrete Product角色：
```java
public class ProductA1 implements AbstractFactoryA {
    // 实现产品A的接口中定义的操作
}

public class ProductA2 implements AbstractFactoryA {
    // 实现产品A的接口中定义的操作
}

public class ProductB1 implements AbstractFactoryB {
    // 实现产品B的接口中定义的操作
}

public class ProductB2 implements AbstractFactoryB {
    // 实现产品B的接口中定义的操作
}
```
Concrete Factory角色
```java
public class ConcreteFactory1 implements AbstractFactory {

    public AbstractProductA createProductA() {
        return new ProductA1();
    }
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

public class ConcreteFactory2 implements AbstractFactory {

    public AbstractProductA createProductA() {
        return new ProductA2();
    }
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
```
Client角色：
```java
public class Client {
    public static void main(String[] args) {
        // 创建抽象工厂对象
        AbstractFactory af = new ConcreteFactory1();
        // 通过抽象工厂来获取一系列的对象，如产品A和产品B
        af.createProductA();
        af.createProductB();
    }
}
```
#### 优点：
* 分离接口和实现  
客户端使用抽象工厂来创建需要的对象，而客户端根本就不知道具体的实现是谁，客户端只是面向产品的接口编程而已。也就是说，客户端从具体的产品实现中解耦。  
* 使得切换产品簇变得容易  
因为一个具体的工厂实现代表的是一个产品簇，客户端选用不同的工厂实现，就相当于是在切换不同的产品簇。  
#### 缺点：  
* 不太容易扩展新的产品    
如果需要给整个产品添加一个新的产品，那么就需要修改抽象工厂，这样就会导致修改所有的工厂实现类。  
* 容易造成类层次复杂    
在使用抽象工厂模式的时候，如果需要选择的层次过多，那么会造成整个类层次变得复杂。  
#### 使用场景：  
1. 如果希望一个系统独立于它的产品的创建、组合和表示的时候。换句话说，希望一个系统只是知道产品的接口，而不关心实现的时候。  
2. 如果一个系统要由多个产品系列中的一个来配置的时候，换句话说，就是可以动态地切换产品簇的时候。  
2. 如果要强调一系列相关产品的接口，以便联合使用它们的时候。  