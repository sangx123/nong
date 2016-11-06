package com.taixia.nong.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/6/14.
 */
public class SquareModel{

    /**
     * status : 1
     * info : 获取成功!
     * data : {"lb_images":[{"image":"http://static2.51dy.ren/mtap/static/images/2016-06-06/57552375ac3eb.png","url":"thewitnesses://www.51dy.ren/native?name=item&goods_id=333","sort":"3"},{"image":"http://static1.51dy.ren/mtap/static/images/2016-06-06/57552375ad774.png","url":"thewitnesses://www.51dy.ren/native?name=人仍然","sort":"2"},{"image":"http://static.51dy.ren/mtap/static/images/2016-06-06/57552375ab063.png","url":"thewitnesses://www.51dy.ren/native?name=请求","sort":"1"}],"list_data":[{"id":"1","avatar":"1111","user_nick":"1","province":"","city":"","total_point":"0","tags_name":[],"p":"2"},{"id":"2","avatar":"http://static3.51dy.ren/mtap/static/images/2016-06-14/575f8a98aedaf.jpg","user_nick":"2","province":"","city":"","total_point":"0","tags_name":["美剧","日剧"],"p":"2"},{"id":"3","avatar":"11111","user_nick":"3","province":"","city":"","total_point":"0","tags_name":["韩剧","美剧","日剧"],"p":"2"}]}
     */
    private DataBean data;


    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * image : http://static2.51dy.ren/mtap/static/images/2016-06-06/57552375ac3eb.png
         * url : thewitnesses://www.51dy.ren/native?name=item&goods_id=333
         * sort : 3
         */

        private List<LbImagesBean> lb_images;
        /**
         * id : 1
         * avatar : 1111
         * user_nick : 1
         * province :
         * city :
         * total_point : 0
         * tags_name : []
         * p : 2
         */

        private List<ListDataBean> list_data;

        public List<LbImagesBean> getLb_images() {
            return lb_images;
        }

        public void setLb_images(List<LbImagesBean> lb_images) {
            this.lb_images = lb_images;
        }

        public List<ListDataBean> getList_data() {
            return list_data;
        }

        public void setList_data(List<ListDataBean> list_data) {
            this.list_data = list_data;
        }

        public static class LbImagesBean{
            private String image;
            private String url;
            private String sort;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

        }

        public static class ListDataBean {
            private String id;
            private String avatar;
            private String user_nick;
            private String province;
            private String city;
            private String total_point;
            private String p;
            private List<String> tags_name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUser_nick() {
                return user_nick;
            }

            public void setUser_nick(String user_nick) {
                this.user_nick = user_nick;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getTotal_point() {
                return total_point;
            }

            public void setTotal_point(String total_point) {
                this.total_point = total_point;
            }

            public String getP() {
                return p;
            }

            public void setP(String p) {
                this.p = p;
            }

            public List<String> getTags_name() {
                return tags_name;
            }

            public void setTags_name(List<String> tags_name) {
                this.tags_name = tags_name;
            }
        }
    }
}
