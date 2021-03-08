package cn.kevenpotter.designpatterns.decorator.decorator03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream2 extends FilterOutputStream {

    public EncryptOutputStream2(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        b = b + 2;
        if (b >= (97 + 26)) {
            b = b - 26;     // 如果大于,表示已经是y或者z了，减去26就回到a或者b了
        }
        super.write(b);
    }
}
