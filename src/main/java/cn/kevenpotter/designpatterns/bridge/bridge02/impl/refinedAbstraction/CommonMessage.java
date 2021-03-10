package cn.kevenpotter.designpatterns.bridge.bridge02.impl.refinedAbstraction;

import cn.kevenpotter.designpatterns.bridge.bridge02.AbstractMessage;
import cn.kevenpotter.designpatterns.bridge.bridge02.MessageImplementor;

public class CommonMessage extends AbstractMessage {

    public CommonMessage(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        // 对于普通消息，什么都不干，直接调用父类的方法，把消息发送出去就可以了
        super.sendMessage(message, toUser);
    }
}
