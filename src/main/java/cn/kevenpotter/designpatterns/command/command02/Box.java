package cn.kevenpotter.designpatterns.command.command02;

public class Box {

    // 开机命令对象
    private Command openCommand;
    // 重启命令对象
    private Command resetCommand;

    // 设置开机命令对象
    public void setOpenCommand(Command command) {
        this.openCommand = command;
    }

    // 设置重启命令对象
    public void setResetCommand(Command resetCommand) {
        this.resetCommand = resetCommand;
    }

    // 提供给客户使用，接收并响应用户请求，相当于按钮被按下触发的方法
    public void openButtonPressed() {
        this.openCommand.execute();
    }

    // 提供给客户使用，接收并响应用户请求，相当于重启按钮被按下触发的方法
    public void resetButtonPressed() {
        this.resetCommand.execute();
    }
}
