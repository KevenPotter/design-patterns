##工厂方法模式：
>本质：分离算法，选择实现
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
* 定义一系列算法  
策略模式的功能就是定义一系列，实现让这些算法可以相互替换。所以会为这一系列算法定义公共的接口，以约束一系列算法要实现的功能。如果这一系列算法具有公共功能，可以把策略接口实现为抽象类，把这些公共功能实现到父类中。
* 避免使用多重条件判断  
策略模式的一系列策略算法是平等的，是可以互换的，写在一起就是通过if-else结构来组织，如果此时具体的算法实现中又有条件语句，就构成了多重条件语句，使用策略模式能避免这样的多重条件语句。
* 扩展性良好  
在策略模式中扩展新的策略实现非常容易，只要增加新的策略实现类，然后在使用策略的地方选择使用这个新的策略实现就可以了。
####缺点：
* 策略类数量增多，增加数目对象  
由于策略模式把每个具体的策略实现都单独封装成为类，如果备选的策略很多的话，那么对象的数目就会很可观。
* 所有的策略类都需要对外暴露，违背迪米特法则  
让客户端来选择具体使用哪一个策略，这就需要客户了解所有的策略，还要了解各种策略的功能和不同，这样才能做出正确的选择，而且这样也暴露了策略的具体实现。
* 只适合扁平的算法结构  
策略模式的一系列算法地位是平等的，是可以相互替换的，事实上构成了一个扁平的算法结构，也就是在一个策略接口下，有多个平等的策略算法，就相当于兄弟算法。而且在运行时刻只有一个算法被使用，这就限制了算法使用的层级，使用的时候不能嵌套使用。
####使用场景：
1. 出现有许多相关的类，仅仅是行为有差别的情况下，可以使用策略模式来使用多个行为中的一个来配置一个类的方法，实现算法动态切换。
2. 出现同一个算法，有很多不同实现的情况下，可以使用策略模式来把这些“不同的实现”实现成为一个算法的类层次。
3. 需要封装算法中，有与算法相关数据的情况下，可以使用策略模式来避免暴露这些跟算法相关的数据结构。
4. 出现抽象一个定义了很多行为的类，并且是通过多个if-else语句来选择这些行为的情况下，可以使用策略模式来代替这些条件语句。