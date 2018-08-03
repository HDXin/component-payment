package top.atstudy.component.payment.config.service;

import top.atstudy.component.base.IOperatorAware;
import top.atstudy.component.base.Page;
import top.atstudy.component.payment.config.vo.req.PaymentConfigQuery;
import top.atstudy.component.payment.config.vo.req.PaymentConfigReq;
import top.atstudy.component.payment.config.vo.resp.PaymentConfigResp;
import java.util.List;

/**
 * IPaymentConfigService 接口
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public interface IPaymentConfigService {

    PaymentConfigResp getById(Long id);

    Page<PaymentConfigResp> findByQuery(PaymentConfigQuery query);

    List<PaymentConfigResp> listByQuery(PaymentConfigQuery query);

    Long countByQuery(PaymentConfigQuery query);

    PaymentConfigResp createAndGet(PaymentConfigReq req, IOperatorAware operator);

    PaymentConfigResp update(PaymentConfigReq req, IOperatorAware operator);

    boolean remove(Long id, IOperatorAware operator);


}

