## 桥接模式：  
>本质：分离抽象和实现  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;将抽象和实现解耦，使得两者可以独立地变化（Decouple an abstraction from its implementation so that the two can vary independently.）。  
#### 通用类图解释：  
**Abstraction角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抽象部分的接口。通常在这个对象中，要维护一个实现部分的对象引用，抽象对象里面的方法，需要调用实现部分的对象来完成。这个对象中的方法，通常都是和具体的业务相关的方法。  
**RefinedAbstraction角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;扩展抽象部分的接口。通常在这些对象中，定义跟实际业务相关的方法，这些方法的实现通常会使用Abstraction中定义的方法，也可能需要调用实现部分的对象来完成。  
**Implementor角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义实现部分的接口。这个接口不用和Abstraction中的方法一致，通常是由Implementor接口提供基本的操作。而Abstraction中定义的是基于这些基本操作的业务方法，也就是说Abstraction定义了基于这些基本操作的较高层次的操作。  
**ConcreteImplementor角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真正实现Implementor接口的对象。  
#### 通用类图代码演示：  
Implementor角色：
```java
public interface Implementor {
    /**
     * 示例方法，实现抽象部分需要的某些具体功能
     */
    void operationImpl();
}
```
Abstraction角色：
```java
public abstract class Abstraction {
    
    /**
     * 持有一个实现部分的对象
     */
    protected Implementor impl;
    /**
     * 构造方法，传入实现部分的对象
     */
    public Abstraction(Implementor impl) {
        this.impl = impl;
    }
    /**
     * 示例操作，实现一定的功能，可能需要转调实现部分的具体实现方法
     */
    public void operation() {
        impl.operationImpl();
    }
}
```
ConcreteImplementor角色：
```java
public class ConcreteImplementorA implements Implementor {
    public void operationImpl() {
        // 真正的实现
    }
}

public class ConcreteImplementorB implements Implementor {
    public void operationImpl() {
        // 真正的实现
    }
}
```
RefinedAbstraction角色：
```java
public class RefinedAbstraction extends Abstraction {
    
    public RefinedAbstraction(Implementor impl) {
        supre(impl);
    }
    
    public void otherOperation() {
        /*
         * 实现一定的功能，可能会使用具体实现部分的实现方法
         * 但是本方法最大的可能是使用Abstraction中定义的方法
         * 通过组合使用Abstraction中定义的方法来完成更多的功能
         */
    }
}
```
#### 优点：  
* 桥接模式很好地实现了开闭原则  
通常应用桥接模式的地方，抽象部分和实现部分都是可变化的，也就是应用会有两个变化的维度，桥接模式就是找到这两个变化，并分别封装起来，从而合理地实现OCP。  
在使用桥接模式的时候，通常情况下，顶层的Abstraction和Implementor是不变的，而具体的Implementor的实现是可变的。由于Abstraction是通过接口来操作具体的实现，因此具体的Implementor的实现是可以扩展的，根据需要可以有多个具体的实现。  
同样地，RefinedAbstraction也是可变的，它继承并扩展Abstraction，通常在RefinedAbstraction的实现中，会调用Abstraction中的方法，通过组合使用来完成更多的功能，这些功能常常是与具体业务有关系的。  
* 桥接模式很好地体现了多用对象组合，少用对象继承  
如果使用对象继承来扩展功能，不但让对象之间有很强的耦合性，而且会需要很多的子类才能够完成相应的功能，这可能需要两个维度上的可变化数量的乘积个子类。  
而采用对象的组合，松散了对象之间的耦合性，不但使每个对象变得简单和可维护，还大大减少了子类的个数，根据前面的描述，大约需要两个维度上的可变化数量的和个子类。  
#### 使用场景：  
1. 如果你不希望在抽象部分和实现部分采用固定的绑定关系，可以采用桥接模式，来把抽象部分和实现部分分开，然后在程序运行期间来动态地设置抽象部分需要用到的具体的实现，还可以动态地切换具体的实现。  
2. 如果出现抽象部分和实现部分都能够扩展的情况，可以采用桥接模式，让抽象部分和实现部分独立地变化，从而灵活地进行单独扩展，而不是搅在一起，扩展一边就会影响到另一边。  
3. 如果希望实现部分的修改不会对客户产生影响，可以采用桥接模式。由于客户是面向抽象的接口在运行，实现部分的修改可以独立于抽象部分，并不会对客户产生影响，也可以说对客户是透明的。  
4. 如果采用继承的实现方案，会导致产生很多的子类，对于这种情况，可以考虑采用桥接模式，分析功能变化的原因，看看是否能分离成不同的维度，然后通过桥接模式来分离它们，从而减少子类的数目。  