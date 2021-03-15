package cn.kevenpotter.designpatterns.facade.facade01;

public class Client {

    public static void main(String[] args) {
        ModernPostOffice modernPostOffice = new ModernPostOffice();
        String context = "Haa";
        String address = "Happy Road No. 666, God Province,Heaven";
        modernPostOffice.sendLetter(context, address);
    }
}
