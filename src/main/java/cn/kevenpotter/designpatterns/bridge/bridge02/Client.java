package cn.kevenpotter.designpatterns.bridge.bridge02;

import cn.kevenpotter.designpatterns.bridge.bridge02.impl.concreteImplementor.MessageMobile;
import cn.kevenpotter.designpatterns.bridge.bridge02.impl.concreteImplementor.MessageSMS;
import cn.kevenpotter.designpatterns.bridge.bridge02.impl.refinedAbstraction.CommonMessage;
import cn.kevenpotter.designpatterns.bridge.bridge02.impl.refinedAbstraction.SpecialUrgencyMessage;
import cn.kevenpotter.designpatterns.bridge.bridge02.impl.refinedAbstraction.UrgencyMessage;

public class Client {

    public static void main(String[] args) {
        MessageImplementor implementor = new MessageSMS();
        AbstractMessage m = new CommonMessage(implementor);
        m.sendMessage("请喝一杯茶", "小李");
        m = new UrgencyMessage(implementor);
        m.sendMessage("请喝一杯茶", "小李");
        m = new SpecialUrgencyMessage(implementor);
        m.sendMessage("请喝一杯茶", "小李");

        implementor = new MessageMobile();
        m = new CommonMessage(implementor);
        m.sendMessage("请喝一杯茶", "小李");
        m = new UrgencyMessage(implementor);
        m.sendMessage("请喝一杯茶", "小李");
        m = new SpecialUrgencyMessage(implementor);
        m.sendMessage("请喝一杯茶", "小李");
    }
}
