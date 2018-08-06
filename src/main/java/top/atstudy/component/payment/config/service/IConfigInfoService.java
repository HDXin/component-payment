package top.atstudy.component.payment.config.service;

import top.atstudy.component.base.IOperatorAware;
import top.atstudy.component.base.Page;
import top.atstudy.component.payment.config.vo.req.ConfigInfoQuery;
import top.atstudy.component.payment.config.vo.req.ConfigInfoReq;
import top.atstudy.component.payment.config.vo.resp.ConfigInfoResp;
import java.util.List;

/**
 * IConfigInfoService 接口
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public interface IConfigInfoService {

    ConfigInfoResp getById(Long id);

    Page<ConfigInfoResp> findByQuery(ConfigInfoQuery query);

    List<ConfigInfoResp> listByQuery(ConfigInfoQuery query);

    Long countByQuery(ConfigInfoQuery query);

    ConfigInfoResp createAndGet(ConfigInfoReq req, IOperatorAware operator);

    ConfigInfoResp update(ConfigInfoReq req, IOperatorAware operator);

    boolean remove(Long id, IOperatorAware operator);


}

