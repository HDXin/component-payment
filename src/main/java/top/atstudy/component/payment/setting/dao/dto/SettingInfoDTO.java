package top.atstudy.component.payment.setting.dao.dto;

import top.atstudy.component.base.BaseDTO;
import top.atstudy.component.base.enums.EnumDeleted;
import java.io.Serializable;

public class SettingInfoDTO extends BaseDTO implements Serializable {
    private Long id;

    private String payNotifyUrl;

    private String refundNotifyUrl;

    private EnumDeleted deleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayNotifyUrl() {
        return payNotifyUrl;
    }

    public void setPayNotifyUrl(String payNotifyUrl) {
        this.payNotifyUrl = payNotifyUrl == null ? null : payNotifyUrl.trim();
    }

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl == null ? null : refundNotifyUrl.trim();
    }

    public EnumDeleted getDeleted() {
        return deleted;
    }

    public void setDeleted(EnumDeleted deleted) {
        this.deleted = deleted;
    }
}