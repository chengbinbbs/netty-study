package com.github.chengbin.protocol.response;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;
import lombok.Data;

@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String userName;

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
