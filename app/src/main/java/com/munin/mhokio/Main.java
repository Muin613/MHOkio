package com.munin.mhokio;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/**
 * Created by munin on 2018/2/23.
 * 说白了装饰模式，单链，共享，压缩 原型模式
 */

public class Main {
    static String srcFileName = "C://Users//munin//Desktop//munin613.txt";//excel的原路径(根据实际修改)
    static String dirFileName = "C://Users//munin//Desktop//munin6131.txt";//excel的原路径(根据实际修改)
    public static void main(String[] args) {
        File file=new File(srcFileName);
        File file1=new File(dirFileName);
        try {
            OkioDemo.read1(file,file1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(8080);
//            while (true) {
//                Socket socket = serverSocket.accept();
//                handleClientSocket(socket);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (serverSocket != null) {
//                try {
//                    serverSocket.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    private static void handleClientSocket(final Socket socket) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true) {
//                        BufferedSource source = Okio.buffer(Okio.source(socket));
//                        BufferedSink sink = Okio.buffer(Okio.sink(socket));
//                        int length = source.readInt();
//                        String message = source.readString(length, Charset.forName("utf-8"));
//                        System.out.println("length is: " + length + " , message is : " + message);
//                        if("error exit".equals(message)){
//                            break;
//                        }
//                        String responseMsg = getResponseAccordMsg(message);
//                        if (responseMsg != null) {
//                            int respLength = responseMsg.getBytes().length;
//                            sink.writeInt(respLength);
//                            sink.writeString(responseMsg, Charset.forName("utf-8"));
//                            sink.flush();
//                        }
//                        if("error exit".equals(responseMsg)){
//                            break;
//                        }
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }finally {
//                    if(socket!=null){
//                        try {
//                            socket.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//
//            }
//        });
//        thread.start();
//    }
//
//    private static String getResponseAccordMsg(String msg) {
//        String result = "";
//        if (msg != null && msg.length() > 0) {
//            if (msg.equals("hello")) {
//                result = "hello";
//            } else if (msg.equals("nice to meet you")) {
//                result = "nice to meet you too";
//            } else if (msg.equals("see you")) {
//                result = "see you next time";
//            }
//        }
//        if (result.length() == 0) {
//            result = "error exit";
//        }
//        return result;
//    }
}
