package cn.kevenpotter.designpatterns.command.command03.command;

import cn.kevenpotter.designpatterns.command.command03.Command;
import cn.kevenpotter.designpatterns.command.command03.OperationApi;

public class AddCommand implements Command {

    // 持有具体执行计算的对象
    private OperationApi operationApi = null;
    // 操作的数据，也就是要加上的数据
    private int opeNum;

    public AddCommand(OperationApi operationApi, int opeNum) {
        this.operationApi = operationApi;
        this.opeNum = opeNum;
    }

    @Override
    public void execute() {
        this.operationApi.add(opeNum);
    }

    @Override
    public void undo() {
        this.operationApi.sub(opeNum);
    }
}
