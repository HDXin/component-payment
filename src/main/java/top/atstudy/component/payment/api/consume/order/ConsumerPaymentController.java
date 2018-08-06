package top.atstudy.component.payment.api.consume.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.atstudy.component.auth.vo.SessionUser;
import top.atstudy.component.base.controller.BasicController;
import top.atstudy.component.payment.config.service.IConfigInfoService;
import top.atstudy.component.payment.config.vo.resp.ConfigInfoResp;
import top.atstudy.component.payment.setting.service.ISettingInfoService;
import top.atstudy.component.payment.setting.vo.resp.SettingInfoResp;
import top.atstudy.sdk.payment.wechat.config.PayConfig;
import top.atstudy.sdk.payment.wechat.service.PaymentService;
import top.atstudy.sdk.payment.wechat.vo.UnifiedOrderReq;
import top.atstudy.sdk.payment.wechat.vo.UnifiedOrderResp;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: hdxin
 * Date: 2018-08-01
 * Time: 12:11
 */
@RestController
@RequestMapping("/payment/consumer")
public class ConsumerPaymentController extends BasicController{

    @Autowired
    private ISettingInfoService settingInfoService;

    @Autowired
    private IConfigInfoService configInfoService;

    /**
     * 统一下单
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/unifiedorder")
    public UnifiedOrderResp unifiedorder(@RequestBody UnifiedOrderReq req) throws InvocationTargetException, IllegalAccessException {

        //1.获取系统配置信息
        SettingInfoResp setting = settingInfoService.getSetting();
        String payNotifyUrl = setting.getPayNotifyUrl();

        //2.获取配置
        SessionUser sessionUser = getSessionUser();
        ConfigInfoResp config = this.configInfoService.getById(sessionUser.getOperatorId());

        //3.维护配置
        PayConfig payConfig = new PayConfig();
        payConfig.setAppid(config.getAppid());
        payConfig.setMch_id(config.getMchId());
        payConfig.setNotify_url(payNotifyUrl);
        payConfig.setTrade_type(config.getTradeType());
        payConfig.setKey(config.getPaymentKey());

        //4.统一下单
        UnifiedOrderResp resp = PaymentService.getInstance(payConfig).unifiedorder(req);

        return resp;
    }

}
