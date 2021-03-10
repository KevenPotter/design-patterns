package cn.kevenpotter.designpatterns.bridge.bridge02.impl.concreteImplementor;

import cn.kevenpotter.designpatterns.bridge.bridge02.MessageImplementor;

public class MessageSMS implements MessageImplementor {

    @Override
    public void send(String message, String toUser) {
        System.out.println("使用站内短消息的方式, 发送消息: " + message + "给" + toUser);
    }
}
