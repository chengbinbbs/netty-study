package com.github.chengbin.protocol.command;

import com.github.chengbin.protocol.request.GroupMessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class SendToGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {

        GroupMessageRequestPacket requestPacket = new GroupMessageRequestPacket();

        System.out.print("发送消息给某个某个群组：");
        String groupId = scanner.next();
        String message = scanner.next();

        requestPacket.setGroupId(groupId);
        requestPacket.setMessage(message);

        channel.writeAndFlush(requestPacket);
    }
}
