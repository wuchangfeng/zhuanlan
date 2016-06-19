package com.wu.allen.zhuanlan.model;

/**
 * Created by allen on 2016/6/15.
 */
public class Article {

        private String title;
        private String titleImage;
        private String summary;
        private String content;
        private int commentsCount;
        private int likeCount;
        private String slug;
        private String articleSlug;



    public Article(String title, String titleImage, String summary, String content, int commentsCount,
                   int likeCount, String slug,String articleSlug) {
        this.title = title;
        this.titleImage = titleImage;
        this.summary = summary;
        this.content = content;
        this.commentsCount = commentsCount;
        this.likeCount = likeCount;
        this.slug = slug;
        this.articleSlug = articleSlug;
    }

    public String getArticleSlug() {
        return articleSlug;
    }

    public void setArticleSlug(String articleSlug) {
        this.articleSlug = articleSlug;
    }

    public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleImage() {
            return titleImage;
        }

        public void setTitleImage(String titleImage) {
            this.titleImage = titleImage;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }


    }

