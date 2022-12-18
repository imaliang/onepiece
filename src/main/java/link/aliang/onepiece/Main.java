package link.aliang.onepiece;

import link.aliang.onepiece.html.OnePieceGenerator;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Description: 主函数
 * @Author: aliang
 * @Date: 2022-12-18 14:11
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        log.info("----------------------开始生成----------------------");
        OnePieceGenerator.generatorAll();
        log.info("----------------------生成成功----------------------");
    }
}
