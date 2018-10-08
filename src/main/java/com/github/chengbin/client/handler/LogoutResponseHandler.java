package com.github.chengbin.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.github.chengbin.protocol.response.LogoutResponsePacket;
import com.github.chengbin.util.SessionUtil;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket logoutResponsePacket) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}
