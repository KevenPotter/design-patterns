package cn.kevenpotter.designpatterns.decorator.decorator03;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new EncryptOutputStream1(new FileOutputStream("MyEncrypt.txt"))));
        dout.write("abcdxyz".getBytes());
        dout.close();
    }
}
