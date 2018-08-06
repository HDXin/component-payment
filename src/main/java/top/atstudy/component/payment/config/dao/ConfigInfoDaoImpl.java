package top.atstudy.component.payment.config.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.atstudy.component.base.BaseDao;
import top.atstudy.component.base.Page;
import top.atstudy.component.base.Pagination;
import top.atstudy.component.base.enums.EnumDeleted;
import top.atstudy.component.base.enums.EnumOrder;
import top.atstudy.component.payment.config.dao.dto.ConfigInfoDTO;
import top.atstudy.component.payment.config.dao.dto.ConfigInfoDTOExample;
import top.atstudy.component.payment.config.dao.mapper.ConfigInfoDTOMapper;
import top.atstudy.component.payment.config.vo.req.ConfigInfoQuery;
import java.util.Date;
import java.util.List;

/**
 * IConfigInfoDao 实现类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
@Service
public class ConfigInfoDaoImpl extends BaseDao implements IConfigInfoDao {
    /******* Fields Area *******/
    private ConfigInfoDTOMapper configInfoDTOMapper;

    /******* Construction Area *******/
    public ConfigInfoDaoImpl(@Autowired ConfigInfoDTOMapper configInfoDTOMapper) {
        this.configInfoDTOMapper = configInfoDTOMapper;
    }

    @Override
    public ConfigInfoDTO getById(Long id) {
        return this.configInfoDTOMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<ConfigInfoDTO> findByExample(ConfigInfoDTOExample example, Pagination... paginationParam) {
        Pagination pagination = paginationParam == null || paginationParam.length == 0 ? new Pagination() : paginationParam[0];
        Page<ConfigInfoDTO> page = new Page<ConfigInfoDTO>(pagination);
        String orderBySql = super.buildSortSql(page.buildSortFields());
        example.setOrderByClause(orderBySql);
        long total = this.configInfoDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > page.getOffset()) {
            example.limit(page.getOffset(), page.getLimit());
            List<ConfigInfoDTO> targets = this.configInfoDTOMapper.selectByExample(example);
            page.setItems(targets);
        }
        return page;
    }


    @Override
    public List<ConfigInfoDTO> listByExample(ConfigInfoDTOExample example) {
        this.loadDefaultOrder(example);
        return this.configInfoDTOMapper.selectByExample(example);
    }

    @Override
    public ConfigInfoDTO getByExample(ConfigInfoDTOExample example) {
        ConfigInfoDTO target = null;
        this.loadDefaultOrder(example);
        List<ConfigInfoDTO> targets = this.configInfoDTOMapper.selectByExample(example);
        if (targets.size() > 0) {
            target = targets.get(0);
        }
        return target;
    }

    @Override
    public Long countByExample(ConfigInfoDTOExample example) {
        this.loadDefaultOrder(example);
        return this.configInfoDTOMapper.countByExample(example);
    }

    @Override
    public Page<ConfigInfoDTO> findByQuery(ConfigInfoQuery query) {
        Page<ConfigInfoDTO> page = new Page<>(query);
        ConfigInfoDTOExample example = this.buildQueryExample(query);

        this.loadDefaultOrder(example);
        long total = this.configInfoDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > page.getOffset()) {
            example.limit(page.getOffset(), page.getLimit());
            List<ConfigInfoDTO> targets = this.configInfoDTOMapper.selectByExample(example);
            page.setItems(targets);
        }
        return page;
    }

    @Override
    public List<ConfigInfoDTO> listByQuery(ConfigInfoQuery query) {
        ConfigInfoDTOExample example = this.buildQueryExample(query);
        return this.configInfoDTOMapper.selectByExample(example);
    }


    @Override
    public Long countByQuery(ConfigInfoQuery query) {
        ConfigInfoDTOExample example = this.buildQueryExample(query);
        return this.configInfoDTOMapper.countByExample(example);
    }

    @Override
    public boolean create(ConfigInfoDTO target) {
        return this.configInfoDTOMapper.insertSelective(target) > 0;
    }


    @Override
    public ConfigInfoDTO createAndGet(ConfigInfoDTO target) {
        ConfigInfoDTO result = null;
        if (this.create(target)) {
            result = this.getById(target.getId());
        }
        return result;
    }

    @Override
    public boolean update(ConfigInfoDTO target) {
        target.setUpdateTime(new Date());
        return this.configInfoDTOMapper.updateByPrimaryKeySelective(target) > 0;
    }

    @Override
    public ConfigInfoDTO updateAndGet(ConfigInfoDTO target) {
        ConfigInfoDTO result = null;
        if (this.update(target)) {
            result = this.getById(target.getId());
        }
        return result;
    }

    @Override
    public boolean remove(ConfigInfoDTO target) {
        target.setDeleted(EnumDeleted.DELETED);
        return this.update(target);
    }

    @Override
    public boolean batchCreate(List<ConfigInfoDTO> targets) {
        boolean batchFlag = targets.stream().map(this::create).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    @Override
    public boolean batchUpdate(List<ConfigInfoDTO> targets) {
        boolean batchFlag = targets.stream().map(this::update).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    @Override
    public boolean batchRemove(List<ConfigInfoDTO> targets) {
        boolean batchFlag = targets.stream().map(this::remove).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    private void loadDefaultOrder(ConfigInfoDTOExample example) {
        if (StringUtils.isEmpty(example.getOrderByClause())) {
            String orderBySql = "create_time" + " " + EnumOrder.DESC.getCode();
            example.setOrderByClause(orderBySql);
        }
    }

    private ConfigInfoDTOExample buildQueryExample(ConfigInfoQuery query) {
        ConfigInfoDTOExample example = new ConfigInfoDTOExample();
        ConfigInfoDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(EnumDeleted.NORMAL);
        String orderBySql = super.buildSortSql(query.buildSortFields());
        example.setOrderByClause(orderBySql);
        example.limit(query.getOffset(), query.getLimit());
        return example;
    }


}
