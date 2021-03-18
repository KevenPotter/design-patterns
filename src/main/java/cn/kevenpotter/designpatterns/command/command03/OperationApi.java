package cn.kevenpotter.designpatterns.command.command03;

public interface OperationApi {

    // 获取计算完成后的结果
    int getResult();

    // 设置计算开始的初始值
    void setResult(int result);

    // 执行加法
    void add(int num);

    // 执行减法
    void sub(int num);
}
