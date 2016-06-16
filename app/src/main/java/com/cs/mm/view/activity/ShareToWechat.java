/*
package com.cs.mm.view.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cs.mm.R;
import com.cs.mm.util.WeChatUtil;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;



public class ShareToWechat extends AppCompatActivity {
    public static final String _ID="wx17f3cf35ab1a441e";
    private static final int THUMB_SIZE = 150;

    private IWXAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_to_wechat);

        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, SyncStateContract.Constants._ID, false);
        // 将该app注册到微信
        api.registerApp(SyncStateContract.Constants.APP);
    }

    */
/**
     * 分享一张图片到朋友
     *
     * @param view
     *//*

    public void testShareImage2friend(View view) {
        share2Wx(true);
    }

    */
/**
     * 分享一张图片到朋友圈
     *
     * @param view
     *//*

    public void testShareImage2friends(View view) {
        share2Wx(false);
    }

    */
/**
     * @param isShareFriend true 分享到朋友，false分享到朋友圈
     *//*

    private void share2Wx(boolean isShareFriend) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        WXImageObject imgObj = new WXImageObject(bitmap);

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bitmap, THUMB_SIZE, THUMB_SIZE, true);//缩略图大小
        bitmap.recycle();
        msg.thumbData = WeChatUtil.bmpToByteArray(thumbBmp, true);  // 设置缩略图

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("img");
        req.message = msg;
        req.scene = isShareFriend ? SendMessageToWX.Req.WXSceneSession : SendMessageToWX.Req.WXSceneTimeline;
        api.sendReq(req);
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }
}
*/
