package com.github.chengbin.protocol.command;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}
