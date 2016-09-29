package mrdshinse.go2web;

import mrdshinse.go2web.message.MessageReader4Console;

/**
 * 実行クラス
 *
 * @author mrdShinse
 */
public class Main {

    public static void main(String[] args) {
        new MessageReader4Console("h001.msg").read().ifPresent(System.out::println);
    }
}
