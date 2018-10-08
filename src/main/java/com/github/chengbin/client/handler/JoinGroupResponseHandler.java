package com.github.chengbin.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.github.chengbin.protocol.response.JoinGroupResponsePacket;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, JoinGroupResponsePacket responsePacket) throws Exception {
        if (responsePacket.isSuccess()) {
            System.out.println("加入群[" + responsePacket.getGroupId() + "]成功!");
        } else {
            System.err.println("加入群[" + responsePacket.getGroupId() + "]失败，原因为：" + responsePacket.getReason());
        }
    }
}
