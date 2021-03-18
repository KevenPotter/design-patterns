package cn.kevenpotter.designpatterns.command.command02;

public interface MainBoardApi {
    // 主板具有能开机的功能
    void open();

    // 主板具有实现重启的功能
    void reset();
}
