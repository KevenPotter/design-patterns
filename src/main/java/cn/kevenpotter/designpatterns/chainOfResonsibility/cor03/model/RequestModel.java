package cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model;

public class RequestModel {

    /*具体的业务类型*/
    private String type;

    public RequestModel(String _type) {
        this.type = _type;
    }

    public String getType() {
        return type;
    }

}
