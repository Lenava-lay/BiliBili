package com.example.bilibili.contentobj;

public class RecommendObject {


    @RecommendLabel("aid")
    public Integer aid; //视频编号
    @RecommendLabel("typeid")
    public Integer typeId;  //视频分类id
    @RecommendLabel("typename")
    public String typeName;  //视频分类名称
    @RecommendLabel("title")
    public String title;  //视频标题
    @RecommendLabel("subtitle")
    public String subTitle; //视频副标题
    @RecommendLabel("play")
    public Integer play; //播放次数
    @RecommendLabel("review")
    public Integer review; // 评论数
    @RecommendLabel("video_review")
    public Integer videoReview; //弹幕数
    @RecommendLabel("favorites")
    public Integer favorites; //收藏数
    @RecommendLabel("author")
    public String author;  //视频作者
    @RecommendLabel("mid")
    public Integer mid;  //视频作者id
    @RecommendLabel("create")
    public String create; //视频创建日期
    @RecommendLabel("description")
    public String description;  //视频简介
    @RecommendLabel("pic")
    public String pic;  //视频封面地址
    @RecommendLabel("credit")
    public Integer credit;  //评分数量
    @RecommendLabel("coins")
    public Integer coins;  //推荐数量
    @RecommendLabel("duration")
    public String duration; //视频时长


    //似乎没用
    @RecommendLabel("last_recommend")
    public String lastRecommend;  //最后推荐信息

}
