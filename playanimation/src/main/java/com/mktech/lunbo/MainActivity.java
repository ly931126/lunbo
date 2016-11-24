package com.mktech.lunbo;

import java.util.ArrayList;

import com.jorge.circlelibrary.ImageCycleView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageCycleView mCycleView;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        /** 找到轮播控件*/
        mCycleView = (ImageCycleView) findViewById(R.id.cycleView);

        mCycleView.setCycle_T(ImageCycleView.CYCLE_T.CYCLE_VIEW_NORMAL);
        /**装在数据的集合  文字描述*/
        ArrayList<String> imageDescList = new ArrayList<>();
        /**装在数据的集合  图片地址*/
        ArrayList<String> urlList = new ArrayList<>();

        /**添加数据*/
        urlList.add("http://attach.bbs.miui.com/forum/month_1012/101203122706c89249c8f58fcc.jpg");
        urlList.add("http://bbsdown10.cnmo.com/attachments/201308/06/091441rn5ww131m0gj55r0.jpg");
//        urlList.add("http://kuoo8.com/wall_up/hsf2288/200801/2008012919460743597.jpg");
        urlList.add("http://attach.bbs.miui.com/forum/201604/05/001754vp6j0vmcj49f0evc.jpg.thumb.jpg");
        urlList.add("http://d.3987.com/taiqiumein_141001/007.jpg");
        urlList.add("http://attach.bbs.miui.com/forum/201604/05/100838d2b99k6ihk32a36a.jpg.thumb.jpg");

        imageDescList.add("小仓柚子");
        imageDescList.add("抚媚妖娆性感美女");
        imageDescList.add("热血沸腾 比基尼");
        imageDescList.add(" 台球美女");
        imageDescList.add("身材妙曼");
        initCarsuelView(imageDescList, urlList);
    }

    /**
     * 初始化轮播图
     */
    public void initCarsuelView(ArrayList<String> imageDescList, ArrayList<String> urlList) {
//		LinearLayout.LayoutParams cParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, getScreenHeight(MainActivity.this) * 3 / 10);
//		mCycleView.setLayoutParams(cParams);
        ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
            @Override
            public void onImageClick(int position, View imageView) {
                /**实现点击事件*/
                Toast.makeText(MainActivity.this, "position=" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void displayImage(String imageURL, ImageView imageView) {
                /**在此方法中，显示图片，可以用自己的图片加载库，也可以用本demo中的（Imageloader）*/
                mImageLoader = ImageLoader.getInstance();
                mImageLoader.init(ImageLoaderConfiguration.createDefault(MainActivity.this));
                ImageLoaderHelper.getInstance().loadImage(imageURL, imageView);
            }
        };
        mCycleView.pushImageCycle();
        /**设置数据*/
        mCycleView.setImageResources(imageDescList, urlList, mAdCycleViewListener);
        // 是否隐藏底部
        mCycleView.hideBottom(false);
        mCycleView.startImageCycle();
    }
//	/**
//	 * 得到屏幕的高度
//	 * @param context
//	 * @return
//	 */
//	public static int getScreenHeight(Context context){
//		if (null == context) {
//			return 0;
//		}
//		DisplayMetrics dm = new DisplayMetrics();
//		dm = context.getApplicationContext().getResources().getDisplayMetrics();
//		return dm.heightPixels;
//	}
}
