package cn.kevenpotter.designpatterns.facade.facade01;

import cn.kevenpotter.designpatterns.facade.facade01.impl.LetterProcessImpl;

public class ModernPostOffice {

    private ILetterProcess letterProcess = new LetterProcessImpl();

    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);
        letterProcess.letterIntoEnvelope();
        letterProcess.sendLetter();
    }

}
