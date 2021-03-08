package cn.kevenpotter.designpatterns.decorator;

/**
 * 概念：动态的给一个对象添加一些额外的职责。就增加功能来说，装饰模式相比生成子类更为灵活。
 * <p>
 * 优点：
 * 1.装饰类与被装饰类可以独立发展，而不会相互耦合。换句话说，Component类无须知道Decorator类，Decorator类是从外部来扩展Component类的功能，而Decorator也不用知道具体的构件
 * 2.装饰模式是继承关系的一个替代方案。我们看装饰类Decorator不管装饰多少层，返回的对象还是Component，实现的还是is-a的关系
 * 3.装饰模式可以动态地扩展一个实现类的功能，这不需要多说，装饰模式的定义就是如此
 * 缺点：
 * 1.多层的装饰比较复杂，会产生很多细粒度对象，应该尽量减少装饰类的数量，以便降低系统的复杂度
 * <p>
 * 装饰模式的本质：动态组合，动态是手段，组合才是目的
 */
public class Overview {
}
