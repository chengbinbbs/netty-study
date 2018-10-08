package com.github.chengbin.server.handler;

import com.github.chengbin.protocol.request.LogoutRequestPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.github.chengbin.protocol.response.LogoutResponsePacket;
import com.github.chengbin.util.SessionUtil;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    private LogoutRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket logoutRequestPacket) throws Exception {
        SessionUtil.unBindSession(ctx.channel());

        LogoutResponsePacket responsePacket = new LogoutResponsePacket();
        responsePacket.setSuccess(true);

        ctx.channel().writeAndFlush(responsePacket);
    }
}
