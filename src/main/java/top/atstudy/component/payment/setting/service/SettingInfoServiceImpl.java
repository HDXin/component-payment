package top.atstudy.component.payment.setting.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.atstudy.component.base.IOperatorAware;
import top.atstudy.component.base.Page;
import top.atstudy.component.base.enums.EnumDeleted;
import top.atstudy.component.payment.setting.dao.ISettingInfoDao;
import top.atstudy.component.payment.setting.dao.dto.SettingInfoDTO;
import top.atstudy.component.payment.setting.dao.dto.SettingInfoDTOExample;
import top.atstudy.component.payment.setting.vo.req.SettingInfoQuery;
import top.atstudy.component.payment.setting.vo.req.SettingInfoReq;
import top.atstudy.component.payment.setting.vo.resp.SettingInfoResp;
import java.util.List;

/**
 * ISettingInfoService 实现类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
@Service
public class SettingInfoServiceImpl implements ISettingInfoService {
    /******* Fields Area *******/

    private ISettingInfoDao settingInfoDao;

    /******* Construction Area *******/
    public SettingInfoServiceImpl(@Autowired ISettingInfoDao settingInfoDao) {
        this.settingInfoDao = settingInfoDao;
    }

    @Override
    public SettingInfoResp getById(Long id) {
        SettingInfoResp target = null;
        SettingInfoDTOExample example = new SettingInfoDTOExample();
        SettingInfoDTOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andDeletedEqualTo(EnumDeleted.NORMAL);
        List<SettingInfoDTO> targets = this.settingInfoDao.listByExample(example);
        SettingInfoDTO targetDto = this.settingInfoDao.getByExample(example);
        if (targetDto != null) {
            target = SettingInfoResp.parseSinglet(targetDto);
        }
        return target;
    }



    @Override
    public Page<SettingInfoResp> findByQuery(SettingInfoQuery query) {
        Page<SettingInfoDTO> targetPage = this.settingInfoDao.findByQuery(query);
        Page<SettingInfoResp> page = new Page<>(targetPage);
        page.setItems(SettingInfoResp.parseList(targetPage.getItems()));
        return page;
    }

    @Override
    public List<SettingInfoResp> listByQuery(SettingInfoQuery query) {
        List<SettingInfoDTO> targets = this.settingInfoDao.listByQuery(query);
        return SettingInfoResp.parseList(targets);
    }

    @Override
    public Long countByQuery(SettingInfoQuery query) {
        return this.settingInfoDao.countByQuery(query);
    }

    @Override
    public SettingInfoResp createAndGet(SettingInfoReq req, IOperatorAware operator) {
        SettingInfoDTO target = req.convertToDTO();
        target.setOperator(operator, true);
        target = this.settingInfoDao.createAndGet(target);
        return SettingInfoResp.parseSinglet(target);
    }

    @Override
    public SettingInfoResp update(SettingInfoReq req, IOperatorAware operator) {
        SettingInfoDTO target = req.convertToDTO();
        target.setOperator(operator, false);
        target = this.settingInfoDao.updateAndGet(target);
        return SettingInfoResp.parseSinglet(target);
    }

    @Override
    public boolean remove(Long id, IOperatorAware operator) {
        SettingInfoDTO target = this.settingInfoDao.getById(id);
        target.setOperator(operator, false);
        return this.settingInfoDao.remove(target);
    }

    @Override
    public SettingInfoResp getSetting() {
        SettingInfoQuery query = new SettingInfoQuery();
        List<SettingInfoDTO> targets = this.settingInfoDao.listByQuery(query);
        return CollectionUtils.isEmpty(targets) ? null:SettingInfoResp.parseSinglet(targets.get(0));
    }

    /******* GetSet Area ******/

    /******* Method Area *******/


}
