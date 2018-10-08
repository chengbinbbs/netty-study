package com.github.chengbin.server.handler;

import com.github.chengbin.protocol.request.HeartBeatRequestPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.github.chengbin.protocol.response.HeartBeatResponsePacket;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
@ChannelHandler.Sharable
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

    public static final HeartBeatRequestHandler INSTANCE = new HeartBeatRequestHandler();

    private HeartBeatRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatRequestPacket heartBeatRequestPacket) throws Exception {
        ctx.writeAndFlush(new HeartBeatResponsePacket());
    }
}
