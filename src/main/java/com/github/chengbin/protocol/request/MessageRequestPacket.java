package com.github.chengbin.protocol.request;

import com.github.chengbin.protocol.command.Command;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.github.chengbin.protocol.Packet;

@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
