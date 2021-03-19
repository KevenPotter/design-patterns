package cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02;

public class ComputerEngineer {

    private CPUApi cpu = null;
    private MainboardApi mainboard = null;

    public void makeComputer(AbstractFactory schema) {
        // 1.首先准备好装机所需要的配件
        prepareHardwares(schema);
        // 2.组装电脑
        // 3.测试电脑
        // 4.交付客户
    }

    private void prepareHardwares(AbstractFactory schema) {
        this.cpu = schema.createCPUApi();
        this.mainboard = schema.createMainboardApi();
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}
