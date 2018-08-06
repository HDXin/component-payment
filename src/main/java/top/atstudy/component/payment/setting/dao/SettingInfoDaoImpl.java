package top.atstudy.component.payment.setting.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.atstudy.component.base.BaseDao;
import top.atstudy.component.base.Page;
import top.atstudy.component.base.Pagination;
import top.atstudy.component.base.enums.EnumDeleted;
import top.atstudy.component.base.enums.EnumOrder;
import top.atstudy.component.payment.setting.dao.dto.SettingInfoDTO;
import top.atstudy.component.payment.setting.dao.dto.SettingInfoDTOExample;
import top.atstudy.component.payment.setting.dao.mapper.SettingInfoDTOMapper;
import top.atstudy.component.payment.setting.vo.req.SettingInfoQuery;
import java.util.Date;
import java.util.List;

/**
 * ISettingInfoDao 实现类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
@Service
public class SettingInfoDaoImpl extends BaseDao implements ISettingInfoDao {
    /******* Fields Area *******/
    private SettingInfoDTOMapper settingInfoDTOMapper;

    /******* Construction Area *******/
    public SettingInfoDaoImpl(@Autowired SettingInfoDTOMapper settingInfoDTOMapper) {
        this.settingInfoDTOMapper = settingInfoDTOMapper;
    }

    @Override
    public SettingInfoDTO getById(Long id) {
        return this.settingInfoDTOMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<SettingInfoDTO> findByExample(SettingInfoDTOExample example, Pagination... paginationParam) {
        Pagination pagination = paginationParam == null || paginationParam.length == 0 ? new Pagination() : paginationParam[0];
        Page<SettingInfoDTO> page = new Page<SettingInfoDTO>(pagination);
        String orderBySql = super.buildSortSql(page.buildSortFields());
        example.setOrderByClause(orderBySql);
        long total = this.settingInfoDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > page.getOffset()) {
            example.limit(page.getOffset(), page.getLimit());
            List<SettingInfoDTO> targets = this.settingInfoDTOMapper.selectByExample(example);
            page.setItems(targets);
        }
        return page;
    }


    @Override
    public List<SettingInfoDTO> listByExample(SettingInfoDTOExample example) {
        this.loadDefaultOrder(example);
        return this.settingInfoDTOMapper.selectByExample(example);
    }

    @Override
    public SettingInfoDTO getByExample(SettingInfoDTOExample example) {
        SettingInfoDTO target = null;
        this.loadDefaultOrder(example);
        List<SettingInfoDTO> targets = this.settingInfoDTOMapper.selectByExample(example);
        if (targets.size() > 0) {
            target = targets.get(0);
        }
        return target;
    }

    @Override
    public Long countByExample(SettingInfoDTOExample example) {
        this.loadDefaultOrder(example);
        return this.settingInfoDTOMapper.countByExample(example);
    }

    @Override
    public Page<SettingInfoDTO> findByQuery(SettingInfoQuery query) {
        Page<SettingInfoDTO> page = new Page<>(query);
        SettingInfoDTOExample example = this.buildQueryExample(query);

        this.loadDefaultOrder(example);
        long total = this.settingInfoDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > page.getOffset()) {
            example.limit(page.getOffset(), page.getLimit());
            List<SettingInfoDTO> targets = this.settingInfoDTOMapper.selectByExample(example);
            page.setItems(targets);
        }
        return page;
    }

    @Override
    public List<SettingInfoDTO> listByQuery(SettingInfoQuery query) {
        SettingInfoDTOExample example = this.buildQueryExample(query);
        return this.settingInfoDTOMapper.selectByExample(example);
    }


    @Override
    public Long countByQuery(SettingInfoQuery query) {
        SettingInfoDTOExample example = this.buildQueryExample(query);
        return this.settingInfoDTOMapper.countByExample(example);
    }

    @Override
    public boolean create(SettingInfoDTO target) {
        return this.settingInfoDTOMapper.insertSelective(target) > 0;
    }


    @Override
    public SettingInfoDTO createAndGet(SettingInfoDTO target) {
        SettingInfoDTO result = null;
        if (this.create(target)) {
            result = this.getById(target.getId());
        }
        return result;
    }

    @Override
    public boolean update(SettingInfoDTO target) {
        target.setUpdateTime(new Date());
        return this.settingInfoDTOMapper.updateByPrimaryKeySelective(target) > 0;
    }

    @Override
    public SettingInfoDTO updateAndGet(SettingInfoDTO target) {
        SettingInfoDTO result = null;
        if (this.update(target)) {
            result = this.getById(target.getId());
        }
        return result;
    }

    @Override
    public boolean remove(SettingInfoDTO target) {
        target.setDeleted(EnumDeleted.DELETED);
        return this.update(target);
    }

    @Override
    public boolean batchCreate(List<SettingInfoDTO> targets) {
        boolean batchFlag = targets.stream().map(this::create).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    @Override
    public boolean batchUpdate(List<SettingInfoDTO> targets) {
        boolean batchFlag = targets.stream().map(this::update).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    @Override
    public boolean batchRemove(List<SettingInfoDTO> targets) {
        boolean batchFlag = targets.stream().map(this::remove).filter(v -> !v).count() == 0;
        return batchFlag;
    }

    private void loadDefaultOrder(SettingInfoDTOExample example) {
        if (StringUtils.isEmpty(example.getOrderByClause())) {
            String orderBySql = "create_time" + " " + EnumOrder.DESC.getCode();
            example.setOrderByClause(orderBySql);
        }
    }

    private SettingInfoDTOExample buildQueryExample(SettingInfoQuery query) {
        SettingInfoDTOExample example = new SettingInfoDTOExample();
        SettingInfoDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(EnumDeleted.NORMAL);
        String orderBySql = super.buildSortSql(query.buildSortFields());
        example.setOrderByClause(orderBySql);
        example.limit(query.getOffset(), query.getLimit());
        return example;
    }


}
