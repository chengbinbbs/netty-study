package com.github.chengbin.server.handler;

import com.github.chengbin.protocol.response.QuitGroupResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import com.github.chengbin.protocol.request.QuitGroupRequestPacket;
import com.github.chengbin.util.SessionUtil;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
@ChannelHandler.Sharable
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket>{

    public static final QuitGroupRequestHandler INSTANCE = new QuitGroupRequestHandler();

    private QuitGroupRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket quitGroupRequestPacket) throws Exception {
        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 移除
        String groupId = quitGroupRequestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.remove(ctx.channel());

        // 2. 构造退群响应发送给客户端
        QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();
        responsePacket.setSuccess(true);
        responsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(responsePacket);
    }
}
