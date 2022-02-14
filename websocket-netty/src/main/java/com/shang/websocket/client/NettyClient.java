package com.shang.websocket.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @program: qingcheng
 * @author: XIONG CHUAN
 * @create: 2019-04-28 19:42
 * @description: 客户端
 **/

@Slf4j
@Data
public class NettyClient implements Runnable {

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "9010"));
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

    private String content;

    public NettyClient(String content) {
        this.content = content;
    }

    @Override
    public void run() {
        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {

            int num = 0;
            boolean boo =true;

            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new NettyClientChannelInitializer());

            ChannelFuture future = b.connect(HOST, PORT).sync();

            while (boo) {

                num++;

                future.channel().writeAndFlush(content + "--" + new Date().getTime());

                try { //休眠一段时间
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //每一条线程向服务端发送的次数
                if (num == 3) {
                    boo = false;
                }
            }

            log.info(content + "-----------------------------" + num);
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

}
