/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Component
public class BuyingArticleDataManager extends AbstractDataManager<BuyingArticle> {

    private Long nextId = 1L;

    @Override
    protected synchronized void generateId(BuyingArticle object) {
        object.setId(nextId++);
    }

    public List<BuyingArticle> findArticlesByBuying(Buying buying) {
        List<BuyingArticle> result = new ArrayList<>();
        for (BuyingArticle object : objects) {
            if (Objects.equals(object.getBuying().getId(), buying.getId())) {
                result.add(object);
            }
        }
        return result;
    }

}
