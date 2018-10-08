package com.github.chengbin.protocol.response;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;
import lombok.Data;

@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return Command.MESSAGE_RESPONSE;
    }
}
