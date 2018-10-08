package com.github.chengbin.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import com.github.chengbin.protocol.request.CreateGroupRequestPacket;
import com.github.chengbin.protocol.response.CreateGroupResponsePacket;
import com.github.chengbin.util.IDUtil;
import com.github.chengbin.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
@ChannelHandler.Sharable
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    public static final CreateGroupRequestHandler INSTANCE = new CreateGroupRequestHandler();

    private CreateGroupRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) throws Exception {

        List<String> userIds = createGroupRequestPacket.getUserIds();
        List<String> usernames = new ArrayList<>();

        // 1. 创建一个 channel 分组
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());

        // 2. 筛选出待加入群聊的用户的 channel 和 userName
        for (String userId : userIds) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                usernames.add(SessionUtil.getSession(channel).getUserName());
            }
        }

        // 3. 创建群聊创建结果的响应
        CreateGroupResponsePacket responsePacket = new CreateGroupResponsePacket();
        responsePacket.setSuccess(true);
        responsePacket.setGroupId(IDUtil.randomId());
        responsePacket.setUsernames(usernames);

        // 4. 给每个客户端发送拉群通知
        channelGroup.writeAndFlush(responsePacket);
        System.out.print("群创建成功，id 为[" + responsePacket.getGroupId() + "], ");
        System.out.println("群里面有：" + responsePacket.getUsernames());

        // 5. 保存群组相关的信息
        SessionUtil.bindChannelGroup(responsePacket.getGroupId(), channelGroup);
    }
}
