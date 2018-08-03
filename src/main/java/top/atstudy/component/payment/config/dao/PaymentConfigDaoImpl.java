package top.atstudy.component.payment.config.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.atstudy.component.base.BaseDao;
import top.atstudy.component.base.Page;
import top.atstudy.component.base.Pagination;
import top.atstudy.component.base.enums.EnumDeleted;
import top.atstudy.component.base.enums.EnumOrder;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTO;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTOExample;
import top.atstudy.component.payment.config.dao.mapper.PaymentConfigDTOMapper;
import top.atstudy.component.payment.config.vo.req.PaymentConfigQuery;
import java.util.Date;
import java.util.List;

/**
 * IPaymentConfigDao 实现类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
@Service
public class PaymentConfigDaoImpl extends BaseDao implements IPaymentConfigDao {
    /******* Fields Area *******/
    private PaymentConfigDTOMapper paymentConfigDTOMapper;

    /******* Construction Area *******/
    public PaymentConfigDaoImpl(@Autowired PaymentConfigDTOMapper paymentConfigDTOMapper) {
        this.paymentConfigDTOMapper = paymentConfigDTOMapper;
    }

    @Override
    public PaymentConfigDTO getById(Long id) {
        return this.paymentConfigDTOMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<PaymentConfigDTO> findByExample(PaymentConfigDTOExample example, Pagination... paginationParam) {
        Pagination pagination = paginationParam == null || paginationParam.length == 0 ? new Pagination() : paginationParam[0];
        Page<PaymentConfigDTO> page = new Page<PaymentConfigDTO>(pagination);
        String orderBySql = super.buildSortSql(page.buildSortFields());
        example.setOrderByClause(orderBySql);
        long total = this.paymentConfigDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > page.getOffset()) {
            example.limit(page.getOffset(), page.getLimit());
            List<PaymentConfigDTO> targets = this.paymentConfigDTOMapper.selectByExample(example);
            page.setItems(targets);
        }
        return page;
    }


    @Override
    public List<PaymentConfigDTO> listByExample(PaymentConfigDTOExample example) {
        this.loadDefaultOrder(example);
        return this.paymentConfigDTOMapper.selectByExample(example);
    }

    @Override
    public PaymentConfigDTO getByExample(PaymentConfigDTOExample example) {
        PaymentConfigDTO target = null;
        this.loadDefaultOrder(example);
        List<PaymentConfigDTO> targets = this.paymentConfigDTOMapper.selectByExample(example);
        if (targets.size() > 0) {
            target = targets.get(0);
        }
        return target;
    }

    @Override
    public Long countByExample(PaymentConfigDTOExample example) {
        this.loadDefaultOrder(example);
        return this.paymentConfigDTOMapper.countByExample(example);
    }

    @Override
    public Page<PaymentConfigDTO> findByQuery(PaymentConfigQuery query) {
        Page<PaymentConfigDTO> page = new Page<>(query);
        PaymentConfigDTOExample example = this.buildQueryExample(query);

        this.loadDefaultOrder(example);
        long total = this.paymentConfigDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > page.getOffset()) {
            example.limit(page.getOffset(), page.getLimit());
            List<PaymentConfigDTO> targets = this.paymentConfigDTOMapper.selectByExample(example);
            page.setItems(targets);
        }
        return page;
    }

    @Override
    public List<PaymentConfigDTO> listByQuery(PaymentConfigQuery query) {
        PaymentConfigDTOExample example = this.buildQueryExample(query);
        return this.paymentConfigDTOMapper.selectByExample(example);
    }


    @Override
    public Long countByQuery(PaymentConfigQuery query) {
        PaymentConfigDTOExample example = this.buildQueryExample(query);
        return this.paymentConfigDTOMapper.countByExample(example);
    }

    @Override
    public boolean create(PaymentConfigDTO target) {
        return this.paymentConfigDTOMapper.insertSelective(target) > 0;
    }


    @Override
    public PaymentConfigDTO createAndGet(PaymentConfigDTO target) {
        PaymentConfigDTO result = null;
        if (this.create(target)) {
            result = this.getById(target.getId());
        }
        return result;
    }

    @Override
    public boolean update(PaymentConfigDTO target) {
        target.setUpdateTime(new Date());
        return this.paymentConfigDTOMapper.updateByPrimaryKeySelective(target) > 0;
    }

    @Override
    public PaymentConfigDTO updateAndGet(PaymentConfigDTO target) {
        PaymentConfigDTO result = null;
        if (this.update(target)) {
            result = this.getById(target.getId());
        }
        return result;
    }

    @Override
    public boolean remove(PaymentConfigDTO target) {
        target.setDeleted(EnumDeleted.DELETED);
        return this.update(target);
    }

    @Override
    public boolean batchCreate(List<PaymentConfigDTO> targets) {
        boolean batchFlag = targets.stream().map(this::create).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    @Override
    public boolean batchUpdate(List<PaymentConfigDTO> targets) {
        boolean batchFlag = targets.stream().map(this::update).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    @Override
    public boolean batchRemove(List<PaymentConfigDTO> targets) {
        boolean batchFlag = targets.stream().map(this::remove).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    private void loadDefaultOrder(PaymentConfigDTOExample example) {
        if (StringUtils.isEmpty(example.getOrderByClause())) {
            String orderBySql = "create_time" + " " + EnumOrder.DESC.getCode();
            example.setOrderByClause(orderBySql);
        }
    }

    private PaymentConfigDTOExample buildQueryExample(PaymentConfigQuery query) {
        PaymentConfigDTOExample example = new PaymentConfigDTOExample();
        PaymentConfigDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(EnumDeleted.NORMAL);
        String orderBySql = super.buildSortSql(query.buildSortFields());
        example.setOrderByClause(orderBySql);
        example.limit(query.getOffset(), query.getLimit());
        return example;
    }


}
