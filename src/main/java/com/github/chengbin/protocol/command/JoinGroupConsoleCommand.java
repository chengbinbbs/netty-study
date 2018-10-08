package com.github.chengbin.protocol.command;

import com.github.chengbin.protocol.request.JoinGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class JoinGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {

        JoinGroupRequestPacket requestPacket = new JoinGroupRequestPacket();
        System.out.println("输入 groupId，加入群聊：");

        String groupId = scanner.next();
        requestPacket.setGroupId(groupId);

        channel.writeAndFlush(requestPacket);
    }
}
