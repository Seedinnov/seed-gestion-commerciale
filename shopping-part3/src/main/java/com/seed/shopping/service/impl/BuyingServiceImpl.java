/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.bean.BuyingArticleDataManager;
import com.seed.shopping.bean.BuyingDataManager;
import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.service.contract.ArticleService;
import com.seed.shopping.service.contract.BuyingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
public class BuyingServiceImpl implements BuyingService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private BuyingDataManager buyingDataManager;
    @Autowired
    private BuyingArticleDataManager buyingArticleDataManager;

    @Override
    public List<Buying> getAllBuyings() {
        return buyingDataManager.findAll();
    }

    @Override
    @Transactional
    public void saveBuying(List<BuyingArticle> articles) {
        Buying buying = articles.get(0).getBuying();
        buyingDataManager.create(buying);
        for (BuyingArticle ba : articles) {
            ba.setBuying(buying);
            articleService.addToStock(ba.getArticle().getId(), ba.getQuantity());
            buyingArticleDataManager.create(ba);
        }
    }

    @Override
    public List<BuyingArticle> findArticlesByBuying(Buying buying) {
        return buyingArticleDataManager.findArticlesByBuying(buying);
    }

}
