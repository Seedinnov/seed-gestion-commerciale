/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.bean.SellingArticleDataManager;
import com.seed.shopping.bean.SellingDataManager;
import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import com.seed.shopping.service.contract.ArticleService;
import com.seed.shopping.service.contract.SellingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
public class SellingServiceImpl implements SellingService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private SellingDataManager sellingDataManager;
    @Autowired
    private SellingArticleDataManager sellingArticleDataManager;

    @Override
    public List<Selling> getAllSellings() {
        return sellingDataManager.findAll();
    }

    @Override
    @Transactional
    public void saveSelling(List<SellingArticle> articles) {
        Selling selling = articles.get(0).getSelling();
        sellingDataManager.create(selling);
        for (SellingArticle sa : articles) {
            sa.setSelling(selling);
            articleService.subFromStock(sa.getArticle().getId(), sa.getQuantity());
            sellingArticleDataManager.create(sa);
        }
    }

    @Override
    public List<SellingArticle> findArticlesBySelling(Selling selling) {
        return sellingArticleDataManager.findArticlesByBuying(selling);
    }

}
