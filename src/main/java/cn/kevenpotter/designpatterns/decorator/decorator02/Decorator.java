package cn.kevenpotter.designpatterns.decorator.decorator02;

import java.util.Date;

public abstract class Decorator extends Component {

    private Component c;

    public Decorator(Component c) {
        this.c = c;
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        return this.c.calcPrize(user, begin, end);
    }
}
