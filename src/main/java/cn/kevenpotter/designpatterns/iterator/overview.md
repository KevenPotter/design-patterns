## 迭代器模式：  
>本质：控制访问聚合对象中的元素  
#### 概念：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提供一种方法访问一个容器对象中各个元素，而又不需要暴露该对象的内部细节（Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.）。    
#### 通用类图解释：  
**Iterator抽象迭代器：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抽象迭代器负责定义访问和遍历元素的接口，而且基本上是有固定的3个方法：`first()`获得第一个元素，`next()`访问下一个元素，`isDone()`是否已经访问到底部（Java叫做`hasNest()`方法）。  
**ConcreteIterator具体迭代器：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;具体迭代器角色要实现迭代器接口，完成容器元素的遍历。  
**Aggregate抽象容器：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容器角色负责提供创建具体迭代器角色的接口，必然提供一个类似`createIterator()`这样的方法，在Java中一般是`iterator()`方法。  
**ConcreteAggregate具体容器：**  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;具体容器实现容器接口定义的方法，创建出容纳迭代器的对象。  
#### 通用类图代码演示：  
抽象迭代器：
```java
public interface Iterator {
    // 遍历到下一个元素
    Object next();
    // 是否已经遍历到尾部
    boolean hasNext();
    // 删除当前指向的元素
    boolean remove();
}
```
具体迭代器：
```java
public class ConcreteIterator implements Iterator {
    private Vector vector = new Vector();
    // 定义当前游标
    public int cursor = 0;
    @SuppressWarnings("unchecked")
    public ConcreteIterator(Vector vector) {
        this.vector = vector;
    }

    // 判断是否到达尾部
    public boolean hasNext() {
        if (this.cursor == this.vector.size()){
            return false;
        }else {
            return true;
        }
    }

    // 返回下一个元素
    public Object next() {
        Object result = null;
        if (this.hasNext()){
            result = this.vector.get(this.cursor++);
        }else {
            result = null;
        }
        return result;
    }

    // 删除当前元素
    public boolean remove() {
        this.vector.remove(this.cursor);
        return true;
    }
}
```
抽象容器：
```java
public interface Aggregate() {
    // 是容器必然有元素的增加
    void add(Object object);
    // 减少元素
    void remove(Object object);
    // 由迭代器来遍历所有的元素
    Iterator iterator();
}
```
具体容器：
```java
public class ConcreteAggregate implements Aggregate {
    // 容纳对象的容器
    private Vector vector  = new Vector();
    // 增加一个元素
    public void add(Object object) {
        this.vector.add(object);
    }
    // 返回迭代器对象
    public Iterator iterator() {
        return new ConcreteAggregate(this.vector);
    }
    // 删除一个元素
    public void remove(Object object) {
        this.remove(object);
    }
}
```
场景类：
```java
public class Client {
    public static void main(String[] args) {
        // 声明出容器
        Aggregate agg = new ConcreteAggregate();
        // 产生对象数据放进去
        agg.add("abc");
        agg.add("aaa");
        agg.add("1234");
        // 遍历一下
        Iterator iterator = agg.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
```
#### 优点：
* 更好的封装性。  
* 迭代器模式可以让你访问一个聚合对象的内容，而无须暴露该聚合对象的内部表示，从而提高聚合对象的封装性。  
* 可以以不同的遍历方式来遍历一个聚合。  
* 使用迭代器模式，使得聚合对象的内容和具体的迭代算法分离开。这样就可以通过使用不同的迭代器的实例、不同的遍历方式来遍历一个聚合对象了。  
* 迭代器简化了聚合的接口。  
* 有了迭代器的接口，则聚合本身就不需要再定义这些接口了，从而简化了聚合的接口定义。  
* 简化客户端调用  
* 迭代器为遍历不同的聚合对象提供了一个统一的接口，使得客户端遍历聚合对象的内容变得更简单。  
* 同一个聚合上可以有多个遍历。  
* 每个迭代器保持它自己的遍历状态。  
#### 使用场景：  
1. 如果你希望提供访问一个聚合对象的内容，但是又不想暴露它的内部表示的时候，可以使用迭代器模式来提供迭代器接口，从而让客户端只是通过迭代器的接口来访问聚合对象，而无需关心聚合对象的内部实现。  
2. 如果你希望有多种遍历方式可以访问聚合对象，可以使用迭代器模式。  
3. 如果你希望为遍历不同的聚合对象提供一个统一的接口，可以使用迭代器模式。  