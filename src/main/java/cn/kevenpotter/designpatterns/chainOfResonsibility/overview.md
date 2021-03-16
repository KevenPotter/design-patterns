## 责任链模式：  
>本质：分离职责，动态组合  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止（Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the reveiving objects and pass the request along the chain until an object handles it.）。  
#### 通用类图解释：  
**Handler角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义职责的接口，通常在这里定义处理请求的方法，可以在这里实现后继链。  
**ConcreteHandler角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实现职责的类，在这个类中，实现对在它职责范围内请求的处理，如果不处理，就继续转发请求给后继者。  
**Client角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;职责链的客户端，向链上的具体处理对象提交请求，让职责链负责处理。  
#### 通用类图代码演示：  
Handler角色：
```java
public abstract class Handler {
    // 持有后继的职责对象
    protected Handler successor;
    // 设置后继的职责对象
    public void setSuccessor(Handler successor){
        this.successor = successor;
    }
    /**
     * 示意处理请求的方法，虽然这个示意方法是没有传入参数的，
     * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
     */
    public abstract void handlerRequest();
}
```
ConcreteHandler角色：
```java
public class ConcreteHandler1 extends Handler {
    @Override
    public void handlerRequest() {
        /*
         * 根据某些条件来判断是否属于自己处理的职责范围，
         * 判断条件比如，从外部传入的参数，或者这里主动去获取的外部数据，
         * 如从数据库中获取等，下面这句话只是个示意
         */
        boolean someCondition = false;
        if (someCondition){
            // 如果属于自己处理的职责范围，就在这里处理请求
            System.out.println("ConcreteHandler1 handle request");
        } else {
            if (this.successor != null){
                this.successor.handlerRequest();
            }
        }
    }
}

public class ConcreteHandler2 extends Handler {
    @Override
    public void handlerRequest() {
        /*
         * 根据某些条件来判断是否属于自己处理的职责范围，
         * 判断条件比如，从外部传入的参数，或者这里主动去获取的外部数据，
         * 如从数据库中获取等，下面这句话只是个示意
         */
        boolean someCondition = false;
        if (someCondition){
            // 如果属于自己处理的职责范围，就在这里处理请求
            System.out.println("ConcreteHandler2 handle request");
        } else {
            if (this.successor != null){
                this.successor.handlerRequest();
            }
        }
    }
}
```
Client角色：
```java
public class Client {
    public static void main(String[] args) {
        // 先要组装职责链
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.setSuccessor(h2);
        h1.handleRequest();
    }
}
```
#### 优点：  
* 请求者和接收者松散耦合  
在职责链模式中，请求者并不知道接收者是谁，也不知道具体如何处理，请求者只是负责向职责链发出请求就可以了。而每个职责对象也不用管请求者或者是其他的职责对象，只负责处理自己的部分，其他的就交给其他的职责对象去处理。也就是说，请求者和接收者是完全解耦的。  
* 动态组合职责  
职责链模式会把功能处理分散到单独的职责对象中，然后在使用的时候，可以动态组合职责形成职责链，从而可以灵活地给对象分配职责，也可以灵活地实现和改变对象的职责。  
#### 缺点：  
* 会产生很多细粒度对象  
职责链模式会把功能处理分散到单独的职责对象中，也就是每个职责对象只处理一个方面的功能，要把整个业务处理完，需要很多职责对象的组合，这样会产生大量的细粒度职责对象。  
* 不一定能被处理  
职责链模式的每个职责对象只负责自己处理的那一部分，因此可能会出现某个请求，把整个链传递完了，都没有职责对象处理它。这就需要在使用职责链模式的时候，需要提供默认的处理，并且注意构建的链的有效性。  
#### 使用场景：  
1. 如果有多个对象可以处理同一个请求，但是具体由哪个对象来处理该请求，是运行时刻动态确定的。这种情况可以使用职责链模式，把处理请求的对象实现成为职责对象，然后把它们构件成一个职责链，当请求在这个链中传递的时候，具体由哪个职责对象来处理，会在运行时动态判断。  
2. 如果你想在不明确指定接收者的情况下，向多个对象中的其中一个提交请求的话，可以使用职责链模式。职责链模式实现了请求者和接收者之间的解耦，请求者不需要知道究竟是哪一个接收者对象来处理了请求。  
3. 如果想要动态指定处理一个请求的对象集合，可以使用职责链模式。职责链模式能动态地构建职责链，也就是动态地来决定到底哪些职责对象来参与到处理请求中来，相当于是动态地指定了处理一个请求的职责对象集合。  