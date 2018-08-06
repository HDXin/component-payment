package top.atstudy.component.payment.config.vo.resp;

import top.atstudy.component.base.util.BeanUtils;
import top.atstudy.component.payment.config.dao.dto.ConfigInfoDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ConfigInfo 相应参数模板
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public class ConfigInfoResp extends ConfigInfoDTO{

    public static ConfigInfoResp parseSinglet(ConfigInfoDTO target) {
        ConfigInfoResp self = new ConfigInfoResp();
        return self.parse(target);
    }

    public static List<ConfigInfoResp> parseList(List<ConfigInfoDTO> targets) {
        return targets.stream().map(ConfigInfoResp::parseSinglet).collect(Collectors.toList());
    }

    public ConfigInfoResp parse(ConfigInfoDTO target) {
        if(target == null) {
            return null;
        }
        BeanUtils.copyProperties(target, this);
        return this;
    }

    public static ConfigInfoDTO convertToDTO(ConfigInfoResp resp) {
        return resp.convertToDTO();
    }

    public static List<ConfigInfoDTO> convertToDTO(List<ConfigInfoResp> resps) {
        return resps.stream().map(v -> v.convertToDTO()).collect(Collectors.toList());
    }

    public ConfigInfoDTO convertToDTO() {
        return BeanUtils.copyProperties(this, ConfigInfoDTO.class);
    }
}
