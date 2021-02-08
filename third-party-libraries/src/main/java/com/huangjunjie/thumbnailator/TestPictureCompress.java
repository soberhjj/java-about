package com.huangjunjie.thumbnailator;

import org.junit.Test;

import java.io.IOException;

/**
 * @Author: huangJunJie  2021-02-08 09:32
 */
public class TestPictureCompress {
    @Test
    public void testCompressPicForScale() throws IOException {
        byte[] localImageByte = AcquireImageBytesUtils.getLocalImageByte("C:\\Users\\Administrator\\Desktop\\图片\\szx.jpg");
        byte[] netImageByte = AcquireImageBytesUtils.getNetImageByte("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa0.att.hudong.com%2F30%2F29%2F01300000201438121627296084016.jpg&refer=http%3A%2F%2Fa0.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1615340859&t=8d51f7a7ab39fe30480b49426196e854");
        //进行压缩
        byte[] bytes = PicUtils.compressPicForScale(localImageByte, 50);
        byte[] bytes1 = PicUtils.compressPicForScale(netImageByte, 5);
        AcquireImageBytesUtils.saveImageToLocal(bytes, "C:\\Users\\Administrator\\Desktop\\图片\\szx-copy.jpg");
        AcquireImageBytesUtils.saveImageToLocal(bytes1, "C:\\Users\\Administrator\\Desktop\\图片\\net.jpg");

    }
}

