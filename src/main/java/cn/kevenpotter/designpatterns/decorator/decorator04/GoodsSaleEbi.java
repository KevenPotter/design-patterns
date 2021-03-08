package cn.kevenpotter.designpatterns.decorator.decorator04;

import cn.kevenpotter.designpatterns.decorator.decorator04.domain.SaleModel;

public interface GoodsSaleEbi {

    /**
     * 保存销售信息，本来销售数据应该是多条，太麻烦了，为了演示，简单点儿
     *
     * @param user      操作人员
     * @param customer  客户
     * @param saleModel 销售数据
     * @return 是否保存成功
     */
    public boolean sale(String user, String customer, SaleModel saleModel);
}
