package com.github.chengbin.server.handler;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
@ChannelHandler.Sharable
public class IMHandler extends SimpleChannelInboundHandler<Packet> {

    public static final IMHandler INSTANCE = new IMHandler();

    private Map<Byte, SimpleChannelInboundHandler<? extends Packet>> handlerMap;

    private IMHandler(){
        handlerMap = new HashMap<>();

        handlerMap.put(Command.MESSAGE_REQUEST, MessageRequestHandler.INSTANCE);
        handlerMap.put(Command.CREATE_GROUP_REQUEST, CreateGroupRequestHandler.INSTANCE);
        handlerMap.put(Command.JOIN_GROUP_REQUEST, JoinGroupRequestHandler.INSTANCE);
        handlerMap.put(Command.QUIT_GROUP_REQUEST, QuitGroupRequestHandler.INSTANCE);
        handlerMap.put(Command.LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestHandler.INSTANCE);
        handlerMap.put(Command.GROUP_MESSAGE_REQUEST, GroupMessageRequestHandler.INSTANCE);
        handlerMap.put(Command.LOGOUT_REQUEST, LogoutRequestHandler.INSTANCE);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet packet) throws Exception {
        handlerMap.get(packet.getCommand()).channelRead(ctx,packet);

//        threadPool.submit(new Runnable() {
//            long begin = System.currentTimeMillis();
//            // 1. balabala 一些逻辑
//            // 2. 数据库或者网络等一些耗时的操作
//
//            // 3. writeAndFlush
//        xxx.writeAndFlush().addListener(future -> {
//                if (future.isDone()) {
//                    // 4. balabala 其他的逻辑
//                    long time =  System.currentTimeMillis() - begin;
//                }
//            });
//        })
    }
}
