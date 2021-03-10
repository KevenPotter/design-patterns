##策略模式：
####概念：
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义一组算法，将每个算法都封装起来，并且使它们之间可以互换（Define a family of algorithms, encapsulate each one, and make them interchangeable.）。  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;策略模式使用的就是面向对象的继承和多态机制。
####通用类图解释：
**Context封装角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;它也叫做上下文角色，起承上启下封装作用，屏蔽高层模块对策略、算法的直接访问，封装可能存在的变化。  
**Strategy抽象策略角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;策略、算法家族的抽象，通常为接口，定义每个策略或算法必须具有的方法和属性。
**ConcreteStrategy具体策略角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实现抽象策略中的操作，该类含有具体的算法。
####通用类图代码演示：
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

####优点：
* 算法可以自由切换
* 避免使用多重条件判断
* 扩展性良好
####缺点：
* 策略类数量增多
* 所有的策略类都需要对外暴露，违背迪米特法则
####使用场景：
多个类只有在算法或行为上稍有不同的场景。  
算法需要自由切换的场景。  
需要屏蔽算法规则的场景