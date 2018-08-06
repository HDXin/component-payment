package top.atstudy.component.payment.config.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.atstudy.component.payment.config.dao.dto.ConfigInfoDTO;
import top.atstudy.component.payment.config.dao.dto.ConfigInfoDTOExample;
import java.util.List;

public interface ConfigInfoDTOMapper {
    long countByExample(ConfigInfoDTOExample example);

    int deleteByExample(ConfigInfoDTOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ConfigInfoDTO record);

    int insertSelective(ConfigInfoDTO record);

    List<ConfigInfoDTO> selectByExample(ConfigInfoDTOExample example);

    ConfigInfoDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ConfigInfoDTO record, @Param("example") ConfigInfoDTOExample example);

    int updateByExample(@Param("record") ConfigInfoDTO record, @Param("example") ConfigInfoDTOExample example);

    int updateByPrimaryKeySelective(ConfigInfoDTO record);

    int updateByPrimaryKey(ConfigInfoDTO record);
}