package top.atstudy.component.payment.setting.vo.req;

import top.atstudy.component.base.util.BeanUtils;
import top.atstudy.component.payment.setting.dao.dto.SettingInfoDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SettingInfo 请求参数模板
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public class SettingInfoReq extends SettingInfoDTO{


    private static final long serialVersionUID = 1L;

    public static SettingInfoDTO convertToDTO(SettingInfoReq req) {
        return req.convertToDTO();
    }

    public static List<SettingInfoDTO> convertToDTO(List<SettingInfoReq> reqs) {
        return reqs.stream().map(v -> v.convertToDTO()).collect(Collectors.toList());
    }

    public SettingInfoDTO convertToDTO() {
        return BeanUtils.copyProperties(this, SettingInfoDTO.class);
    }
}
