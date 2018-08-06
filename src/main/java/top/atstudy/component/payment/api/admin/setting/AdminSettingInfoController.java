package top.atstudy.component.payment.api.admin.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.atstudy.component.base.Page;
import top.atstudy.component.base.controller.BasicController;
import top.atstudy.component.exception.APIException;
import top.atstudy.component.payment.setting.service.ISettingInfoService;
import top.atstudy.component.payment.setting.vo.req.SettingInfoQuery;
import top.atstudy.component.payment.setting.vo.resp.SettingInfoResp;

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
@RequestMapping("/payment/admin/setting")
public class AdminSettingInfoController extends BasicController {
    /******* Fields Area *******/

    @Autowired
    private ISettingInfoService settingInfoService;

    /******* Construction Area *******/
    /******* GetSet Area ******/


    @GetMapping("/{id}")
    public SettingInfoResp get(@PathVariable("id") Long id) {
        SettingInfoResp target = this.settingInfoService.getById(id);
        return target;
    }

    @GetMapping("")
    public Page<SettingInfoResp> find(SettingInfoQuery query) {
        Page<SettingInfoResp> target = this.settingInfoService.findByQuery(query);
        return target;
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) throws APIException {
        this.settingInfoService.remove(id, super.getSessionUser());
    }

    /******* Method Area *******/


}

