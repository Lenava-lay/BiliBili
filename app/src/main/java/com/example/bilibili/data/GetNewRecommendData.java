package com.example.bilibili.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bilibili.contentobj.RecommendLabel;
import com.example.bilibili.contentobj.RecommendObject;
import com.example.bilibili.mainviews.headpage.view.adapters.MyRecyclerViewRecommendAdapter;
import com.example.bilibili.utils.URLUtils;

import java.lang.reflect.Field;
import java.util.List;

public class GetNewRecommendData {

    private static int pageSize = 10;
    private static String baseUrl = "http://api.bilibili.cn/recommend?pagesize=" + pageSize + "&page=";

    public static final int LOAD_SUCCESSFUL = 1;
    public static final int LOAD_FAILD = 2;

    // flag =true 则表示尾部添加， false表示头部添加
    public static int getNewData(int page, MyRecyclerViewRecommendAdapter adapter, boolean flag) {

        try {
            JSONArray listArray = getJsonArray(page);
            List<RecommendObject> dataList = adapter.getAllMovies();


            int index = 0;
            for (Object obj : listArray) {
                JSONObject json = (JSONObject) obj;

                RecommendObject rec = null;
                try {
                    rec = setFields(json);
                } catch (IllegalAccessException e) {

                }
                if(flag)
                    dataList.add(rec);
                else
                    dataList.add(index++, rec);
            }
        } catch (Exception e) {
            return LOAD_FAILD;
        }

        return LOAD_SUCCESSFUL;



    }


    private static JSONArray getJsonArray(int page) {
        String result = URLUtils.doGet(baseUrl+ page);
        JSONObject dataRoot = JSON.parseObject(result);
        String dataListStr = dataRoot.getString("list");
        JSONArray listArray = JSON.parseArray(dataListStr);
        return listArray;
    }


    private static RecommendObject setFields(JSONObject json) throws IllegalAccessException {
        Class clazz = RecommendObject.class;
        Field[] fields = clazz.getFields();
        RecommendObject recommendObject = new RecommendObject();
        Object value;
        RecommendLabel ano;
        for (Field field : fields) {
            ano = field.getAnnotation(RecommendLabel.class);
            assert ano != null;
            value = json.get(ano.value());
            if (!ano.value().equals("") && value != null) {
                field.setAccessible(true);
                Class type = field.getType();
                if (type == Integer.class) {
                    field.set(recommendObject, Integer.valueOf(value.toString()));
                } else {
                    field.set(recommendObject, value.toString());
                }
            }
        }
        return recommendObject;
    }


    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        GetNewRecommendData.pageSize = pageSize;
    }

}
