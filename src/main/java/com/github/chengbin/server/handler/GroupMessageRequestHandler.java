package com.github.chengbin.server.handler;

import com.github.chengbin.protocol.request.GroupMessageRequestPacket;
import com.github.chengbin.protocol.response.GroupMessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import com.github.chengbin.util.SessionUtil;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
@ChannelHandler.Sharable
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {

    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    private GroupMessageRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket groupMessageRequestPacket) throws Exception {
        // 1.拿到 groupId 构造群聊消息的响应
        String groupId = groupMessageRequestPacket.getGroupId();

        GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();
        responsePacket.setGroupId(groupId);
        responsePacket.setMessage(groupMessageRequestPacket.getMessage());
        responsePacket.setFromUser(SessionUtil.getSession(ctx.channel()).getUserName());

        // 2. 拿到群聊对应的 channelGroup，写到每个客户端
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.writeAndFlush(responsePacket);
    }
}
