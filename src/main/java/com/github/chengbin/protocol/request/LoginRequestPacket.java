package com.github.chengbin.protocol.request;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;
import lombok.Data;

@Data
public class LoginRequestPacket extends Packet {
    private String userName;

    private String password;

    @Override
    public Byte getCommand() {

        return Command.LOGIN_REQUEST;
    }
}
