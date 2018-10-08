package com.github.chengbin.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.github.chengbin.protocol.response.ListGroupMembersResponsePacket;
import com.github.chengbin.session.Session;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListGroupMembersResponsePacket listGroupMembersResponsePacket) throws Exception {

        System.out.print("群[" + listGroupMembersResponsePacket.getGroupId() + "]中的人包括：");
        for (Session session : listGroupMembersResponsePacket.getSessionList()) {
            System.out.print(session.getUserName() + " ");
        }
    }
}
