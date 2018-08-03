package top.atstudy.component.auth.vo;

import top.atstudy.component.base.IOperatorAware;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: hdxin
 * Date: 2018-08-01
 * Time: 11:15
 */
public class SessionUser extends PaymentConfigDTO implements IOperatorAware{

    @Override
    public Long getOperatorId() {
        return getId();
    }

    @Override
    public String getOperatorName() {
        return getProjectName();
    }

    @Override
    public String getOperationId() {
        return getId().toString();
    }
}
