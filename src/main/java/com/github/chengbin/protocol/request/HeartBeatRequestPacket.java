package com.github.chengbin.protocol.request;

import com.github.chengbin.protocol.Packet;

import static com.github.chengbin.protocol.command.Command.HEARTBEAT_REQUEST;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class HeartBeatRequestPacket extends Packet{
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
