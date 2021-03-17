package cn.kevenpotter.designpatterns.command.command02;

public class Box {

    // 开机命令对象
    private Command openCommand;

    // 设置开机命令对象
    public void setOpenCommand(Command command) {
        this.openCommand = command;
    }

    // 提供给客户使用，接收并响应用户请求，相当于按钮被按下触发的方法
    public void openButtonPressed() {
        this.openCommand.execute();
    }
}
