package top.atstudy.component.payment.config.vo.req;

import top.atstudy.component.base.util.BeanUtils;
import top.atstudy.component.payment.config.dao.dto.ConfigInfoDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ConfigInfo 请求参数模板
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public class ConfigInfoReq extends ConfigInfoDTO{

    private static final long serialVersionUID = 1L;

    public static ConfigInfoDTO convertToDTO(ConfigInfoReq req) {
        return req.convertToDTO();
    }

    public static List<ConfigInfoDTO> convertToDTO(List<ConfigInfoReq> reqs) {
        return reqs.stream().map(v -> v.convertToDTO()).collect(Collectors.toList());
    }

    public ConfigInfoDTO convertToDTO() {
        return BeanUtils.copyProperties(this, ConfigInfoDTO.class);
    }
}
