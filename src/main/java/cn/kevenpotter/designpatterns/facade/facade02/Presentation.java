package cn.kevenpotter.designpatterns.facade.facade02;

public class Presentation {

    public void generate() {
        ConfigModel cm = ConfigManager.getInstance().getConfigData();   // 1.从配置管理里面获取相应的配置信息
        if (cm.isNeedGenPresentation()) {
            System.out.println("正在生成表现层代码文件");                   // 2.按照要求去生成相应的代码，并保存成文件
        }
    }
}
