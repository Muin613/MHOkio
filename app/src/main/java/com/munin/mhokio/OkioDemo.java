package com.munin.mhokio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

/**
 * Created by munin on 2018/2/23.
 */

public class OkioDemo {


    public static void write(File file) throws Exception {
        Sink sink = Okio.sink(file);
        BufferedSink bufferedSink = Okio.buffer(sink);
        bufferedSink.writeString("123456Munin613", Charset.forName("UTF-8"));
        bufferedSink.flush();
        bufferedSink.close();
        sink.close();
    }

    public static void read(File file) throws Exception {
        Source source = Okio.source(file);
        BufferedSource bufferedSource = Okio.buffer(source);
        String result = bufferedSource.readString(Charset.forName("UTF-8"));
        System.out.println(result);
        bufferedSource.close();
        source.close();
    }


    public static void read1(File file, File file1) throws Exception {
        Sink sink = Okio.sink(file1);
        long totalL=0;


        totalL=file.length();
        System.out.println(totalL);
        final long finalTotalL = totalL;
        ForwardingSink forwardingSink = new ForwardingSink(sink) {
            long dataL = 0l;
            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                dataL += byteCount;
                System.out.println(dataL+"   "+ finalTotalL);
            }
        };
        BufferedSink bufferedSink=Okio.buffer(forwardingSink);


        Source source = Okio.source(file);
        BufferedSource bufferedSource = Okio.buffer(source);
        bufferedSink.writeAll(source);
        bufferedSink.flush();
        String result = bufferedSource.readString(Charset.forName("UTF-8"));
        System.out.println(result);
        bufferedSource.close();
        source.close();
        bufferedSink.close();
        sink.close();

    }
}
