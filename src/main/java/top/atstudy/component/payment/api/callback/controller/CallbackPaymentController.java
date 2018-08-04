package top.atstudy.component.payment.api.callback.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import top.atstudy.component.base.controller.BasicController;
import top.atstudy.component.payment.config.vo.req.PaymentConfigReq;

/**
 * @author Sudao @ HuangDexin
 * @email : huangdexin@kuaicto.com or 735513870@qq.com
 * @date: 2017/11/15
 * @time: 下午1:27
 * =========================================
 * <p>
 * Contributors :
 * harley - 2017/11/15 下午1:27
 */
@Controller
@RequestMapping("/payment/callback")
public class CallbackPaymentController extends BasicController {


    /**
     * 微信服务器回调
     * @return
     */
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value = "/notify", produces = MediaType.TEXT_XML_VALUE)
    public ParamsReq callback(@RequestBody ParamsReq req){

        return req;
    }

}

