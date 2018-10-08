package com.github.chengbin.server.handler;

import com.github.chengbin.protocol.request.ListGroupMembersRequestPacket;
import com.github.chengbin.protocol.response.ListGroupMembersResponsePacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import com.github.chengbin.session.Session;
import com.github.chengbin.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    public static final ListGroupMembersRequestHandler INSTANCE = new ListGroupMembersRequestHandler();

    private ListGroupMembersRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket listGroupMembersRequestPacket) throws Exception {

        // 1. 获取群的 ChannelGroup
        String groupId = listGroupMembersRequestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        // 2. 遍历群成员的 channel，对应的 session，构造群成员的信息
        List<Session> sessionList = new ArrayList<>();
        for (Channel channel : channelGroup) {
            Session session = SessionUtil.getSession(channel);
            sessionList.add(session);
        }

        // 3. 构建获取成员列表响应写回到客户端
        ListGroupMembersResponsePacket responsePacket = new ListGroupMembersResponsePacket();
        responsePacket.setSessionList(sessionList);
        responsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(responsePacket);

    }
}
