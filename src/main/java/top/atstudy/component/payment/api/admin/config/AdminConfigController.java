package top.atstudy.component.payment.api.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import top.atstudy.component.base.config.AuthToken;
import top.atstudy.component.base.controller.BasicController;
import top.atstudy.component.payment.config.service.IConfigInfoService;
import top.atstudy.component.payment.config.vo.req.ConfigInfoReq;
import top.atstudy.component.payment.config.vo.resp.ConfigInfoResp;

/**
 * @author Sudao @ HuangDexin
 * @email : 735513870@qq.com
 * @date: 2017/11/15
 * @time: 下午1:27
 * =========================================
 * <p>
 * Contributors :
 * harley - 2017/11/15 下午1:27
 */
@RestController
@RequestMapping("/payment/admin/config")
public class AdminConfigController extends BasicController {
    /******* Fields Area *******/

    @Autowired
    private IConfigInfoService configInfoService;

    /******* Construction Area *******/
    /******* GetSet Area ******/

    /**
     * 创建配置
     * @param req
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("")
    public ConfigInfoResp create(@RequestBody ConfigInfoReq req){
        ConfigInfoResp resp = this.configInfoService.createAndGet(req, getSessionUser());
        AuthToken authToken = createToken(resp.getId(), resp.getProjectName());
        String token = authToken.token();
        resp.setToken(token);

        ConfigInfoReq target = new ConfigInfoReq();
        target.setId(resp.getId());
        target.setToken(token);
        return this.configInfoService.update(target, getSessionUser());
    }

    /**
     * 编辑配置
     * @param id
     * @param req
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @PutMapping("/{id}")
    public ConfigInfoResp update(@PathVariable("id") Long id,
                                    @RequestBody ConfigInfoReq req){
        req.setId(id);
        String token = createToken(id, req.getProjectName()).token();
        req.setToken(token);

        return this.configInfoService.update(req, getSessionUser());
    }
}

