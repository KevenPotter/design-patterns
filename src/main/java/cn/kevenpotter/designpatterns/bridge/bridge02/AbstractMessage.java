package cn.kevenpotter.designpatterns.bridge.bridge02;

public abstract class AbstractMessage {

    protected MessageImplementor implementor;

    public AbstractMessage(MessageImplementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 发送消息，转调实现部分的方法
     *
     * @param message 要发送的消息内容
     * @param toUser  消息发送的目的人员
     */
    public void sendMessage(String message, String toUser) {
        this.implementor.send(message, toUser);
    }
}
