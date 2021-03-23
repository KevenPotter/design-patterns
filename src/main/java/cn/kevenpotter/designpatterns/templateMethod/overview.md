## 模板方法模式：  
>本质：固定算法骨架  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义一个操作中的算法的框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤（Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure n）。    
#### 通用类图解释：  
**AbstractClass角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抽象类。用来定义算法骨架和原语操作，具体的子类通过重定义这些原语操作来实现一个算法的各个步骤。在这个类里面，还可以提供算法中通用的实现。其中，它的方法分为两类：  
* 基本方法  
基本方法也叫做基本操作，是由子类实现的方法，并且在模板方法被调用。  
* 模板方法  
可以有一个或几个，一般是一个具体方法，也就是一个框架，实现对基本方法的调度，完成固定的逻辑。  
_注意：为了防止恶意的操作，一般模板方法都加上final关键字，不允许被覆写。另外，抽象模板中的基本方法尽量设计为protected类型，符合迪米特法则，不需要暴露的属性或方法尽量不要设置为protected类型。实现类若非必要，尽量不要扩大父类中的访问权限。_  

**ConcreteClass角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;具体实现类。用来实现算法骨架中的某些步骤，完成与特定子类相关的功能。  
#### 通用类图代码演示：  
AbstractClass角色：
```java
public abstract class AbstractClass {
    // 基本方法
    protected abstract void doSomething();
    // 基本方法
    protected abstract void doAnything();
    // 模板方法
    public void templateMethod() {
        // 调用基本方法，完成相关的逻辑
        this.doAnything();
        this.doSomething();
    }
}
```
ConcreteClass角色：
```java
public class ConcreteClass1 extends AbstractClass {
    // 实现基本方法
    protected void doSomething() {
        // 业务逻辑处理
    }
    protected void doAnything() {
            // 业务逻辑处理
    }
}

public class ConcreteClass2 extends AbstractClass {
    // 实现基本方法
    protected void doSomething() {
        // 业务逻辑处理
    }
    protected void doAnything() {
            // 业务逻辑处理
    }
}
```
Client角色：
```java
public class Client {
    public static void main(String[] args){
        AbstractClass class1 = new ConcreteClass1();
        AbstractClass class2 = new ConcreteClass2();
        // 调用模板方法
        class1.templateMethod();
        class2.templateMethod();
    }
}
```
较为完整的模板定义示例：
```java
public abstract class AbstractTemplate {

    // 模板方法，定义算法骨架
    public final void templateMethod() {
        this.operation1();              // 第一步
        this.operation2();              // 第二步
        this.doPrimitiveOperation1();   // 第三步
        this.doPrimitiveOperation2();   // 第四步
        this.hookOperation1();          // 第五步
    }

    // 具体操作1，算法中的步骤，固定实现，而且子类不需要访问
    private void operation1() {
        // 在这里具体的实现
    }

    // 具体操作2，算法中的步骤，固定实现，子类可能需要访问
    protected final void operation2() {
        // 在这里具体的实现
    }

    // 具体的AbstractClass操作，子类的公共功能，但通常不是具体的算法步骤
    protected void commonOperation() {
        // 在这里具体的实现
    }

    // 原语操作1，算法中的必要步骤，父类无法确定如何真正实现，需要子类来实现
    protected abstract void doPrimitiveOperation1();

    // 原语操作2，算法中的必要步骤，父类无法确定如何真正实现，需要子类来实现
    protected abstract void doPrimitiveOperation2();

    // 钩子操作，算法中的步骤，不一定需要，提供默认实现，由子类选择并具体实现
    protected void hookOperation1() {
        // 在这里提供默认实现
    }

    // 工厂方法，创建某个对象，这里用Object代替了，在算法实现中可能需要
    protected abstract Object createOneObject();
}
```
#### 优点：
* 封装不变部分，扩展可变部分  
把认为是不变部分的算法封装到父类实现，而可变部分的则可以通过继承来继续扩展。  
* 提取公共部分代码，便于维护  
* 行为由父类控制，子类实现  
基本方法是由子类实现的，因此子类可以通过扩展的方式增加相应的功能，符合开闭原则。  
#### 缺点：  
* 算法骨架不易升级    
模板方法模式最基本的功能就是通过模板的指定，把算法骨架固定下来。事实上模板和子类是非常耦合的，如果相对模板中的算法骨架进行变更，可能就会要求所有相关的子类进行相应的变化。所以抽取算法骨架的时候要特别小心，尽量确保是不会变化的部分才放到模板中。  
#### 使用场景：  
1. 需要固定定义算法骨架，实现一个算法的不变的部分，并把可变的行为留给子类来实现的情况。  
2. 各个子类中具有公共行为，应该抽取出来，集中在一个公共类中去实现，从而避免代码重复。  
2. 需要控制子类扩展的情况。模板方法模式会在特定的点来调用子类的方法，这样只允许在这些点进行扩展。  