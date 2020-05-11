package com.pku45a.difference.module.ShuHang.Tab2.Activity;

import java.util.List;

import io.reactivex.Observable;
import per.goweii.rxhttp.request.Api;
import com.pku45a.difference.http.WanResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MyAPI extends Api {
    public static ApiService api() {
        return api(ApiService.class);
    }

    public static class ApiCode {
        public static final int ERROR = 1000;

        public static final int SUCCESS = 0;

        public static final int FAILED_NO_CACHE = -9000;  //没有缓存

        public static final int FAILED_NOT_LOGIN = -1001; //请先登录
    }

    public interface ApiService {
        /**
         * 获取首页列表
         * 方法： GET
         */
        @GET("api/user/getAll")
        Observable<WanResponse<List<HomeEntity>>> getHomeList(@Query("user_id") int userId,
                                                              @Query("page") int page,
                                                              @Query("type") int type
                                                               );
    }
}
