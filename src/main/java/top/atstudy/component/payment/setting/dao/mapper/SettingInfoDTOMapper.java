package top.atstudy.component.payment.setting.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.atstudy.component.payment.setting.dao.dto.SettingInfoDTO;
import top.atstudy.component.payment.setting.dao.dto.SettingInfoDTOExample;

import java.util.List;

public interface SettingInfoDTOMapper {
    long countByExample(SettingInfoDTOExample example);

    int deleteByExample(SettingInfoDTOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SettingInfoDTO record);

    int insertSelective(SettingInfoDTO record);

    List<SettingInfoDTO> selectByExample(SettingInfoDTOExample example);

    SettingInfoDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SettingInfoDTO record, @Param("example") SettingInfoDTOExample example);

    int updateByExample(@Param("record") SettingInfoDTO record, @Param("example") SettingInfoDTOExample example);

    int updateByPrimaryKeySelective(SettingInfoDTO record);

    int updateByPrimaryKey(SettingInfoDTO record);
}