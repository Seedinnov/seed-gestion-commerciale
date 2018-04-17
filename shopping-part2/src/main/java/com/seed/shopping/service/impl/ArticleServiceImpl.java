/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.bean.ArticleDataManager;
import com.seed.shopping.model.Article;
import com.seed.shopping.service.contract.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDataManager articleDataManager;

    @Override
    public List<Article> getAllArticles() {
        return articleDataManager.findAll();
    }

    @Override
    public void addArticle(Article article) {
        article.setRemainingQuantity(0);
        articleDataManager.create(article);
    }

    @Override
    public List<Article> findByName(String name) {
        return articleDataManager.findByName(name);
    }

    @Override
    public Integer addToStock(Integer articleId, Integer addedValue) throws IllegalArgumentException {
        if (addedValue == null || addedValue < 1) {
            throw new IllegalArgumentException("La valeur à ajouter doit être positive!");
        }
        return add(articleId, addedValue);
    }

    @Override
    public Integer subFromStock(Integer articleId, Integer addedValue) throws IllegalArgumentException {
        if (addedValue == null || addedValue < 1) {
            throw new IllegalArgumentException("La valeur à retrancher doit être positive!");
        }
        return add(articleId, -addedValue);
    }

    /**
     * Cette fonction assure l'accès unique à l'édition du solde d'un article.
     *
     * @param articleId Id de l'article
     * @param addedValue Valeur à ajouter
     * @return Le stock après ajout
     * @throws IllegalArgumentException
     */
    private synchronized Integer add(Integer articleId, Integer addedValue) throws IllegalArgumentException {
        Article article = articleDataManager.findById(articleId);
        if (article == null) {
            throw new IllegalArgumentException("Aucun article avec pour ID " + articleId);
        }
        article.setRemainingQuantity(article.getRemainingQuantity() + addedValue);
        articleDataManager.edit(article);
        return article.getRemainingQuantity();
    }

}
