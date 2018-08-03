package top.atstudy.component.payment.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.atstudy.component.base.IOperatorAware;
import top.atstudy.component.base.Page;
import top.atstudy.component.base.enums.EnumDeleted;
import top.atstudy.component.payment.config.dao.IPaymentConfigDao;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTO;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTOExample;
import top.atstudy.component.payment.config.vo.req.PaymentConfigQuery;
import top.atstudy.component.payment.config.vo.req.PaymentConfigReq;
import top.atstudy.component.payment.config.vo.resp.PaymentConfigResp;
import java.util.List;

/**
 * IPaymentConfigService 实现类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
@Service
public class PaymentConfigServiceImpl implements IPaymentConfigService {
    /******* Fields Area *******/

    private IPaymentConfigDao paymentConfigDao;

    /******* Construction Area *******/
    public PaymentConfigServiceImpl(@Autowired IPaymentConfigDao paymentConfigDao) {
        this.paymentConfigDao = paymentConfigDao;
    }

    @Override
    public PaymentConfigResp getById(Long id) {
        PaymentConfigResp target = null;
        PaymentConfigDTOExample example = new PaymentConfigDTOExample();
        PaymentConfigDTOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andDeletedEqualTo(EnumDeleted.NORMAL);
        List<PaymentConfigDTO> targets = this.paymentConfigDao.listByExample(example);
        PaymentConfigDTO targetDto = this.paymentConfigDao.getByExample(example);
        if (targetDto != null) {
            target = PaymentConfigResp.parseSinglet(targetDto);
        }
        return target;
    }



    @Override
    public Page<PaymentConfigResp> findByQuery(PaymentConfigQuery query) {
        Page<PaymentConfigDTO> targetPage = this.paymentConfigDao.findByQuery(query);
        Page<PaymentConfigResp> page = new Page<>(targetPage);
        page.setItems(PaymentConfigResp.parseList(targetPage.getItems()));
        return page;
    }

    @Override
    public List<PaymentConfigResp> listByQuery(PaymentConfigQuery query) {
        List<PaymentConfigDTO> targets = this.paymentConfigDao.listByQuery(query);
        return PaymentConfigResp.parseList(targets);
    }

    @Override
    public Long countByQuery(PaymentConfigQuery query) {
        return this.paymentConfigDao.countByQuery(query);
    }

    @Override
    public PaymentConfigResp createAndGet(PaymentConfigReq req, IOperatorAware operator) {
        PaymentConfigDTO target = req.convertToDTO();
        target.setOperator(operator, true);
        target = this.paymentConfigDao.createAndGet(target);
        return PaymentConfigResp.parseSinglet(target);
    }

    @Override
    public PaymentConfigResp update(PaymentConfigReq req, IOperatorAware operator) {
        PaymentConfigDTO target = req.convertToDTO();
        target.setOperator(operator, false);
        target = this.paymentConfigDao.updateAndGet(target);
        return PaymentConfigResp.parseSinglet(target);
    }

    @Override
    public boolean remove(Long id, IOperatorAware operator) {
        PaymentConfigDTO target = this.paymentConfigDao.getById(id);
        target.setOperator(operator, false);
        return this.paymentConfigDao.remove(target);
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


}
