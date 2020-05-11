package com.pku45a.difference.http;

import com.pku45a.difference.module.QB.Modal.QBCodeResponse;
import com.pku45a.difference.module.QB.Modal.QBHeartResponse;
import com.pku45a.difference.module.QB.Modal.QBLoginResponse;
import com.pku45a.difference.module.QB.Modal.QBWechatEntity;
import com.pku45a.difference.module.ShuHang.Tab2.Activity.HomeEntity;
import com.pku45a.difference.module.StarMap.Modal.SMMessageDetailEntity;
import com.pku45a.difference.module.home.model.BannerBean;
import com.pku45a.difference.module.home.model.HotKeyBean;
import com.pku45a.difference.module.login.model.LoginBean;
import com.pku45a.difference.module.main.model.ArticleBean;
import com.pku45a.difference.module.main.model.ArticleListBean;
import com.pku45a.difference.module.main.model.ChapterBean;
import com.pku45a.difference.module.main.model.CollectionLinkBean;
import com.pku45a.difference.module.main.model.ConfigBean;
import com.pku45a.difference.module.main.model.UpdateBean;
import com.pku45a.difference.module.main.model.UsefulWebBean;
import com.pku45a.difference.module.main.model.UserPageBean;
import com.pku45a.difference.module.mine.model.AboutMeBean;
import com.pku45a.difference.module.mine.model.CoinRankBean;
import com.pku45a.difference.module.mine.model.CoinRecordBean;

import java.util.List;

import io.reactivex.Observable;
import per.goweii.rxhttp.request.Api;
import per.goweii.rxhttp.request.base.BaseBean;

import com.pku45a.difference.module.StarMap.Modal.SMFocusUserEntity;
import com.pku45a.difference.module.StarMap.Modal.SMFocusUserResponse;
import com.pku45a.difference.module.StarMap.Modal.SMHeadIconEntity;
import com.pku45a.difference.module.StarMap.Modal.SMMessageListEntity;
import com.pku45a.difference.module.StarMap.Modal.SMUserEntity;
import com.pku45a.difference.module.navigation.model.NaviBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author CuiZhen
 * @date 2019/5/7
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class WanApi extends Api {

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

        @GET("https://gitee.com/goweii/WanAndroidServer/raw/master/update/update.json")
        Observable<WanResponse<UpdateBean>> update();

        @GET("https://gitee.com/goweii/WanAndroidServer/raw/master/about/about_me.json")
        Observable<WanResponse<AboutMeBean>> getAboutMe();

        @GET("https://gitee.com/goweii/WanAndroidServer/raw/master/config/config.json")
        Observable<WanResponse<ConfigBean>> getConfig();
        ////////////////////////////////////////////////////////////////////////////////
        //创建订单
        @FormUrlEncoded
        @POST("new_year/web/index.php?r=api/qubei/request_wechat_pay")
        Observable<WanResponse<QBWechatEntity>> qbWechatPay(@Field("user_id") String user_id,
                                                            @Field("amount") int amount,
                                                            @Field("vip_days") int vip_days,
                                                            @Field("body") String body);

        @GET("new_year/web/index.php?r=api/qubei/invite_friend")
        Observable<WanResponse<List<String>>> qbInviteFriend(@Query("user_id") String userId,
                                                              @Query("friend_phone") String friendPhone);

        @GET("new_year/web/index.php?r=api/qubei/phone_login")
        Observable<WanResponse<QBLoginResponse>> qbLogin(@Query("user_id") String userId,
                                                         @Query("phone") String phone);

        @GET("new_year/web/index.php?r=api/qubei/reply_invitation")
        Observable<WanResponse<List<String>>> qbReply(@Query("user_id") String userId,
                                                         @Query("friend_id") String friendId,
                                                      @Query("accept") String accept);

        @GET("new_year/web/index.php?r=api/qubei/add_leave_reminder")
        Observable<WanResponse<List<String>>> qbAddRemind(@Query("user_id") String userId,
                                                      @Query("frined_id") String friendId,
                                                      @Query("location_name") String location,
                                                          @Query("latitude") double latitude,
                                                          @Query("longitude") double longitude);

        @GET("new_year/web/index.php?r=api/qubei/frontend_heartbeat")
        Observable<WanResponse<QBHeartResponse>> qbHeartFront(@Query("user_id") String userId,
                                                         @Query("latitude") double latitude,
                                                         @Query("longitude") double longitude,
                                                              @Query("location_name") String location,
                                                              @Query("battery") int battery);

        @GET("new_year/web/index.php?r=api/qubei/backend_heartbeat")
        Observable<WanResponse<QBHeartResponse>> qbHeartBackground(@Query("user_id") String userId,
                                                              @Query("latitude") double latitude,
                                                              @Query("longitude") double longitude,
                                                                   @Query("location_name") String location,
                                                                   @Query("battery") int battery);

        @GET("new_year/web/index.php?r=api/qubei/ask_phone_verification")
        Observable<WanResponse<QBCodeResponse>> qbGetCode(@Query("user_id") String userId,
                                                          @Query("mobile") String phone);
        ////////////////////////////////////////////////////////////////////////////////
        //登录
        @FormUrlEncoded
        @POST("user/login")
        Observable<WanResponse<SMUserEntity>> smLogin(@Field("user_name") String username,
                                                    @Field("pass_word") String password);
        //检查用户名
        @FormUrlEncoded
        @POST("user/checkName")
        Observable<WanResponse<String>> smCheckUserName(@Field("user_name") String username);

        //检查手机号是否存在
        @FormUrlEncoded
        @POST("user/checkPhone")
        Observable<WanResponse<String>> smCheckPhone(@Field("tell_number") String phone);

        //注册
        @FormUrlEncoded
        @POST("user/regist")
        Observable<WanResponse<String>> smRegister(@Field("user_name") String name,
                                                   @Field("tell_number") String phone,
                                                   @Field("pass_word") String password);

        //重置密码
        @FormUrlEncoded
        @POST("user/findPwd")
        Observable<WanResponse<String>> smResetPassword(@Field("tell_number") String phone,
                                                   @Field("new_password") String password);

        //修改密码
        @FormUrlEncoded
        @POST("user/modifyPwd")
        Observable<WanResponse<String>> smModifyPassword(@Field("user_id") String userId,
                                                         @Field("tell_number") String phone,
                                                         @Field("pass_word") String password,
                                                         @Field("new_password") String newPassword);

        //获取用户信息
        @FormUrlEncoded
        @POST("user/getUserInformation")
        Observable<WanResponse<SMUserEntity>> smGetUserInfo(@Field("user_id") String userId);

        //修改隐身状态
        @FormUrlEncoded
        @POST("user/changeName")
        Observable<WanResponse<String>> smChangeHideState(@Field("user_id") String userId);

        //设置标签
        @FormUrlEncoded
        @POST("user/setUserTag")
        Observable<WanResponse<String>> smSetTag(@Field("user_id") String userId,
                                                 @Field("user_tag") String tag);

        //获取头像列表
        @FormUrlEncoded
        @POST("user/getAllHeadpic")
        Observable<WanResponse<List<SMHeadIconEntity>>> getHeadIconList(@Field("user_id") String userId);

        //设置用户头像
        @FormUrlEncoded
        @POST("user/modifyHeadpic")
        Observable<WanResponse<String>> smSetUserIcon(@Field("user_id") String userId,
                                                 @Field("user_icon") String userIcon);

        //获取消息列表
        @FormUrlEncoded
        @POST("message/info")
        Observable<WanResponse<List<SMMessageListEntity>>> getMessageList(@Field("user_id") String userId);

        //获取消息详情列表
        @FormUrlEncoded
        @POST("message/detail")
        Observable<WanResponse<List<SMMessageDetailEntity>>> getMessageDetailList(@Field("user_id") String userId,
                                                                                  @Field("type") int type);

        //关注
        @FormUrlEncoded
        @POST("like/add")
        Observable<WanResponse<String>> smFocusUser(@Field("user_id") String userId,
                                                      @Field("friend_id") String friendId);

        //取消关注
        @FormUrlEncoded
        @POST("like/remove")
        Observable<WanResponse<String>> smUnfocusUser(@Field("user_id") String userId,
                                                    @Field("friend_id") String friendId);

        //获取已关注列表
        @FormUrlEncoded
        @POST("like/lists")
        Observable<WanResponse<SMFocusUserResponse>> getFocusUserList(@Field("user_id") String userId);

        //获取推荐列表
        @FormUrlEncoded
        @POST("like/putlist")
        Observable<WanResponse<List<SMFocusUserEntity>>> getRecommendUserList(@Field("user_id") String userId);
        ////////////////////////////////////////////////////////////////////////////////

        /**
         * 项目列表数据
         * 方法：GET
         * 参数：
         * cid 分类的id，上面项目分类接口
         * 页码：拼接在链接中，从1开始。
         */
        @GET("api/user/getAll")
        Observable<WanResponse<List<HomeEntity>>> getHomeList(@Query("user_id") int userId,
                                                              @Query("page") int page,
                                                              @Query("type") int type);

        /**
         * 登录
         * 方法： POST
         * 参数：
         * username，password
         * 登录后会在cookie中返回账号密码，只要在客户端做cookie持久化存储即可自动登录验证。
         */
        @FormUrlEncoded
        @POST("user/login")
        Observable<WanResponse<LoginBean>> login(@Field("username") String username,
                                                 @Field("password") String password);

        /**
         * 注册
         * 方法： POST
         * 参数：
         * username，password,repassword
         */
        @FormUrlEncoded
        @POST("user/register")
        Observable<WanResponse<LoginBean>> register(@Field("username") String username,
                                                    @Field("password") String password,
                                                    @Field("repassword") String repassword);

        /**
         * 退出
         * 方法： GET
         * 访问了 logout 后，服务端会让客户端清除 Cookie（即cookie max-Age=0），
         * 如果客户端 Cookie 实现合理，可以实现自动清理，如果本地做了用户账号密码和保存，及时清理。
         */
        @GET("user/logout/json")
        Observable<WanResponse<BaseBean>> logout();

        /**
         * 获取公众号列表
         * 方法： GET
         */
        @GET("wxarticle/chapters/json")
        Observable<WanResponse<List<ChapterBean>>> getWxArticleChapters();

        /**
         * 查看某个公众号历史数据
         * 方法：GET
         * 参数：
         * 公众号 ID：拼接在 url 中，eg:405
         * 公众号页码：拼接在 url 中，eg:1
         */
        @GET("wxarticle/list/{id}/{page}/json")
        Observable<WanResponse<ArticleListBean>> getWxArticleList(@Path("id") int id,
                                                                  @Path("page") int page);

        /**
         * 在某个公众号中搜索历史文章
         * 方法：GET
         * 参数：
         * k : 字符串，eg:Java
         * 公众号 ID：拼接在 url 中，eg:405
         * 公众号页码：拼接在 url 中，eg:1
         */
        @GET("wxarticle/list/{id}/{page}/json")
        Observable<WanResponse<ArticleListBean>> getWxArticleList(@Path("id") int id,
                                                                  @Path("page") int page,
                                                                  @Query("k") String key);

        /**
         * 项目分类
         * 方法： GET
         */
        @GET("project/tree/json")
        Observable<WanResponse<List<ChapterBean>>> getProjectChapters();

        /**
         * 项目列表数据
         * 方法：GET
         * 参数：
         * cid 分类的id，上面项目分类接口
         * 页码：拼接在链接中，从1开始。
         */
        @GET("project/list/{page}/json")
        Observable<WanResponse<ArticleListBean>> getProjectArticleList(@Path("page") int page,
                                                                       @Query("cid") int id);

        /**
         * 置顶文章
         * 方法：GET
         */
        @GET("article/top/json")
        Observable<WanResponse<List<ArticleBean>>> getTopArticleList();

        /**
         * 首页文章列表
         * 方法：GET
         * 参数：页码，拼接在连接中，从0开始。
         */
        @GET("article/list/{page}/json")
        Observable<WanResponse<ArticleListBean>> getArticleList(@Path("page") int page);

        /**
         * 首页banner
         */
        @GET("banner/json")
        Observable<WanResponse<List<BannerBean>>> getBanner();

        /**
         * 常用网站
         */
        @GET("friend/json")
        Observable<WanResponse<List<UsefulWebBean>>> getUsefulWebList();

        /**
         * 搜索热词
         */
        @GET("hotkey/json")
        Observable<WanResponse<List<HotKeyBean>>> getHotKeyList();

        /**
         * 搜索
         * 方法：POST
         * 参数：
         * 页码：拼接在链接上，从0开始。
         * k ： 搜索关键词
         * 支持多个关键词，用空格隔开
         */
        @FormUrlEncoded
        @POST("article/query/{page}/json")
        Observable<WanResponse<ArticleListBean>> search(@Path("page") int page,
                                                        @Field("k") String key);

        /**
         * 搜索热词
         */
        @GET("navi/json")
        Observable<WanResponse<List<NaviBean>>> getNaviList();

        /**
         * 体系数据
         */
        @GET("tree/json")
        Observable<WanResponse<List<ChapterBean>>> getKnowledgeList();

        /**
         * 知识体系下的文章
         * 方法：GET
         * 参数：
         * cid 分类的id，上述二级目录的id
         * 页码：拼接在链接上，从0开始。
         */
        @GET("article/list/{page}/json")
        Observable<WanResponse<ArticleListBean>> getKnowledgeArticleList(@Path("page") int page,
                                                                         @Query("cid") int id);

        /**
         * 收藏文章列表
         * 方法：GET
         * 参数： 页码：拼接在链接中，从0开始。
         */
        @GET("lg/collect/list/{page}/json")
        Observable<WanResponse<ArticleListBean>> getCollectArticleList(@Path("page") int page);

        /**
         * 收藏网站列表
         * 方法：GET
         */
        @GET("lg/collect/usertools/json")
        Observable<WanResponse<List<CollectionLinkBean>>> getCollectLinkList();

        /**
         * 收藏站内文章
         * 方法：POST
         * 参数： 文章id，拼接在链接中。
         */
        @POST("lg/collect/{id}/json")
        Observable<WanResponse<BaseBean>> collect(@Path("id") int id);

        /**
         * 收藏站外文章
         * 方法：POST
         * 参数：
         * title，author，link
         */
        @FormUrlEncoded
        @POST("lg/collect/add/json")
        Observable<WanResponse<ArticleBean>> collect(@Field("title") String title,
                                                     @Field("author") String author,
                                                     @Field("link") String link);

        /**
         * 收藏网址
         * 方法：POST
         * 参数：
         * name,link
         */
        @FormUrlEncoded
        @POST("lg/collect/addtool/json")
        Observable<WanResponse<CollectionLinkBean>> collect(@Field("name") String name,
                                                            @Field("link") String link);

        /**
         * 取消收藏 文章列表
         * 方法：POST
         * 参数：
         * id:拼接在链接上 id传入的是列表中文章的id。
         */
        @POST("lg/uncollect_originId/{id}/json")
        Observable<WanResponse<BaseBean>> uncollect(@Path("id") int id);

        /**
         * 删除收藏网站
         * 方法：POST
         * 参数：
         * id
         */
        @FormUrlEncoded
        @POST("lg/collect/deletetool/json")
        Observable<WanResponse<BaseBean>> uncollectLink(@Field("id") int id);

        /**
         * 编辑收藏网站
         * 方法：POST
         * 参数：
         * id,name,link
         */
        @FormUrlEncoded
        @POST("lg/collect/updatetool/json")
        Observable<WanResponse<CollectionLinkBean>> updateCollectLink(@Field("id") int id,
                                                                      @Field("name") String name,
                                                                      @Field("link") String link);

        /**
         * 取消收藏 我的收藏页面（该页面包含自己录入的内容）
         * 方法：POST
         * 参数：
         * id:拼接在链接上
         * originId:列表页下发，无则为-1
         * originId 代表的是你收藏之前的那篇文章本身的id； 但是收藏支持主动添加，这种情况下，没有originId则为-1
         */
        @FormUrlEncoded
        @POST("lg/uncollect/{id}/json")
        Observable<WanResponse<BaseBean>> uncollect(@Path("id") int id,
                                                    @Field("originId") int originId);

        /**
         * 获取个人积分
         */
        @GET("lg/coin/getcount/json")
        Observable<WanResponse<Integer>> getCoin();

        /**
         * 获取个人积分获取列表
         * page 1开始
         */
        @GET("lg/coin/list/{page}/json")
        Observable<WanResponse<CoinRecordBean>> getCoinRecordList(@Path("page") int page);

        /**
         * 积分排行榜接口
         * page 1开始
         */
        @GET("coin/rank/{page}/json")
        Observable<WanResponse<CoinRankBean>> getCoinRankList(@Path("page") int page);

        /**
         * 广场列表数据
         * 可能出现返回列表数据<每页数据，因为有自见的文章被过滤掉了。
         * page 0开始
         */
        @GET("user_article/list/{page}/json")
        Observable<WanResponse<ArticleListBean>> getUserArticleList(@Path("page") int page);

        /**
         * 分享人对应列表数据
         * page 从1开始
         */
        @GET("user/{userId}/share_articles/{page}/json")
        Observable<WanResponse<UserPageBean>> getUserPage(@Path("userId") int userId,
                                                          @Path("page") int page);

        /**
         * 自己的分享的文章列表
         * 页码，从1开始
         */
        @GET("user/lg/private_articles/{page}/json")
        Observable<WanResponse<UserPageBean>> getMineShareArticleList(@Path("page") int page);

        /**
         * 删除自己分享的文章
         * 文章id，拼接在链接上
         */
        @POST("lg/user_article/delete/{id}/json")
        Observable<WanResponse<BaseBean>> deleteMineShareArticle(@Path("id") int id);

        /**
         * 分享文章
         * 注意需要登录后查看，如果为CSDN，简书等链接会直接通过审核，在对外的分享文章列表中展示。
         * title
         * link
         */
        @FormUrlEncoded
        @POST("lg/user_article/add/json")
        Observable<WanResponse<BaseBean>> shareArticle(@Field("title") String title,
                                                       @Field("link") String link);
    }

}
