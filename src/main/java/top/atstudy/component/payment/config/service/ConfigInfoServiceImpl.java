package top.atstudy.component.payment.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.atstudy.component.base.IOperatorAware;
import top.atstudy.component.base.Page;
import top.atstudy.component.base.enums.EnumDeleted;
import top.atstudy.component.payment.config.dao.IConfigInfoDao;
import top.atstudy.component.payment.config.dao.dto.ConfigInfoDTO;
import top.atstudy.component.payment.config.dao.dto.ConfigInfoDTOExample;
import top.atstudy.component.payment.config.vo.req.ConfigInfoQuery;
import top.atstudy.component.payment.config.vo.req.ConfigInfoReq;
import top.atstudy.component.payment.config.vo.resp.ConfigInfoResp;
import java.util.List;

/**
 * IConfigInfoService 实现类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
@Service
public class ConfigInfoServiceImpl implements IConfigInfoService {
    /******* Fields Area *******/

    private IConfigInfoDao configInfoDao;

    /******* Construction Area *******/
    public ConfigInfoServiceImpl(@Autowired IConfigInfoDao configInfoDao) {
        this.configInfoDao = configInfoDao;
    }

    @Override
    public ConfigInfoResp getById(Long id) {
        ConfigInfoResp target = null;
        ConfigInfoDTOExample example = new ConfigInfoDTOExample();
        ConfigInfoDTOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andDeletedEqualTo(EnumDeleted.NORMAL);
        List<ConfigInfoDTO> targets = this.configInfoDao.listByExample(example);
        ConfigInfoDTO targetDto = this.configInfoDao.getByExample(example);
        if (targetDto != null) {
            target = ConfigInfoResp.parseSinglet(targetDto);
        }
        return target;
    }



    @Override
    public Page<ConfigInfoResp> findByQuery(ConfigInfoQuery query) {
        Page<ConfigInfoDTO> targetPage = this.configInfoDao.findByQuery(query);
        Page<ConfigInfoResp> page = new Page<>(targetPage);
        page.setItems(ConfigInfoResp.parseList(targetPage.getItems()));
        return page;
    }

    @Override
    public List<ConfigInfoResp> listByQuery(ConfigInfoQuery query) {
        List<ConfigInfoDTO> targets = this.configInfoDao.listByQuery(query);
        return ConfigInfoResp.parseList(targets);
    }

    @Override
    public Long countByQuery(ConfigInfoQuery query) {
        return this.configInfoDao.countByQuery(query);
    }

    @Override
    public ConfigInfoResp createAndGet(ConfigInfoReq req, IOperatorAware operator) {
        ConfigInfoDTO target = req.convertToDTO();
        target.setOperator(operator, true);
        target = this.configInfoDao.createAndGet(target);
        return ConfigInfoResp.parseSinglet(target);
    }

    @Override
    public ConfigInfoResp update(ConfigInfoReq req, IOperatorAware operator) {
        ConfigInfoDTO target = req.convertToDTO();
        target.setOperator(operator, false);
        target = this.configInfoDao.updateAndGet(target);
        return ConfigInfoResp.parseSinglet(target);
    }

    @Override
    public boolean remove(Long id, IOperatorAware operator) {
        ConfigInfoDTO target = this.configInfoDao.getById(id);
        target.setOperator(operator, false);
        return this.configInfoDao.remove(target);
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


}
