/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.Article;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Component
public class ArticleDataManager extends AbstractDataManager<Article> {

    private Integer nextId = 1;

    public void edit(Article article) {
        for (int i = 0; i < objects.size(); i++) {
            if (Objects.equals(objects.get(i).getId(), article.getId())) {
                objects.remove(i);
                objects.add(article);
                return;
            }
        }
    }

    public List<Article> findByName(String name) {
        List<Article> result = new ArrayList<>();
        for (Article article : objects) {
            if (article.getName().toUpperCase().contains(name.toUpperCase())) {
                result.add(article);
            }
        }
        return result;
    }

    public Article findById(Integer id) {
        for (Article article : objects) {
            if (Objects.equals(article.getId(), id)) {
                return article;
            }
        }
        return null;
    }

    @Override
    protected synchronized void generateId(Article object) {
        object.setId(nextId++);
    }

}
