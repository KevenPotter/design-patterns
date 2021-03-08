package cn.kevenpotter.designpatterns.decorator.decorator03;

import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream1 extends OutputStream {

    private OutputStream os = null;

    public EncryptOutputStream1(OutputStream os) {
        this.os = os;
    }

    @Override
    public void write(int b) throws IOException {
        b = b + 2;
        if (b >= (97 + 26)) {
            b = b - 26;     // 如果大于,表示已经是y或者z了，减去26就回到a或者b了
        }
        this.os.write(b);
    }
}
