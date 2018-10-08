package com.github.chengbin.server.handler;

import com.github.chengbin.protocol.request.JoinGroupRequestPacket;
import com.github.chengbin.protocol.response.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import com.github.chengbin.util.SessionUtil;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
@ChannelHandler.Sharable
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {

    public static final JoinGroupRequestHandler INSTANCE = new JoinGroupRequestHandler();

    private JoinGroupRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket joinGroupRequestPacket) throws Exception {

        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 添加进去
        String groupId = joinGroupRequestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.add(ctx.channel());

        // 2. 构造加群响应发送给客户端
        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();
        responsePacket.setSuccess(true);
        responsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(responsePacket);

    }
}
