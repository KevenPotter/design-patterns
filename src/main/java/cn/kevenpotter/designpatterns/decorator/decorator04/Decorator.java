package cn.kevenpotter.designpatterns.decorator.decorator04;

public abstract class Decorator implements GoodsSaleEbi {

    protected GoodsSaleEbi ebi;

    public Decorator(GoodsSaleEbi ebi) {
        this.ebi = ebi;
    }
}
