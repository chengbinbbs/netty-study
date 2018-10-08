package com.github.chengbin.client.handler;

import com.github.chengbin.protocol.response.GroupMessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GroupMessageResponsePacket groupMessageResponsePacket) throws Exception {
        String fromUser = groupMessageResponsePacket.getFromUser();
        String groupId = groupMessageResponsePacket.getGroupId();
        String message = groupMessageResponsePacket.getMessage();
        System.out.println("收到群[" + groupId + "]中[" + fromUser + "]发来的消息：" + message);
    }
}
