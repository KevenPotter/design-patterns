package cn.kevenpotter.designpatterns.facade.facade02;

public class Facade {

    public void generate() {
        new Presentation().generate();
        new Business().generate();
        new DAO().generate();
    }
}
