## 策略模式：  
>本质：分离算法，选择实现  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义一组算法，将每个算法都封装起来，并且使它们之间可以互换（Define a family of algorithms, encapsulate each one, and make them interchangeable.）。  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;策略模式使用的就是面向对象的继承和多态机制。
#### 通用类图解释：  
**Context封装角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;它也叫做上下文角色，起承上启下封装作用，屏蔽高层模块对策略、算法的直接访问，封装可能存在的变化。  
**Strategy抽象策略角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;策略、算法家族的抽象，通常为接口，定义每个策略或算法必须具有的方法和属性。
**ConcreteStrategy具体策略角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实现抽象策略中的操作，该类含有具体的算法。
#### 通用类图代码演示：  
抽象的策略角色：
```java
public interface Strategy {
    // 策略模式的运算法则
    public void doSomething();
}
```
具体的策略角色：
```java
public class ConcreteStrategy1 implements Strategy {
    public void doSomething() {
        System.out.println("具体策略1的运算法则");
    }
}

public class ConcreteStrategy2 implements Strategy {
    public void doSomething() {
        System.out.println("具体策略2的运算法则");
    }
}
```
封装角色：
```java
public class Context {
    // 抽象策略
    private Strategy strategy = null;
    // 构造函数设置具体策略
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    // 封装后的策略方法
    public void doAnything() {
        this.strategy.doSomething();
    }
}
```
高层模块：
```java
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategy1();
        Context context = new Context(strategy);
        context.doAnything();
    }
}
```
#### 优点：  
* 定义一系列算法  
策略模式的功能就是定义一系列，实现让这些算法可以相互替换。所以会为这一系列算法定义公共的接口，以约束一系列算法要实现的功能。如果这一系列算法具有公共功能，可以把策略接口实现为抽象类，把这些公共功能实现到父类中。  
* 避免使用多重条件判断  
策略模式的一系列策略算法是平等的，是可以互换的，写在一起就是通过if-else结构来组织，如果此时具体的算法实现中又有条件语句，就构成了多重条件语句，使用策略模式能避免这样的多重条件语句。  
* 扩展性良好  
在策略模式中扩展新的策略实现非常容易，只要增加新的策略实现类，然后在使用策略的地方选择使用这个新的策略实现就可以了。  
#### 缺点：  
* 策略类数量增多，增加数目对象  
由于策略模式把每个具体的策略实现都单独封装成为类，如果备选的策略很多的话，那么对象的数目就会很可观。  
* 所有的策略类都需要对外暴露，违背迪米特法则  
让客户端来选择具体使用哪一个策略，这就需要客户了解所有的策略，还要了解各种策略的功能和不同，这样才能做出正确的选择，而且这样也暴露了策略的具体实现。  
* 只适合扁平的算法结构  
策略模式的一系列算法地位是平等的，是可以相互替换的，事实上构成了一个扁平的算法结构，也就是在一个策略接口下，有多个平等的策略算法，就相当于兄弟算法。而且在运行时刻只有一个算法被使用，这就限制了算法使用的层级，使用的时候不能嵌套使用。  
#### 使用场景： 
1. 出现有许多相关的类，仅仅是行为有差别的情况下，可以使用策略模式来使用多个行为中的一个来配置一个类的方法，实现算法动态切换。  
2. 出现同一个算法，有很多不同实现的情况下，可以使用策略模式来把这些“不同的实现”实现成为一个算法的类层次。  
3. 需要封装算法中，有与算法相关数据的情况下，可以使用策略模式来避免暴露这些跟算法相关的数据结构。  
4. 出现抽象一个定义了很多行为的类，并且是通过多个if-else语句来选择这些行为的情况下，可以使用策略模式来代替这些条件语句。  