package com.github.chengbin.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.PacketCodeC;

import java.util.List;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf,Packet> {

    public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

    private PacketCodecHandler(){

    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, List<Object> out) throws Exception {
        ByteBuf byteBuf = ctx.channel().alloc().ioBuffer();
        PacketCodeC.INSTANCE.encode(byteBuf, packet);
        out.add(byteBuf);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        out.add(PacketCodeC.INSTANCE.decode(byteBuf));
    }
}
