package com.cs.mm.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by exbbefl on 6/12/2016.
 */
public class ImageUtil {
    public static Uri saveImage(Context context, String url, Bitmap bitmap, ImageView imageView, String tag){
        //妹纸保存路径
        String imgDir = Environment.getExternalStorageDirectory().getPath() + "/M2M";
        //图片名称处理
        String[] fileNameArr = url.substring(url.lastIndexOf("/") + 1).split("\\.");
        String fileName = fileNameArr[0] + ".png";
        //创建文件路径
        File fileDir = new File(imgDir);
        if (!fileDir.exists()){
            fileDir.mkdir();
        }
        //创建文件
        File imageFile = new File(fileDir,fileName);
        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            if (tag.equals("save")){
                if (compress){
                    Snackbar.make(imageView,"妹纸已经在相册等你了... ",Snackbar.LENGTH_SHORT).show();
                }else {
                    Snackbar.make(imageView,"妹纸残忍地拒绝了你的请求... ",Snackbar.LENGTH_SHORT).show();
                }
            }else{
                if (!compress){
                    Snackbar.make(imageView,"妹纸拒绝了你的请求... ",Snackbar.LENGTH_SHORT).show();
                }
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Uri uri = Uri.fromFile(imageFile);
        //发送广播，通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,uri));
        return uri;
    }
}