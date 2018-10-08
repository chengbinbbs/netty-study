package com.github.chengbin.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.github.chengbin.protocol.response.QuitGroupResponsePacket;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, QuitGroupResponsePacket quitGroupResponsePacket) throws Exception {

        if(quitGroupResponsePacket.isSuccess()){
            System.out.println("退出群聊[" + quitGroupResponsePacket.getGroupId() + "]成功！");
        }else {
            System.out.println("退出群聊[" + quitGroupResponsePacket.getGroupId() + "]失败！");
        }
    }
}
