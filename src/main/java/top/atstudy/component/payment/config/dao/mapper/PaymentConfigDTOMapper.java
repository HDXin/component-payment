package top.atstudy.component.payment.config.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTO;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTOExample;

import java.util.List;

public interface PaymentConfigDTOMapper {
    long countByExample(PaymentConfigDTOExample example);

    int deleteByExample(PaymentConfigDTOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymentConfigDTO record);

    int insertSelective(PaymentConfigDTO record);

    List<PaymentConfigDTO> selectByExample(PaymentConfigDTOExample example);

    PaymentConfigDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymentConfigDTO record, @Param("example") PaymentConfigDTOExample example);

    int updateByExample(@Param("record") PaymentConfigDTO record, @Param("example") PaymentConfigDTOExample example);

    int updateByPrimaryKeySelective(PaymentConfigDTO record);

    int updateByPrimaryKey(PaymentConfigDTO record);
}