package com.github.chengbin.protocol.response;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }
}
