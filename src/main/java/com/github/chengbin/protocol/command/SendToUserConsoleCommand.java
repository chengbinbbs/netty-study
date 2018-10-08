package com.github.chengbin.protocol.command;

import io.netty.channel.Channel;
import com.github.chengbin.protocol.request.MessageRequestPacket;

import java.util.Scanner;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class SendToUserConsoleCommand implements ConsoleCommand {


    @Override
    public void exec(Scanner scanner, Channel channel) {

        System.out.print("发送消息给某个用户:");

        String toUserId = scanner.next();
        String message = scanner.next();
        MessageRequestPacket requestPacket = new MessageRequestPacket(toUserId,message);
        channel.writeAndFlush(requestPacket);
    }
}
