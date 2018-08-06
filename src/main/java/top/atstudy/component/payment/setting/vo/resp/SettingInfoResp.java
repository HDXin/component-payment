package top.atstudy.component.payment.setting.vo.resp;

import top.atstudy.component.base.util.BeanUtils;
import top.atstudy.component.payment.setting.dao.dto.SettingInfoDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SettingInfo 相应参数模板
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public class SettingInfoResp extends SettingInfoDTO {

    private static final long serialVersionUID = 1L;



    public static SettingInfoResp parseSinglet(SettingInfoDTO target) {
        SettingInfoResp self = new SettingInfoResp();
        return self.parse(target);
    }

    public static List<SettingInfoResp> parseList(List<SettingInfoDTO> targets) {
        return targets.stream().map(SettingInfoResp::parseSinglet).collect(Collectors.toList());
    }

    public SettingInfoResp parse(SettingInfoDTO target) {
        if(target == null) {
            return null;
        }
        BeanUtils.copyProperties(target, this);
        return this;
    }

    public static SettingInfoDTO convertToDTO(SettingInfoResp resp) {
        return resp.convertToDTO();
    }

    public static List<SettingInfoDTO> convertToDTO(List<SettingInfoResp> resps) {
        return resps.stream().map(v -> v.convertToDTO()).collect(Collectors.toList());
    }

    public SettingInfoDTO convertToDTO() {
        return BeanUtils.copyProperties(this, SettingInfoDTO.class);
    }
}
