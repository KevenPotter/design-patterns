## 装饰器模式：  
>本质：动态组合，动态是手段，组合才是目的  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;动态的给一个对象添加一些额外的职责。就增加功能来说，装饰模式相比生成子类更为灵活（Attach additional responsibilities to an object dynamically keeping the same interface. Decorators provide a flexible alternative to subclassing for extending functionality.）。  
#### 通用类图解释：  
**Component抽象构件：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Component是一个接口或者是抽象类，就是定义我们最核心的对象，也就是最原始的对象。  
**ConcreteComponent具体构件：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是最核心、最原始、最基本的接口或抽象类的实现，你要装饰的就是它。  
**Decorator装饰角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所有装饰器的抽象父类，需要定义一个与组件接口一致的接口，并持有一个private的Component对象，其实就是持有一个被装饰的对象。  
**ConcreteDecorator具体装饰角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实际的装饰器对象，实现具体要向被装饰对象添加的功能。  
#### 通用类图代码演示：  
Component抽象构件：
```java
public abstract class Component {
    // 抽象的方法
    public abstract void operate();
}
```
ConcreteComponent具体构件：
```java
public class ConcreteComponent extends Component {
    // 具体实现
    @Override
    public void operate() {
        System.out.println("do something");        
    }
}
```
Decorator装饰角色：
```java
public abstract class Decorator extends Component {

    private Component component = null;
    // 通过构造函数传递被修饰者
    public Decorator (Component component) {
        this.component = component;
    }
    @Override
    public void operate() {
        this.component.operate();
    }
}
```
ConcreteDecorator具体装饰角色：
```java
public class ConcreteDecorator1 extends Decorator {

    // 定义被修饰者
    public ConcreteDecorator1(Component component) {
        super(component);
    }
    // 定义自己的修饰方法
    private void method1() {
        System.out.println("method1 修饰");
    }
    // 重写父类的operate方法
    public void operate() {
        this.method1();
        super.operate();
    }
}

public class ConcreteDecorator2 extends Decorator {

    // 定义被修饰者
    public ConcreteDecorator1(Component component) {
        super(component);
    }
    // 定义自己的修饰方法
    private void method2() {
        System.out.println("method2 修饰");
    }
    // 重写父类的operate方法
    public void operate() {
        super.operate();
        this.method2();
    }
}
```
Client角色：
```java
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        // 第一次修饰
        component = new ConcreteDecorator1(component);
        // 第二次修饰
        component = new ConcreteDecorator2(component);
        // 修饰后运行
        component.operate();
    }
}
```
#### 优点：  
* 比继承更灵活  
从为对象添加功能的角度来看，装饰模式比继承更灵活。继承是静态的，而且一旦继承所有子类都有一样的功能。而装饰模式采用把功能分离到每个装饰器当中，然后通过对象组合的方式，在运行时动态地组合功能，每个被装饰地对象最终有哪些功能，是由运行期动态组合的功能来决定的。  
* 更容易复用功能  
装饰模式把一系列复杂的功能分散到每个装饰器当中，一般一个装饰器只实现一个功能，使实现装饰器变得简单，更重要的是这样有利于装饰器功能的复用，可以给一个对象增加多个同样的装饰器，也可以把一个装饰器用来装饰不同的对象，从而实现复用装饰器的功能。  
* 简化高层定义  
装饰模式可以通过组合装饰器的方式，为对象增添任意多的功能。因此在进行高层定义的时候，不用把所有的功能都定义出来，而是定义最基本的就可以了，可以在需要使用的时候，组合相应的装饰器来完成所需的功能。  
#### 缺点：  
* 会产生很多细粒度对象  
多层的装饰比较复杂，会产生很多细粒度对象，应该尽量减少装饰类的数量，以便降低系统的复杂度。  
#### 使用场景：  
1. 如果需要在不影响其他对象的情况下，以动态、透明的方式给对象添加职责，可以使用装饰模式，这几乎就是装饰模式的主要功能。  
2. 如果不适合使用子类来进行扩展的时候，可以考虑使用装饰模式。因为装饰模式是使用的“对象组合”的方式。所谓不适合用子类扩展的方式，比如，扩展功能需要的子类太多，造成子类数目呈爆炸性增长。  