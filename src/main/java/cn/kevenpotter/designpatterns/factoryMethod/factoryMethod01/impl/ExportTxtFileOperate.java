package cn.kevenpotter.designpatterns.factoryMethod.factoryMethod01.impl;

import cn.kevenpotter.designpatterns.factoryMethod.factoryMethod01.ExportFileApi;
import cn.kevenpotter.designpatterns.factoryMethod.factoryMethod01.ExportOperate;

public class ExportTxtFileOperate extends ExportOperate {

    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportTxtFile();
    }
}
