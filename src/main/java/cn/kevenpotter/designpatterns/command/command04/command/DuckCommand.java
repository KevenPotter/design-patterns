package cn.kevenpotter.designpatterns.command.command04.command;

import cn.kevenpotter.designpatterns.command.command04.Command;
import cn.kevenpotter.designpatterns.command.command04.CookApi;

public class DuckCommand implements Command {

    private int tableNum;

    public DuckCommand(int tableNum) {
        this.tableNum = tableNum;
    }

    private CookApi cookApi = null;

    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    @Override
    public int getTableNum() {
        return tableNum;
    }

    @Override
    public void execute() {
        this.cookApi.cook(tableNum, "北京烤鸭");
    }
}
