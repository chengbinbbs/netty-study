package com.github.chengbin.protocol.command;

import com.github.chengbin.protocol.request.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {

        LoginRequestPacket requestPacket = new LoginRequestPacket();

        System.out.println("请输入用户名登录:");

        String username = scanner.next();
        requestPacket.setUserName(username);
        requestPacket.setPassword("admin");

        // 发送登录数据包
        channel.writeAndFlush(requestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
