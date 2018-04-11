/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.model;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public class BuyingArticle {

    private Buying buying;

    private Article article;

    private Integer quantity = 1;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public BuyingArticle() {
    }

    public BuyingArticle(BuyingArticle src) {
        this.quantity = src.quantity;
        this.buying = new Buying(src.buying);
        this.article = new Article(src.article);
    }

    public BuyingArticle(Buying buying, Article article, Integer quantity) {
        this.buying = buying;
        this.article = article;
        this.quantity = quantity;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public Buying getBuying() {
        return buying;
    }

    public void setBuying(Buying buying) {
        this.buying = buying;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
//</editor-fold>

}
