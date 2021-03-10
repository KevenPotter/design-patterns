package cn.kevenpotter.designpatterns.bridge.bridge02.impl.refinedAbstraction;

import cn.kevenpotter.designpatterns.bridge.bridge02.AbstractMessage;
import cn.kevenpotter.designpatterns.bridge.bridge02.MessageImplementor;

public class UrgencyMessage extends AbstractMessage {

    public UrgencyMessage(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急: " + message;
        super.sendMessage(message, toUser);
    }

    /**
     * 扩展自己的新功能: 监控某消息的处理过程
     *
     * @param messageId 被监控的消息的编号
     * @return 包含监控到的数据对象, 这里示意一下, 所以用了Object
     */
    public Object watch(String messageId) {
        return null;
    }
}
