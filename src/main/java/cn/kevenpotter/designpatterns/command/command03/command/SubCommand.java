package cn.kevenpotter.designpatterns.command.command03.command;

import cn.kevenpotter.designpatterns.command.command03.Command;
import cn.kevenpotter.designpatterns.command.command03.OperationApi;

public class SubCommand implements Command {

    private OperationApi operationApi = null;
    private int opeNum;

    public SubCommand(OperationApi operationApi, int opeNum) {
        this.operationApi = operationApi;
        this.opeNum = opeNum;
    }

    @Override
    public void execute() {
        this.operationApi.sub(opeNum);
    }

    @Override
    public void undo() {
        this.operationApi.add(opeNum);
    }
}
