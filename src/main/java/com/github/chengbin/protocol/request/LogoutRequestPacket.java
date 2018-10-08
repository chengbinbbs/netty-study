package com.github.chengbin.protocol.request;

import com.github.chengbin.protocol.Packet;

import static com.github.chengbin.protocol.command.Command.LOGOUT_REQUEST;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class LogoutRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}
