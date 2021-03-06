package org.bdickele.sptransp.controller;

import org.bdickele.sptransp.dto.GoodsDTO;
import org.bdickele.sptransp.exception.SpTranspBizError;
import org.bdickele.sptransp.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/goods")
public class GoodsController extends AbstractController {

    @Autowired
    private GoodsRepository repository;


    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<GoodsDTO> goods() {
        return repository.findAll();
    }

    @RequestMapping(value="/{code}", method= RequestMethod.GET,
            produces="application/json")
    public GoodsDTO goods(@PathVariable String code) {
        GoodsDTO goods = repository.findByCode(code);

        if (goods==null) {
            throw SpTranspBizError.GOODS_NOT_FOUND.exception(code);
        }

        return goods;
    }
}
