package top.atstudy.component.payment.api.admin.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import top.atstudy.component.base.Page;
import top.atstudy.component.base.config.AuthToken;
import top.atstudy.component.base.controller.BasicController;
import top.atstudy.component.exception.APIException;
import top.atstudy.component.payment.config.service.IPaymentConfigService;
import top.atstudy.component.payment.config.vo.req.PaymentConfigQuery;
import top.atstudy.component.payment.config.vo.req.PaymentConfigReq;
import top.atstudy.component.payment.config.vo.resp.PaymentConfigResp;

/**
 * smart-mybatis-spring-boot-starter
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ HuangDexin
 * @email : huangdexin@kuaicto.com or 735513870@qq.com
 * @date: 2017/11/15
 * @time: 下午1:27
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/15 下午1:27
 */
@RestController
@RequestMapping("/api/admin/config")
public class PaymentConfigController extends BasicController {
    /******* Fields Area *******/

    @Autowired
    private IPaymentConfigService paymentConfigService;

    /******* Construction Area *******/
    /******* GetSet Area ******/

    /**
     * 创建配置
     * @param req
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("")
    public PaymentConfigResp create(@RequestBody PaymentConfigReq req){
        PaymentConfigResp resp = this.paymentConfigService.createAndGet(req, getSessionUser());
        AuthToken authToken = createToken(resp.getId(), resp.getProjectName());
        String token = authToken.token();
        resp.setToken(token);

        PaymentConfigReq target = new PaymentConfigReq();
        target.setId(resp.getId());
        target.setToken(token);
        return this.paymentConfigService.update(target, getSessionUser());
    }

    /**
     * 编辑配置
     * @param id
     * @param req
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @PutMapping("/{id}")
    public PaymentConfigResp update(@PathVariable("id") Long id,
                                    @RequestBody PaymentConfigReq req){
        req.setId(id);
        String token = createToken(id, req.getProjectName()).token();
        req.setToken(token);

        return this.paymentConfigService.update(req, getSessionUser());
    }

    @GetMapping("/{id}")
    public PaymentConfigResp get(@PathVariable("id") Long id) {
        PaymentConfigResp target = this.paymentConfigService.getById(id);
        return target;
    }

    @GetMapping("")
    public Page<PaymentConfigResp> find(PaymentConfigQuery query) {
        Page<PaymentConfigResp> target = this.paymentConfigService.findByQuery(query);
        return target;
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) throws APIException {
        this.paymentConfigService.remove(id, super.getSessionUser());
    }

    /******* Method Area *******/


}

