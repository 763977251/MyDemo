package com.shang.websocket.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: qingcheng
 * @author: XIONG CHUAN
 * @create: 2019-04-28 19:37
 * @description: 客户端处理类
 **/

@Slf4j
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 计算有多少客户端接入，第一个string为客户端ip
     */
    private static final ConcurrentHashMap<ChannelId, ChannelHandlerContext> CLIENT_MAP = new ConcurrentHashMap<>();

    /** 客户端请求的心跳命令 */
    private static final ByteBuf HEARTBEAT_SEQUENCE =
            Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("heartbeat", CharsetUtil.UTF_8));

    @Override
    public void channelActive(ChannelHandlerContext ctx) {

        CLIENT_MAP.put(ctx.channel().id(), ctx);

        log.info("ClientHandler Active");
    }

    /**
     * @param ctx
     * @author xiongchuan on 2019/4/28 16:10
     * @DESCRIPTION: 有服务端端终止连接服务器会触发此函数
     * @return: void
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {

        ctx.close();
        log.info("服务端终止了服务");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("回写数据:" + msg);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

        //cause.printStackTrace();
        log.info("服务端发生异常【" + cause.getMessage() + "】");
        ctx.close();
    }

    /**
     * @param msg       需要发送的消息内容
     * @param channelId 连接通道唯一id
     * @author xiongchuan on 2019/4/28 16:10
     * @DESCRIPTION: 客户端给服务端发送消息
     * @return: void
     */
    public void channelWrite(ChannelId channelId, String msg) {

        ChannelHandlerContext ctx = CLIENT_MAP.get(channelId);

        if (ctx == null) {
            log.info("通道【" + channelId + "】不存在");
            return;
        }

        //将客户端的信息直接返回写入ctx
        ctx.write(msg + " 时间：" + new Date());
        //刷新缓存区
        ctx.flush();
    }

    /**
     * 如果4s没有收到写请求，则向服务端发送心跳请求
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if(IdleState.WRITER_IDLE.equals(event.state())) {
                ctx.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE) ;
            }
        }
        super.userEventTriggered(ctx, evt);
    }
}
