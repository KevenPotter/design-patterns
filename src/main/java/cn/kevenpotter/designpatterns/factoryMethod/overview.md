##工厂方法模式：
>本质：延迟到子类来选择实现
####概念：
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类（Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.）。    
####通用类图解释：
**Product角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义工厂方法所创建的对象的接口，也就是实际需要使用的对象的接口。  
**ConcreteProduct角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;具体的Product接口的实现对象。  
**Creator角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建器，声明工厂方法，工厂方法通常会返回一个Product类型的实例对象，而且多是抽象方法。也可以在Creator里面提供工厂方法的默认实现，让工厂方法返回一个缺省的Product类型的实例对象。  
**ConcreteCreator角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;具体的创建器对象，覆盖实现Creator定义的工厂方法，返回具体的Product实力。  
####通用类图代码演示：
抽象产品类：
```java
public abstract class Product {
    // 产品类的公共方法
    public void method1() {
        // 业务逻辑处理
    }
    // 抽象方法
    public abstract void method2();
}
```
具体产品类：
```java
public class ConcreteProduct1 extends Product {
    public void method2() {
        // 业务逻辑处理
    }
}

public class ConcreteProduct2 extends Product {
    public void method2() {
        // 业务逻辑处理
    }
}
```
抽象工厂类：
```java
public abstract class Creator {
    /**
     * 创建一个产品对象，其输入参数类型可以自行设置
     * 通常为String、Enum、Class等，当然也可以为空
     */
    public abstract <T extends Product> T createProduct(Class<T> c);
}
```
具体工厂类
```java
public class ConcreteCreator extends Creator {
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product)Class.forName(c.getName()).newInstance();
        } catch (Exception e){
            // 异常处理
        }
        return (T)product;
    }
}
```
高层模块：
```java
public class Client {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct(ConcreteProduct1.class);
    }
}
```
####优点：
* 可以在不知具体实现的情况下编程  
工厂方法模式可以让你在实现功能的时候，如果需要某个产品对象，只需要使用产品的接口即可，而无需关心具体的实现。选择具体实现的任务延迟到子类去完成。  
* 更容易扩展对象的新版本  
工厂方法给子类提供了一个挂钩，使得扩展新的对象版本变得非常容易。  
* 连接平行的类层次  
工厂方法除了创造产品对象外，在连接平行的类层次上也大显身手  
####缺点：
* 具体产品对象和工厂方法的耦合性  
在工厂方法模式中，工厂方法是需要创建产品对象的，也就是需要选择具体的产品对象，并创建它们的实例，因此具体产品对象和工厂方法是耦合的。  
####使用场景：
1. 如果一个类需要创建某个接口的对象，但是又不知道具体的实现，这种情况可以选用工厂方法模式，把创建对象的工作延迟到子类去实现。  
2. 如果一个类本身就希望由它的子类来创建所需的对象的时候，应该使用工厂方法模式。  