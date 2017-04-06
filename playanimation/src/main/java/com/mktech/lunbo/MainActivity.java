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
        urlList.add("http://pic.sc.chinaz.com/files/pic/pic9/201703/bpic685.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491489054326&di=a0048b47c63a386e2820bc7ed2083000&imgtype=0&src=http%3A%2F%2Fimg01.taopic.com%2F141120%2F235109-1411200RZ118.jpg");
//        urlList.add("http://kuoo8.com/wall_up/hsf2288/200801/2008012919460743597.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491489112002&di=950d9f7d59bbb54161e8d53d1b9bc3f4&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F1%2Fd%2F160.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491489172386&di=de8b3e47b52377fa5b5eae40c69e4996&imgtype=0&src=http%3A%2F%2Fimg1.qunarzz.com%2Ftravel%2Fd2%2F1508%2F20%2Ffe351ebdb1b464.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491489426822&di=d4441b33d08b4bc3317437cb7d908b39&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fnuomi%2Fwh%3D470%2C285%2Fsign%3Db0665bcf09d162d985bb6a1826ef85de%2F7c1ed21b0ef41bd51f00fdff52da81cb39db3d6d.jpg");

        imageDescList.add("野果");
        imageDescList.add("排骨");
        imageDescList.add("冰淇淋");
        imageDescList.add("甜品");
        imageDescList.add("牛肉面");
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
