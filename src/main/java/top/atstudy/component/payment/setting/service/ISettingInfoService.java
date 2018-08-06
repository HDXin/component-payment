package top.atstudy.component.payment.setting.service;


import top.atstudy.component.base.IOperatorAware;
import top.atstudy.component.base.Page;
import top.atstudy.component.payment.setting.vo.req.SettingInfoQuery;
import top.atstudy.component.payment.setting.vo.req.SettingInfoReq;
import top.atstudy.component.payment.setting.vo.resp.SettingInfoResp;
import java.util.List;

/**
 * ISettingInfoService 接口
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public interface ISettingInfoService {

    SettingInfoResp getById(Long id);

    Page<SettingInfoResp> findByQuery(SettingInfoQuery query);

    List<SettingInfoResp> listByQuery(SettingInfoQuery query);

    Long countByQuery(SettingInfoQuery query);

    SettingInfoResp createAndGet(SettingInfoReq req, IOperatorAware operator);

    SettingInfoResp update(SettingInfoReq req, IOperatorAware operator);

    boolean remove(Long id, IOperatorAware operator);

    /**
     * 获取系统配置
     * @return
     */
    SettingInfoResp getSetting();

}

