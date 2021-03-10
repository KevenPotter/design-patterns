package cn.kevenpotter.designpatterns.bridge.bridge02.impl.refinedAbstraction;

import cn.kevenpotter.designpatterns.bridge.bridge02.AbstractMessage;
import cn.kevenpotter.designpatterns.bridge.bridge02.MessageImplementor;

public class SpecialUrgencyMessage extends AbstractMessage {

    public SpecialUrgencyMessage(MessageImplementor implementor) {
        super(implementor);
    }

    public void hurry(String messageId) {
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "特急: " + message;
        super.sendMessage(message, toUser);
    }
}
