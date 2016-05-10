package com.think.awhealth.ui.map;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.utils.DistanceUtil;
import com.think.awhealth.R;
import com.think.awhealth.bean.entity.Hospital;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.Subscription;
public class PeripheralMapActivity extends AppCompatActivity {
    @InjectView(R.id.bmapView)
    MapView mMapView;
    @InjectView(R.id.id_marker_ly)
    RelativeLayout mMarkerLayout;
    @InjectView(R.id.id_infor_img)
    ImageView mInforImage;
    @InjectView(R.id.id_infor_name)
    TextView mInforName;
    @InjectView(R.id.id_infor_distance)
    TextView mInforDistance;
    @InjectView(R.id.id_infor_address)
    TextView mInforAddress;
    @InjectView(R.id.id_infor_phone)
    TextView mInforPhone;


    private Context mContext;
    private BaiduMap mBaiduMap;

    //定位相关
    private LocationClient mLocationClient;
    private MyLocationListener mMyLocationListener;
    private Boolean isFirstIn = true;
    private double mLatitude;
    private double mLongtitude;
    // 自定义定位图标
    private BitmapDescriptor mIconLocation;
    private MyOrientationListener mMyOrientationListener;
    private float mCurrentX;

    private MyLocationConfiguration.LocationMode mLocationMode;

    //覆盖物相关
    //定位标记
    private BitmapDescriptor mMarker;

    //检索功能相关
    PoiSearch mPoiSearch;
    //检索结果监听器
    private OnGetPoiSearchResultListener mPoiSearchResultListener;
    //检索获得的所有点的信息集合
    private List<PoiInfo> mPoiResultAllPoi;


    //医院信息集合
    private List<Hospital> mHospitalList;
    //RxJava 在view destory的时候，如果subscribe没有得到解除，应该及时    手动释放
    private Subscription subscribe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        百度地图初始化
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_peripheral_map);

        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadHospitalInfor();
            }
        });

        initView();

        //初始化定位
        initLocation();
        //初始化搜索
        initPoiSearch();
        //
        initMarker();

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Bundle extraInfo = marker.getExtraInfo();
                //搜索Marker的详细信息
                mPoiSearch.searchPoiDetail(new PoiDetailSearchOption().poiUid(marker.getExtraInfo().getString("uid")));
                mMarkerLayout.setVisibility(View.VISIBLE);
                //为点击Marker 的位置处显示inforWindow
                return true;
            }
        });

        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMarkerLayout.setVisibility(View.GONE);

            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {

                return false;
            }
        });

    }

    private void initPoiSearch() {
        //创建POI检索实例
        mPoiSearch = PoiSearch.newInstance();
        //创建POI检索监听者
        mPoiSearchResultListener = new OnGetPoiSearchResultListener() {
            @Override
            public void onGetPoiResult(PoiResult poiResult) {
                if (poiResult.error != SearchResult.ERRORNO.NO_ERROR){
                    Toast.makeText(mContext,"检索失败，错误code"+poiResult.error.name(),Toast.LENGTH_LONG);
                } else {

                    //获取检索结果
                    mPoiResultAllPoi = poiResult.getAllPoi();
                    Toast.makeText(mContext,"您的范围50km内一共有"+mPoiResultAllPoi.size()+"个医院",Toast.LENGTH_LONG);
                    addOverlays();
                }


            }
            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
                //获取place详情页结果
//                SearchResult.ERRORNO error = poiDetailResult.error;
                mInforName.setText(poiDetailResult.getName());
                //距离
                double distance = DistanceUtil.getDistance(poiDetailResult.getLocation(), new LatLng(mLatitude, mLongtitude));

                mInforAddress.setText(poiDetailResult.getAddress());
                DecimalFormat df = new DecimalFormat("#.00");
                mInforDistance.setText("距离:"+df.format(distance)+"km");
                mInforPhone.setText(poiDetailResult.getTelephone());

                InfoWindow infoWindow;
                TextView tv = new TextView(mContext);
//                tv.setBackground(getResources().getDrawable(R.drawable.));
                tv.setPadding(30, 20, 30, 50);
                tv.setText(poiDetailResult.getName());
                tv.setBackgroundResource(R.drawable.bg_keyword);
                final LatLng latLng = poiDetailResult.getLocation();
                // 经纬度转化为屏幕上的点
                Point point = mBaiduMap.getProjection().toScreenLocation(latLng);

                LatLng ll = mBaiduMap.getProjection().fromScreenLocation(point);

                infoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(tv),ll, -47,new InfoWindow.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick() {
                        mBaiduMap.hideInfoWindow();
                    }
                }
                );
                mBaiduMap.showInfoWindow(infoWindow);

            }
        };
        mPoiSearch.setOnGetPoiSearchResultListener(mPoiSearchResultListener);
    }

    private void initMarker() {
        mMarker = BitmapDescriptorFactory.fromResource(R.mipmap.maker);
    }

    private void initView() {
        mBaiduMap = mMapView.getMap();
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(mapStatusUpdate);
    }

    private void initLocation() {

        mLocationMode = MyLocationConfiguration.LocationMode.NORMAL;
        mLocationClient = new LocationClient(this);
        mMyLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(mMyLocationListener);

        LocationClientOption option = new LocationClientOption();
        //坐标类型
        option.setCoorType("bd09ll");
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setScanSpan(1000);

        mLocationClient.setLocOption(option);
        //初始化图标
        mIconLocation = BitmapDescriptorFactory.fromResource(R.mipmap.navi_map_gps_locked);
        mMyOrientationListener = new MyOrientationListener(mContext);
        mMyOrientationListener.setOnOrientationListener(new MyOrientationListener.OnOrientationListener() {
            @Override
            public void onOrientationChanged(float x) {
                mCurrentX = x;
            }
        });
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.inject(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mBaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted()) {
            mLocationClient.start();
            //开启方向传感器
            mMyOrientationListener.start();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
        //关闭方向传感器
        mMyOrientationListener.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMapView!=null) {
            mMapView.onDestroy();
        }
        ButterKnife.reset(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_map_common:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;

            case R.id.id_map_site:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;

            case R.id.id_map_traffic:
                if (mBaiduMap.isTrafficEnabled()) {
                    mBaiduMap.setTrafficEnabled(false);
                    item.setTitle("实时交通(off)");
                } else {
                    mBaiduMap.setTrafficEnabled(true);
                    item.setTitle("实时交通(on)");
                }
                break;
            case R.id.id_map_location:
                centerToMyLocation();
                break;
            case R.id.id_map_mode_common://普通模式
                mLocationMode = MyLocationConfiguration.LocationMode.NORMAL;

                break;
            case R.id.id_map_mode_following://跟随模式
                mLocationMode = MyLocationConfiguration.LocationMode.FOLLOWING;
                break;
            case R.id.id_map_mode_compass://罗盘模式
                mLocationMode = MyLocationConfiguration.LocationMode.COMPASS;
                break;
            case R.id.id_add_overlay:
                loadHospitalInfor();
                break;
            case android.R.id.home:
                this.finish();
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 请求服务器，加载附近的医院信息
     */
    private void loadHospitalInfor() {

        PoiNearbySearchOption searchOption = new PoiNearbySearchOption()
                .keyword("医院")
                .location(new LatLng(mLatitude,mLongtitude))
                .pageCapacity(10)
                .radius(1000*50);


        mPoiSearch.searchNearby(searchOption);

    }

    //添加覆盖物
    private void addOverlays() {
        //参数 服务器获取的List;
        //清楚图层
        mBaiduMap.clear();
        //金维度
        LatLng latLng = null;
        Marker marker = null;
        //覆盖物
        OverlayOptions options;

        for (PoiInfo poiInfo:mPoiResultAllPoi){
            latLng = poiInfo.location;
            options = new MarkerOptions().position(latLng)
                    .icon(mMarker).zIndex(5);
            marker = (Marker) mBaiduMap.addOverlay(options);
            Bundle bundle = new Bundle();
            bundle.putString("uid", poiInfo.uid);
            marker.setExtraInfo(bundle);
        }

        //移动到最后一个 点的位置
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        //将地图移动到最后一个Marker的位置
        mBaiduMap.setMapStatus(msu);
    }

    /**
     * 将地图中心定位到我的位置
     */
    private void centerToMyLocation() {
        LatLng  latLng = new LatLng(mLatitude,mLongtitude);
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.animateMapStatus(msu);
    }



    private class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            MyLocationData data = new MyLocationData.Builder()//
                    .direction(mCurrentX)//方向
                    .accuracy(bdLocation.getRadius())//
                    .latitude(bdLocation.getLatitude())//
                    .longitude(bdLocation.getLongitude())//
                    .build();

            mBaiduMap.setMyLocationData(data);
            //设置Location (包括定位模式，定位图标)
            MyLocationConfiguration configuration = new
                    MyLocationConfiguration(mLocationMode,true,mIconLocation);
            mBaiduMap.setMyLocationConfigeration(configuration);
            //每次定位都修改
            mLatitude = bdLocation.getLatitude();
            mLongtitude = bdLocation.getLongitude();

            //如果是第一次定位，将中心点设置到 用户当前定位的位置
            if (isFirstIn) {
                //精度
                LatLng latLng = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
                mBaiduMap.animateMapStatus(msu);
                isFirstIn = false;

                Toast.makeText(mContext, bdLocation.getAddrStr(), Toast.LENGTH_LONG);
            }

        }
    }
}
