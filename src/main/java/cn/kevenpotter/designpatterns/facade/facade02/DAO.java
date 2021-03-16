package cn.kevenpotter.designpatterns.facade.facade02;

public class DAO {

    public void generate() {
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenDao()) {
            System.out.println("正在生成数据层代码文件");
        }
    }
}
