## 命令模式：  
>本质：封装请求  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能（Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.）。  
#### 通用类图解释：  
**Command角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义命令的接口，声明执行的方法。  
**ConcreteCommand角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;命令接口实现对象，是“虚”的实现；通常会持有接收者，并调用接收者的功能来完成命令要执行的操作。  
**Receiver角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;接收者，真正执行命令的对象。任何类都可能成为一个接收者，只要它能够实现命令要求实现的相应功能。  
**Invoker角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;要求命令对象执行请求，通常会持有命令对象，可以持有很多的命令对象。这个是客户端真正触发命令并要求命令执行相应操作的地方，也就是说相当于使用命令对象的入口。  
**Client角色：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建具体的命令对象，并且设置命令对象的接收者。注意，这个不是我们常规意义上的客户端，而是在组装命令对象和接收者，获取，把这个Client称为装配者会更好理解，因为真正使用命令的客户端是从Invoker来触发执行。  
#### 通用类图代码演示：  
Command角色：
```java
public interface Command {
    // 执行命令对应的操作
    void execute();
}
```
ConcreteCommand角色：
```java
public class ConcreteCommand implements Command {
    // 持有相应的接收者对象
    private Receiver receiver = null;
    // 示意，命令对象可以有自己的状态
    private String state;
    // 构造方法，传入相应的接收者对象
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    // 通常会转调接收者对象的相应方法，让接收者来真正执行功能
    public void execute() {
        receiver.action();
    }
}
```
Receiver角色：
```java
public class Receiver {
    // 真正执行相应命令的操作
    public void action() {
        // 真正执行命令操作的功能代码
    }
}
```
Invoker角色：
```java
public class Invoker {

    // 持有命令对象
    private Command command = null;
    //设置调用者持有的命令对象
    public void setCommand(Command command) {
        this.command = command;
    }
    // 要求命令执行请求
    public void runCommand() {
        command.execute();
    }
}
```
Client角色：
```java
public class Client {

    // 示意，负责创建命令对象，并设定它的接收者
    public void assemble() {
        Receiver receiver = new Receiver();                 // 创建接收者
        Command command = new ConcreteCommand(receiver);    // 创建命令对象，设定它的接收者
        Invoker invoker = new Invoker();                    // 创建Invoker，把命令对象设置进去
        invoker.setCommand(command);
    }
}
```
#### 优点：  
* 更松散的耦合  
命令模式使得发起命令的对象——客户端，和具体实现命令的对象——接收者对象完全解耦，也就是说发起命令的对象完全不知道具体实现对象是谁，也不知道如何实现。  
* 更动态的控制  
命令模式把请求封装起来，可以动态地对他进行参数化、队列化和日志化等操作，从而使得系统更灵活。  
* 很自然的复合命令  
命令模式中的命令对象能够很容易地组合成复合命令，也就是宏命令，从而使系统操作更简单，功能更强大。  
* 更好的扩展性  
由于发起命令的对象和具体的实现完全解耦，因此扩展新的命令就很容易，只需要实现新的命令对象，然后在装配的时候，把具体的实现对象设置到命令对象中，然后就可以使用这个命令对象，已有的实现完全不用变化。  
#### 缺点：  
* 命令繁多将会导致子类繁多  
如果有N个命令，Command的子类就是N个，类将会膨胀的非常大。  
#### 使用场景：  
1. 如果需要抽象出需要执行的动作，并参数化这些对象，可以选用命令模式。将这些需要执行的动作抽象称为命令，然后实现命令的参数化配置。  
2. 如果需要在不同的时刻指定、排列和执行请求，可以选用命令模式。将这些请求封装称为命令对象，然后实现将请求队列化。  
3. 如果需要支持取消操作，可以选用命令模式，通过管理命令对象，能很容易地实现命令的恢复和重做功能。  
4. 如果需要支持当系统崩溃时，能将系统的操作功能重新执行一遍，可以选用命令模式。将这些操作功能的请求封装成命令对象，然后实现日志命令，就可以在系统恢复以后，通过日志获取命令列表，从而重新执行一遍功能。  
5. 在需要事务的系统中，可以选用命令模式。命令模式提供了对事务进行建模的方法。命令模式有一个别名就是Transaction。  