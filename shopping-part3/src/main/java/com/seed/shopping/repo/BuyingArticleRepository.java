/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.repo;

import com.seed.shopping.model.BuyingArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public interface BuyingArticleRepository extends JpaRepository<BuyingArticle, Long>{
    
}
