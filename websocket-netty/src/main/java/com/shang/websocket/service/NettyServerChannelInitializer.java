package com.shang.websocket.service;

import com.shang.websocket.handler.NettyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * Netty获取、发送数据及处理
 */
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        channel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8)); //获取客户端数据的编码格式
        channel.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8)); //发送给客户端数据的编码格式
        channel.pipeline().addLast(new NettyServerHandler());  //添加Netty处理类
    }
}


